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
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<form action="/stage/upload" method="post" enctype="multipart/form-data" id="uploadForm">
    <input type="file" name="file" />

    <input type="submit" value="上传" />
</form>
<script type="text/javascript">
    function upload(){
        $("#uploadForm").submit();
    }
</script>
</body>
</html>
