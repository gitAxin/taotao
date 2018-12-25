/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ContentServiceImpl.java   
 * @Package com.taotao.rest.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月24日 下午10:39:14   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.rest.service.ContentService;

/**   
 * @Description: TODO 
 * @ClassName:  ContentServiceImpl
 * @author:  Axin 
 * @date:   2018年12月24日 下午10:39:14   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class ContentServiceImpl implements ContentService {

	
	@Autowired
	private TbContentMapper contentMapper;
	
	/* (non-Javadoc)
	 * @see com.taotao.rest.service.ContentService#getContentList(long)
	 */
	@Override
	public List<TbContent> getContentList(long contentCid) {
		
		TbContentExample example = new TbContentExample();
		example.createCriteria().andCategoryIdEqualTo(contentCid);
		List<TbContent> list = this.contentMapper.selectByExample(example);
		return list;
	}

}
