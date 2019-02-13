
package com.taotao.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.DataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemParamItem;
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
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	@Autowired 
	private TbItemParamItemMapper itemParamItemMapper;

	
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


	
	public TaotaoResult createItem(TbItem item,String desc, String itemParam) throws Exception {
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		//商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		tbItemMapper.insert(item);
		//添加商品描述
		
		TaotaoResult result = insertItemDesc(itemId,desc);
		if(result.getStatus() != 200){
			throw new Exception("商品描述添加失败");
		}
		
		result = insertItemParamItem(itemId, itemParam);
		if(result.getStatus() != 200){
			throw new Exception("商品规格参数添加失败");
		}
		
		return TaotaoResult.ok(itemId);
	}


	/**
	 * @Title: insertItemDesc   
	 * @Description: 添加商品描述 
	 * @param: @param itemId
	 * @param: @param desc
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	private TaotaoResult insertItemDesc(long itemId, String desc) {
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		this.tbItemDescMapper.insert(itemDesc);
		return TaotaoResult.ok();
	}
	
	
	/**
	 * 
	 * @Title: insertItemParamItem   
	 * @Description: 添加规格参数 
	 * @param: @param itemId
	 * @param: @param itemParam
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	private TaotaoResult insertItemParamItem(long itemId, String itemParam){
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		this.itemParamItemMapper.insert(itemParamItem);
		return TaotaoResult.ok();
	}

}
