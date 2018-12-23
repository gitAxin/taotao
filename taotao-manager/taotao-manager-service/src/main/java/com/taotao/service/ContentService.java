/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ContentService.java   
 * @Package com.taotao.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月23日 下午9:55:22   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.service;

import com.taotao.common.pojo.DataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**   
 * @Description: 内容服务
 * @ClassName:  ContentService
 * @author:  Axin 
 * @date:   2018年12月23日 下午9:55:22   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public interface ContentService {
	
	
	DataGridResult getContentList(Long categoryId, Integer page, Integer rows);
	
	
	TaotaoResult insertContent(TbContent content);

}
