/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  SearchController.java   
 * @Package com.taotao.portal.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月12日 下午11:00:14   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.controller;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.portal.pojo.SearchResult;
import com.taotao.portal.service.SearchService;

/**   
 * @Description: TODO 
 * @ClassName:  SearchController
 * @author:  Axin 
 * @date:   2019年2月12日 下午11:00:14   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/search")
	public String search(@RequestParam("q")String queryString, @RequestParam(defaultValue="1")Integer page, Model model){
		if(StringUtils.isNotEmpty(queryString)){
			try {
				queryString = new String(queryString.getBytes("iso8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SearchResult searchResult = this.searchService.search(queryString, page);
		model.addAttribute("query", queryString);
		model.addAttribute("totalPages", searchResult.getPageCount());
		model.addAttribute("itemList",searchResult.getItemList());
		model.addAttribute("page",searchResult.getCurPage());
		return "search";
		
	}

}
