package com.stock.action.login;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

	
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String loginHold(Map<String,Object> model)
	{		
		//
		//@RequestMapping({"/","/login"})
		System.out.println("*************  is here  **************");
		
		return "main";
	}
	
}
