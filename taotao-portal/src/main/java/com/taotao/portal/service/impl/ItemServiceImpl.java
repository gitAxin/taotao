/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemServiceImpl.java   
 * @Package com.taotao.portal.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月14日 下午11:05:34   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.portal.pojo.ItemInfo;
import com.taotao.portal.service.ItemService;

/**   
 * @Description: TODO 
 * @ClassName:  ItemServiceImpl
 * @author:  Axin 
 * @date:   2019年2月14日 下午11:05:34   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class ItemServiceImpl implements ItemService {

	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${ITEM_INFO_URL}")
	private String ITEM_INFO_URL;
	
	@Value("${ITEM_DESC_URL}")
	private String ITEM_DESC_URL;
	
	@Value("${ITEM_PARAM_URL}")
	private String ITEM_PARAM_URL;
	
	/* (non-Javadoc)
	 * @see com.taotao.portal.service.ItemService#getItemById(java.lang.Long)
	 */
	@Override
	public ItemInfo getItemById(Long itemId) {
		
		try {
			//调用rest服务查询商品基本信息
			String url = REST_BASE_URL + ITEM_INFO_URL + itemId;
			String response = HttpClientUtil.doGet(url);
			if(StringUtils.isNotEmpty(response)){
				TaotaoResult taotaoResult = TaotaoResult.formatToPojo(response, ItemInfo.class);
				if(taotaoResult.getStatus() == 200){
					ItemInfo item = (ItemInfo)taotaoResult.getData();
					return item;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	/* (non-Javadoc)
	 * @see com.taotao.portal.service.ItemService#getItemDescById(java.lang.Long)
	 */
	@Override
	public String getItemDescById(Long itemId) {
		try {
			//查询商品描述
			String string = HttpClientUtil.doGet(REST_BASE_URL + ITEM_DESC_URL + itemId);
			//转换成java对象
			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(string, TbItemDesc.class);
			if(taotaoResult.getStatus() == 200){
				TbItemDesc itemDesc = (TbItemDesc)taotaoResult.getData();
				//取商品描述信息
				String desc = itemDesc.getItemDesc();
				return desc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/* (non-Javadoc)
	 * @see com.taotao.portal.service.ItemService#getItemParam(java.lang.Long)
	 */
	@Override
	public String getItemParam(Long itemId) {
		try {
			//查询商品描述
			String string = HttpClientUtil.doGet(REST_BASE_URL + ITEM_PARAM_URL + itemId);
			//转换成java对象
			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(string, TbItemParamItem.class);
			if(taotaoResult.getStatus() == 200){
				TbItemParamItem itemParamItem = (TbItemParamItem)taotaoResult.getData();  
				//取商品描述信息
				String paramData = itemParamItem.getParamData();
				
				List<Map> param = JsonUtils.jsonToList(paramData, Map.class);
				
				StringBuffer sb = new StringBuffer();
				//将参数信息转换成html
				sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	

}
