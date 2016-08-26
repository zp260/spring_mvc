<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/4
  Time: 下午4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户编辑</title>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.js" type="text/javascript"></script>
    <script src="/js/Validform_v5.3.2.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/css/validform/style.css" type="text/css" media="all" />
    <link rel="stylesheet" href="/css/validform/demo.css" type="text/css" media="all" />
    <script src="/js/user.js" type="text/javascript"></script>
</head>
<body>
<h2>修改用户资料</h2>
 <form:form method="post" action="/user/updateInfo" modelAttribute="userInfo">
     <table>
         <tr>
             <th>ID</th>
             <th>登录名</th>
             <th>员工姓名</th>
             <th>用户角色</th>
             <th>用户权限</th>
         </tr>
         <tr>
             <td>
                  ${map.user.id}<form:hidden path="id" value="${map.user.id}" />
             </td>
             <td>
                     ${map.user.loginName}
             </td>
             <td>
                <form:input path="userName" value="${map.user.userName}" placeholder="员工姓名必须是2到6位中文字符！" datatype="zh2-6" errormsg="员工姓名必须是2到6位中文字符！！" nullmsg="员工姓名不能为空" />
                 <label></label>
             </td>
             <td>
                 <form:select path="userPower" onchange="setPower();">
                     <form:options items="${map.powerName}"></form:options>
                 </form:select>
             </td>
             <td>
                 <form:checkboxes path="rightContent" items="${map.powerList}"/>
                 <input type="hidden" value="${map.powerKeys}">
             </td>
             <td>
                 <input type="submit" value="修改">
             </td>
         </tr>
     </table>
 </form:form>
<h2>修改密码</h2>
<form:form method="post" action="/user/updatePass" modelAttribute="userPass">
<div>
       <ul>
           <input type="hidden" value="${map.user.id}" name="id">
           <li><label>输入密码:</label><form:input path="passWord" value="" placeholder="密码范围在6~16位之间！" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！" /><label></label></li>
           <li><label>确认密码:</label><input value="" id="repeatPass" name="repeatPass" placeholder="密码范围在6~16位之间！" datatype="*" nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！" recheck="passWord"><label></label></li>
           <li><input type="submit" value="修改" class="submit"><input type="reset" value="重 置" /></li>
       </ul>


</div>
</form:form>
<script>
    makeCheckBox(${map.powerKeys});
    makeSelect(${map.user.userPower});
    $(function(){

        $("#userPass").Validform({
            tiptype:2,
            ajaxPost:true,
            callback:function(data){
                if (data.status == "y"){
                    setTimeout(function(){
                        $.Showmsg("连接超时");
                    },3000);
                }
            }
        });
    });
    $(function(){

        $("#userInfo").Validform({
            tiptype:2,
            ajaxPost:true,
            callback:function(data){
                if (data.status == "y"){
                    setTimeout(function(){
                        $.Showmsg("连接超时");
                    },3000);
                }
            }
        });
    });
</script>
</body>
</html>
