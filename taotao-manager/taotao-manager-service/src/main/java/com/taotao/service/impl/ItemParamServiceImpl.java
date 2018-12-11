/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemParamServiceImpl.java   
 * @Package com.taotao.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月11日 下午11:09:38   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;

/**   
 * @ClassName:  ItemParamServiceImpl   
 * @Description:TODO   
 * @author:  Axin 
 * @date:   2018年12月11日 下午11:09:38   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{


	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		TbItemParamExample example = new TbItemParamExample();
		example.createCriteria().andItemCatIdEqualTo(cid);
		List<TbItemParam> list = this.itemParamMapper.selectByExample(example);
		//判断是否查询到结果
		if(list != null && list.size()>0){
			return TaotaoResult.ok(list.get(0));
		}
		
		return TaotaoResult.ok();
	}

	/* (non-Javadoc)
	 * @see com.taotao.service.ItemParamService#insertItemParam(com.taotao.pojo.TbItemParam)
	 */
	@Override
	public TaotaoResult insertItemParam(TbItemParam itemParam) {
		//补全pojo
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		this.itemParamMapper.insert(itemParam);
		return TaotaoResult.ok();
	}
	
	
	
	
	

}
