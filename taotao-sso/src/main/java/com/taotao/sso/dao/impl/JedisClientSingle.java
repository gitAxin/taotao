/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  JedisClientSingle.java   
 * @Package com.taotao.rest.dao   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月28日 上午12:00:53   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.sso.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.sso.dao.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**   
 * @Description: TODO 
 * @ClassName:  JedisClientSingle
 * @author:  Axin 
 * @date:   2018年12月28日 上午12:00:53   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
//未使用@Repository注解 ，在spring中配置
//@Repository
public class JedisClientSingle implements JedisClient {
	
	//byType 在容器中找JedisPool类型，找到后注入进来,如果是根据byName匹配的话，配置文件的bean须要有一个id属性
	//@Resource是jdk自带的注解 ,
	@Autowired
	private JedisPool jedisPool;

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#get(java.lang.String)
	 */
	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#set(java.lang.String, java.lang.String)
	 */
	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.set(key, value);
		jedis.close();
		return string;
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#hget(java.lang.String, java.lang.String)
	 */
	@Override
	public String hget(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		String string = jedis.hget(hkey, key);
		jedis.close();
		return string;
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#hset(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long hset(String hkey, String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(hkey, key, value);
		jedis.close();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#incr(java.lang.String)
	 */
	@Override
	public long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#expire(java.lang.String, long)
	 */
	@Override
	public long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key,second);
		jedis.close();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#ttl(java.lang.String)
	 */
	@Override
	public long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#del(java.lang.String)
	 */
	@Override
	public long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.taotao.rest.dao.JedisClient#hdel(java.lang.String, java.lang.String)
	 */
	@Override
	public long hdel(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(hkey,key);
		jedis.close();
		return result;
	}
	
	

}
