/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemParamController.java   
 * @Package com.taotao.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月11日 下午11:13:36   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.DataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;

/**   
 * @ClassName:  ItemParamController   
 * @Description:TODO   
 * @author:  Axin 
 * @date:   2018年12月11日 下午11:13:36   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	
	
	@Autowired
	private ItemParamService itemParamService;
	
	
	
	@RequestMapping("/list")
	@ResponseBody
	public DataGridResult getItemParamList(Integer page, Integer rows){
		DataGridResult result = this.itemParamService.getItemParamList(page, rows);
		return result;
	}
	
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable Long itemCatId){
		TaotaoResult result = this.itemParamService.getItemParamByCid(itemCatId);
		return result;
		
	}
	
	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData){
		
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		TaotaoResult result = this.itemParamService.insertItemParam(itemParam);
		return result;
		
	}

}
