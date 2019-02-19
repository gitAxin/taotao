/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  PageController.java   
 * @Package com.taotao.sso.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月19日 下午10:05:29   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * @Description: 页面跳转Controller 
 * @ClassName:  PageController
 * @author:  Axin 
 * @date:   2019年2月19日 下午10:05:29   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Controller
@RequestMapping("/page")
public class PageController {
	
	@RequestMapping("/register")
	public String showRegister(){
		return "register";
		
	}
	
	@RequestMapping("/showLogin")	
	public String showLogin(){
		return "login";
		
	}

}
