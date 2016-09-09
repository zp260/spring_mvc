<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/14
  Time: 下午5:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link href="/css/upload.css" rel="stylesheet" type="text/css"/>
    <script src="/js/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
    <link href="/js/uploadify/css/uploadify.css" type="text/css" rel="stylesheet">
    <script src="/js/Validform_v5.3.2.js" type="text/javascript"></script>
    <script src="/js/ValidForm_ext.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/css/validform/style.css" type="text/css" media="all"/>
    <script src="/js/pdfobject.min.js" type="text/javascript"></script>

<script type="text/javascript">
       /**初始化一些全局变量
        *
        * @type fileArray {Array}  存储已上传的文件数组
        * @contract                用来储存当前合同号
        * @fileObj                 存储当前上传的PDF inuput对象
        * @stageNum                存储提交批次信息后，返回的批次数；
        */
        var fileArray = [];
        var contract = "";
        var fileObj; //
        var stageNum = -1;

        function searchChange() {
            if ($("#search").val() == "conDate") {
                $("#endSpan").css("display", "inline");
            } else {
                $("#endSpan").css("display", "none");
            }
        }

        $(function () {
            $("#monetaryUnit").val("${contract.monetaryUnit}");//适配货币下拉菜单
            $(':input', '#contract').not(':button, :submit, :reset, :hidden').attr('readonly', true);//查看表单禁止编辑
            <!-- 日历控件 Js -->
            $('.date_picker').date_input();
            <!-- 上传控件 -->
            $("#file_upload").uploadify({
                'swf': '/js/uploadify/uploadify.swf',
                'uploader': '/fileupload;jsessionid=${pageContext.session.id}',
                'cancelImg': '/js/uploadify/img/uploadify-cancel.png',
                'queueID': 'queue',
                'width': '100',
                'height': '32',
                'fileTypeDesc': '指定类型文件',
                'fileTypeExts': '*.jpg;*.png;*.pdf',
                'fileObjName': 'file',
                'buttonText': '批量上传',
                'fileSizeLimit': '100000KB',
                'multi': true,
                'auto': false,
                'onUploadSuccess': function (file, data, response) {
                    var newData = eval('(' + data + ')');
                    var uploadPath = newData.path;
                    if(allreadyUpload(uploadPath)){
                        fileArray.push(uploadPath);
                    }else {
                        var s; //这个没什么用  方便调试断点用
                    }

                    var inputPath = Serialize(fileArray); //生成存储数据库的 数组字符窜"[/upload/20160901/name.pdf,/upload/20160901/name.pdf]"
                    //写入指定INPUT 的VALUE
                    fileObj.val(inputPath);
                    //更新上传列表
                    fileListHtml();

                },
                'onFallback': function () {//检测FLASH失败调用
                    alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
                },
                'formData': {}

            });
            <!-- 验证合同输入-->
            $("#contract").Validform({
                tiptype: 1,
                ajaxPost: true,
                beforeSubmit: function (curform) {
                    //在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。
                    //这里明确return false的话表单将不会提交;
                },
                callback: function (data) {
                    if (data.success == true) {
                        contract = $("#conSN").val();//全局存储合同号
                        $(':input', '#contract').not(':button, :submit, :reset, :hidden').attr('readonly', true);//关闭合同修改
                        $("#changeBt").css("display", "inline")
                        $("#confirm").css("display", "none");
                    }
                    if (data.success == false) {
                        alert(data.errormsg);
                    }
                }
            });
            <!--验证批次表单 -->
            $("#stage").Validform({
                tiptype:1,
                ajaxPost:true,
                callback:function(data){
                    if (data.success){
                        location.reload(true);//刷新
                    }else{
                        alert(data.errormsg);
                    }
                },
                beforeSubmit:function(curform){
                    if ($("#stageConSN")==""){alert("合同号为空，请先输入合同信息");return false;}
                    //在表单提交执行验证之前执行的函数，curform参数是当前表单对象。
                    //这里明确return false的话将不会继续执行验证操作;
                },
            });
        });

