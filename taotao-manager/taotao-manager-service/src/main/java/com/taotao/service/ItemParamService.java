/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  ItemParamService.java   
 * @Package com.taotao.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2018年12月11日 下午11:08:53   
 * @version V1.0 
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.service;

import com.taotao.common.pojo.DataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**   
 * @ClassName:  ItemParamService   
 * @Description:TODO   
 * @author:  Axin 
 * @date:   2018年12月11日 下午11:08:53   
 * @Copyright: 2018 www.hao456.top Inc. All rights reserved. 
 */
public interface ItemParamService {
	
	
	DataGridResult getItemParamList(Integer page, Integer rows);
	
	TaotaoResult getItemParamByCid(long cid);
	
	
	TaotaoResult insertItemParam(TbItemParam itemParam);

}
