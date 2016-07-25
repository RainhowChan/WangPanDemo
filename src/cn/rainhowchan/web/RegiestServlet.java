package cn.rainhowchan.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rainhowchan.domain.User;
import cn.rainhowchan.servcie.UserService;
import cn.rainhowchan.utils.CommonUtils;

public class RegiestServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		User user = CommonUtils.conventToBean(request.getParameterMap(), User.class);
		System.out.println(user);
		UserService service = new UserService();
		try {
			service.insertUser(user);
			response.getWriter().write("注册成功！两秒后跳转到登录界面");
		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);	
	}

}
