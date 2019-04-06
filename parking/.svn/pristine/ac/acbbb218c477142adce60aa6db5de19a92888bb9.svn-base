/**
 * 
 */
package com.example.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.bean.Admin;

/**
 * <p>Title:SecurityInterceptor</p>
 * <p>Description:</p>
 * <p>DevelopTools:Eclipse_x64_v4.7.1</p>
 * <p>DevelopSystem : macOS Sierra 10.12.1</p>
 * <p>Company : org.xiongyi</p>
 * @author:XiongYi
 * @date:2019年3月4日 上午10:36:33
 * @version:12.0.0
 */
public class SecurityInterceptor implements HandlerInterceptor{

	 
	private List<String> excludeUrls;// 不需要拦截的资源
 
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}
 
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
 
	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {
 
	}
 
	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {
 
	}
 
	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		HttpSession session = request.getSession();
		Admin adminLogin = (Admin) session.getAttribute("admin");
		//判断是否包含在菜单权限里
 
		if ((url.indexOf("/admin/") > -1) || excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
			return true;
		}
		
		if ((adminLogin == null) || (adminLogin.getAdminId() == null)) {// 如果没有登录或登录超时
//			request.setAttribute("msg", "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			return false;
		}
		
//		if(!adminLogin.getAccessAllList().contains(url)){
//			return true;
//		}
// 
//		if (!adminLogin.getAccessList().contains(url)) {// 如果当前用户没有访问此资源的权限
//			request.setAttribute("msg", "您没有访问此资源的权限！<br/>请联系超管赋予您<br/>[" + url + "]<br/>的资源访问权限！");
//			request.getRequestDispatcher("login").forward(request, response);
//			return false;
//		}
 
		return true;
	}
}