//        显示合同提交按钮
        function showChange() {
            $("#changeBt").css("display", "none")
            $("#confirm").css("display", "inline");
            $(':input', '#contract').not(':button, :submit, :reset, :hidden').attr('readonly', false);//开放合同修改
            $("#conSN").attr('readonly', true); //合同号禁止修改
        }
        function showStage(obj){
            $(obj).css("display","none");
            $("#stageForm").css("display","block");
        }
        /**
         *  显示上传
         * @param obj 存储上传的INPUT对象
         */
        function showUpload(obj) {
            $("#uploads").css("display", "block");
            <!--同一个上传 本次编辑多次上传文件的解决方案 -->
            if (fileObj == obj) {
                var filePath = fileObj.val();//获取已经上传的所有文件路径
                if (filePath != "") {
                    fileArray = eval('(' + filePath + ')');//将文件数组重新赋值到全局数组变量,上传插件取到这个数组 增加后期上传的文件。
                }
            }
            else {  //否则属于本次编辑初次上传
                fileObj = obj;

                if(fileObj.val()!="" && fileObj!==null && typeof(fileObj) !=="undefined" ){ //如果有值，显示出来
                    var files =  fileObj.val();
                    var files_arr =  eval("("+files+")"); //将数组字符转换成数组对象
                    fileArray = files_arr; //赋值到全局变量
                    fileListHtml();
                }else {
                    fileArray = []; //新的上传，清空文件数组
                }
            }
        }
        /**
         * 关闭上传界面
         */
        function closeUploads() {
            $("#uploads").css("display", "none");
            $("#queueFileList").html("");

        }
       /**
        * --序列化数组 转化成入库字符串--
        * @param obj           需要序列化的数组
        * @returns {string}    返回序列化的好的序列字符窜
        * @constructor
        */
       function Serialize(obj) {
           switch (obj.constructor) {
               case Object:
                   var str = "{";
                   for (var o in obj) {
                       str += o + ":" + Serialize(obj[o]) + ",";
                   }
                   if (str.substr(str.length - 1) == ",")
                       str = str.substr(0, str.length - 1);
                   return str + "}";
                   break;
               case Array:
                   var str = "[";
                   for (var o in obj) {
                       str += Serialize(obj[o]) + ",";
                   }
                   if (str.substr(str.length - 1) == ",")
                       str = str.substr(0, str.length - 1);
                   return str + "]";
                   break;
               case Boolean:
                   return "\"" + obj.toString() + "\"";
                   break;
               case Date:
                   return "\"" + obj.toString() + "\"";
                   break;
               case Function:
                   break;
               case Number:
                   return "\"" + obj.toString() + "\"";
                   break;
               case String:
                   return "\"" + obj.toString() + "\"";
                   break;
           }
       }

       //PDF文件读取代码
       function pdfRead(obj){
           $("#readPdf").css('display','block'); //显示PDF层
           var pdfPath = obj.attr("pdfPath");
           PDFObject.embed(pdfPath,"#readPdf");
           var closeHtm = '<a href="javascript:closePdf();">关闭PDF预览</a>';
           $("#readPdf").append(closeHtm);
       }
       //    关闭PDF层
       function closePdf(){
           $("#readPdf").css('display','none');
       }
       //    检查上传的文件是否已经上传过
       function  allreadyUpload(file){
           var flag=false;
           if (fileArray.length===0){
               return true;
           }
           for (i=0;i<fileArray.length;i++){
               if (file === fileArray[i]){
                   flag = false;
                   return flag;
               }
               else {
                   flag=true;
               }
           }
           return flag;
       }
       <!--删除这个要更新上传的PDF -->

       /**
        * @param obj 要删除的对象前面的A标签
        */
       function  delPdfFile(obj){
           var index =Number($(obj).next().val()); // 取下一个INPUT的 上传文件的值
           fileArray.splice(index,1); //文件数组中删除
           fileObj.val(Serialize(fileArray));
           fileListHtml();
       }

       /**
        *      重新生成已经上传的文件列表
        *
        */
       function fileListHtml(){
           var html="";
           for(i=0;i<fileArray.length;i++){
               html+= '<input type="button" onclick="delPdfFile(this)" value="删除" /> <input type="button" onclick="pdfRead($(this))" value="'+i+'" pdfPath="'+fileArray[i]+'" />';
           }
           $("#queueFileList").html(html);
       }
