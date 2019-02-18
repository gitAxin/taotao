/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  UserService.java   
 * @Package com.taotao.sso.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月17日 下午8:14:16   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;

/**   
 * @Description: TODO 
 * @ClassName:  UserService
 * @author:  Axin 
 * @date:   2019年2月17日 下午8:14:16   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface UserService {
	
	
	TaotaoResult checkData(String content, Integer type);
	
	TaotaoResult createUser(TbUser user);
	
	TaotaoResult userLogin(String username, String password);

}
