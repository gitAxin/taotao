/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  JedisTest.java   
 * @Package com.taotao.rest.jedis   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月27日 下午10:44:24   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**   
 * @Description: TODO 
 * @ClassName:  JedisTest
 * @author:  Axin 
 * @date:   2018年12月27日 下午10:44:24   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public class JedisTest {
	
	/**
	 * 测试单机版
	 * @Description: TODO  
	 * @Title: testJedisSingle   
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	@Test
	public void testJedisSingle(){
		//创建一个jedis对象
		Jedis jedis = new Jedis("47.104.228.117",6379);
		//调用jedis对象的方法，方法名称和redis的命令一致
		jedis.set("key1", "jedis test");
		String string = jedis.get("key1");
		System.out.println(string);
		//关闭jedis
		jedis.close();
		
	}
	
	/**
	 * 使用连接池
	 */

	@Test
	public void testJedisPool(){
		JedisPool pool = new JedisPool("47.104.228.117",6379);
		Jedis jedis = pool.getResource();
		//调用jedis对象的方法，方法名称和redis的命令一致
		String string = jedis.get("key1");
		System.out.println(string);
		jedis.close();
		pool.close();
	}
	
	/**
	 * 集群版redis测试
	 * @Description: TODO  
	 * @Title: testJedisCluster   
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	@Test
	public void testJedisCluster(){
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("47.104.228.117",7001));
		nodes.add(new HostAndPort("47.104.228.117",7002));
		nodes.add(new HostAndPort("47.104.228.117",7003));
		nodes.add(new HostAndPort("47.104.228.117",7004));
		nodes.add(new HostAndPort("47.104.228.117",7005));
		nodes.add(new HostAndPort("47.104.228.117",7006));
		//jediscluster 自带连接池
		JedisCluster cluster = new JedisCluster(nodes);
		cluster.set("key1", "cluster test");
		String string = cluster.get("key1");
		System.out.println(string);
		cluster.close();
		
		
	}
	/**
	 * 测试spring整合的单机版
	 * @Description: TODO  
	 * @Title: testSpringJedisSingle   
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	@Test
	public void testSpringJedisSingle(){
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
		Jedis jedis = pool.getResource();
		String string = jedis.get("key1");
		System.out.println(string);
		jedis.close();
		pool.close();
	}
	
	/**
	 * 测试spring整合的redis集群
	 * @Description: TODO  
	 * @Title: testSpringJedisCluster   
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	@Test
	public void testSpringJedisCluster(){
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisCluster cluster = (JedisCluster) applicationContext.getBean("redisClient");
		String string = cluster.get("key1");
		System.out.println(string);
		cluster.close();
	}
	
	

}
