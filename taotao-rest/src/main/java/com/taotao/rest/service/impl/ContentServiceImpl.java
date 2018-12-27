/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ContentServiceImpl.java   
 * @Package com.taotao.rest.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月24日 下午10:39:14   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ContentService;

/**   
 * @Description: TODO 
 * @ClassName:  ContentServiceImpl
 * @author:  Axin 
 * @date:   2018年12月24日 下午10:39:14   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class ContentServiceImpl implements ContentService {

	
	@Autowired
	private TbContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	/* (non-Javadoc)
	 * @see com.taotao.rest.service.ContentService#getContentList(long)
	 */
	@Override
	public List<TbContent> getContentList(long contentCid) {
		//从缓存中取内容
		try {
			String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, contentCid+"");
			if(!StringUtils.isBlank(result)){
				//把字符串转换成list
				List<TbContent> resultList = JsonUtils.jsonToList(result, TbContent.class);
				return resultList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TbContentExample example = new TbContentExample();
		example.createCriteria().andCategoryIdEqualTo(contentCid);
		List<TbContent> list = this.contentMapper.selectByExample(example);
		//向缓存中添加内容
		try {
			//需要把list转换成字符串
			String string = JsonUtils.objectToJson(list);
			jedisClient.hset("INDEX_CONTENT_REDIS_KEY", contentCid+"", string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
