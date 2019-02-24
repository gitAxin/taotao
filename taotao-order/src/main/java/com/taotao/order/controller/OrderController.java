/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  OrderController.java   
 * @Package com.taotao.order.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月24日 下午11:24:13   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.order.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.order.pojo.Order;
import com.taotao.order.service.OrderService;

/**   
 * @Description: TODO 
 * @ClassName:  OrderController
 * @author:  Axin 
 * @date:   2019年2月24日 下午11:24:13   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createOrder(@RequestBody Order order){
		try {
			TaotaoResult taotaoResult = this.orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());
			return taotaoResult;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

}
