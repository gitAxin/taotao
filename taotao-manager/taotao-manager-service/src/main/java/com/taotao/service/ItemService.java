package com.taotao.service;

import com.taotao.common.pojo.DataGridResult;
import com.taotao.common.pojo.TaotaoResult;
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
	
	/**
	 * 查询所有商品
	 * @Author Axin
	 * @DateTime 2018年12月3日 上午9:32:48
	 * @param page
	 * @param rows
	 * @return
	 */
	DataGridResult getItemList(Integer page, Integer rows);
	
	
	/**
	 * @Title: createItem   
	 * @Description: 添加商品  
	 * @param: @param item
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	TaotaoResult createItem(TbItem item);

}
