<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2022/1/18
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jq.js"></script>

</head>
<body>
<form action="${pageContext.request.contextPath}/root/addUser" accept-charset="UTF-8" method="post">
<%--    name要跟实体类的属性一样，才能为User参数的属性赋上值--%>
    <label for="um">用户名</label><input type="text" id="um" name="userName" required> <br>
    <label for="age">年龄</label><input type="number" id="age" name="userAge" required> <br>
    <label for="addr">住址</label><input type="text" id="addr" name="userAddress" required><br>
    <button class="btn btn-primary" type="submit">添加</button>
</form>
</body>
</html>
