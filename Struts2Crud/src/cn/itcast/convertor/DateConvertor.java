package cn.itcast.convertor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateConvertor extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			Class toType) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if(toType==Date.class){
			//转换成日期
			String s = ((String[])value)[0];
			try {
				return df.parseObject(s);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}else{
			Date d = (Date)value;
			return df.format(d);
		}
	}
	
}
