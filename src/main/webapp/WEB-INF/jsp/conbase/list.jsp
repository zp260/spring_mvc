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
                 searchURL= "/conbase/searchByDate/?start="+defaultValue+"&end="+endValue;
            }else{
                 searchURL= "/conbase/search/?fieldName="+fieldName+"&value="+defaultValue;
            }
            window.location.href =searchURL;
        }
    </script>
</head>
<body>
<!--上传文件区域-->
<div id="uploads" style="display: none;clear: both;" class="uploadLoyer">
    <a href="javascript:closeUploads();" class="closeUploads"><i class="fa fa-close"></i>关闭</a>
    <form>
        <input id="file_upload" name="file_upload" type="file" multiple="true">
        <div class="bts"><a href="javascript:$('#file_upload').uploadify('upload','*')">开始上传所有文件</a><a href="javascript:$('#file_upload').uploadify('cancel','*')">取消上传所有文件</a></div>
        <!-批量上传按钮-->
        <p>
            <!--上传第一个未上传的文件
            <a href="javascript:$('#file_upload').uploadify('upload')">上传</a>
            <a href="javascript:$('#file_upload').uploadify('cancel')">取消上传</a>
            --取消第一个未取消的文件 -->

        </p>
        <div id="queue"></div><!-上传队列展示区-->
    </form>
</div>
<!--上传文件区域结束-->
<!--查询栏 start-->
<div class="currency_top fl">
    <ul class="oh">
        <li class="currency_li">
            <select class="currency_select" id="search" onchange="searchChange();">
                <option value="conSN">按合同号查询</option>
                <option value="supplier">按供应商查询</option>
                <option value="goodsName">按货物名称查询</option>
                <option value="useORG">按使用单位查询</option>
                <option value="conDate">按签订时间查询</option>
            </select>
        </li>
        <li>
            <input class="currency_input" type="text" id="search_start">
            <span style="display: none;" id="endSpan"><input class="currency_input" type="text" id="search_end"></span>
        </li>
        <li>
            <input type="button" class="zj fz" value="查询" onclick="search();">
        </li>
    </ul>
</div>
<!--查询栏 end-->
<!--合同基本信息 start-->
<div class="start" style="display: none;">
    <form:form action="/conbase/insert" method="post" modelAttribute="contract">

        <div class="del fl">
            <label>1</label><span class="bt">合同基本信息</span>
        </div>
        <div class="del fr">
            <input type="submit" value="修改合同" class="zj fz" id="changeConBt">
        </div>
        <ul class="nav_ul oh">
            <li style="display:none"><span>ID</span><input name="id" value=""/></li>
            <li class="ne">
                <div class="new">合同号</div>
                <form:input path="conSN" class="news" datatype="*"  nullmsg="合同号必须输入"/>
            </li>
            <li class="ne">
                <div class="new">签订时间</div>
                <form:input path="conDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="合同签订时间必须输入"  />
            </li>
            <li class="ne">
                <div class="new">使用单位</div>
                <form:input path="useORG" class="news" datatype="*"  nullmsg="使用单位必须输入"/>
            </li>
            <li class="ne">
                <div class="new">供应商</div>
                <form:input path="supplier" class="news" datatype="*"  nullmsg="供货商必须输入" />
            </li>
            <li class="ne">
                <div class="new1">合同金额</div>
                <select class="news1 wi" name="monetaryUnit" id="monetaryUnit" datatype="*" nullmsg="货币单位必须选择" errormsg="货币单位必须选择">
                    <option value="">货币</option>
                    <c:forEach var="list" items="${currencyList}">
                        <option value="${list.moneyName}">${list.moneyName}</option>
                    </c:forEach>
                </select>
                <form:input path="conPrice"  class="news" datatype="rule_nums"  nullmsg="合同金额必须输入" errormsg="合同金额必须是数字类型" />
            </li>
            <li class="ne">
                <div class="new1">折美元价</div>
                <form:input path="dollerRate" class="news1" placeholder="汇率" datatype="rule_nums"  nullmsg="汇率必须输入" errormsg="汇率必须是数字类型" />
                <form:input path="atDoller" class="news" datatype="rule_nums"  nullmsg="金额必须输入" errormsg="金额必须是数字类型" />
            </li>
            <li class="ne">
                <div class="new1">折人民币价</div>
                <form:input path="rmbRate" class="news1" placeholder="汇率" datatype="rule_nums"  nullmsg="汇率必须输入" errormsg="汇率必须是数字类型" />
                <form:input path="atRMB" class="news" datatype="rule_nums"  nullmsg="金额必须输入" errormsg="金额必须是数字类型" />
            </li>
            <li class="ne">
                <div class="new">交货期</div>
                <form:input path="deliveryDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="交货时间必须输入" />
            </li>
            <li class="ne">
                <div class="new">L/C开出期限</div>
                <form:input path="lcTimeLimit" class="news" />
            </li>
            <li class="ne">
                <div class="new">开证行</div>
                <form:input path="lcFrom" class="news" />
            </li>
            <li class="ne">
                <div class="new">L/C编号</div>
                <form:input path="lcSN" class="news" />
            </li>
            <li class="ne">
                <div class="new">开证金额</div>
                <form:input path="lcPrice" class="news" datatype="rule_nums"  nullmsg="金额必须输入" errormsg="金额必须是数字类型" />
            </li>
            <li class="ne">
                <div class="new">开出时间</div>
                <form:input path="lcStartDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="开出时间必须输入" />
            </li>
            <li class="ne">
                <div class="new">改证时间</div>
                <form:input path="lcChangeDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="改证时间必须输入" />
            </li>
            <li class="ne">
                <div class="new">改证原因</div>
                <form:input path="lcChangeReason" class="news" />
            </li>
            <li class="ne">
                <div class="new">中标通知书编码</div>
                <form:input path="biddingSN" class="news" />
            </li>
            <li class="ne">
                <div class="new">合同来源</div>
                <form:input path="conFrom" class="news" />
                <form:hidden path="isInport" value="1" /> <!--是否进口合同 -->
            </li>
        </ul>


    </form:form>
