/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  CartServiceImpl.java   
 * @Package com.taotao.portal.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月23日 下午8:41:03   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbItem;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;

/**   
 * @Description: TODO 
 * @ClassName:  CartServiceImpl
 * @author:  Axin 
 * @date:   2019年2月23日 下午8:41:03   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class CartServiceImpl implements CartService {

	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${ITEM_INFO_URL}")
	private String ITEM_INFO_URL;
	/* 
	 * @see com.taotao.portal.service.CartService#addCartItem(long, int)
	 */
	@Override
	public TaotaoResult addCartItem(long itemId, int num, 
				HttpServletRequest request,HttpServletResponse response) {
		
		CartItem cartItem = null;
		//取购物车商品列表
		List<CartItem> list = getCartItemList(request);
		//判断购物车商品列表中是否存在此商品
		for (CartItem cItem : list) {
			if(cItem.getId() == itemId){
				//增加商品数量
				cItem.setNum(cItem.getNum() + num);
				cartItem = cItem;
				break;
			}
		}
		//取商品信息
		if(cartItem == null){
			cartItem = new CartItem();
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_INFO_URL + itemId);
			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItem.class);
			if(taotaoResult.getStatus() == 200){
				TbItem item = (TbItem)taotaoResult.getData();
				cartItem.setId(item.getId());
				cartItem.setTitle(item.getTitle());
				cartItem.setImage(item.getImage()==null?"":item.getImage().split(",")[0]);
				cartItem.setNum(num);
				cartItem.setPrice(item.getPrice());
			}
			list.add(cartItem);
		}
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(list),  true);
		return TaotaoResult.ok();
	}
	
	/**
	 * 从Cookie中取商品列表 
	 * @Description: TODO  
	 * @Title: getCartItemList   
	 * @param: @return      
	 * @return: List<CartItem>      
	 * @throws
	 */
	private List<CartItem> getCartItemList(HttpServletRequest request){
		//从cookie中取商品列表
		String cartJson = CookieUtils.getCookieValue(request, "TT_CART", true);
		if(StringUtils.isEmpty(cartJson)){
			return new ArrayList<CartItem>();
		}
		try {
			List<CartItem> list = JsonUtils.jsonToList(cartJson, CartItem.class);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<CartItem>();
	}

	/* (non-Javadoc)
	 * @see com.taotao.portal.service.CartService#getCartItemList(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response) {
		return getCartItemList(request);
	}


	/* (non-Javadoc)
	 * @see com.taotao.portal.service.CartService#updateCartItemNum(long, int, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public TaotaoResult updateCartItemNum(long itemId, int num, HttpServletRequest request,
			HttpServletResponse response) {
		List<CartItem> list = getCartItemList(request);
		for (CartItem cartItem : list) {
			if(cartItem.getId() == itemId){
				cartItem.setNum(num);
				break;
			}
		}
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(list),  true);
		return TaotaoResult.ok();
	}

	/* (non-Javadoc)
	 * @see com.taotao.portal.service.CartService#deleteCartItem(long, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public TaotaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response) {
		
		List<CartItem> list = getCartItemList(request);
		
		Iterator<CartItem> iterator = list.iterator();
		while(iterator.hasNext()){
			CartItem cartItem = iterator.next();
			if(cartItem.getId() == itemId){
				iterator.remove();
				break;
			}
		}
		
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(list),  true);
		return TaotaoResult.ok();
	}

	
	
	
	
}
