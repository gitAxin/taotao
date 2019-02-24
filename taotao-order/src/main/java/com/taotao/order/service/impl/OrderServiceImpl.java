/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  OrderServiceImpl.java   
 * @Package com.taotao.order.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月24日 下午10:56:51   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.order.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbOrderItemMapper;
import com.taotao.mapper.TbOrderMapper;
import com.taotao.mapper.TbOrderShippingMapper;
import com.taotao.order.dao.JedisClient;
import com.taotao.order.service.OrderService;
import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

/**   
 * @Description: TODO 
 * @ClassName:  OrderServiceImpl
 * @author:  Axin 
 * @date:   2019年2月24日 下午10:56:51   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private TbOrderMapper orderMapper;
	@Autowired
	private TbOrderItemMapper orderItemMapper;
	@Autowired
	private TbOrderShippingMapper orderShippingMapper;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${ORDER_GEN_KEY}")
	private String ORDER_GEN_KEY;
	@Value("${ORDER_INIT_ID}")
	private String ORDER_INIT_ID;
	@Value("${ORDER_DETAIL_GEN_KEY}")
	private String ORDER_DETAIL_GEN_KEY;
	
	
	
	/* (non-Javadoc)
	 * @see com.taotao.order.service.OrderService#createOrder(com.taotao.pojo.TbOrder, java.util.List, com.taotao.pojo.TbOrderShipping)
	 */
	@Override
	public TaotaoResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping) {

		//向订单表中插入记录
		//获得订单号
		String string = jedisClient.get(ORDER_GEN_KEY);
		if(StringUtils.isEmpty(string)){
			jedisClient.set(ORDER_GEN_KEY, ORDER_INIT_ID);
		}
		long orderId = jedisClient.incr(ORDER_GEN_KEY);
		
		//补全pojo的属性
		order.setOrderId(orderId + "");
		//状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
		order.setStatus(1);
		Date date = new Date();
		order.setCreateTime(date);
		order.setUpdateTime(date);
		order.setBuyerRate(0);//1-已评价 0-未评价
		this.orderMapper.insert(order);
		
		//插入订单明细
		for (TbOrderItem item : itemList) {
			//补全订单明细
			//取订单明细id
			long orderDetailId = jedisClient.incr(ORDER_DETAIL_GEN_KEY);
			item.setId(orderDetailId + "");
			item.setOrderId(orderId + "");
			this.orderItemMapper.insert(item);
		}
		//插入物流表
		orderShipping.setOrderId(orderId+"");
		orderShipping.setCreated(date);
		orderShipping.setUpdated(date);
		this.orderShippingMapper.insert(orderShipping);
		
		return TaotaoResult.ok(orderId);
	}

}
