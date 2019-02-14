/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemService.java   
 * @Package com.taotao.rest.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月14日 下午9:46:21   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;

/**   
 * @Description: TODO 
 * @ClassName:  ItemService
 * @author:  Axin 
 * @date:   2019年2月14日 下午9:46:21   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface ItemService {
	
	
	TaotaoResult getItemBaseInfo(long itemId);
	
	
	TaotaoResult getItemDesc(long itemId);
	
	
	TaotaoResult getItemParam(long itemId);

}
