/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  SolrJTest.java   
 * @Package com.taotao.rest.solrj   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月9日 下午7:57:53   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.solrj;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**   
 * @Description: TODO 
 * @ClassName:  SolrJTest
 * @author:  Axin 
 * @date:   2019年2月9日 下午7:57:53   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public class SolrJTest {
	
	/**
	 * @throws IOException 
	 * @throws SolrServerException 
	 * 
	 * @Description: TODO  
	 * @Title: addDocument   
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	@Test
	public void addDocument() throws SolrServerException, IOException{
		//创建一个连接
		SolrServer solrServer = new HttpSolrServer("http://www.hao456.top/solr/");
		//创建一个文档对象
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "test005");
		document.addField("item_title", "测试商品5");
		document.addField("item_price", 123456);
		//把文档对象写入索引库
		solrServer.add(document);
		//提交
		solrServer.commit();
		
	}
	
	
	@Test
	public void deleteDocument() throws SolrServerException, IOException{
		//创建一个连接
		SolrServer solrServer = new HttpSolrServer("http://www.hao456.top/solr/");
		//solrServer.deleteById("");
		solrServer.deleteByQuery("*:*");
		solrServer.commit();
		
	}
	
	
	@Test
	public void queryDocument() throws Exception{
		//创建一个连接
		SolrServer solrServer = new HttpSolrServer("http://www.hao456.top/solr/");
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		query.setStart(1);
		query.setRows(5);
		QueryResponse query2 = solrServer.query(query);
		SolrDocumentList results = query2.getResults();
		long numFound = results.getNumFound();
		System.out.println("共查询到"+numFound+"条数据");
		for (SolrDocument solrDocument : results) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_image"));
			System.out.println(solrDocument.get("item_price"));
			
		}
		
		
	}
	
	

}
