package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
*********************************************
*@类名   ChacterEncoding
*@时间   2017年6月1日 上午9:41:53
*@作者   guyan
*@描述        处理中文乱码
*********************************************
*/
public class ChacterEncoding implements Filter{
	  protected FilterConfig filterConfig = null; //初始化配置
	    protected String encoding = null; 			//接收字符编码
	    protected boolean ignore = true;			//是否忽略大小写
	public void destroy() {
		// TODO Auto-generated method stub
		this.encoding = null;
        this.filterConfig = null;

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 if (ignore || (request.getCharacterEncoding() == null)) {
	            String encoding = selectEncoding(request);	//如果为空先从web.xml中得到
	            if (encoding != null){
	                request.setCharacterEncoding(encoding);	//设置字符集编码
				}
	        }
	        chain.doFilter(request, response);//过滤

	}
	private String selectEncoding(ServletRequest request) {
		// TODO Auto-generated method stub
		return (this.encoding);
	}

	/**
	 * 得到字符编码
	 * @param request
	 * @return
	 */

	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fc;	
        this.encoding = filterConfig.getInitParameter("encoding");	//从web.xml文件中读取encoding的值
        String value = filterConfig.getInitParameter("ignore");		//从web.xml文件中读取ignore的值
        //以下三种情况均为忽略大小写
        if (value == null)
            this.ignore = true;
        else if (value.equalsIgnoreCase("true"))
            this.ignore = true;
        else if (value.equalsIgnoreCase("yes"))
            this.ignore = true;
        else
            this.ignore = false;

	}

}
