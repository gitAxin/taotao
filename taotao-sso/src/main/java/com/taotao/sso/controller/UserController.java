/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  UserController.java   
 * @Package com.taotao.sso.controller   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月17日 下午8:39:39   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.pojo.TbUser;
import com.taotao.sso.service.UserService;

/**   
 * @Description: 用户Controller 
 * @ClassName:  UserController
 * @author:  Axin 
 * @date:   2019年2月17日 下午8:39:39   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/check/{param}/{type}")
	@ResponseBody
	public Object checkData(@PathVariable("param") String param,
									@PathVariable("type")Integer type,
									String callback){
		
		TaotaoResult result = null;
		
		if(StringUtils.isEmpty(param)){
			result =  TaotaoResult.build(400, "校验内容不能为空");
		}
		if(type == null){
			result =  TaotaoResult.build(400, "校验内容类型不能为空");
		}
		if(type != 1 && type !=2 && type != 3){
			result =  TaotaoResult.build(400, "校验内容类型不能为空");
		}
		if(result != null){
			if(StringUtils.isNotEmpty(callback)){
				MappingJacksonValue mapperJacksonValue = new MappingJacksonValue(result);
				mapperJacksonValue.setJsonpFunction(callback);
				return mapperJacksonValue;
			}else{
				return result;
			}
		}
		try {
			result =  userService.checkData(param, type);
		} catch (Exception e) {
			result =  TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		if(StringUtils.isNotEmpty(callback)){
			MappingJacksonValue mapperJacksonValue = new MappingJacksonValue(result);
			mapperJacksonValue.setJsonpFunction(callback);
			return mapperJacksonValue;
		}else{
			return result;
		}
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createUser(TbUser user){
		try {
			TaotaoResult taotaoResult = this.userService.createUser(user);
			return taotaoResult;
		} catch (Exception e) {
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
	
	@RequestMapping(value="/login")
	@ResponseBody
	public TaotaoResult login(String username, String password){
		try {
			TaotaoResult result = userService.userLogin(username, password);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
	
	@RequestMapping(value="/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable("token")String token,String callback){
		TaotaoResult result;
		try {
			result = userService.getUserByToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			result =  TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		if(StringUtils.isEmpty(callback)){
			return result;
		}else{
			 MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			 mappingJacksonValue.setJsonpFunction(callback);
			 return mappingJacksonValue;
		}
	}
}
