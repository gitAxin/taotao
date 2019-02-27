/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title:  LoginInterceptor.java   
 * @Package com.taotao.portal.interceptor   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: axin     
 * @date:   2019年2月22日 下午9:53:39   
 * @version V1.0 
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
package com.taotao.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.common.utils.CookieUtils;
import com.taotao.pojo.TbUser;
import com.taotao.portal.service.impl.UserServiceImpl;

/**   
 * @Description: 登录拦截器 
 * @ClassName:  LoginInterceptor
 * @author:  Axin 
 * @date:   2019年2月22日 下午9:53:39   
 * @Copyright: 2019 www.hao456.top Inc. All rights reserved. 
 */
public class LoginInterceptor implements HandlerInterceptor{

	
	@Autowired
	private UserServiceImpl userService;
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//在Handler执行之前处理
		
		//1：从cookie中取token
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		//2:根据token调用sso接口，换取用户信息
		TbUser user = userService.getUserByToken(token);
		//取不到用户信息
		if(user == null){
			//需要跳转到登录页面，需要把用户请求的url作为参数传递给登录页面
			response.sendRedirect(userService.SSO_BASE_URL+userService.SSO_PAGE_LOGIN
						+ "?redirect=" + request.getRequestURL());
			//返回false
			return false;
			
		}
		
		//取到用户信息，放行
		//把用户信息放入Request中
		request.setAttribute("user", user);
		//返回值决定handler是否执行。true：执行，false：不执行。
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// hander执行之后，返回ModelAndView之前
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 返回ModelAndView之后
		
	}
	
	

}
