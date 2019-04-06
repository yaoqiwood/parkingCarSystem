package com.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title			: BackHandlerInterceptor</p>
 * <p>Description	: 系统最高权限拦截器</p>
 * <p>DevelopTools	: Eclipse_x64_v4.9.0</p>
 * <p>DevelopSystem	: Windows10</p>
 * @author			: Lian
 * @date			: 2019年02月18日 23:33:03
 * @version	 		: 1.0.0
 */
public class BackHandlerInterceptor implements HandlerInterceptor {

	/**
	 * 进入Handler方法之前执行
	 * @param request 	HttpServletRequest
	 * @param response 	HttpServletResponse
	 * @param handler 	handler
	 * @return true(放行) or false(拦截)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("执行前");
		return true;
	}

	/**
	 * 进入Handler方法之后，返回modelAndView之前执行(可以往MV里面填充公用的ModelAndView)
	 * @param request 	HttpServletRequest
	 * @param response 	HttpServletResponse
	 * @param handler 	handler
	 * @param mv 		ModelAndView
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("执行中");
	}

	/**
	 * 执行Handler完成后执行(统一异常处理，统一日志处理)
	 * @param request 	HttpServletRequest
	 * @param response 	HttpServletResponse
	 * @param handler 	handler
	 * @param e 		异常信息
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("执行后");
	}

}
