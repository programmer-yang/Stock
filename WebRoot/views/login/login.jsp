<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
  <head>
    <title>login.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link href="<s:url value='/resources/css/bootstrap.css'/>" rel="stylesheet">
    <link href="<s:url value='/resources/css/flat-ui.css'/>" rel="stylesheet">
    <link href="<s:url value='/resources/css/demo.css'/>" rel="stylesheet">
    <link href="<s:url value='/resources/css/login.css'/>" rel="stylesheet">
	
  </head>
  
  <body>
  	<div class="container">
	  	<!-- 登陆 BEGIN -->
	    <div class="login login-center">
	        <div class="login-screen">
	          <div class="login-icon">
	            <img src="<s:url value='/resources/images/login/icon.png' />" alt="Welcome to Mail App" />
	            <h4>Welcome to <small>Stock App</small></h4>
	          </div>
			  
			  <s:url var="authUrl" value="/j_spring_security_check" />
			  <form name="loginForm" id="loginForm" method="post" action="${authUrl }">
		          <div class="login-form">
		            <div class="form-group">
		              <input type="text" class="form-control login-field" value="" placeholder="用户名" id="login-name" name="j_username" />
		              <label class="login-field-icon fui-user" for="login-name"></label>
		            </div>
		
		            <div class="form-group">
		              <input type="password" class="form-control login-field" value="" placeholder="密码" id="login-pass" name="j_password" />
		              <label class="login-field-icon fui-lock" for="login-pass"></label>
		            </div>
		
		            <a class="btn btn-primary btn-lg btn-block" href="javascript:loginForm.submit()">登  陆</a>
		            
		            <a class="login-link" href="#">忘记密码  ?</a>
		          </div>
	          </form>
	        </div>
	      </div>
	      <!-- 登陆 END -->
	     </div>
      
  </body>
</html>
