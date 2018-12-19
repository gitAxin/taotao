/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemCatController.java   
 * @Package com.taotao.rest.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月19日 下午11:36:04   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;

/**   
 * @Description: TODO 
 * @ClassName:  ItemCatController
 * @author:  Axin 
 * @date:   2018年12月19日 下午11:36:04   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	
	/*@RequestMapping(value="/itemcat/list",produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback){
		CatResult itemCatList = this.itemCatService.getItemCatList();
		String jsonString = JsonUtils.objectToJson(itemCatList);
		String result = callback + "(" + jsonString + ");";
		return result;
	}*/
	
	@RequestMapping(value="/itemcat/list")
	@ResponseBody
	public MappingJacksonValue getItemCatList(String callback){
		CatResult itemCatList = this.itemCatService.getItemCatList();
		MappingJacksonValue jacksonValue = new MappingJacksonValue(itemCatList);
		jacksonValue.setJsonpFunction(callback);
		return jacksonValue;
		
	}
	
	
	
	
}
