/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  PictureController.java   
 * @Package com.taotao.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月6日 下午11:57:50   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;

/**   
 * @ClassName:  PictureController   
 * @Description: 图片上传控制层 
 * @author:  Axin 
 * @date:   2018年12月6日 下午11:57:50   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */

@Controller
public class PictureController {
	
	@Autowired
	private PictureService pictureService;
	
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile){
		Map<String, Object> result = this.pictureService.uploadPicture(uploadFile);
		//为了兼容在火狐浏览器，需要将对象转换为JSON字符串
		return JsonUtils.objectToJson(result);
		
	}

}
