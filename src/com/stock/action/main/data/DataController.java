package com.stock.action.main.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stock.entity.Stock;
import com.stock.entity.StockLog;
import com.stock.entity.StockName;
import com.stock.entity.User;
import com.stock.service.StockNameService;
import com.stock.service.StockService;
import com.stock.utils.AjaxUtil;
import com.stock.utils.JsonFactory;

@Controller
public class DataController {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private StockNameService snService;
	
	
	@RequestMapping("data/add/load/content")
	public String loadAddDataContent()
	{
		String path = "main/data/add_data";
		log.info("load add data page content");
		return path;
	}
	
	@RequestMapping("/data/ajax/user/stockname")
	public void getCurUserStockNames(HttpServletResponse res,HttpSession session)
	{
		User curUser = (User) session.getAttribute("currentUser");
		if(curUser !=null )
		{
			List<Stock> list = stockService.getStocksByUser(curUser);
			Map<String,String> map = new HashMap<String,String>();
			for(Stock s : list){
				s.setStockName(snService.findById(new StockName(s.getStockNameId())));
				map.put(s.getId()+"", s.getStockName().getName());
			}
			AjaxUtil.ajaxWrite(res, JsonFactory.getJson(map));
		}		
	}
	
	@RequestMapping("data/add/save/stock/use")
	public void getStockLogDataByPost(@ModelAttribute("form") StockLog sl)
	{
		System.out.println("is here ");
		System.out.println(sl.getTime());
		System.out.println(sl.getStockId());
		System.out.println(sl.getNumber());
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
