/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  PictureService.java   
 * @Package com.taotao.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月6日 下午10:56:12   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**   
 * @ClassName:  PictureService   
 * @Description: 图片上传服务接口  
 * @author:  Axin 
 * @date:   2018年12月6日 下午10:56:12   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public interface PictureService {
	
	/**
	 * 
	 * @Title: uploadPicture   
	 * @Description: 图片上传
	 * @param: @param uploadFile
	 * @param: @return      
	 * @return: Map<String,Object>      
	 * @throws
	 */
	Map<String,Object> uploadPicture(MultipartFile uploadFile);

}