</script>
</head>
<body>
<!--上传文件区域-->
<div id="uploads" style="display: none;clear: both;" class="draggable">
    <a href="javascript:closeUploads();" class="closeUploads"><i class="fa fa-close"></i>关闭</a>
    <form>
        <input id="file_upload" name="file_upload" type="file" multiple="true">
        <!-批量上传按钮-->
        <div class="bts">
            <a href="javascript:$('#file_upload').uploadify('upload','*')">开始上传所有文件</a>
            <a href="javascript:$('#file_upload').uploadify('cancel','*')">取消上传所有文件</a>
        </div>
        <!-上传队列展示区-->
        <div id="queue"></div>
        <!--服务器已经上传过的文件列表-->
        <div id="queueFileList"></div>
    </form>
</div>
<!--上传文件区域结束-->

<!--合同基本信息 start-->

<div class="start">
    <form:form action="/conbase/update" method="post" modelAttribute="contract">

        <div class="del fl">
            <label>1</label><span class="bt">合同基本信息</span>
        </div>
        <div class="del fr">
            <span id="confirm" style="display:none;">
                <input type="submit" value="确定修改" class="zj fz">
            </span>
            <input type="button" value="修改合同" class="zj fz" onclick="showChange();" id="changeBt">
        </div>
        <ul class="nav_ul oh">
            <li style="display:none"><span>ID</span><form:input path="id" /></li>
            <li class="ne">
                <div class="new">合同号</div>
                <form:input path="conSN" class="news" datatype="*" nullmsg="合同号必须输入"/>
            </li>
            <li class="ne">
                <div class="new">签订时间</div>
                <form:input path="conDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="合同签订时间必须输入"/>
            </li>
            <li class="ne">
                <div class="new">使用单位</div>
                <form:input path="useORG" class="news" datatype="*" nullmsg="使用单位必须输入"/>
            </li>
            <li class="ne">
                <div class="new">供应商</div>
                <form:input path="supplier" class="news" datatype="*" nullmsg="供货商必须输入"/>
            </li>
            <li class="ne">
                <div class="new1">合同金额</div>
                <select class="news1 wi" name="monetaryUnit" id="monetaryUnit" datatype="*" nullmsg="货币单位必须选择" errormsg="货币单位必须选择">
                    <option value="">货币</option>
                    <c:forEach var="list" items="${currencyList}">
                        <option value="${list.moneyName}">${list.moneyName}</option>
                    </c:forEach>
                </select>
                <form:input path="conPrice" class="news" datatype="rule_nums" nullmsg="合同金额必须输入" errormsg="合同金额必须是数字类型"/>
            </li>
            <li class="ne">
                <div class="new1">折美元价</div>
                <form:input path="dollerRate" class="news1" placeholder="汇率" datatype="rule_nums" nullmsg="汇率必须输入" errormsg="汇率必须是数字类型"/>
                <form:input path="atDoller" class="news" datatype="rule_nums" nullmsg="金额必须输入" errormsg="金额必须是数字类型"/>
            </li>
            <li class="ne">
                <div class="new1">折人民币价</div>
                <form:input path="rmbRate" class="news1" placeholder="汇率" datatype="rule_nums" nullmsg="汇率必须输入" errormsg="汇率必须是数字类型"/>
                <form:input path="atRMB" class="news" datatype="rule_nums" nullmsg="金额必须输入" errormsg="金额必须是数字类型"/>
            </li>
            <li class="ne">
                <div class="new">交货期</div>
                <form:input path="deliveryDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="交货时间必须输入"/>
            </li>
            <li class="ne">
                <div class="new">L/C开出期限</div>
                <form:input path="lcTimeLimit" class="news"/>
            </li>
            <li class="ne">
                <div class="new">开证行</div>
                <form:input path="lcFrom" class="news"/>
            </li>
            <li class="ne">
                <div class="new">L/C编号</div>
                <form:input path="lcSN" class="news"/>
            </li>
            <li class="ne">
                <div class="new">开证金额</div>
                <form:input path="lcPrice" class="news" datatype="rule_nums" nullmsg="金额必须输入" errormsg="金额必须是数字类型"/>
            </li>
            <li class="ne">
                <div class="new">开出时间</div>
                <form:input path="lcStartDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="开出时间必须输入"/>
            </li>
            <li class="ne">
                <div class="new">改证时间</div>
                <form:input path="lcChangeDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="改证时间必须输入"/>
            </li>
            <li class="ne">
                <div class="new">改证原因</div>
                <form:input path="lcChangeReason" class="news"/>
            </li>
            <li class="ne">
                <div class="new">中标通知书编码</div>
                <form:input path="biddingSN" class="news"/>
            </li>
            <li class="ne">
                <div class="new">合同来源</div>
                <form:input path="conFrom" class="news"/>
                <form:hidden path="isInport" value="1"/> <!--是否进口合同 -->
            </li>
        </ul>
    </form:form>
