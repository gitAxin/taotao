/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  CatNode.java   
 * @Package com.taotao.rest.pojo   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月19日 下午10:27:12   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**   
 * @Description: TODO 
 * @ClassName:  CatNode
 * @author:  Axin 
 * @date:   2018年12月19日 下午10:27:12   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public class CatNode {
	
	@JsonProperty("n")//生成JSON字符串格式时使和n代表k
	private String name;
	@JsonProperty("u")
	private String url;
	@JsonProperty("i")
	private List<?> item;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the item
	 */
	public List<?> getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(List<?> item) {
		this.item = item;
	}

	
}
