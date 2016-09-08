<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/25
  Time: 上午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>批次编辑</title>
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
//        初始化一些全局变量
        var fileArray = []; //存储已上传的文件数组
        var contract="${stage.conSN}"; //用来储存当前合同号
        var fileObj; //存储当前上传的PDF inuput对象
        var stageNum=${stage.stageNum};

        $(function(){
            $(':input','#stage').not(':button, :submit, :reset, :hidden').attr('readonly',true);//上传完成禁止再次编辑表单
            $("#port").val("${stage.port}");//适配港口下拉菜单

        });
function changeStage(){
    $(':input','#stage').not(':button, :submit, :reset, :hidden').attr('readonly',false);//再次编辑表单
    $(".changeHide").css("display","inline");
    $("#changeBt").css("display","none");
}
</script>
</head>
<body>
<!--上传文件区域-->
<div id="uploads" style="display: none;clear: both;" class="uploadLoyer">
    <a href="javascript:closeUploads();" class="closeUploads"><i class="fa fa-close"></i>关闭</a>
    <form>
        <input id="file_upload" name="file_upload" type="file" multiple="true">
        <div class="bts"><a href="javascript:$('#file_upload').uploadify('upload','*')">开始上传所有文件</a><a
                href="javascript:$('#file_upload').uploadify('cancel','*')">取消上传所有文件</a></div>
        <!-批量上传按钮-->
        <p>
            <!--上传第一个未上传的文件
            <a href="javascript:$('#file_upload').uploadify('upload')">上传</a>
            <a href="javascript:$('#file_upload').uploadify('cancel')">取消上传</a>
            --取消第一个未取消的文件 -->

        </p>
        <div id="queue"></div>
        <!-上传队列展示区-->
    </form>
</div>
<!--上传文件区域结束-->

