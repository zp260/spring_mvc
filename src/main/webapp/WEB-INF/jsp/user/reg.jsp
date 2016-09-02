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
    <title>Title</title>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.js" type="text/javascript"></script>
    <script src="/js/Validform_v5.3.2.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/css/validform/style.css" type="text/css" media="all" />
    <link rel="stylesheet" href="/css/validform/demo.css" type="text/css" media="all" />
    <script src="/js/user.js" type="text/javascript"></script>
</head>
<body>

<form:form method="post" action="/user/insert" modelAttribute="user" acceptCharset="utf-8">
    <table>
        <tr>
            <td>员工姓名 :</td>
            <td><form:input path="userName" placeholder="员工姓名必须是2到6位中文字符！" datatype="zh2-6" errormsg="员工姓名必须是2到6位中文字符！！"/></td>
            <td><div class="Validform_checktip"></div></td>
        </tr>
        <tr>
            <td>登陆名 :</td>
            <td><form:input path="loginName"  placeholder="只能输入6-20个字母、数字、下划线" datatype="/^(\w){6,20}$/" nullmsg="用户密码不能为空" errormsg="只能输入6-20个字母、数字、下划线"/></td>
            <td><div class="Validform_checktip"></div></td>
        </tr>
        <tr>
            <td>密码 :</td>
            <td><form:password path="passWord" placeholder="密码范围在6~16位之间！" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！"  /></td>
            <td><div class="Validform_checktip"></div></td>
        </tr>
        <tr>
            <td>确认密码 :</td>
            <td><input value="" type="password" id="repeatPass" name="repeatPass" placeholder="密码范围在6~16位之间！" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！" recheck="passWord" /></td>
            <td><div class="Validform_checktip"></div></td>
        </tr>
        <tr>
            <td>预置管理角色 :</td>
            <td>
                <form:select path="userPower" onchange="setPower();" datatype="*"  nullmsg="请选择相应权限！">
                    <form:options items="${map.powerName}"/>
                </form:select>
            </td>
            <td><div class="Validform_checktip"></div></td>
        </tr>
        <tr>
            <td>选择权限 :<label></label></td>
            <td>
                <form:checkboxes path="rightContent" items="${map.powerList}" datatype="*"  nullmsg="请选择相应权限！" errormsg="请选择相应权限！！" />
            </td>
            <td><div class="Validform_checktip"></div></td>
        </tr>
        <tr>

            <td><input type="submit" value="添加新员工" /></td>
        </tr>
        <tr>

            <td colspan="2"><a href="/user/list">用户列表</a></td>
        </tr>
    </table>
</form:form>
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
