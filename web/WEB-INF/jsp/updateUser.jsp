<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2022/1/19
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>

  <form action="${pageContext.request.contextPath}/root/updateUser" method="post">
    <%--    name要跟实体类的属性一样，才能为User参数的属性赋上值--%>
    <%--后端updae语句//where userid=#{userid} 所以也要传userid，隐藏域传id--%>
      <input hidden name="userId" value="${queryUsers.userId}" readonly>
    <label for="um">用户名</label><input type="text" id="um" name="userName" value="${queryUsers.userName}" required> <br>
    <label for="age">年龄</label><input type="number" id="age" name="userAge" value="${queryUsers.userAge}" required> <br>
    <label for="addr">住址</label><input type="text" id="addr" name="userAddress" value="${queryUsers.userAddress}" required><br>
    <button class="btn btn-primary" type="submit">完成</button>
  </form>
  </body>
</html>
