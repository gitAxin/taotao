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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
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

}
