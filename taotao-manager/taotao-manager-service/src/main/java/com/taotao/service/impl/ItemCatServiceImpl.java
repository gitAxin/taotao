/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemCatServiceImpl.java   
 * @Package com.taotao.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月3日 下午11:06:48   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;

/**   
 * @ClassName:  ItemCatServiceImpl   
 * @Description:商品分类接口实现类  
 * @author:  Axin 
 * @date:   2018年12月3日 下午11:06:48   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{

	
	@Autowired
	private TbItemCatMapper itemCatMapper;
	/* (non-Javadoc)
	 * @see com.taotao.service.ItemCatService#getCatList(long)
	 */
	@Override
	public List<TreeNode> getCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<TbItemCat> list = this.itemCatMapper.selectByExample(example);
		
		List<TreeNode> nodeList = new ArrayList<>();
		for (TbItemCat cat : list) {
			TreeNode node = new TreeNode();
			node.setId(cat.getId());
			node.setText(cat.getName());
			node.setState(cat.getIsParent()?"closed":"open");
			nodeList.add(node);
		}

		return nodeList;
	}
	
	
	
	

}
