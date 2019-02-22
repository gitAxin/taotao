/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  UserService.java   
 * @Package com.taotao.portal.service   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月22日 下午10:16:21   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.service;

import com.taotao.pojo.TbUser;

/**   
 * @Description: TODO 
 * @ClassName:  UserService
 * @author:  Axin 
 * @date:   2019年2月22日 下午10:16:21   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public interface UserService {
	
	TbUser getUserByToken(String token);

}
