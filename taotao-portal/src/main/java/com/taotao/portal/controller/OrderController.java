/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  OrderController.java   
 * @Package com.taotao.portal.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月25日 下午10:35:22   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.pojo.TbUser;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.CartService;
import com.taotao.portal.service.OrderService;

/**   
 * @Description: TODO 
 * @ClassName:  OrderController
 * @author:  Axin 
 * @date:   2019年2月25日 下午10:35:22   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order-cart")
	public String showOrderCar(HttpServletRequest request, HttpServletResponse response,Model model){
		List<CartItem> itemList = this.cartService.getCartItemList(request, response);
		model.addAttribute("cartList", itemList);
		return "order-cart";
	}
	
	
	
	/**
	 * 创建订单
	 * @Description: TODO  
	 * @Title: create   
	 * @param: @param order
	 * @param: @param model
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("/create")
	public String create(Order order,HttpServletRequest request,Model model){
		
		try {
			//调用创建订单服务之前补全用户信息
			//从request中取用户信息(此用户信息是在拦截器中存入的)
			TbUser user = (TbUser)request.getAttribute("user");
			order.setUserId(user.getId());
			order.setBuyerNick(user.getUsername());
			//调用服务
			String orderId = this.orderService.creteOrder(order);
			model.addAttribute("orderId", orderId);
			model.addAttribute("payment", order.getPayment());
			model.addAttribute("date", new DateTime().plusDays(3).toString("yyyy-MM-dd"));
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "创建订单出错。请稍后重试！");
			return "error/exception";
		}
		
		
	}
}
