<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/25
  Time: 下午2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
    <script src="/js/uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
    <link href="/js/uploadify/css/uploadify.css" type="text/css" rel="stylesheet">
</head>
<body>
<h1>Uploadify Demo</h1>
<form>
    <div id="queue"></div>
    <input id="file_upload" name="file_upload" type="file" multiple="true">
</form>

<script type="text/javascript">
    $(function() {
        $('#file_upload').uploadify({
            'formData'     : {
                'timestamp' : '',
                'token'     : ''
            },
            'swf'      : '/js/uploadify/uploadify.swf',
            'uploader' : '/fileupload;jsessionid=${pageContext.session.id}',
            'auto':false,
            'onFallback' : function() {//检测FLASH失败调用
                alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
            },
        });
    });
</script>
</body>
</html>
