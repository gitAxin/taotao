/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemService.java   
 * @Package com.taotao.search.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月9日 下午9:51:27   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.search.service;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;

import com.taotao.common.pojo.TaotaoResult;

/**   
 * @Description: TODO 
 * @ClassName:  ItemService
 * @author:  Axin 
 * @date:   2019年2月9日 下午9:51:27   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface ItemService {

	TaotaoResult importAllItems();
	
	
	TaotaoResult importById(String id);
}
