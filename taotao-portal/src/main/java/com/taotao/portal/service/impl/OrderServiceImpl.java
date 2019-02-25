/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  OrderServiceImpl.java   
 * @Package com.taotao.portal.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月25日 下午11:11:54   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.OrderService;

/**   
 * @Description: TODO 
 * @ClassName:  OrderServiceImpl
 * @author:  Axin 
 * @date:   2019年2月25日 下午11:11:54   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class OrderServiceImpl implements OrderService {

	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	/* (non-Javadoc)
	 * @see com.taotao.portal.service.OrderService#creteOrder(com.taotao.portal.pojo.Order)
	 */
	@Override
	public String creteOrder(Order order) {
		//调用taotao-order服务提交订单
		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));
		TaotaoResult taotaoResult = TaotaoResult.format(json);
		if(taotaoResult.getStatus() == 200){
			String orderId = taotaoResult.getData().toString();
			return orderId;
		}
		return "";
	}

}
