package cn.rainhowchan.utils;

import java.util.UUID;

public class FileUploadUtils {

	public static String getRealName(String name) {
		return name.substring(name.lastIndexOf("\\")+1);
	}

	public static String getUUIDFileName(String fileName) {
		int index = fileName.lastIndexOf(".");
		if(index!=-1)
			return UUID.randomUUID().toString().replace("-", "")+fileName.substring(index);//文件名带有后缀的
		else
			return UUID.randomUUID().toString().replace("-", "");//文件名不带后缀的
	}

	/**
	 * 目录分离
	 * @param fileName
	 * @return
	 */
	public static String getRandomSavePath(String fileName) {
		int hashCode = fileName.hashCode();
		int a=hashCode&0xf;
		hashCode=hashCode&0xf;
		int b=hashCode&0xf;
		return "/"+a+"/"+b;
	}
	
}
