/**
 * 
 */
package com.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.text.StringEscapeUtils;



/**
 * <p>
 * Title:XsslHttpServletRequestWrapper
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
 * @date:2019年3月2日 上午10:53:57
 * @version:12.0.0
 */
public class XsslHttpServletRequestWrapper extends HttpServletRequestWrapper {

	 public XsslHttpServletRequestWrapper(HttpServletRequest request) {  
	        super(request);  
	    }  
	  
	    @Override  
	    public String getHeader(String name) {  
	        return StringEscapeUtils.escapeHtml4(super.getHeader(name));  
	    }  
	  
	    @Override  
	    public String getQueryString() {  
	        return StringEscapeUtils.escapeHtml4(super.getQueryString());  
	    }  
	  
	    @Override  
	    public String getParameter(String name) {  
	        return StringEscapeUtils.escapeHtml4(super.getParameter(name));  
	    }  
	  
	    @Override  
	    public String[] getParameterValues(String name) {  
	        String[] values = super.getParameterValues(name);  
	        if(values != null) {  
	            int length = values.length;  
	            String[] escapseValues = new String[length];  
	            for(int i = 0; i < length; i++){  
	                escapseValues[i] = StringEscapeUtils.escapeHtml4(values[i]);  
	            }  
	            return escapseValues;  
	        }  
	        return super.getParameterValues(name);  
	    }
}
