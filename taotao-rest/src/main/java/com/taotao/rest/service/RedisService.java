/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  RedisService.java   
 * @Package com.taotao.rest.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年1月9日 下午10:11:19   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;

/**   
 * @Description: TODO 
 * @ClassName:  RedisService
 * @author:  Axin 
 * @date:   2019年1月9日 下午10:11:19   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface RedisService {
	
	TaotaoResult syncContent(long contentCid);

}
