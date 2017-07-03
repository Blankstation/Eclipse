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
*@����   ChacterEncoding
*@ʱ��   2017��6��1�� ����9:41:53
*@����   guyan
*@����        ������������
*********************************************
*/
public class ChacterEncoding implements Filter{
	  protected FilterConfig filterConfig = null; //��ʼ������
	    protected String encoding = null; 			//�����ַ�����
	    protected boolean ignore = true;			//�Ƿ���Դ�Сд
	public void destroy() {
		// TODO Auto-generated method stub
		this.encoding = null;
        this.filterConfig = null;

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 if (ignore || (request.getCharacterEncoding() == null)) {
	            String encoding = selectEncoding(request);	//���Ϊ���ȴ�web.xml�еõ�
	            if (encoding != null){
	                request.setCharacterEncoding(encoding);	//�����ַ�������
				}
	        }
	        chain.doFilter(request, response);//����

	}
	private String selectEncoding(ServletRequest request) {
		// TODO Auto-generated method stub
		return (this.encoding);
	}

	/**
	 * �õ��ַ�����
	 * @param request
	 * @return
	 */

	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fc;	
        this.encoding = filterConfig.getInitParameter("encoding");	//��web.xml�ļ��ж�ȡencoding��ֵ
        String value = filterConfig.getInitParameter("ignore");		//��web.xml�ļ��ж�ȡignore��ֵ
        //�������������Ϊ���Դ�Сд
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
