/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ContentCategoryController.java   
 * @Package com.taotao.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月20日 下午10:23:45   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ContentCategoryService;

/**   
 * @Description: 首页内容分类控制层 
 * @ClassName:  ContentCategoryController
 * @author:  Axin 
 * @date:   2018年12月20日 下午10:23:45   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	
	
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNode> getCategoryList(@RequestParam(value="id", defaultValue="0")Long parentId){
		List<TreeNode> resultList = this.contentCategoryService.getCategoryList(parentId);
		return resultList;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createContentCategory(Long parentId, String name){
		TaotaoResult result = this.contentCategoryService.insertContentCategory(parentId, name);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContentCategory(Long id){
		this.contentCategoryService.deleteContentCategoryById(id);
		return TaotaoResult.ok();
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult updateContentCategory(Long id,String name){
		this.contentCategoryService.updateContentCategoryNameById(id, name);
		return TaotaoResult.ok();
		
	}
	
	
}
