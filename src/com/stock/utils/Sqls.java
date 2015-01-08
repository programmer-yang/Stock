package com.stock.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
/**
 * 
 * SQL存储类
 * 实现很糟糕，目前没有更好的想法实现这块，先这么用这吧，以后待需要的时候再来修改
 * 
 * @author Yang
 *
 */
public class Sqls {
	
	private static Log log = null;
	private static Map<String,String> sqls = null;
	private static final String PATH = "configs/db/sqls.xml";
	
	private static void loadMap() 
	{
		String sqlPath = null;
		log = LogFactory.getLog(Sqls.class);
		sqlPath = Thread.currentThread().getContextClassLoader().getResource("").toString();
		sqlPath = sqlPath.substring(6,sqlPath.indexOf("WEB-INF"));	
		sqlPath = "/"+sqlPath;
		sqlPath += PATH;
		log.info("加载sql信息,加载路径为:"+sqlPath);
		sqls = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File(sqlPath));
			Element root =doc.getRootElement();
			
			listNodes(root);
		} catch (DocumentException e) {
			log.debug("加载SQL配置文件错误");
			log.debug(e.getMessage());
		}
		log.info("加载SQL操作执行完成，成功加载：+"+sqls.size()+"条SQL语句");
		//log = null;
	}
	
	public static String getSql(String key){
		String sql = null;
		if(sqls == null)
		{
			loadMap();
		}
		if(sqls!=null && sqls.size()<=0)
		{
			log.error("未加载到如何SQL信息，请确认配置文件是否正确");
		}
		//log.info("获取SQL请求：["+key+" : "+sqls.get(key)+"]");
		sql = sqls.get(key);
		if(sql == null && !"".equals(key))
		{
			log.error("获取key="+key+"的SQL信息错误");
			sql = null;
		}

		return sql;
	}
	
	public static void listNodes(Element node) {  
		String key = "";
		String value = "";
		Attribute attr = node.attribute("id");
		if(attr!=null&&!attr.getValue().equals(""))
		{
			key = attr.getValue();
			value = node.getTextTrim();
			if(value!=null&&!value.equals(""))
			{
				sqls.put(key, value);
			}
		}
		@SuppressWarnings("unchecked")
		Iterator<Element> it = node.elementIterator();  
		while (it.hasNext()) {
		    listNodes(it.next());  
		}
	}
	
	public static void showAllSql()
	{
		if(sqls!=null&&sqls.size()>0)
		{
			Set<String> keys = sqls.keySet();
			for (String key : keys) {
				System.out.println(key+":"+sqls.get(key));
			}
		}
	}
	
	public static void refresh()
	{
		loadMap();
	}
	
	public static void showPara(String sqlName,String sql,Object...para)
	{
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("SQL :[ ");
		sb.append(sqlName);
		sb.append(" : ");
		sb.append(sql);
//		sb.append(" ]");
//		log.info(sb.toString());
		
//		sb.delete(0, sb.length());
		
//		sb.append("参数列表:[ ");
//		sb.append(sqlName);
		sb.append(" : ");
		for(Object p : para)
		{
			sb.append(p+" ");
		}
		sb.append(" ]");
		
		log.info(sb.toString());
	}
	
}
