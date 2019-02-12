/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemServiceImpl.java   
 * @Package com.taotao.search.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月9日 下午9:52:20   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.search.mapper.ItemMapper;
import com.taotao.search.pojo.Item;
import com.taotao.search.service.ItemService;

/**   
 * @Description: TODO 
 * @ClassName:  ItemServiceImpl
 * @author:  Axin 
 * @date:   2019年2月9日 下午9:52:20   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */

@Service
public class ItemServiceImpl implements ItemService {

	/* (non-Javadoc)
	 * @see com.taotao.search.service.ItemService#importAllItems()
	 */
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private SolrServer solrServer;
	
	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
	@Override
	public TaotaoResult importAllItems(){
		logger.info("导入商品信息到索引库");
		try {
			//查询商品列表
			List<Item> list = itemMapper.getItemList();
			
			int count = 0;
			for (Item item : list) {
				//创建一个SolrInputDocument对象
				SolrInputDocument document = new SolrInputDocument();
				document.setField("id", item.getId());
				document.setField("item_title", item.getTitle());
				document.setField("item_sell_point", item.getSell_point());
				document.setField("item_price", item.getPrice());
				document.setField("item_image", item.getImage());
				document.setField("item_category_name", item.getCategory_name());
				document.setField("item_desc", item.getItem_des());
				//写入索引库
				solrServer.add(document);
				count ++;
				logger.info("导入第{}条",count);
				if(count >=1000){
					break;
				}
			}
			solrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	
		return TaotaoResult.ok();
	}

}