</div>
<!--批次信息 start-->
<div class="start" id="stageForm" style="display: none;">
    <form:form action="/stage/update" method="post" modelAttribute="stage">

        <div class="del fl">
            <label>2</label><a href="" class="bt">批次信息</a>
        </div>

        <div class="del fr">
            <input type="submit" value="增加" class="zj fz">
        </div>
        <ul class="nav_ul oh">
            <li style="display: none;"> <input type="input" name="conSN" value="${contract.conSN}" id="stageConSN" ></li>
            <li class="ne">
                <div class="new">预计发货时间</div>
                <form:input path="goodsSendETime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="预计发货时间必须输入" />
            </li>
            <li class="ne">
                <div class="new">实际发货时间</div>
                <form:input path="goodsSendATime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="实际发货时间必须输入" />
            </li>
            <li class="ne">
                <div class="new">预计到港时间</div>
                <form:input path="goodsArriveETime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="预计到港时间必须输入" />
            </li>
            <li class="ne">
                <div class="new">实际到港时间</div>
                <form:input path="goodsArriveATime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="实际到港时间必须输入"  />
            </li>
            <li class="ne">
                <div class="new">收到电子单据日期</div>
                <form:input path="ebDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="收到电子单据日期必须输入" />
            </li>
            <li class="ne">
                <div class="new">银行通知来单日期</div>
                <form:input path="bankNoticeBillTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="银行通知来单日期必须输入"  />
            </li>
            <li class="ne">
                <div class="new">收到银行单据日期</div>
                <form:input path="BillTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="收到银行单据日期必须输入"  />
            </li>
            <li class="ne">
                <div class="new">单据给大同海关日期</div>
                <form:input path="billToCustomsDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="单据给大同海关日期必须输入"  />
            </li>
            <li class="ne">
                <div class="new">报关单号
                    <a class="new_a" id="new_a" onclick="showUpload($('#cdPdf'));">电子版</a>
                    <span style="display: none;">
                        <form:input path="cdPdf"  class="new_a"  />
                    </span>
                </div>
                <form:input path="cdSN" class="news" datatype="*"  nullmsg="报关单号必须输入" />
            </li>
            <li class="ne">
                <div class="new">进口日期</div>
                <form:input path="portDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="进口日期必须输入"  />
            </li>
            <li class="ne">
                <div class="new">申报日期</div>
                <form:input path="cdTime" class="news date_picker"  datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="申报日期必须输入"  />
            </li>
            <li class="ne">
                <div class="new">进口口岸</div>
                <form:select path="port" class="news" datatype="*" errormsg="口岸必须选择"  nullmsg="口岸必须选择">
                    <option value="">口岸</option>
                    <c:forEach var="portList" items="${portList}">
                        <option value="${portList.portName}">${portList.portName}</option>
                    </c:forEach>
                </form:select>
            </li>
            <li class="ne">
                <div class="new">缴税日期</div>
                <form:input path="taxDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="缴税日期必须输入"  />
            </li>
            <li class="ne">
                <div class="new">关税
                    <a class="new_a" onclick="showUpload($('#tariffsPdf'));" id="new_b">
                        <span style="display: none;">
                            <form:input path="tariffsPdf"  class="new_a" />
                        </span>
                        电子版
                    </a>
                </div>
                <form:input path="tariffs" class="news" datatype="rule_nums"  nullmsg="关税必须输入" />
            </li>
            <li class="ne">
                <div class="new">
                    增值税
                    <a class="new_a" onclick="showUpload($('#vatPdf'))" id="new_c">
                        <span style="display: none;">
                            <form:input path="vatPdf" class="new_a" />
                        </span>电子版
                    </a>
                </div>
                <form:input path="vat" class="news" datatype="rule_nums"  nullmsg="增值税必须输入" />
            </li>
            <li class="ne">
                <div class="new">银行付汇日期</div>
                <form:input path="bankFHtime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="银行付汇日期必须输入"  />
            </li>
            <li class="ne">
                <div class="new">收汇方收汇日期</div>
                <form:input path="getFHtime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="收汇方收汇日期必须输入"  />
            </li>
            <li class="ne">
                <div class="new">具体到矿时间</div>
                <form:input path="goodsArriveCoalDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="具体到矿时间必须输入"  />
            </li>
            <li class="ne">
                <div class="new">特别关税
                    <a class="new_a" onclick="showUpload($('#specialTariffPdf'))" id="new_d">
                        <span style="display: none;">
                            <form:input path="specialTariffPdf" class="new_a" />
                        </span>
                        电子版
                    </a>
                </div>
                <form:input path="specialTariff" class="news" datatype="rule_nums"  nullmsg="特别关税必须输入" />
            </li>
            <li class="ne">
                <div class="new">补税</div>
                <form:input path="paytax" class="news" datatype="rule_nums"  nullmsg="补税必须输入" />
            </li>
            <li class="ne">
                <div class="new">滞报金</div>
                <form:input path="lateFee" class="news" datatype="rule_nums"  nullmsg="滞报金必须输入" />
            </li>
            <li class="ne">
                <div class="new">放行日期</div>
                <form:input path="passTime" class="news date_picker"  datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="放行日期必须输入" />
            </li>
            <li class="ne">
                <div class="new">报检日期</div>
                <form:input path="InspectionTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="报检日期必须输入"  />
            </li>
            <li class="ne">
                <div class="new">报检编号</div>
                <form:input path="InspectionSN" class="news" />
            </li>
            <li class="ne">
                <div class="new">集装箱检日期</div>
                <form:input path="containerCheckTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="集装箱检日期必须输入"  />
            </li>
            <li class="ne">
                <div class="new">商检费</div>
                <form:input path="inspectionCharges" class="news" datatype="rule_nums"  nullmsg="商检费必须输入" />
            </li>
            <li class="ne">
                <div class="new">熏蒸费</div>
                <form:input path="fumigationCharges" class="news" datatype="rule_nums"  nullmsg="熏蒸费必须输入" />
            </li>
            <li class="ne">
                <div class="new">开箱时间</div>
                <form:input path="openContainerTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03"  nullmsg="开箱时间必须输入"  />
            </li>
            <li class="ne">
                <div class="new">开箱结果</div>
                <form:input path="openContainerResoult" class="news" />
            </li>
            <li class="ne">
                <div class="new">提单</div>
                <form:input path="getDocPdf" class="news" />
            </li>
            <li class="ne">
                <div class="new">发票</div>
                <form:input path="invoicePdf" class="news" />
            </li>
            <li class="ne">
                <div class="new">箱单</div>
                <form:input path="boxDocPdf" class="news" />
            </li>
            <li class="ne">
                <div class="new">原产地证</div>
                <form:input path="coPdf" class="news" />
            </li>
        </ul>
    </form:form>

</div>
<!--批次 end --><!--批次信息 end-->
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
