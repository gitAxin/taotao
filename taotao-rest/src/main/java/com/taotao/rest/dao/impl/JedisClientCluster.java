/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  JedisClientCluster.java   
 * @Package com.taotao.rest.dao.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月28日 上午12:13:17   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.rest.dao.JedisClient;

import redis.clients.jedis.JedisCluster;

/**   
 * @Description: TODO 
 * @ClassName:  JedisClientCluster
 * @author:  Axin 
 * @date:   2018年12月28日 上午12:13:17   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
//未使用@Repository注解 ，在spring中配置
//@Repository
public class JedisClientCluster implements JedisClient {

	
	//byType 在容器中找JedisCluster类型，找到后注入进来
	@Autowired
	private JedisCluster jedisCluster;

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#get(java.lang.String)
	 */
	@Override
	public String get(String key) {
		return jedisCluster.get(key);
		//此处不能关闭
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#set(java.lang.String, java.lang.String)
	 */
	@Override
	public String set(String key, String value) {
		return jedisCluster.set(key,value);
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#hget(java.lang.String, java.lang.String)
	 */
	@Override
	public String hget(String hkey, String key) {
		return jedisCluster.hget(hkey, key);
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#hset(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long hset(String hkey, String key, String value) {
		return jedisCluster.hset(hkey, key, value);
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#incr(java.lang.String)
	 */
	@Override
	public long incr(String key) {
		return jedisCluster.incr(key);
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#expire(java.lang.String, int)
	 */
	@Override
	public long expire(String key, int second) {
		return jedisCluster.expire(key,second);
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#ttl(java.lang.String)
	 */
	@Override
	public long ttl(String key) {
		return jedisCluster.ttl(key);
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#del(java.lang.String)
	 */
	@Override
	public long del(String key) {
		return jedisCluster.del(key);
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#hdel(java.lang.String, java.lang.String)
	 */
	@Override
	public long hdel(String hkey, String key) {
		return jedisCluster.hdel(hkey, key);
	}
	
	
	
	

}
