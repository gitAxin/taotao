
package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
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



	@Override
	public List<TbItem> getItemList(Integer page, Integer rows) {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> list = this.tbItemMapper.selectByExample(example);
		return list;
	}
	
	

}
