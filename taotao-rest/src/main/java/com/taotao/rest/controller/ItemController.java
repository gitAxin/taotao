/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemController.java   
 * @Package com.taotao.rest.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月14日 下午9:49:55   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.rest.service.ItemService;

/**   
 * @Description: TODO 
 * @ClassName:  ItemController
 * @author:  Axin 
 * @date:   2019年2月14日 下午9:49:55   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */

@Controller
@RequestMapping("/item")
public class ItemController {

	
	@Autowired
	private ItemService itemService;
	
	/**
	 * @Description: 根据商品id查询商品基本信息  
	 * @Title: getItemBaseInfo   
	 * @param: @param itemId
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public TaotaoResult getItemBaseInfo(@PathVariable("itemId") Long itemId){
		return this.itemService.getItemBaseInfo(itemId);
	}
	
	/**
	 * 
	 * @Description: 根据商品id查询商品描述
	 * @Title: getItemDesc   
	 * @param: @param itemId
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public TaotaoResult getItemDesc(@PathVariable("itemId") Long itemId){
		return this.itemService.getItemDesc(itemId);
	}
	
	/**
	 * @Description: 根据商品id查询商品规格
	 * @Title: getItemParam   
	 * @param: @param itemId
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public TaotaoResult getItemParam(@PathVariable("itemId") Long itemId){
		return this.itemService.getItemParam(itemId);
	}
	
	
	
}
