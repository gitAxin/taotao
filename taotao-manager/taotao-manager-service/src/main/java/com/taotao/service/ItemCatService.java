/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemCatService.java   
 * @Package com.taotao.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月3日 下午11:05:11   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.TreeNode;

/**   
 * @ClassName:  ItemCatService   
 * @Description:TODO   
 * @author:  Axin 
 * @date:   2018年12月3日 下午11:05:11   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public interface ItemCatService {

	
	List<TreeNode> getCatList(long parentId);
}
