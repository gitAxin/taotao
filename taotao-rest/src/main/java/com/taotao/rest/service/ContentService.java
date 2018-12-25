/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ContentService.java   
 * @Package com.taotao.rest.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月24日 下午10:38:15   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.service;

import java.util.List;

import com.taotao.pojo.TbContent;

/**   
 * @Description: TODO 
 * @ClassName:  ContentService
 * @author:  Axin 
 * @date:   2018年12月24日 下午10:38:15   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public interface ContentService {
	
	List<TbContent> getContentList(long contentCid);

}
