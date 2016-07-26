package cn.rainhowchan.utils;

import java.util.UUID;

public class FileUploadUtils {

	public static String getRealName(String name) {
		return name.substring(name.lastIndexOf("\\")+1);
	}

	public static String getUUIDFileName(String fileName) {
		int index = fileName.lastIndexOf(".");
		if(index!=-1)
			return UUID.randomUUID()+fileName.substring(index);//文件名带有后缀的
		else
			return UUID.randomUUID().toString();//文件名不带后缀的
	}
	
}
