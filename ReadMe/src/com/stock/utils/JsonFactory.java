package com.stock.utils;

import java.util.Map;

public class JsonFactory {

	public static String getJson(Map<String,String> map)
	{
		StringBuffer sb = new StringBuffer();
		if(map!=null&&map.size()>0)
		{
			for (Object o : map.keySet()) {
				sb.append("\"");
				sb.append(o.toString());
				sb.append("\"");
				sb.append(":");
				sb.append("\"");
				sb.append(map.get(o));
				sb.append("\"");
				sb.append(",");
			}
		}
		return trimJson(sb.toString());
	}
	
	private static String trimJson(String str)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		if(str!=null)
		{
			String s = str.substring(str.length()-1,str.length());
			if(s.equals(","))
			{
				str = str.substring(0,str.length()-1);
			}
		}
		sb.append(str);
		sb.append("}");
		return sb.toString();
	}
	
	
}
