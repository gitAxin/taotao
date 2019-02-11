/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  SearchDaoImpl.java   
 * @Package com.taotao.search.dao.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月11日 下午9:07:11   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.search.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taotao.search.dao.SearchDao;
import com.taotao.search.pojo.Item;
import com.taotao.search.pojo.SearchResult;

/**   
 * @Description: TODO 
 * @ClassName:  SearchDaoImpl
 * @author:  Axin 
 * @date:   2019年2月11日 下午9:07:11   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Repository
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private SolrServer solrServer;
	/* (non-Javadoc)
	 * @see com.taotao.search.dao.SearchDao#search(org.apache.solr.client.solrj.SolrQuery)
	 */
	@Override
	public SearchResult search(SolrQuery query) throws SolrServerException {
		SearchResult result = new SearchResult();
		//根据查询条件查询索引库
		QueryResponse queryResponse = solrServer.query(query);
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		result.setRecordCount(solrDocumentList.getNumFound());
		
		List<Item> itemList = new ArrayList<>();
		
		//取高亮显示
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		for (SolrDocument solrDocument : solrDocumentList) {
			Item item = new Item();
			item.setId((String)solrDocument.get("id"));
			
			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
			String itemTitle = "";
			if(list != null && list.size()> 0 ){
				itemTitle = list.get(0);
			}else{
				itemTitle = (String)solrDocument.get("item_title");
			}
				
			item.setTitle(itemTitle);
			item.setImage((String)solrDocument.get("item_image"));
			item.setPrice((Long)solrDocument.get("item_price"));
			item.setSell_point((String)solrDocument.get("item_sell_point"));
			item.setCategory_name((String)solrDocument.get("item_category_name"));
			//添加到商品列表
			itemList.add(item);
		}
		
		result.setItemList(itemList);
		return result;
	}

}
