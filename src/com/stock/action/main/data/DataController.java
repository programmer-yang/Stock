package com.stock.action.main.data;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataController {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping("main/data/load/content")
	public String loadAddDataContent()
	{
		String path = "main/data/add_data";
		log.info("load add data page content");
		return path;
	}
	
}
