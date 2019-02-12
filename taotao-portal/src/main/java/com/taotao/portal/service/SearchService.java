/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  SearchService.java   
 * @Package com.taotao.portal.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月12日 下午10:46:17   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.service;

import com.taotao.portal.pojo.SearchResult;

/**   
 * @Description: TODO 
 * @ClassName:  SearchService
 * @author:  Axin 
 * @date:   2019年2月12日 下午10:46:17   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface SearchService {
	
	
	SearchResult search(String queryString, int page);

}
