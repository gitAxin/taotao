/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  SearchService.java   
 * @Package com.taotao.search.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月11日 下午9:47:42   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;

/**   
 * @Description: TODO 
 * @ClassName:  SearchService
 * @author:  Axin 
 * @date:   2019年2月11日 下午9:47:42   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface SearchService {
	
	
	SearchResult search(String queryString, int page, int rows) throws Exception;

}
