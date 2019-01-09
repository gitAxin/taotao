/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ContentServiceImpl.java   
 * @Package com.taotao.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月23日 下午9:57:08   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.DataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.service.ContentService;

/**   
 * @Description: TODO 
 * @ClassName:  ContentServiceImpl
 * @author:  Axin 
 * @date:   2018年12月23日 下午9:57:08   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class ContentServiceImpl implements ContentService {

	
	@Autowired
	private TbContentMapper contentMapper;
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;
	
	/* (non-Javadoc)
	 * @see com.taotao.service.ContentService#getContentList(java.lang.Long, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public DataGridResult getContentList(Long categoryId, Integer page, Integer rows) {

		TbContentExample example = new TbContentExample();
		example.createCriteria().andCategoryIdEqualTo(categoryId);
		
		PageHelper.startPage(page, rows);
		List<TbContent> list = this.contentMapper.selectByExample(example);
		
		PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(list);
		long total = pageInfo.getTotal();
		
		DataGridResult result = new DataGridResult();
		result.setRows(list);
		result.setTotal(total);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.taotao.service.ContentService#insertContent(com.taotao.pojo.TbContent)
	 */
	@Override
	public TaotaoResult insertContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		this.contentMapper.insert(content);
		
		try {
			//添加缓存同步逻辑
			HttpClientUtil.doGet(REST_BASE_URL+REST_CONTENT_SYNC_URL+content.getCategoryId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return TaotaoResult.ok();
	}

	
	
	
}
