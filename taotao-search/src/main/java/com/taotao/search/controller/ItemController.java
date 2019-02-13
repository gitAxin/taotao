/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemController.java   
 * @Package com.taotao.search.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月9日 下午10:36:57   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.service.ItemService;

/**   
 * @Description: TODO 
 * @ClassName:  ItemController
 * @author:  Axin 
 * @date:   2019年2月9日 下午10:36:57   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Controller
@RequestMapping("/manager")
public class ItemController {

	
	@Autowired
	private ItemService itemService;
	
	
	@RequestMapping("/importall")
	@ResponseBody
	public TaotaoResult importAllItems(){
		return this.itemService.importAllItems();
	}
	
	@RequestMapping("/importById")
	@ResponseBody
	public TaotaoResult importById(String id){
		return this.itemService.importById(id);
	}
	
	
}
