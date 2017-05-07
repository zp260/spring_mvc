<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <!--引用CSS-->
    <link type="text/css" rel="stylesheet" href="/css/main.css">
    <script type="text/javascript" src="/js/jquery.min8.js"></script>
    <script type="text/javascript" src="/js/jquery.date_input.pack.js"></script>
    <script type="text/javascript">
        function searchChange(){
            if($("#search").val()=="conDate"){
                $("#endSpan").css("display","inline");
                $("#search_start").addClass("date_picker");
            }else {
                $("#endSpan").css("display","none");
                $("#search_start").removeClass("date_picker");
            }
            $('.date_picker').date_input();//日历控件
        }
    </script>
</head>
<body>
<div class="del fl">
    <a href="" class="bt">供货商查询</a>
</div>

<div class="start currency_top fl">
    <!--查询栏 start-->
    <form action="/supplier/search" method="post">
        <ul class="oh">
            <li class="currency_li">
                <select class="currency_select" name="filedName" id="search" onchange="searchChange();">
                    <option value="biddingSN">按中标通知书编码查询</option>
                    <option value="supplier">按供货商名称查询</option>
                    <option value="conDate">按年份查询</option>
                    <option value="useORG">按使用单位查询</option>
                </select>
            </li>
            <li>
                <input class="currency_input" type="text" id="search_start" name="search_start">
                <span style="display: none;" id="endSpan">
                    <input class="currency_input date_picker" type="text" id="search_end" name="search_end">
                </span>
            </li>
            <li>
                <input type="submit" class="zj fz" value="查询">
            </li>
        </ul>
    </form>
    <!--查询栏 end-->
</div>

<div class="start currency_wrap">
    <table border="0" cellpadding="0" cellspacing="0">
        <thead>
        <tr>
            <th>序号</th>
            <th>供货商名称</th>
            <th>中标通知书编码</th>
            <%--<th>货物名称</th>--%>
            <th>年份</th>
            <th>使用单位</th>
        </tr>
        </thead>
        <c:forEach var="con" items="${list}">
            <tr>
                <td><a href="/conbase/edit?id=${con.id}">${con.id}</a> </td>
                <td>${con.supplier}</td>
                <td>${con.biddingSN}</td>
                <%--<td></td>--%>
                <td>${con.conDate}</td>
                <td>${con.useORG}</td>
            </tr>
        </c:forEach>
    </table>
</div>


<div class="footer fz ra fl">
    <span>版权所有 &copy; 大同煤矿集团有限责任公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：大同市万腾科技股份有限公司</span>
</div>

</body>



</html>
