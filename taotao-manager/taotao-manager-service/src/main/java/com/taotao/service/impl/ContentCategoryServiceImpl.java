/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ContentCategoryServiceImpl.java   
 * @Package com.taotao.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月20日 下午10:15:06   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.service.ContentCategoryService;

/**   
 * @Description: TODO 
 * @ClassName:  ContentCategoryServiceImpl
 * @author:  Axin 
 * @date:   2018年12月20日 下午10:15:06   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService{

	
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	/* (non-Javadoc)
	 * @see com.taotao.service.ContentCategoryService#getCategoryList(long)
	 */
	@Override
	public List<TreeNode> getCategoryList(Long parentId) {
		// 根据parentId查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<TbContentCategory> list = this.contentCategoryMapper.selectByExample(example);
		
		List<TreeNode> resultList = new ArrayList<>();
		for (TbContentCategory item : list) {
			TreeNode node = new TreeNode();
			node.setId(item.getId());
			node.setText(item.getName());
			if(item.getIsParent()){
				node.setState("closed");
			}else{
				node.setState("open");
			}
			resultList.add(node);
		}
		return resultList;
	}
	/* (non-Javadoc)
	 * @see com.taotao.service.ContentCategoryService#insertContentCategory(java.lang.Long, java.lang.String)
	 */
	@Override
	public TaotaoResult insertContentCategory(Long parentId, String name) {
		TbContentCategory cat = new TbContentCategory();
		cat.setName(name);
		cat.setIsParent(false);
		cat.setStatus(1);//1:正常 2：删除
		cat.setParentId(parentId);
		cat.setSortOrder(1);
		cat.setCreated(new Date());
		cat.setUpdated(new Date());
		//添加记录
		this.contentCategoryMapper.insert(cat);
		
		//查看父节点的isParent列是否为true,如果不是true改为true
		TbContentCategory parentCat = this.contentCategoryMapper.selectByPrimaryKey(parentId);
		if(!parentCat.getIsParent()){
			parentCat.setIsParent(true);
			//更新父节点
			this.contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		return TaotaoResult.ok(cat);
	}
	/* (non-Javadoc)
	 * @see com.taotao.service.ContentCategoryService#deleteContentCategoryById(java.lang.Long, java.lang.Long)
	 */
	@Override
	public void deleteContentCategoryById(Long id) {
		
		//先查询出父id
		TbContentCategory content = this.contentCategoryMapper.selectByPrimaryKey(id);
		Long parentId = content.getParentId();
		
		//删除
		this.contentCategoryMapper.deleteByPrimaryKey(id);
		//查询是否还有同级
		TbContentCategoryExample example = new TbContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<TbContentCategory> list = this.contentCategoryMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(list)){
			TbContentCategory parent = this.contentCategoryMapper.selectByPrimaryKey(parentId);
			parent.setIsParent(false);
			this.contentCategoryMapper.updateByPrimaryKey(parent);
		}
	}
	/* (non-Javadoc)
	 * @see com.taotao.service.ContentCategoryService#updateContentCategoryNameById(java.lang.Long)
	 */
	@Override
	public void updateContentCategoryNameById(Long id,String name) {
		//根据id查出对象
		TbContentCategory category = this.contentCategoryMapper.selectByPrimaryKey(id);
		category.setName(name);
		this.contentCategoryMapper.updateByPrimaryKey(category);
		
	}
	
	
	
	

}
