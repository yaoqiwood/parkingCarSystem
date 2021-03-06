/**
 * 
 */
package com.example.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;



/**
 * <p>
 * Title:MyXssFilter
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * DevelopTools:Eclipse_x64_v4.7.1
 * </p>
 * <p>
 * DevelopSystem : macOS Sierra 10.12.1
 * </p>
 * <p>
 * Company : org.xiongyi
 * </p>
 * 
 * @author:XiongYi
 * @date:2019年3月2日 上午10:51:13
 * @version:12.0.0
 */
public class MyXssFilter implements Filter {
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        filterChain.doFilter(new XsslHttpServletRequestWrapper(request),servletResponse);
    }

    @Override
    public void destroy() {

    }
}
