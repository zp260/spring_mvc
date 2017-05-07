<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/1
  Time: 下午5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>增加员工</title>
    <link type="text/css" rel="stylesheet" href="/css/main.css">
    <script src="/js/jquery.min8.js" type="text/javascript"></script>
    <script src="/js/Validform_v5.3.2.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/css/validform/style.css" type="text/css" media="all" />
    <link rel="stylesheet" href="/css/validform/demo.css" type="text/css" media="all" />
    <script src="/js/user.js" type="text/javascript"></script>
</head>
<body>
<form:form method="post" action="/user/insert" modelAttribute="user" acceptCharset="utf-8">
<div class="del fl">
    <a href="" class="bt">用户管理</a>
</div>

<div class="start currency_top fl">
    <!--查询栏 start-->
    <ul class="oh">
        <li>
            <div class="currency_date">员工姓名</div>
            <form:input path="userName" placeholder="员工姓名必须是2到6位中文字符！" datatype="zh2-6" errormsg="员工姓名必须是2到6位中文字符！！" class="currency_time" />
        </li>
        <li>
            <div class="currency_date">登录帐号</div>
            <form:input path="loginName"  placeholder="只能输入6-20个字母、数字、下划线" datatype="/^(\w){6,20}$/" nullmsg="用户密码不能为空" errormsg="只能输入6-20个字母、数字、下划线" class="currency_time" />
        </li>
        <li>
            <div class="currency_date">登录密码</div>
            <form:password path="passWord" placeholder="密码范围在6~16位之间！" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！"  class="currency_time" />
        </li>
        <li>
            <div class="currency_date">确认密码</div>
            <input value="" type="password" id="repeatPass" name="repeatPass" placeholder="密码范围在6~16位之间！" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！" recheck="passWord" class="currency_time"/>
        </li>
        <li>
            <div class="currency_date">预置管理角色 :</div>
            <form:select path="userPower" onchange="setPower();" datatype="*"  nullmsg="请选择相应权限！">
                <form:options items="${map.powerName}"/>
            </form:select>
        </li>
        <li>
            <div class="currency_date">选择权限 :</div>
            <form:checkboxes path="rightContent" items="${map.powerList}" datatype="*"  nullmsg="请选择相应权限！" errormsg="请选择相应权限！！" />
        </li>
        <li>
            <input type="submit" class="zj fz" value="增加">
            <input type="reset" class="zj fz" value="取消">
            <span style="font-size: 12px; color: #f00;">*当前页面为编辑模式</span>
        </li>
    </ul>
    <!--查询栏 end-->

</div>
    <div class="start currency_wrap">
        <div class="currency_date fl">选择权限</div>
        <div class="currency_lin fl">
            <ul class="oh">
                <li  class="fl">
                    <p class="fl"><input name="" type="checkbox"/>合同录入</p>
                    <p class="fl"><input name="" type="checkbox"/>合同修改</p>
                    <p class="fl">（<input name="" type="checkbox"/>增加</p>
                    <p class="fl"><input name="" type="checkbox"/>删除</p>
                    <p class="fl"><input name="" type="checkbox"/>修改）</p>
                </li>
                <li  class="fl">
                    <p class="fl"><input name="" type="checkbox"/>合同审核</p>
                    <p class="fl"><input name="" type="checkbox"/>供应商</p>
                    <p class="fl">（<input name="" type="checkbox"/>增加</p>
                    <p class="fl"><input name="" type="checkbox"/>删除</p>
                    <p class="fl"><input name="" type="checkbox"/>修改）</p>
                </li>
                <li  class="fl">
                    <p class="fl"><input name="" type="checkbox" value=""/>录入员</p>
                    <p class="fl"><input name="" type="checkbox" value=""/>查询员</p>
                    <p class="fl"><input name="" type="checkbox" value=""/>系统管理</p>
                </li>
                <li  class="fl">
                    <p class="fl"><input name="" type="checkbox"/>进口口岸</p>
                    <p class="fl">（<input name="" type="checkbox"/>增加</p>
                    <p class="fl"><input name="" type="checkbox"/>删除</p>
                    <p class="fl"><input name="" type="checkbox"/>修改）</p>
                </li>
                <li  class="fl">
                    <p class="fl"><input name="" type="checkbox"/>系统管理员</p>
                    <p class="fl">（<input name="" type="checkbox"/>增加</p>
                    <p class="fl"><input name="" type="checkbox"/>删除</p>
                    <p class="fl"><input name="" type="checkbox"/>修改）</p>
                </li>
            </ul>


        </div>
    </div>
</form:form>

<a href="/user/list">用户列表</a>
<div class="del fl" style="padding:25px 0 0 25px">
    <a href="" class="bt">用户列表</a>
</div>

<div class="start currency_wrap">
    <table border="0" cellpadding="0" cellspacing="0">
        <thead>
        <tr>
            <th>员工姓名</th>
            <th>登录账号</th>
            <th>登录密码</th>
            <th>权限设置</th>
        </tr>
        </thead>
        <tr>
            <td>张三</td>
            <td>admin</td>
            <td>admin</td>
            <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
        </tr>
        <tr class="currency_td">
            <td>李四</td>
            <td>admin</td>
            <td>admin</td>
            <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
        </tr>
    </table>
</div>


<div class="footer fz ra fl">
    <span>版权所有 &copy; 大同煤矿集团有限责任公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：大同市万腾科技股份有限公司</span>
</div>
<script>
    $(function(){
        $("#user").Validform({
            tiptype:3,
        });
    });

    makeCheckBox([11]);
    makeSelect(0);
</script>
</body>
</html>
