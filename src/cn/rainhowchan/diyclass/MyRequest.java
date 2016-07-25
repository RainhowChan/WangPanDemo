package cn.rainhowchan.diyclass;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;
	private boolean flag=true;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}

	@Override
	public String getParameter(String name) {
		if(name==null) return null;
		
		Map<String, String[]> map = getParameterMap();
		String[] st = map.get(name);
		if(st==null||st.length==0) return null;
		
		return st[0];
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = request.getParameterMap();
		
		if(flag){
			for(String key:map.keySet()){
				String[] values=map.get(key);
				for (int i = 0; i < values.length; i++) {
					try {
						values[i]=new String(values[i].getBytes("iso8859-1"),"utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}	
			}
			flag=false;
		}
		return map;
	}

	@Override
	public String[] getParameterValues(String name) {
		if(name==null) return null;	
		return getParameterMap().get(name);
	}
	
	
}
