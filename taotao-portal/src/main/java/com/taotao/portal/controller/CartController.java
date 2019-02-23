/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  CartItemController.java   
 * @Package com.taotao.portal.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月23日 下午9:59:20   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;

/**   
 * @Description: TODO 
 * @ClassName:  CartItemController
 * @author:  Axin 
 * @date:   2019年2月23日 下午9:59:20   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/add/{itemId}.html")
	public String addCart(@PathVariable Long itemId, 
			@RequestParam(defaultValue="1")Integer num,
			HttpServletRequest request, HttpServletResponse response){
		TaotaoResult result = this.cartService.addCartItem(itemId, num, request, response);
		//为了防止页面上重复刷新/cart/add/{itemId}.html此页面导致重复添加商品，需重定向一下成功页面
		return "redirect:../success.html";
				
	}
	
	
	@RequestMapping("/success")
	public String addCart(){ 
		return "cartSuccess";
	}
	
	/**
	 * 购物车列表展示
	 * @Description: TODO  
	 * @Title: cartList   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("/cart")
	public String showCart(HttpServletRequest request, HttpServletResponse response,
						Model model){
		List<CartItem> list = this.cartService.getCartItemList(request, response);
		model.addAttribute("cartList", list);
		return "cart";
	}
	
	
	@RequestMapping("/update/num/{itemId}/{num}")
	public void updateCartItemNum(@PathVariable Long itemId,
								@PathVariable int num,
								HttpServletRequest request, HttpServletResponse response){
		this.cartService.updateCartItemNum(itemId, num, request, response);
	}
	

	@RequestMapping("/delete/{itemId}")
	public String deleteCartItem(@PathVariable Long itemId,
			HttpServletRequest request, HttpServletResponse response){
		this.cartService.deleteCartItem(itemId, request, response);
		return "redirect:../cart.html";
	}

}
