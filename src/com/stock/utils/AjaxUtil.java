package com.stock.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;

public class AjaxUtil
{
	public static void ajaxWrite(HttpServletResponse response, String result)
	{
		
		try
		{
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().write(result);
		}
		catch (IOException e)
		{
			LogFactory.getLog(AjaxUtil.class).error("AJAX请求异常");
			LogFactory.getLog(AjaxUtil.class).error(e.getMessage());
		}
	}
}
