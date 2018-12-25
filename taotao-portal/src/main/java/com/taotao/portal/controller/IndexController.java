/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  IndexController.java   
 * @Package com.taotao.portal.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月16日 下午11:45:08   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.service.ContentService;

/**   
 * @Description: TODO 
 * @ClassName:  IndexController
 * @author:  Axin 
 * @date:   2018年12月16日 下午11:45:08   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */

@Controller
public class IndexController {
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index")
	public String showIndex(Model model){
		String json = this.contentService.getContentList();
		model.addAttribute("ad1", json);
		return "index";
	}

	//produces=MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8" 可以避免响应中文字符时出现乱码问题
	@RequestMapping(value="/httpclient/post", method = RequestMethod.POST,
					produces=MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
	@ResponseBody
	public String testHttpClient(String username, String password){
		return "username:" + username + "\tpassword:" + password;
		//return TaotaoResult.ok();
	}
}
