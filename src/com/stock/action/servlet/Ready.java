package com.stock.action.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.stock.utils.Sqls;

public class Ready extends HttpServlet {

	
	private Log log =LogFactory.getLog(this.getClass());
	
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException 
	{
		log.info("初始化数据开始");
		
		Sqls.refresh();//初始化Sql集合
		
		log.info("初始化数据结束");
	}

	
	
	
}
