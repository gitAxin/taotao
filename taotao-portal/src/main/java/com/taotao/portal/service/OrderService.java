/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  OrderService.java   
 * @Package com.taotao.portal.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月25日 下午11:10:52   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.service;

import com.taotao.portal.pojo.Order;

/**   
 * @Description: TODO 
 * @ClassName:  OrderService
 * @author:  Axin 
 * @date:   2019年2月25日 下午11:10:52   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface OrderService {
	
	/**
	 * 调用taotao-order服务接口创建订单
	 * @Description: TODO  
	 * @Title: creteOrder   
	 * @param: @param order
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	String creteOrder(Order order);

}
