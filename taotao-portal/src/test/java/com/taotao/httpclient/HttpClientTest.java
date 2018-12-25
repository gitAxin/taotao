/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  HttpClientTest.java   
 * @Package com.taotao.httpclient   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月24日 下午11:13:22   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.httpclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**   
 * @Description: TODO 
 * @ClassName:  HttpClientTest
 * @author:  Axin 
 * @date:   2018年12月24日 下午11:13:22   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public class HttpClientTest {
	
	/**
	 * 测试get请求
	 * @Description: TODO  
	 * @Title: doGet   
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	@Test
	public void doGet()throws Exception{
		
		//创建一个httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建一个GET对象
		HttpGet get = new HttpGet("http://www.baidu.com?id=13&name=45");//url中可以放参数
		//执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		//取响应的结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);
		HttpEntity entity = response.getEntity();
		//InputStream content = entity.getContent();
		String string = EntityUtils.toString(entity,"utf-8");
		System.out.println(string);
		//关闭httpClient
		response.close();
		httpClient.close();
		
	}
	
	/**
	 * 执行get请求带参数
	 * @Description: TODO  
	 * @Title: doGetWithParam   
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	@Test
	public void doGetWithParam() throws Exception{
				//创建一个httpclient对象
				CloseableHttpClient httpClient = HttpClients.createDefault();
				//创建一个uri对象
				URIBuilder uriBuilder = new URIBuilder("http://www.sogou.com/web");
				uriBuilder.addParameter("query", "花千骨");
				
				HttpGet get = new HttpGet(uriBuilder.build());
				//执行请求
				CloseableHttpResponse response = httpClient.execute(get);
				//取响应的结果
				int statusCode = response.getStatusLine().getStatusCode();
				System.out.println(statusCode);
				HttpEntity entity = response.getEntity();
				//InputStream content = entity.getContent();
				String string = EntityUtils.toString(entity,"utf-8");
				System.out.println(string);
				//关闭httpClient
				response.close();
				httpClient.close();
	}
	
	/**
	 * 执行post请求
	 * @Description: TODO  
	 * @Title: doPost   
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	@Test
	public void doPost() throws Exception{
		
	
		//创建一个httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.action");
		//执行请求
		CloseableHttpResponse response = httpClient.execute(post);
		String string = EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println(string);
		//关闭httpClient
		response.close();
		httpClient.close();
	}
	
	
	@Test
	public void doPostWithParam()throws Exception{

		//创建一个httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		//HTTP请求时，如果是html后缀，springmvc默认以为要返回一个html页面，如果此时返回一个json数据，则会报406错误，改为.action后缀，则可以避免此问题 -->
		//.action已经在web.xml中配置过了
		HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.action");
		//创建一个Entity，模拟一个表单
		List<NameValuePair> kvList = new ArrayList<>();
		kvList.add(new BasicNameValuePair("username","张三"));
		kvList.add(new BasicNameValuePair("password","123456"));
		//包装成一个Entity对象
		StringEntity entity = new UrlEncodedFormEntity(kvList,"utf-8");//发送时中文要以UTF-8字符集发送
		post.setEntity(entity);
		//执行请求
		CloseableHttpResponse response = httpClient.execute(post);
		String string = EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println(string);
		//关闭httpClient
		response.close();
		httpClient.close();
	}

}
