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
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.js" type="text/javascript"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" action="/user/insert" modelAttribute="user" acceptCharset="utf-8">
    <table>
        <tr>
            <td>员工姓名 :</td>
            <td><form:input path="userName" /></td>
        </tr>
        <tr>
            <td>登陆名 :</td>
            <td><form:input path="loginName" /></td>
        </tr>
        <tr>
            <td>密码 :</td>
            <td><form:password path="passWord" /></td>
        </tr>
        <tr>
            <td>角色 :</td>
            <td>
                <form:select path="userPower" onchange="setPower();">
                    <option>预置管理角色</option>
                    <form:options items="${map.powerName}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>选择权限 :</td>
            <td>
                <form:checkboxes path="rightContent" items="${map.powerList}"/>
            </td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="添加新员工" /></td>
        </tr>
        <tr>

            <td colspan="2"><a href="/user/list">用户列表</a></td>
        </tr>
    </table>
</form:form>
<script>
   function setPower(){
      var select_id =  $("#userPower option:selected").val();
       switch (select_id)
       {
           case "1":
//               $("input[name='userPower']:checkbox[value='"+12+"']").prop("checked",true);设置指定VALUE为CHECKED
               makeSelectCheckBox([11]);
               break;
           case "2":
                   var powerlist = new Array(8,10,11,12);
               makeSelectCheckBox(powerlist);
               break;
           case "3":
               makeSelectCheckBox([9,11]);
               break;
           case "4":
               makeSelectCheckBox([0,1,2,3,8,9,10,11,12,13]);
               break;
           case "5":
               makeSelectCheckBox([0,1,2,3,7,8,9,10,11,12,13]);
               break;
           case "6":
               makeSelectCheckBox([4,5,6,7,11]);
               break;
       }
   }
    function makeSelectCheckBox(arr){
        $("input[name='rightContent']").val(arr);
    }
</script>
</body>
</html>