</div>
<div class="del fr">
                <input type="button" value="增加批次信息" class="zj fz" onclick="showStage(this);">
</div>
<!--批次信息 start-->
<div class="start" id="stageForm" style="display: none;">
    <form:form action="/stage/insert" method="post" modelAttribute="stage">

        <div class="del fl">
            <label>2</label><a href="" class="bt">批次信息</a>
        </div>
        <div class="del fr">
            <input type="submit" value="增加" class="zj fz">
        </div>
        <ul class="nav_ul oh">
            <li style="display: none;"> <input type="input" name="conSN" value="${contract.conSN}" id="stageConSN" ></li>
            <li class="ne">
                <div class="new">批次</div>
                <form:input path="stageNum" class="news" datatype="n" errormsg="批次信息必须为数字"  nullmsg="批次信息必须输入" />
            </li>
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
                <div class="new">报关金额</div>
                <form:input path="cdPrice" class="news" datatype="rule_nums" errormsg="报关金额必须为数字类型"  nullmsg="报关金额必须输入"  />
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
    <!--批次信息 end-->
</div>
<!--批次 end -->
<!--批次信息列表 start-->
<table class="listTable">
    <tr>
        <th>id</th>
        <th>批次</th>
        <th>报关单号</th>
        <th>申报日期</th>
        <th>进口口岸</th>
        <th>进口日期</th>
        <th>关税</th>
        <th>增值税</th>
        <th>商检费</th>
    </tr>
    <c:forEach var="stage" items="${stageList}">
        <tr>
            <td><a href="/stage/edit?id=${stage.id}">${stage.id}</a></td>
            <td>${stage.stageNum}</td>
            <td>${stage.cdSN}</td>
            <td>${stage.cdTime}</td>
            <td>${stage.port}</td>
            <td>${stage.portDate}</td>
            <td>${stage.tariffs}</td>
            <td>${stage.vat}</td>
            <td>${stage.inspectionCharges}</td>
            <td><a href="/conbase/del?id=${stage.id}">删除</a></td>
            <td><a href="/stage/edit?id=${stage.id}">查看/编辑</a></td>
        </tr>
    </c:forEach>
</table>

<script type="text/javascript">
    function getStage(num) {
        var bodyWidth = $(document.body).width();
        window.showModalDialog("/stage/getByNumHtml?num=" + num + "&consn=" + "${contract.conSN}", window, "dialogWidth:" + bodyWidth);
    }
</script>
</body>
</html>
