/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  UserServiceImpl.java   
 * @Package com.taotao.portal.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月22日 下午10:20:47   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.pojo.TbUser;
import com.taotao.portal.service.UserService;

/**   
 * @Description: TODO 
 * @ClassName:  UserServiceImpl
 * @author:  Axin 
 * @date:   2019年2月22日 下午10:20:47   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class UserServiceImpl implements UserService {

	
	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;
	
	@Value("${SSO_USER_TOKEN}")
	private String SSO_USER_TOKEN;
	
	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;
	
	/* (non-Javadoc)
	 * @see com.taotao.portal.service.UserService#getUserByToken(java.lang.String)
	 */
	@Override
	public TbUser getUserByToken(String token) {
		try {
			String json = HttpClientUtil.doGet(SSO_BASE_URL + SSO_USER_TOKEN +token);
			if(StringUtils.isEmpty(json)){
				return null;
			}
			//把json转换成TaotaoResult
			TaotaoResult result = TaotaoResult.formatToPojo(json, TbUser.class);
			if(result.getStatus()==200){
				return (TbUser)result.getData();
			}
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return null;
	}

}
