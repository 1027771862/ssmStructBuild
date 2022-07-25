<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2022/1/13
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<head>
    <title>所有用户页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />。
    <meta name="viewport" content="width=device-width, initial-scale=1">
<%--    导入bootstrap进行样式美化--%>
    <link href="statics/css/bootstrap.min.css" type="stylesheet"/>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js" ></script>
    <script>
        $("document").ready(function (){
            $("#keyInput").change(function (){
                $.post({
                    url:"${pageContext.request.contextPath}/root/searchUser",
                    data:{
                      "keyword":$("#keyInput").val()
                    },
                    success:function(data,status){
                        console.log(data)
                    },
                    error:function(){
                        alert("error")
                    },
                })
            })
        })
    </script>
</head>
<body>
<h1>所有用户展示界面</h1>
即：${list}
<%--.container 类用于固定宽度并支持响应式布局的容器。--%>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-7 colunm">
            <div class="page-header"><h2>用户信息——————展示</h2></div>
        </div>
        <div class="col-md-5" colunm>
            <input type="text" id="keyInput"> <a class="btn btn-primary">搜索</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 colunm">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>用户编号</th>
                        <th>用户名</th>
                        <th>用户年龄</th>
                        <th>用户住址</th>
                        <th>操作</th>
                        <a href="${pageContext.request.contextPath}/root/toAddPage" style="text-decoration: none;color: skyblue">新增用户</a>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${list}">
                        <tr>
                            <td>${user.userId}</td>
                            <td>${user.userName}</td>
                            <td>${user.userAge}</td>
                            <td>${user.userAddress}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/root/toUpdateUser?id=${user.userId}" class="btn btn-primary">修改</a>
                                &nbsp|&nbsp
                                <a href="${pageContext.request.contextPath}/root/deleteUser/${user.userId}" class="btn btn-primary" style="color: red">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
