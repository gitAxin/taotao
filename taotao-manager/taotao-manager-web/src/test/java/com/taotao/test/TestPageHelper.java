/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  TestPageHelper.java   
 * @Package com.taotao.test   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月2日 下午11:44:47   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

/**   
 * @ClassName:  TestPageHelper   
 * @Description:TODO   
 * @author:  Axin 
 * @date:   2018年12月2日 下午11:44:47   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public class TestPageHelper {
	
	@Test
	public void testPageHelper(){
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(1, 10);
		List<TbItem> list = mapper.selectByExample(example);
		for (TbItem item : list) {
			System.out.println(item.getTitle());
			
		}
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		System.out.println("总共:"+total+"条记录");
		
	}

}
