
package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * @ClassName:  ItemServiceImpl   
 * @Description:TODO   
 * @author:  Axin 
 * @date:   2018年12月2日 下午10:08:13   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved.
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	
	@Autowired
	private TbItemMapper tbItemMapper;


	
	@Override
	public TbItem getItemById(long itemId) {
		TbItem item = this.tbItemMapper.selectByPrimaryKey(itemId);
		return item;
	}

}
