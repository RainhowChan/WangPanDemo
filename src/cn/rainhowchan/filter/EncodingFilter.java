package cn.rainhowchan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rainhowchan.diyclass.MyRequest;

public class EncodingFilter implements Filter{

	private String encoding;

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpServletResponse response=(HttpServletResponse)servletResponse;
		
		HttpServletRequest myRequest=new MyRequest(request);
		if(request.getMethod().equalsIgnoreCase("GET"))//get����
			response.setContentType("text/html;charset="+encoding);
		else//post����
			request.setCharacterEncoding(encoding);
		chain.doFilter(myRequest, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
	}

}
