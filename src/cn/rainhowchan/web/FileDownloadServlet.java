package cn.rainhowchan.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;
import cn.rainhowchan.domain.Resource;
import cn.rainhowchan.servcie.DataService;
/**
 * Description 文件下载
 * @author RainhowChan
 */
public class FileDownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uuidName = request.getParameter("uuidname");
		DataService service = new DataService();
		try {
			Resource resource = service.searchDataByUuidName(uuidName);
			File file=new File(resource.getSavepath()+"\\"+resource.getUuidname());
			if(file.exists()){
				String realName = resource.getRealname();
				String fileName=realName;
//				String fileName=new String(realName.getBytes("iso8859-1"),"utf-8");
				response.setContentType(getServletContext().getMimeType(realName));
				
				String agent=request.getHeader("user-agent");
				if(agent.contains("MSIE")){
					fileName=URLEncoder.encode(fileName,"utf-8");
				}else if(agent.contains("Firefox")){
					BASE64Encoder base64Encoder = new BASE64Encoder();
					fileName = "=?utf-8?B?"
							+ base64Encoder.encode(fileName.getBytes("utf-8"))
							+ "?=";
				} else {
					fileName = URLEncoder.encode(fileName, "utf-8");
				}
				response.setHeader("content-disposition", "attachment;filename="+fileName);
				
				FileInputStream fis=new FileInputStream(file);
				ServletOutputStream os = response.getOutputStream();
				int len=-1;
				byte[] buffer=new byte[1024*100];
				while((len=fis.read(buffer))!=-1){
					os.write(buffer, 0, len);
				}
				os.close();
				fis.close();
			}else{
				throw new Exception("下载资源不存在.");
			}
		} catch (Exception e) {
			response.getWriter().write(e.toString());
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
