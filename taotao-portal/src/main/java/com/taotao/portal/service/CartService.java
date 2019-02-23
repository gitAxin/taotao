/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  CartService.java   
 * @Package com.taotao.portal.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月23日 下午8:40:00   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;

/**   
 * @Description: TODO 
 * @ClassName:  CartService
 * @author:  Axin 
 * @date:   2019年2月23日 下午8:40:00   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface CartService {
	
	/**
	 * 添加购物车商品
	 * @Description: TODO  
	 * @Title: addCartItem   
	 * @param: @param itemId
	 * @param: @param num
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	TaotaoResult addCartItem(long itemId, int num,HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 获取购物车列表 
	 * @Description: TODO  
	 * @Title: getCartItemList   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: List<CartItem>      
	 * @throws
	 */
	List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 修改购物车商品数量
	 * @Description: TODO  
	 * @Title: updateCartItemNum   
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	TaotaoResult updateCartItemNum(long itemId, int num, HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 删除购物车商品
	 * @Description: TODO  
	 * @Title: deleteCartItem   
	 * @param: @param itemId
	 * @param: @param request
	 * @param: @param response
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	TaotaoResult deleteCartItem(long itemId,HttpServletRequest request,HttpServletResponse response);

}
