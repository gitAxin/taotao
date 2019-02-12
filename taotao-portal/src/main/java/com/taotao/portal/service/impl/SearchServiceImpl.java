/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  SearchServiceImpl.java   
 * @Package com.taotao.portal.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月12日 下午10:47:06   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.portal.pojo.SearchResult;
import com.taotao.portal.service.SearchService;

/**   
 * @Description: TODO 
 * @ClassName:  SearchServiceImpl
 * @author:  Axin 
 * @date:   2019年2月12日 下午10:47:06   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class SearchServiceImpl implements SearchService {

	/* (non-Javadoc)
	 * @see com.taotao.portal.service.SearchService#search(java.lang.String, int)
	 */
	@Value("${SEARCH_BASE_URL}")
	private String SEARCH_BASE_URL;
	
	@Override
	public SearchResult search(String queryString, int page) {
		//调用taotao-search的服务
		//查询参数
		Map<String,String> param = new HashMap<>();
		param.put("q", queryString);
		param.put("page", page + "");
		try {
			//调用服务
			String jsonStr = HttpClientUtil.doGet(SEARCH_BASE_URL,param);
			//把字符串转换成java对象
			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(jsonStr, SearchResult.class);
			if(taotaoResult.getStatus() == 200){
				SearchResult result = (SearchResult)taotaoResult.getData();
				return result;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

}
