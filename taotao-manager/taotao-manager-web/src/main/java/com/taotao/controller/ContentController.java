/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ContentController.java   
 * @Package com.taotao.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月23日 下午10:01:40   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.DataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

/**   
 * @Description: TODO 
 * @ClassName:  ContentController
 * @author:  Axin 
 * @date:   2018年12月23日 下午10:01:40   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/query/list")
	@ResponseBody
	public DataGridResult getContentList(Long categoryId, Integer page, Integer rows){
		return this.contentService.getContentList(categoryId, page, rows);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content){
		return this.contentService.insertContent(content);
	}
}
