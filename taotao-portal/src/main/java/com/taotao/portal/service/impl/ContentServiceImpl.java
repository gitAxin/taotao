/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ContentServiceImpl.java   
 * @Package com.taotao.portal.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月25日 下午10:04:16   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbContent;
import com.taotao.portal.service.ContentService;

/**   
 * @Description: 调用服务层服务，查询内容列表
 * @ClassName:  ContentServiceImpl
 * @author:  Axin 
 * @date:   2018年12月25日 下午10:04:16   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class ContentServiceImpl implements ContentService{

	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_INDEX_AD_URL}")
	private String REST_INDEX_AD_URL;
	/* (non-Javadoc)
	 * @see com.taotao.portal.service.ContentService#getContentList()
	 */
	@Override
	public String getContentList() {
		//调用服务层的服务
		String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
		//把字符串转换为TaotaoResult
		try {
			TaotaoResult taotaoResult = TaotaoResult.formatToList(result, TbContent.class);
			List<TbContent> data = (List<TbContent>)taotaoResult.getData();
			//创建一个JSP页面要求的pojo列表
			List<Map<String,Object>> resultList = new ArrayList<>();
			
			for (TbContent item : data) {
				Map<String,Object> map = new HashMap<>();
				map.put("src", item.getPic());
				map.put("height", 240);
				map.put("width", 670);
				map.put("srcB", item.getPic2());
				map.put("widthB", 550);
				map.put("heightB", 240);
				map.put("href", item.getUrl());
				map.put("alt", item.getSubTitle());
				resultList.add(map);
			}
			
			return JsonUtils.objectToJson(resultList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
}
