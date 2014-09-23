package com.stock.action.login;

import java.util.Map;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

	
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String inLogin(Map<String,Object> model)
	{		
		//
		//@RequestMapping({"/","/login"})
		System.out.println("*************login  is here  **************");
		
		return "login/login";
	}
	
	@RequestMapping({"/","/welcome"})
	public String inMain(Map<String,Object> model)
	{		
		System.out.println("*************welcome  is here  **************");
		
		return "main/main";
	}
	
}
