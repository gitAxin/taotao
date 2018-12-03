/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  TreeNode.java   
 * @Package com.taotao.common.pojo   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月3日 下午11:03:01   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.common.pojo;

/**   
 * @ClassName:  TreeNode   
 * @Description: EasyUI树形控件节点
 * @author:  Axin 
 * @date:   2018年12月3日 下午11:03:01   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public class TreeNode {
	
	
	private long id;
	
	private String text;
	
	private String state;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	

}
