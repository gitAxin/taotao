/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  UserServiceImpl.java   
 * @Package com.taotao.sso.service.impl   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月17日 下午8:15:08   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.sso.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.sso.service.UserService;

/**   
 * @Description: 用户管理Service 
 * @ClassName:  UserServiceImpl
 * @author:  Axin 
 * @date:   2019年2月17日 下午8:15:08   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private TbUserMapper userMapper;
	/* (non-Javadoc)
	 * @see com.taotao.sso.service.UserService#checkData(java.lang.String, java.lang.String)
	 */
	@Override
	public TaotaoResult checkData(String content, Integer type) {
		// 对数据进行校验 1、2、3分别代表username,phone,email
		//用户名校验
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		if(1 == type){
			criteria.andUsernameEqualTo(content);
		}else if(2 == type){
			criteria.andPhoneEqualTo(content);
		}else{
			criteria.andEmailEqualTo(content);
		}
		
		List<TbUser> list = userMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(list)){
			return TaotaoResult.ok(true);
		}
		return TaotaoResult.ok(false);
		
	}
	/* (non-Javadoc)
	 * @see com.taotao.sso.service.UserService#createUser(com.taotao.pojo.TbUser)
	 */
	@Override
	public TaotaoResult createUser(TbUser user) {
		user.setCreated(new Date());
		user.setUpdated(new Date());
		//MD5加密
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userMapper.insert(user);
		return TaotaoResult.ok();
	}
	
	
	
	
}
