/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  SearchController.java   
 * @Package com.taotao.search.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月12日 下午9:18:57   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.search.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.search.pojo.SearchResult;
import com.taotao.search.service.SearchService;

/**   
 * @Description: TODO 
 * @ClassName:  SearchController
 * @author:  Axin 
 * @date:   2019年2月12日 下午9:18:57   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value="/query", method=RequestMethod.GET)
	@ResponseBody
	public TaotaoResult search(@RequestParam("q")String queryString,
				@RequestParam(defaultValue="1")Integer page,
				@RequestParam(defaultValue="60")Integer rows){
		
		//查询条件不能为空
		if(StringUtils.isEmpty(queryString))
			return TaotaoResult.build(400, "查询条件不能为空");
		
		SearchResult searchResult = null;
		try {
			queryString = new String(queryString.getBytes("iso8859-1"),"utf-8");
			searchResult = this.searchService.search(queryString, page, rows);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		return TaotaoResult.ok(searchResult);
				
	}
	
}
