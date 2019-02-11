/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  SearchDao.java   
 * @Package com.taotao.search.dao   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月11日 下午9:05:01   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

import com.taotao.search.pojo.SearchResult;

/**   
 * @Description: TODO 
 * @ClassName:  SearchDao
 * @author:  Axin 
 * @date:   2019年2月11日 下午9:05:01   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface SearchDao {

	
	
	SearchResult search(SolrQuery query)  throws SolrServerException ;
}
