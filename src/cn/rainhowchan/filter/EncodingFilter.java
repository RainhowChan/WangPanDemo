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
		
		response.setContentType("text/html;charset="+encoding);
		
		if(request.getMethod().equalsIgnoreCase("GET")){//get«Î«Û
			if(!(request instanceof MyRequest))
				request=new MyRequest(request,encoding);
		}
		else//post«Î«Û
			request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
	}

}
