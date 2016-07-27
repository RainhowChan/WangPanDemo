package cn.rainhowchan.web;

import java.io.File;
import java.io.FileOutputStream;
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
import org.apache.commons.io.IOUtils;

import cn.rainhowchan.domain.Resource;
import cn.rainhowchan.servcie.DataService;
import cn.rainhowchan.utils.FileUploadUtils;

public class FileAddServlet extends HttpServlet {

	private int flag;
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
				Resource resource = new Resource();
				for (FileItem fileItem : items) {
					if(!fileItem.isFormField()){//为上传组件
						String name = fileItem.getName();//得到上传文件的名称，有的浏览器会包含路径
						String fileName=FileUploadUtils.getRealName(name);//得到不含路径的真实文件名
						String uuidname=FileUploadUtils.getUUIDFileName(fileName);//得到编码后的文件名
						File f = new File("d:\\temp",FileUploadUtils.getRandomSavePath(fileName));
						if(!f.exists()) f.mkdirs();
						IOUtils.copy(fileItem.getInputStream(),new FileOutputStream(new File(f,uuidname)));
						fileItem.delete();
						
						resource.setRealname(fileName);
						resource.setUuidname(uuidname);
						resource.setSavepath(f.toString());
						
						flag+=1;
					}else{
						resource.setDescription(fileItem.getString("utf-8"));
						flag+=1;
					}
					
					if(flag==2){
						flag=0;
						DataService service = new DataService();
						try {
							service.addNewFileInfo(resource);
						} catch (Exception e) {
							response.getWriter().write(e.toString());
						}
					}
		
				}
				response.sendRedirect(request.getContextPath()+"/dataSearch");
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}else
			response.getWriter().write("不是上传操作！");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
