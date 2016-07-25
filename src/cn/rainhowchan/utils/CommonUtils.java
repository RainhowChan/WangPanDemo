package cn.rainhowchan.utils;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class CommonUtils {
	public static <T> T conventToBean(@SuppressWarnings("rawtypes") Map map,Class<T> clazz){
		try {
			T bean = clazz.newInstance();
			DateConverter converter = new DateConverter();
			converter.setPattern("yyyy-MM-dd");
			ConvertUtils.register(converter, java.util.Date.class);
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/*class DateConverter implements Converter{

		@Override
		public Object convert(Class type, Object value) {
			if(value==null) return null;
			if(!(value instanceof String))
				return value;
			String dateStr=(String) value;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				return format.parse(dateStr);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		
	}*/
}
