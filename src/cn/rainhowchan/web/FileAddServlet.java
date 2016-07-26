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
		//��������·���������С
		File file=new File(getServletContext().getRealPath("/temp"));
		if(!file.exists()) file.mkdirs();
		DiskFileItemFactory factory = new DiskFileItemFactory(1024*1000,file);
		
		if(ServletFileUpload.isMultipartContent(request)){//�ж��Ƿ�Ϊ�ϴ��ļ�����
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024*1024*20);//���õ����ļ��ϴ���С���Ϊ20M
			upload.setHeaderEncoding("utf-8");//����ϴ��ļ���������������
			
			try {
				@SuppressWarnings("unchecked")
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem fileItem : items) {
					if(!fileItem.isFormField()){//Ϊ�ϴ����
						String name = fileItem.getName();//�õ��ϴ��ļ������ƣ��е�����������·��
						String fileName=FileUploadUtils.getRealName(name);//�õ�����·������ʵ�ļ���
						String uuidname=FileUploadUtils.getUUIDFileName(fileName);//�õ�
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
