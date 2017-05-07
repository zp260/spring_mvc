<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/14
  Time: 下午5:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <!--引用CSS-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="/css/entry.css">
    <link type="text/css" rel="stylesheet" href="/css/main.css">
    <link type="text/css" rel="stylesheet" href="/css/font-awesome/css/font-awesome.min.css">
    <script type="text/javascript" src="/js/jquery.min8.js"></script>
    <script type="text/javascript" src="/js/jquery.date_input.pack.js"></script>
    <link href="/css/upload.css" rel="stylesheet" type="text/css" />
    <script src="/js/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
    <link href="/js/uploadify/css/uploadify.css" type="text/css" rel="stylesheet">
    <script src="/js/Validform_v5.3.2.js" type="text/javascript"></script>
    <script src="/js/ValidForm_ext.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/css/validform/style.css" type="text/css" media="all" />
    <script type="text/javascript">
        <!--初始化一些全局变量-->
        var fileArray = []; //存储已上传的文件数组
        var contract=""; //用来储存当前合同号
        var fileObj; //存储当前上传的PDF inuput对象
        var stageNum=-1; //存储提交批次信息后，返回的批次数；

        function searchChange(){
            if($("#search").val()=="conDate"){
                $("#endSpan").css("display","inline");
            }else {
                $("#endSpan").css("display","none");
            }
        }

        $(function(){
            $(':input','#contract').not(':button, :submit, :reset, :hidden').attr('readonly',true);//查看表单禁止编辑
        });
        function search(){
            var searchURL = window.location.href;
            var fieldName = $("#search").val();
            var defaultValue= $("#search_start").val();
            var endValue = $("#search_end").val();
            if(fieldName=="conDate"){
                 searchURL= "/conbase/searchByDate?start="+defaultValue+"&end="+endValue;
            }else{
                 searchURL= "/conbase/search?fieldName="+fieldName+"&value="+defaultValue;
            }
            window.location.href =searchURL;
        }
    </script>
</head>
<body>
<!--查询栏 start-->
<div class="currency_top fl">
    <ul class="oh">
        <li class="currency_li">
            <select class="currency_select" id="search" onchange="searchChange();" name="filedName">
                <option value="conSN">按合同号查询</option>
                <option value="supplier">按供应商查询</option>
                <option value="goodsName">按货物名称查询</option>
                <option value="useORG">按使用单位查询</option>
                <option value="conDate">按签订时间查询</option>
            </select>
        </li>
        <li>
            <input class="currency_input" type="text" id="search_start">
            <span style="display: none;" id="endSpan">
                <input class="currency_input" type="text" id="search_end">
            </span>
        </li>
        <li>
            <input type="button" class="zj fz" value="查询" onclick="search();">
        </li>
    </ul>
</div>
<!--查询栏 end-->
<table class="listTable">
    <tr>
     <th>id</th>
     <th>合同号 </th>
     <th>合同签订时间 </th>
     <th>是否审核通过 </th>
     <th>使用单位 </th>
     <th>供货商 </th>
     <th>合同金额 </th>
     <th>折美元金额 </th>
     <th>折人民币金额 </th>
     <th>交货日期 </th>
     <th>合同来源 </th>
        <th>操作</th>
    </tr>
<c:forEach var="con" items="${list}">
    <tr>
      <td><a href="/conbase/edit?id=${con.id}">${con.id}</a></td>
      <td>${con.conSN}</td>
      <td>${con.conDate}</td>
      <td>${con.conVerify}</td>
      <td>${con.useORG}</td>
      <td>${con.supplier}</td>
      <td>${con.conPrice}</td>
      <td>${con.atDoller}</td>
      <td>${con.atRMB}</td>
      <td>${con.deliveryDate}</td>
      <td>${con.conFrom}</td>
        <td><a href="/conbase/del?id=${con.id}">删除 &nbsp;<a href="/conbase/edit?id=${con.id}">编辑</a></a></td>
        <td><a href="/conbase/verify?id=${con.id}">审核</a></td>
    </tr>
</c:forEach>
</table>
<script type="text/javascript">
    function getStage(num){
        var bodyWidth =  $(document.body).width();
        window.showModalDialog("/stage/getByNumHtml?num="+num+"&consn="+"${contract.conSN}",window,"dialogWidth:"+bodyWidth);
    }
</script>
</body>
</html>
