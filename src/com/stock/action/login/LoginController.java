package com.stock.action.login;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stock.entity.SecurityUser;
import com.stock.entity.User;
import com.stock.service.UserService;

@Controller
public class LoginController {

	private Log log = LogFactory.getLog(this.getClass());
	private String path;
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String inLogin(Map<String, Object> model) {
		log.info("request  login  is here");

		return "login/login";
	}

	@RequestMapping({ "/", "/welcome" })
	public String inMain(Map<String, Object> model, HttpSession session) {
		path = "main/main";
		log.info("request  welcome  is here");
		holdCurrentUser(model, session);

		return path;
	}

	/**
	 * 控制当前用户信息
	 */
	private void holdCurrentUser(Map<String, Object> model, HttpSession session) {
		try {
			SecurityUser currentUser = null;
			if (null == session.getAttribute("currentUserName")) {
				currentUser = new SecurityUser();
				Object principal = SecurityContextHolder.getContext()
						.getAuthentication().getPrincipal();
				if (principal instanceof UserDetails) {
					currentUser.setUsername(((UserDetails) principal).getUsername());
					@SuppressWarnings("rawtypes")
					Iterator it = ((UserDetails) principal).getAuthorities().iterator();
					StringBuffer authoritys = new StringBuffer();
					while (it.hasNext()) {
						authoritys.append(((GrantedAuthority) it.next())
								.getAuthority() + ",");
					}
					currentUser.setAuthority(authoritys.toString());
				}
				session.setAttribute("currentUserName",currentUser.getUsername());
				session.setAttribute("currentUser", userService.findByUserName(new User(currentUser.getUsername())));

				/**
				 * 获取权限后如何处理，在这里是实现即可
				 */
				// model.put("currentUser", currentUser);
				log.info("CurrentUser:" + currentUser.getUsername() + ":"
						+ currentUser.getAuthority());
			}
		} catch (Exception e) {
			log.error("获取Security用户信息异常");
			log.error(e.getMessage());
			path = "error/404";
		}

	}

}
