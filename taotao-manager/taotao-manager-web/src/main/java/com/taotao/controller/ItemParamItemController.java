/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemParamItemController.java   
 * @Package com.taotao.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月15日 上午12:02:03   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.service.ItemParamItemService;

/**   
 * @Description: TODO 
 * @ClassName:  ItemParamItemController
 * @author:  Axin 
 * @date:   2018年12月15日 上午12:02:03   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Controller
public class ItemParamItemController {
	
	@Autowired
	private ItemParamItemService itemParamItemService;
	
	@RequestMapping("/showItem/{itemId}")
	public String getItemParamItemById(@PathVariable Long itemId, Model model){
		String itemParam = this.itemParamItemService.getItemParamByItemId(itemId);
		model.addAttribute("itemParam", itemParam);
		return "item";
		
	}

}
