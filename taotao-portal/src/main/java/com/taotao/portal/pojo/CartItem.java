/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  CartItem.java   
 * @Package com.taotao.portal.pojo   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月23日 下午9:29:19   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.pojo;

/**   
 * @Description: TODO 
 * @ClassName:  CartItem
 * @author:  Axin 
 * @date:   2019年2月23日 下午9:29:19   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public class CartItem {

	private long id;
	private String title;
	private Integer num;
	private long price;
	private String image;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * @return the price
	 */
	public long getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
