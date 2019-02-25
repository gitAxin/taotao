/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  Order.java   
 * @Package com.taotao.order.pojo   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月24日 下午11:31:24   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.pojo;

import java.util.List;

import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

/**   
 * @Description: TODO 
 * @ClassName:  Order
 * @author:  Axin 
 * @date:   2019年2月24日 下午11:31:24   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public class Order extends TbOrder {
	
	private List<TbOrderItem> orderItems;
	
	private TbOrderShipping orderShipping;

	/**
	 * @return the orderItems
	 */
	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * @return the orderShipping
	 */
	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}

	/**
	 * @param orderShipping the orderShipping to set
	 */
	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
	
	

}
