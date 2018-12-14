/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemParamItemServiceImpl.java   
 * @Package com.taotao.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月14日 下午11:35:19   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.service.ItemParamItemService;

/**
 * @Description: 端口规格参数实现类
 * @ClassName: ItemParamItemServiceImpl
 * @author: Axin
 * @date: 2018年12月14日 下午11:35:19
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved.
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.taotao.service.ItemParamItemService#getItemParamByItemId(java.lang.
	 * Long)
	 */
	@Override
	public String getItemParamByItemId(Long itemId) {
		TbItemParamItemExample example = new TbItemParamItemExample();
		example.createCriteria().andItemIdEqualTo(itemId);
		List<TbItemParamItem> list = this.itemParamItemMapper.selectByExampleWithBLOBs(example);
		if(CollectionUtils.isEmpty(list)){
			return "";
		}
		TbItemParamItem itemParamItem = list.get(0);
		String paramData = itemParamItem.getParamData();
		List<Map> param = JsonUtils.jsonToList(paramData, Map.class);
		
		StringBuffer sb = new StringBuffer();
		
		
		
		
		//将参数信息转换成html
		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
		sb.append("    <tbody>\n");
		for (Map map : param) {
			sb.append("        <tr>\n");
			sb.append("<th class=\"tdTitle\" colspan=\"2\">"+map.get("group")+"</th>\n");
			sb.append("        </tr>\n");
			List<Map> params = (List<Map>) map.get("params");
			for (Map map2 : params) {
				sb.append("        <tr>\n");
				sb.append("            <td class=\"tdTitle\">"+map2.get("k")+"</td>\n");
				sb.append("            <td>"+map2.get("v")+"</td>\n");
				sb.append("        </tr>\n");
			}
		}
		sb.append("    </tbody>\n");
		sb.append("</table>");
		return sb.toString();
		
		
	}
	
	

}
