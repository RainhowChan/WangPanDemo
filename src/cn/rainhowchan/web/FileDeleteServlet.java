package cn.rainhowchan.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.rainhowchan.servcie.DataService;

public class FileDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataService service = new DataService();
		String uuidName = request.getParameter("uuidname");
		
		try {
			String path = service.searchDataByUuidName(uuidName);
			System.out.println(path);
			File file = new File(path);
			if(file.exists())
				file.delete();
			else{
				service.deleteResourceByUuidName(uuidName);
				response.getWriter().write("该文件已经不存在了！");
				return;
			}
		} catch (Exception e1) {
			response.getWriter().write(e1.toString());
			return;
		}
		
		try {
			int count = service.deleteResourceByUuidName(uuidName);
			if(count>0) response.sendRedirect(request.getContextPath()+"/dataSearch");
		} catch (Exception e) {
			response.getWriter().write(e.toString());
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
