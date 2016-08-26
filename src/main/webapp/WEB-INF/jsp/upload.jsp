<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/9
  Time: 上午10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/head"></jsp:include>
<body>
<div id="readPdf"></div>
<form>
    <div id="queue"></div><!-上传队列展示区-->
    <input id="file_upload" name="file_upload" type="file" multiple="true">
    <!-批量上传按钮-->
    <p>
        <!--上传第一个未上传的文件 -->
        <a href="javascript:$('#file_upload').uploadify('upload')">上传</a>
        <!--取消第一个未取消的文件 -->
        <a href="javascript:$('#file_upload').uploadify('cancel')">取消上传</a>
        <a href="javascript:$('#file_upload').uploadify('upload','*')">开始上传所有文件</a>
        <a href="javascript:$('#file_upload').uploadify('cancel','*')">取消上传所有文件</a>
    </p>
</form>
<div>
 <input type="button" onclick="pdfRead($(this))" value="/upload/201608/302EF6434B6ED7D6561FCD2A6E4290C8.pdf">
 <input type="button" onclick="pdfRead($(this))" value="/upload/201608/368068EB07D2DCA60943CD19FAB07F1C.pdf">
</div>
<div class="uploadLoyer">
    <form action="/fileupload" method="post" enctype="multipart/form-data" id="uploadPDF">
        <input type="file" name="file" id="file" onchange="checkFileSize(this);"/><br>
        <input type="text" name="uploadPath" id="uploadPath"/><br>
        <input type="submit" value="提交">
        <input type="button" value="JSON提交" onclick="upload($('#uploadPDF'));">
    </form>
</div>





<script type="text/javascript">
    var fileArray = [];
    var fileOK=false;
    //参数obj为input file对象
    function upload(obj){
        if(fileOK){
            obj.ajaxForm({success :showResponse}).submit();
        }

    }

    function checkFileSize(obj){
        var fileSize = obj.files[0].size / 1024;
        console.log(fileSize);
        if (fileSize < 102400 && checkFileType($(obj))){
            fileOK = true;
        }else {
            alert("文件大小不能超过100！");
            fileOK = false;
        }


    }

    function checkFileType(obj){
        var filePath = obj.val();
        var extStart = filePath.lastIndexOf(".");
        var ext = filePath.substring(extStart,filePath.length).toUpperCase();
        if (ext!=".BMP" && ext!=".JPG" && ext!=".GIF" && ext!=".PNG" && ext!=".JPEG" && ext!=".PDF"){
            alert("请上传bmp,png,gif,jpeg,jpg,pdf格式的文件");
            return false;
        }else {
            return true;
        }
    }

    function showRequest(formData, jqForm, options){
        // formData: 数组对象，提交表单时，form插件会以ajax方式自动提交这些数据，格式如[{name:user,value:val},{name:pwd,value:pwd}]
        // jqForm: jQuery对象，封装了表单的元素
        // options: options对象
        var queryString=$.param(formData); // name=1&address=2
        var formElement=jqForm[0]; // 将jqForm转换为DOM对象
        var address=formElement.address.value; // 访问jqForm的DOM元素
        return true; // 只要不返回false，表单都会提交，在这里可以对表单元素进行验证
    }
    function showResponse(responseText,statusText){
        // dataType=xml
//        var name=$("name",responseXML).text();
//        var address=$("address",responseXML).text();
//        $("#xmlout").html(name+" "+address);
//        dataType=json
        if (responseText.path != ""){
            $("#uploadPath").val(responseText.path);
        }

    }

    $(function(){
        $("#file_upload").uploadify({
            'swf':'/js/uploadify/uploadify.swf',
            'uploader':'/fileupload;jsessionid=${pageContext.session.id}',
            'cancelImg':'/js/uploadify/img/uploadify-cancel.png',
            'queueID':'queue',
            'width':'100',
            'height':'32',
            'fileTypeDesc':'指定类型文件',
            'fileTypeExts':'*.jpg;*.png;*.pdf',
            'fileObjName':'file',
            'buttonText':'批量上传',
            'fileSizeLimit':'100000KB',
            'multi':true,
            'auto':false,
            'onUploadSuccess':function(file,data,response){
                var newData = eval('('+data+')');
                fileArray.push(newData.path);
                var inputPath = Serialize(fileArray);
                console.log("上传成功:文件名=［"+file.name+"]"+"服务器上的路径=["+newData.path+"]fileArray="+fileArray + "序列化后＝"+inputPath);
                var newArr=  eval('('+inputPath+')');
                console.log(newArr.length+newArr[0]);
            },
            'onFallback' : function() {//检测FLASH失败调用
                alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
            },
            'formData':{
            }

        });


    });
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

        //PDF

    function pdfRead(obj){
        console.log(obj.val());
        var pdfPath = obj.val();
        PDFObject.embed(pdfPath,"#readPdf");
    }
</script>
<style>
    .pdfobject-container { height: 500px;}
    .pdfobject { border: 1px solid #666; }
</style>
</body>
</html>
