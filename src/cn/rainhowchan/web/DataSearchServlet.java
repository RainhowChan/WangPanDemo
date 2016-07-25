package cn.rainhowchan.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rainhowchan.domain.Resource;
import cn.rainhowchan.servcie.DataService;

public class DataSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		response.setContentType("text/html");
		int itemCount=5;
		int currentPage=1;
		//从数据库中分页查出所有的数据
		DataService service = new DataService();
		try {
			List<Resource> resources = service.searchDataByLimit(itemCount,currentPage);
			request.setAttribute("resources", resources);
			request.getRequestDispatcher("/wangpan.jsp").forward(request, response);
			
		} catch (Exception e) {
			response.getWriter().write(e.toString());
		}
		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}

}
