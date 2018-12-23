/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ContentCategoryService.java   
 * @Package com.taotao.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月20日 下午10:14:05   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;

/**   
 * @Description: 内容分类服务 
 * @ClassName:  ContentCategoryService
 * @author:  Axin 
 * @date:   2018年12月20日 下午10:14:05   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public interface ContentCategoryService {
	
	
	List<TreeNode> getCategoryList(Long parentId);
	
	
	
	TaotaoResult insertContentCategory(Long parentId, String name);
	
	
	/**
	 * @Description: 删除内容分类根据id  
	 * @Title: deleteContentCategoryById   
	 * @param: @param id
	 * @param: @return      
	 * @return: TaotaoResult      
	 * @throws
	 */
	void deleteContentCategoryById(Long id);
	
	
	/**
	 * @Description: 修改分类名称  
	 * @Title: updateContentCategoryNameById   
	 * @param: id      
	 * @return: void      
	 * @throws
	 */
	void updateContentCategoryNameById(Long id,String name);
}
