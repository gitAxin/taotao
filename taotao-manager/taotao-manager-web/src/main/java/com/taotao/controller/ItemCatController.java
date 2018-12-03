/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemCatController.java   
 * @Package com.taotao.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月3日 下午11:15:57   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ItemCatService;

/**   
 * @ClassName:  ItemCatController   
 * @Description:商品分类Controller   
 * @author:  Axin 
 * @date:   2018年12月3日 下午11:15:57   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNode> getCatList(@RequestParam(value="id",defaultValue="0")long parentId){
		List<TreeNode> list = this.itemCatService.getCatList(parentId);
		return list;
	}

}