<!--批次信息 start-->
<div class="start" id="stageForm">
    <form:form action="/stage/update" method="post" modelAttribute="stage">

        <div class="del fl">
            <label>2</label><a href="" class="bt">批次信息</a>
        </div>

        <div class="del fr">
            <span style="display:none;" class="changeHide"><input type="submit" value="确定修改" class="zj fz"></span>
            <input type="button" value="修改批次信息" class="zj fz" onclick="changeStage();" id="changeBt">
        </div>
        <ul class="nav_ul oh">
            <li style="display: none;">
                <form:input  path="conSN" />
                <form:input path="stageNum" />
                <form:input path="id" />
            </li>
            <li class="ne">
                <div class="new">预计发货时间</div>
                <form:input path="goodsSendETime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="预计发货时间必须输入"/>
            </li>
            <li class="ne">
                <div class="new">实际发货时间</div>
                <form:input path="goodsSendATime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="实际发货时间必须输入"/>
            </li>
            <li class="ne">
                <div class="new">预计到港时间</div>
                <form:input path="goodsArriveETime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="预计到港时间必须输入"/>
            </li>
            <li class="ne">
                <div class="new">实际到港时间</div>
                <form:input path="goodsArriveATime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="实际到港时间必须输入"/>
            </li>
            <li class="ne">
                <div class="new">收到电子单据日期</div>
                <form:input path="ebDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="收到电子单据日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">银行通知来单日期</div>
                <form:input path="bankNoticeBillTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="银行通知来单日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">收到银行单据日期</div>
                <form:input path="BillTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="收到银行单据日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">单据给大同海关日期</div>
                <form:input path="billToCustomsDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="单据给大同海关日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">报关单号
                    <a class="new_a" id="new_a" onclick="showUpload($('#cdPdf'));">电子版</a>
                    <span style="display: none;">
                        <form:input path="cdPdf" class="new_a"/>
                    </span>
                </div>
                <form:input path="cdSN" class="news" datatype="*" nullmsg="报关单号必须输入"/>
            </li>
            <li class="ne">
                <div class="new">报关金额</div>
                <form:input path="cdPrice" class="news" datatype="rule_nums" errormsg="报关金额必须为数字类型"  nullmsg="报关金额必须输入"  />
            </li>
            <li class="ne">
                <div class="new">进口日期</div>
                <form:input path="portDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="进口日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">申报日期</div>
                <form:input path="cdTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="申报日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">进口口岸</div>
                <form:select path="port" class="news" datatype="*" errormsg="口岸必须选择" nullmsg="口岸必须选择">
                    <option value="">口岸</option>
                    <c:forEach var="portList" items="${portList}">
                        <option value="${portList.portName}">${portList.portName}</option>
                    </c:forEach>
                </form:select>
            </li>
            <li class="ne">
                <div class="new">缴税日期</div>
                <form:input path="taxDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="缴税日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">关税
                    <a class="new_a" onclick="showUpload($('#tariffsPdf'));" id="new_b">
                        <span style="display: none;">
                            <form:input path="tariffsPdf" class="new_a"/>
                        </span>
                        电子版
                    </a>
                </div>
                <form:input path="tariffs" class="news" datatype="rule_nums" nullmsg="关税必须输入"/>
            </li>
            <li class="ne">
                <div class="new">
                    增值税
                    <a class="new_a" onclick="showUpload($('#vatPdf'))" id="new_c">
                        <span style="display: none;">
                            <form:input path="vatPdf" class="new_a"/>
                        </span>电子版
                    </a>
                </div>
                <form:input path="vat" class="news" datatype="rule_nums" nullmsg="增值税必须输入"/>
            </li>
            <li class="ne">
                <div class="new">银行付汇日期</div>
                <form:input path="bankFHtime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="银行付汇日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">收汇方收汇日期</div>
                <form:input path="getFHtime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="收汇方收汇日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">具体到矿时间</div>
                <form:input path="goodsArriveCoalDate" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="具体到矿时间必须输入"/>
            </li>
            <li class="ne">
                <div class="new">特别关税
                    <a class="new_a" onclick="showUpload($('#specialTariffPdf'))" id="new_d">
                        <span style="display: none;">
                            <form:input path="specialTariffPdf" class="new_a"/>
                        </span>
                        电子版
                    </a>
                </div>
                <form:input path="specialTariff" class="news" datatype="rule_nums" nullmsg="特别关税必须输入"/>
            </li>
            <li class="ne">
                <div class="new">补税</div>
                <form:input path="paytax" class="news" datatype="rule_nums" nullmsg="补税必须输入"/>
            </li>
            <li class="ne">
                <div class="new">滞报金</div>
                <form:input path="lateFee" class="news" datatype="rule_nums" nullmsg="滞报金必须输入"/>
            </li>
            <li class="ne">
                <div class="new">放行日期</div>
                <form:input path="passTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="放行日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">报检日期</div>
                <form:input path="InspectionTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="报检日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">报检编号</div>
                <form:input path="InspectionSN" class="news"/>
            </li>
            <li class="ne">
                <div class="new">集装箱检日期</div>
                <form:input path="containerCheckTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="集装箱检日期必须输入"/>
            </li>
            <li class="ne">
                <div class="new">商检费</div>
                <form:input path="inspectionCharges" class="news" datatype="rule_nums" nullmsg="商检费必须输入"/>
            </li>
            <li class="ne">
                <div class="new">熏蒸费</div>
                <form:input path="fumigationCharges" class="news" datatype="rule_nums" nullmsg="熏蒸费必须输入"/>
            </li>
            <li class="ne">
                <div class="new">开箱时间</div>
                <form:input path="openContainerTime" class="news date_picker" datatype="rule_date" errormsg="日期格式错误，例子:2012-01-03" nullmsg="开箱时间必须输入"/>
            </li>
            <li class="ne">
                <div class="new">开箱结果</div>
                <form:input path="openContainerResoult" class="news"/>
            </li>
            <li class="ne">
                <div class="new">提单</div>
                <form:input path="getDocPdf" class="news"/>
            </li>
            <li class="ne">
                <div class="new">发票</div>
                <form:input path="invoicePdf" class="news"/>
            </li>
            <li class="ne">
                <div class="new">箱单</div>
                <form:input path="boxDocPdf" class="news"/>
            </li>
            <li class="ne">
                <div class="new">原产地证</div>
                <form:input path="coPdf" class="news"/>
            </li>
        </ul>
    </form:form>

