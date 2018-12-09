/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemController.java   
 * @Package com.taotao.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月2日 下午10:14:00   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.DataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;


/**   
 * @ClassName:  ItemController   
 * @Description:TODO   
 * @author:  Axin 
 * @date:   2018年12月2日 下午10:14:00   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId){
		TbItem item = this.itemService.getItemById(itemId);
		return item;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public DataGridResult getItemList(Integer page, Integer rows){
		DataGridResult result = this.itemService.getItemList(page, rows);
		return result;
	}
	
	/**
	 * @Title: createItem   
	 * @Description: 添加商品  
	 * @param: @param item
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	@RequestMapping(value="/item/save", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createItem(TbItem item){
		TaotaoResult result = this.itemService.createItem(item);
		return result;
	}
	

}
