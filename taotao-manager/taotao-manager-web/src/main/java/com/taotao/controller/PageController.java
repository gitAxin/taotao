/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  PageController.java   
 * @Package com.taotao.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月2日 下午10:44:30   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * @ClassName:  PageController   
 * @Description:页面跳转   
 * @author:  Axin 
 * @date:   2018年12月2日 下午10:44:30   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Controller
public class PageController {

	/**
	 * 打开首页
	 * @Title: page   
	 * @Description: TODO  
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
}
