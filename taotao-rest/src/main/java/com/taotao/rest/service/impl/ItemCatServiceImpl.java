/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemCatServiceImpl.java   
 * @Package com.taotao.rest.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月19日 下午10:33:20   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;

/**   
 * @Description: TODO 
 * @ClassName:  ItemCatServiceImpl
 * @author:  Axin 
 * @date:   2018年12月19日 下午10:33:20   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{

	
	@Autowired
	private TbItemCatMapper itemCatMapper;
	/* (non-Javadoc)
	 * @see com.taotao.rest.service.ItemCatService#getItemCatList()
	 */
	@Override
	public CatResult getItemCatList() {
		CatResult catResult = new CatResult();
		catResult.setData(getCatList(0));
		return catResult;
	}
	/**   
	 * @Description: 查询分类列表 
	 * @Title: getCatList   
	 * @param: @param parentId
	 * @param: @return      
	 * @return: List<?>      
	 * @throws   
	 */
	private List<?> getCatList(long parentId) {

		TbItemCatExample example = new TbItemCatExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<TbItemCat> list = this.itemCatMapper.selectByExample(example);
		
		List resultList = new ArrayList<>();
		int count = 0;
		for (TbItemCat item : list) {
			if(item.getIsParent()){
				CatNode node = new CatNode();
				if(parentId == 0){
					node.setName("<a href='/products/"+item.getId()+".html'>"+item.getName()+"</a>");
				}else{
					node.setName(item.getName());
				}
				node.setUrl("/products/"+item.getId()+".html");
				node.setItem(getCatList(item.getId()));//递归添加
				resultList.add(node);
				count ++;
				//第一级第一层只取14条记录
				if(parentId == 0 && count >= 14 ){
					break;
				}
			}else{
				String catItem = "/products/"+item.getId()+".html|"+item.getName();
				resultList.add(catItem);
			}
		}
		
		return resultList;
	}

	
	
	
}
