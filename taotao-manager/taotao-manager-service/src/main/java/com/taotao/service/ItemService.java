package com.taotao.service;

import com.taotao.pojo.TbItem;

public interface ItemService {
	
	/**
	 * 
	 * @Title: getItemById   
	 * @Description: TODO  
	 * @param: @param itemId
	 * @param: @return      
	 * @return: TbItem      
	 * @throws
	 */
	TbItem getItemById(long itemId);

}
