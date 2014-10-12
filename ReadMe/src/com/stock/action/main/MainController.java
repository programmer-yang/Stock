package com.stock.action.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.entity.Stock;
import com.stock.service.StockService;
import com.stock.utils.AjaxUtil;
import com.stock.utils.JsonFactory;
import com.stock.utils.MathExtend;

@Controller
public class MainController {
	
	private Log log =LogFactory.getLog(this.getClass());
	private String path;
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping("main/chart")
	public String getMainPagePie(Map<String,Object> model)
	{
		log.info("get main page chart path");
		path = "main/chart/chart_page";
		
		model.put("testData", "...baba");
		
		return path;
	}
	
	@RequestMapping("main/load/menu")
	public String loadContentMenu(Map<String,Object> model)
	{
		path="main/menu/menu_left";
		
		return path;
	}
	
	@RequestMapping("main/load/page")
	public String loadMainPage(Map<String,Object> model)
	{
		path="main/chart/chart_page";
		
		return path;
	}
	@RequestMapping("main/ajax/pie/data")
	public void getMainPieDataByJson(Map<String,Object> model,HttpServletResponse response)
	{
		Stock stock = stockService.getStockNumberByUser("100", "1", "SELECT_STOCK_SUM");
		model.put("message", "error");
		AjaxUtil.ajaxWrite(response, getPieJson(stock));
//		AjaxUtil.ajaxWrite(response, "error");
	}
	
	
	private String getPieJson(Stock stock)
	{
		Map<String,String> map = new HashMap<String,String>();
		
		try {
			double sur = MathExtend.divide(Double.parseDouble(stock.getNumberCur()),Double.parseDouble(stock.getNumberSum()),2);
			double use = MathExtend.subtract(1, sur);
			map.put("sur",sur+"");
			map.put("use",use+"");
		} catch (Exception e) {
			log.error("获取首页饼图JSON数据时异常");
			log.error(e.getMessage());
			return "error";
		}
		
		return JsonFactory.getJson(map);
	}
	
	public static void main(String[] args) {
		
		double number = MathExtend.subtract(1, 0.66);
		System.out.println(number);
		
		
	}
	

}
