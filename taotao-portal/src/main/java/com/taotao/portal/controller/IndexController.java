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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
 * @Description: TODO 
 * @ClassName:  IndexController
 * @author:  Axin 
 * @date:   2018年12月16日 下午11:45:08   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */

@Controller
public class IndexController {
	
	
	@RequestMapping("/index")
	public String showIndex(){
		return "index";
	}

}
