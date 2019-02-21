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
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.sso.dao.JedisClient;
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
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;
	
	@Value("${SSO_SESSION_EXPIRE}")
	private Integer SSO_SESSION_EXPIRE;
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
	/* (non-Javadoc)
	 * @see com.taotao.sso.service.UserService#userLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public TaotaoResult userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response) {
		TbUserExample example = new TbUserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<TbUser> list = this.userMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(list)){
			return TaotaoResult.build(400, "用户名或密码错误");
		}
		TbUser user = list.get(0);
		
		if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())){
			return TaotaoResult.build(400, "用户名或密码错误");
		}
		//生成token
		String token = UUID.randomUUID().toString();
		//保存用户之前，把用户密码清掉
		user.setPassword(null);
		String set = jedisClient.set(REDIS_USER_SESSION_KEY+":"+token, JsonUtils.objectToJson(user));
		//设置session的过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY+":"+token, SSO_SESSION_EXPIRE);
		//添加写cookie逻辑
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);
		/*返回token*/
		return TaotaoResult.ok(token);
	}
	/* (non-Javadoc)
	 * @see com.taotao.sso.service.UserService#getUserByToken(java.lang.String)
	 */
	@Override
	public TaotaoResult getUserByToken(String token) {

		String string = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + token);
		if(StringUtils.isEmpty(string)){
			return TaotaoResult.build(400,"此session已经过期，请重新登录");
		}
		//更新过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		
		return TaotaoResult.ok(JsonUtils.jsonToPojo(string, TbUser.class));
	}
	/* (non-Javadoc)
	 * @see com.taotao.sso.service.UserService#logout(java.lang.String, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public TaotaoResult logout(String token, HttpServletRequest request, HttpServletResponse response) {
		jedisClient.del(REDIS_USER_SESSION_KEY + ":" + token);
		CookieUtils.deleteCookie(request, response, "TT_TOKEN");
		return TaotaoResult.ok();
	}
	
	
	
	
	
	
	
}
