/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  PictureServiceImpl.java   
 * @Package com.taotao.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月6日 下午10:58:33   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;

/**   
 * @ClassName:  PictureServiceImpl   
 * @Description: 图片上传服务实现类   
 * @author:  Axin 
 * @date:   2018年12月6日 下午10:58:33   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class PictureServiceImpl implements PictureService {


	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@Override
	public Map<String, Object> uploadPicture(MultipartFile uploadFile) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			String oldName = uploadFile.getOriginalFilename();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			
			String filePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH,
					filePath, newName, uploadFile.getInputStream());
			if(!result){
				map.put("error", 1);
				map.put("message", "文件上传失败");
				return map;
			}
			map.put("error", 0);
			map.put("url", IMAGE_BASE_URL + filePath + "/" + newName);
			return map;
		} catch (Exception e) {
			map.put("error", 1);
			map.put("message", "文件上传发生异常");
			return map;
		}
		
		
	}

}
