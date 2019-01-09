/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  RedisServiceImpl.java   
 * @Package com.taotao.rest.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年1月9日 下午10:12:08   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.RedisService;

/**   
 * @Description: TODO 
 * @ClassName:  RedisServiceImpl
 * @author:  Axin 
 * @date:   2019年1月9日 下午10:12:08   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class RedisServiceImpl implements RedisService{

	
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	/* (non-Javadoc)
	 * @see com.taotao.rest.service.RedisService#syncContent(long)
	 */
	@Override
	public TaotaoResult syncContent(long contentCid) {
		try {
			jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentCid+"");
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}

	
	
}
