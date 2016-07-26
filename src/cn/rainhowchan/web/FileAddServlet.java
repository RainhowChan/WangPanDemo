package cn.rainhowchan.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.rainhowchan.utils.FileUploadUtils;

public class FileAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建缓存路径及缓存大小
		File file=new File(getServletContext().getRealPath("/temp"));
		if(!file.exists()) file.mkdirs();
		DiskFileItemFactory factory = new DiskFileItemFactory(1024*1000,file);
		
		if(ServletFileUpload.isMultipartContent(request)){//判断是否为上传文件操作
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024*1024*20);//设置单个文件上传大小最大为20M
			upload.setHeaderEncoding("utf-8");//解决上传文件中文名乱码问题
			
			try {
				@SuppressWarnings("unchecked")
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem fileItem : items) {
					if(!fileItem.isFormField()){//为上传组件
						String name = fileItem.getName();//得到上传文件的名称，有的浏览器会包含路径
						String fileName=FileUploadUtils.getRealName(name);//得到不含路径的真实文件名
						String uuidname=FileUploadUtils.getUUIDFileName(fileName);//得到
					}
					
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
