/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemService.java   
 * @Package com.taotao.portal.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月14日 下午11:04:14   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.service;

import com.taotao.portal.pojo.ItemInfo;

/**   
 * @Description: TODO 
 * @ClassName:  ItemService
 * @author:  Axin 
 * @date:   2019年2月14日 下午11:04:14   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface ItemService {

	/**
	 * @Description: 根据商品id查询商品基本信息  
	 * @Title: getItemById   
	 * @param: @param itemId
	 * @param: @return      
	 * @return: ItemInfo      
	 * @throws
	 */
	ItemInfo getItemById(Long itemId);
	
	
	/**
	 * 取商品描述
	 * @Description: TODO  
	 * @Title: getItemDescById   
	 * @param: @param itemId
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	String getItemDescById(Long itemId);
	
	/**
	 * 取商品规格参数
	 * @Description: TODO  
	 * @Title: getItemParam   
	 * @param: @param itemId
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	String getItemParam(Long itemId);
}
