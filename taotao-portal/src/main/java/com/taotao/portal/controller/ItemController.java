/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemController.java   
 * @Package com.taotao.portal.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月14日 下午11:11:18   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.portal.pojo.ItemInfo;
import com.taotao.portal.service.ItemService;

/**   
 * @Description: TODO 
 * @ClassName:  ItemController
 * @author:  Axin 
 * @date:   2019年2月14日 下午11:11:18   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	public String showItem(@PathVariable("itemId")Long itemId, Model model){
		ItemInfo item = this.itemService.getItemById(itemId);
		model.addAttribute("item", item);
		return "item";
	}
	
	

}
