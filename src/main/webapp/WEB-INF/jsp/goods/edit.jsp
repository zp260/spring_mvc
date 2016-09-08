<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/1
  Time: 上午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>编辑货物</title>
    <script type="text/javascript" src="/js/jquery.min8.js"></script>
    <script src="/js/Validform_v5.3.2.js" type="text/javascript"></script>
    <script src="/js/ValidForm_ext.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/css/validform/style.css" type="text/css" media="all" />
</head>
<body>
<form:form action="/goods/update" method="post" modelAttribute="goods">
    <table>
        <tr style="display:none;">
            <th>货物ID</th>
            <th>所属合同号</th>
            <th>所属批次id</th>
        </tr>
        <tr>
            <th>货物名称</th>
            <th>货物金额</th>
            <th>规格型号</th>
            <th>货物数量</th>
        </tr>
        <tr style="display:none;">
            <td><form:hidden path="goodsId" value="${good.goodsId}" />${good.goodsId}</td>
            <td><form:input path="conSN" value="${good.conSN}" /></td>
            <td><form:input path="stageNum" value="${good.stageNum}" /></td>
        </tr>
        <tr>
            <td><form:input path="goodsName" value="${good.goodsName}" datatype="*"  nullmsg="货物名称必须输入" /></td>
            <td><form:input path="goodsPrice" value="${good.goodsPrice}" datatype="rule_nums"  nullmsg="货物金额必须输入"  errormsg="金额必须是数字类型" /></td>
            <td><form:input path="goodsModel" value="${good.goodsModel}" /></td>
            <td><form:input path="goodsCount" value="${good.goodsCount}" datatype="rule_nums"  nullmsg="货物数量必须输入" errormsg="货物数量必须是数字类型" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
        </tr>
    </table>
</form:form>
<!--验证货物表单-->
<script type="text/javascript">
    $("#goods").Validform({
        tiptype:1,
        ajaxPost:true,
        callback:function(data){
            if (data.success){ //提交成功后的处理
                self.location=document.referrer;
            }
            if (data.success == false){
                alert(data.errormsg);
            }
        },
        beforeSubmit:function(curform){
            if ($("#conSN").val()=="" && $("#stageNum").val()==""){alert("合同号或批次为空，请先输入合同或批次信息");return false;}
            //在表单提交执行验证之前执行的函数，curform参数是当前表单对象。
            //这里明确return false的话将不会继续执行验证操作;
        },

    });
</script>
</body>
</html>
