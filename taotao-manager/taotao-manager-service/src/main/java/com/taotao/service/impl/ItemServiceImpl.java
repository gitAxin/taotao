
package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.DataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
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
	public DataGridResult getItemList(Integer page, Integer rows) {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> list = this.tbItemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		DataGridResult result = new DataGridResult();
		result.setRows(list);
		result.setTotal(total);
		return result;
	}


	@Override
	public TaotaoResult createItem(TbItem item) {
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		//商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		tbItemMapper.insert(item);
		return TaotaoResult.ok();
	}
	
	
	
	

}
