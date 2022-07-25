<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2022/1/18
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
</head>
<body>
<h5>欢迎大神<span style="color: cyan;">${userLoginInfo.userName}</span></h5>
<h1><a href="${pageContext.request.contextPath}/root/allUser">用户展示</a> </h1>
<h3><a href="${pageContext.request.contextPath}/root/reLogin">注销</a></h3>
<h3><a>文件上传</a></h3>
</body>
</html>
