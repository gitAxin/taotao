/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  OrderService.java   
 * @Package com.taotao.order.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月24日 下午10:54:07   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.order.service;

import java.util.List;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

/**   
 * @Description: TODO 
 * @ClassName:  OrderService
 * @author:  Axin 
 * @date:   2019年2月24日 下午10:54:07   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface OrderService {
	
	
	/**
	 * 创建订单
	 * @Description: TODO  
	 * @Title: createOrder   
	 * @param: @param order
	 * @param: @param itemList
	 * @param: @param orderShipping
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	TaotaoResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);

}
