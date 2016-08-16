<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/9
  Time: 上午10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.js" type="text/javascript"></script>
    <script src="http://oss.maxcdn.com/jquery.form/3.50/jquery.form.min.js"></script>
    <link href="/css/upload.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="uploadLoyer">
    <form action="/fileupload" method="post" enctype="multipart/form-data" id="uploadPDF">
        <input type="file" name="file" id="file" onchange="checkFileSize(this);"/><br>
        <input type="text" name="uploadPath" id="uploadPath"/><br>
        <input type="submit" value="提交">
        <input type="button" value="JSON提交" onclick="upload($('#uploadPDF'));">
    </form>
</div>

<script type="text/javascript">
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


</script>
</body>
</html>
