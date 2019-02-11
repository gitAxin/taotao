/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  SearchServiceImpl.java   
 * @Package com.taotao.search.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月11日 下午9:48:58   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.search.dao.SearchDao;
import com.taotao.search.pojo.SearchResult;
import com.taotao.search.service.SearchService;

/**   
 * @Description: 搜索服务 
 * @ClassName:  SearchServiceImpl
 * @author:  Axin 
 * @date:   2019年2月11日 下午9:48:58   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class SearchServiceImpl implements SearchService {

	
	@Autowired
	private SearchDao searchDao;
	
	/* (non-Javadoc)
	 * @see com.taotao.search.service.SearchService#search(java.lang.String, int, int)
	 */
	@Override
	public SearchResult search(String queryString, int page, int rows) throws Exception{
		
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery(queryString);
		
		solrQuery.setStart((page - 1) * rows);
		solrQuery.setRows(rows);
		//设置默认搜索域
		solrQuery.set("df", "item_keywords");
		//设置高亮显示
		solrQuery.setHighlight(true);
		
		solrQuery.addHighlightField("item_title");
		solrQuery.setHighlightSimplePre("<em style=\"color:red\">");
		solrQuery.setHighlightSimplePost("</em>");
		//执行查询
		SearchResult searchResult = searchDao.search(solrQuery);
		//计算查询结果总页面
		long recordCount = searchResult.getRecordCount();
		long pageCount = recordCount / rows;
		if(pageCount % rows > 0 ){
			pageCount ++;
		}
		searchResult.setPageCount(pageCount);
		searchResult.setCurPage(page);
		
		return searchResult;
	}

}