</div>
<!--批次 end --><!--批次信息 end-->
<!--录入完批次信息后录入跟批次有关的设备信息-->
<div class="start" id="goodsStart">
    <div class="del fl">
        <label>3</label><span class="bt"> 设备明细</span>
    </div>
    <div class="clear"></div>
    <!--已经输入的货物列表 -->
    <table width="100%" id="goodListTab">
        <tr>
            <th>id</th>
            <th>所属合同</th>
            <th>所属批次</th>
            <th>货物名称</th>
            <th>货物金额</th>
            <th>规格型号</th>
            <th>货物数量</th>
            <th>操作</th>
        </tr>
        <c:forEach var="good" items="${goodsList}">
            <tr>
                <td>${good.goodsId}</td>
                <td>${good.conSN}</td>
                <td>${good.stageNum}</td>
                <td>${good.goodsName}</td>
                <td>${good.goodsPrice}</td>
                <td>${good.goodsModel}</td>
                <td>${good.goodsCount}</td>

                <td><a href="/goods/editByid?id=${good.goodsId}">修改</a>&nbsp;<a href="/goods/del?id=${good.goodsId}">删除</a></td>

            </tr>
        </c:forEach>

    </table>
    <form:form action="/goods/insert" method="post" modelAttribute="goods">
        <ul class="nav_ul oh" style="width: 100%;margin-top: 10px;" >
            <li style="display: none;"><label>所属合同号</label><input type="input" name="conSN" value="${stage.conSN}" id="goodsConSN"></li>
            <li style="display: none;"><label>所属批次id</label><input name="stageNum" value="${stage.stageNum}" id="goodsStageNum"/></li>
            <li class="ne"><div class="new">货物名称</div><form:input path="goodsName" class="news" datatype="*"  nullmsg="货物名称必须输入"/></li>
            <li class="ne"><div class="new">货物金额</div><form:input path="goodsPrice" class="news" datatype="rule_nums"  nullmsg="货物金额必须输入"  errormsg="金额必须是数字类型" /></li>
            <li class="ne"><div class="new">规格型号</div><form:input path="goodsModel" class="news" /></li>
            <li class="ne"><div class="new">货物数量</div><form:input path="goodsCount" class="news" datatype="rule_nums"  nullmsg="货物数量必须输入" errormsg="货物数量必须是数字类型" /></li>
        </ul>
        <div class="del fr">
            <input type="submit" value="增加设备" class="zj fz">
        </div>
    </form:form>
</div>
<!--设备信息结束-->


<!-- 序列化数组 转化成入库字符串-->
<script type="text/javascript">

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
</script>
<script type="text/javascript">
    $(function () {

        $('.date_picker').date_input();// <!-- 日历控件 Js -->

//        <!-- 上传控件 -->
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
                fileArray.push(newData.path);
                var inputPath = Serialize(fileArray);
                //写入指定INPUT 的VALUE
                fileObj.val(inputPath);
                <!--将序列化的字符串转化成数组对象-->
                var newArr = eval('(' + inputPath + ')');

            },
            'onFallback': function () {//检测FLASH失败调用
                alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
            },
            'formData': {}

        });
    });

//    <!--验证批次表单 -->
    $("#stage").Validform({
        tiptype:1,
        ajaxPost:true,
        callback:function(data){
            if (data.success){
                $(':input','#stage').not(':button, :submit, :reset, :hidden').attr('readonly',true);//上传完成禁止再次编辑表单
                $(".changeHide").css("display","none");
                $("#changeBt").css("display","inline");
            }else{
                alert(data.errormsg);
            }
        },
        beforeSubmit:function(curform){
            if (contract=="" && stageNum<0){alert("合同号为空，请先输入合同信息");return false;}
            //在表单提交执行验证之前执行的函数，curform参数是当前表单对象。
            //这里明确return false的话将不会继续执行验证操作;
        },
    });
//    <!--验证货物表单-->
    $("#goods").Validform({
        tiptype:1,
        ajaxPost:true,
        callback:function(data){
            if (data.success){ //提交成功后的处理
                <!--清空已经输入的货物 -->
                $(':input','#goods')
                        .not(':button, :submit, :reset, :hidden')
                        .val('')
                        .removeAttr('checked')
                        .removeAttr('selected');
                location.reload(true);
            }
            if (data.success == false){
                alert(data.errormsg);
            }


        },
        beforeSubmit:function(curform){
            if (contract=="" && stageNum==-1){alert("合同号或批次为空，请先输入合同或批次信息");return false;}
            //在表单提交执行验证之前执行的函数，curform参数是当前表单对象。
            //这里明确return false的话将不会继续执行验证操作;
        },

    });

//    <!--关闭上传界面 -->
    function closeUploads() {
        $("#uploads").css("display", "none");
    }
//    <!-- 清空批次表单-->
    function clearStage() {
        $(':input', '#stage')
                .not(':button, :submit, :reset, :hidden')
                .val('')
                .removeAttr('checked')
                .removeAttr('selected');
    }
</script>

<!-- 控制上传文件 Js -->
<script type="text/javascript">
    function showUpload(obj) {
        $("#uploads").css("display", "block");//显示上传
        <!--同一个上传 多次上传文件的解决方案 -->
        if (fileObj == obj) {
            var filePath = fileObj.val();//获取已经上传的所有文件路径
            if (filePath != "") {
                fileArray = eval('(' + filePath + ')');//将文件数组重新赋值到全局数组变量,上传插件取到这个数组 增加后期上传的文件。
            }
        }
        else {
            fileObj = obj;
            fileArray = []; //新的上传，清空文件数组
        }
    }
</script>
</body>
</html>
