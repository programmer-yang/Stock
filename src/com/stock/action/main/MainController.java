package com.stock.action.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stock.entity.Stock;
import com.stock.entity.StockLog;
import com.stock.entity.StockName;
import com.stock.entity.User;
import com.stock.service.StockLogService;
import com.stock.service.StockNameService;
import com.stock.service.StockService;
import com.stock.utils.AjaxUtil;
import com.stock.utils.JsonFactory;
import com.stock.utils.MathExtend;

@Controller
public class MainController {

	private Log log = LogFactory.getLog(this.getClass());
	private String path;

	@Autowired
	private StockService stockService;
	@Autowired
	private StockNameService snService;
	@Autowired
	private StockLogService slService;

	@RequestMapping("main/chart")
	public String getMainPagePie(Map<String, Object> model) {
		log.info("get main page chart path");
		path = "main/chart/chart_page";

		model.put("testData", "...baba");

		return path;
	}

	@RequestMapping("main/load/menu")
	public String loadContentMenu(Map<String, Object> model) {
		path = "main/menu/menu_left";

		return path;
	}

	@RequestMapping("main/load/page")
	public String loadMainPage(Map<String, Object> model) {
		path = "main/chart/chart_page";

		return path;
	}

	@RequestMapping("main/ajax/pie/data")
	public void getMainPieDataByJson(Map<String, Object> model,HttpServletRequest req, HttpServletResponse res) {

		User user = (User) req.getSession().getAttribute("currentUser");
		Stock stockPara = new Stock();// 参数，可修改
		stockPara.setUser(user);
		stockPara.setValid(1);

		Stock stock = stockService.getStockSumByUser(stockPara);

		/**
		 * 目前首页动态获取数据只通过ajax获取了饼图的json数据，饼图旁的说明文字目前还没有说去， 因为还没有最终确认需要获取哪些数据
		 * 待确认后在添加对应方法就好 看是通过一个ajax还是通过多个ajax分别获取，这里还需要思考
		 */

		// model.put("message", "error");
		AjaxUtil.ajaxWrite(res, getPieJson(stock));

	}

	/**
	 * 首页饼图JSON数据处理类
	 */
	private String getPieJson(Stock stock) {
		Map<String, String> map = new HashMap<String, String>();

		try {
			double sur = MathExtend.divide(
					Double.parseDouble(stock.getNumberCur()),
					Double.parseDouble(stock.getNumberSum()), 2);
			double use = MathExtend.subtract(1, sur);
			map.put("sur", sur + "");
			map.put("use", use + "");
		} catch (Exception e) {
			log.error("获取首页饼图JSON数据时异常");
			log.error(e.getMessage());
			return "error";
		}

		return JsonFactory.getJson(map);
	}
	
	@RequestMapping("/main/ajax/column/data")
	public void getColumnDataByJson(Map<String, Object> model,HttpServletRequest req, HttpServletResponse res)
	{
		User user = (User) req.getSession().getAttribute("currentUser");
		StockLog sl = new StockLog();
		Stock s=new Stock();
		s.setUserId(user.getId());
		sl.setStock(s);
		sl.setTime("20140917");//伪数据，待数据正常后改为获取系统当前日期或者参数传递
		List<StockLog> list = slService.getStockLogListById(sl);
		
		//System.out.println(list);
		String columnJson = getColumnJson(list);
		//System.out.println(columnJson);
		
		AjaxUtil.ajaxWrite(res, columnJson);
		
		
	}
	
	private String getColumnJson(List<StockLog> list)
	{
		for(StockLog sl : list)
		{
			sl.setStock(stockService.findById(new Stock(sl.getStockId())));
			sl.getStock().setStockName(snService.findById(new StockName(sl.getStock().getStockNameId())));
			JsonFactory.add(sl.getStock().getStockName().getName(), sl.getNumber());
			
		}
		return JsonFactory.getJsonByBaseJson();
	}
	

	public static void main(String[] args) {

		double number = MathExtend.subtract(1, 0.66);
		System.out.println(number);
		

	}

}
