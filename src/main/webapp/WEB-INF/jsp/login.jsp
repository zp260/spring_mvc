<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/8
  Time: 上午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>登陆界面</title>
    <!--引用CSS-->
    <link type="text/css" rel="stylesheet" href="/css/main.css">
    <link type="text/css" rel="stylesheet" href="/css/font-awesome/css/font-awesome.min.css">
    <script type="text/javascript" src="/js/jquery.min8.js"></script>
</head>
<body onload='document.loginForm.loginName.focus();'>
<div id="back1">
    <div id="back0"></div>
</div>
<div class="logoo">
    <img src="images/logo.png" border="0"/>
</div>
<div class="login">
    <!--查询栏 start-->
<form:form name='loginForm' action="/logincheck" method='POST' modelAttribute="user">
        <ul class="oh">
            <li>
                <i class="fa fa-user"></i>
                <input class="currency_time fr" id="user" placeholder="请输入登录名" type="text" name="loginName">
            </li>
            <li>
                <i class="fa fa-asterisk"></i>
                <input class="currency_time fr" id="password" placeholder="请输入密码" type="password" name='passWord'>
            </li>
            <!--<li>-->
            <!--<i class="fa fa-bolt fl"></i>-->
            <!--<input class="currency_time fl" id="pows" placeholder="请输入验证码" type="text" style="width: 120px; margin-left: 17px;">-->
            <!--<img src="images/u0.jpg" width="120px" height="29px" style="padding-top:3px; " />-->
            <!--</li>-->
            <input type="submit" class="zj fz" value="登&nbsp;&nbsp;&nbsp;&nbsp;录" style="width: 302px; height:35px;">
            <span id="us1" class="show">
                <c:if test="${not empty error}">
                    ${error}
                </c:if></span>
            <span id="pas1" class="show"></span>
        </ul>
</form:form>
    <!--查询栏 end-->
</div>
<script type="text/javascript">
    $("document").ready(function(){
        //防止在frame里面出现登录页面
        if(top.location!==self.location){
            top.location.href=self.location.href;
        }


    });
</script>
</body>
</html>
