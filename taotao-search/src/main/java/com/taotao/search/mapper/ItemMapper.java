/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemMapper.java   
 * @Package com.taotao.search.mapper   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月9日 下午9:30:55   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.search.mapper;

import java.util.List;

import com.taotao.search.pojo.Item;

/**   
 * @Description: TODO 
 * @ClassName:  ItemMapper
 * @author:  Axin 
 * @date:   2019年2月9日 下午9:30:55   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface ItemMapper {

	List<Item> getItemList();	
	
	Item getItemById(Long id);	
}
