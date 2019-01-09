/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  JedisClient.java   
 * @Package com.taotao.rest.dao   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月27日 下午11:58:14   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.dao;

/**   
 * @Description: TODO 
 * @ClassName:  JedisClient
 * @author:  Axin 
 * @date:   2018年12月27日 下午11:58:14   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public interface JedisClient {
	
	String get(String key);
	
	String set(String key, String value);
	
	String hget(String hkey, String key);
	
	long hset(String hkey, String key, String value);
	
	long incr(String key);//自增1 
	
	long expire(String key, int second);
	
	long ttl(String key);
	
	long del(String key);
	
	long hdel(String hkey, String key);

}
