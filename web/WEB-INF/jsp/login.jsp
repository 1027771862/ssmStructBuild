<%--
  Created by IntelliJ IDEA.
  User: 86188
  Date: 2022/1/18
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.min.js"></script>
    <script>
        $('document').ready(function (){
            $('#userName').change(function (){
                $.post({
                    url:"${pageContext.request.contextPath}/umWarn",
                    data:{
                        "userAge":$('#userAge').val(),
                        "userName":$('#userName').val()
                    },
                    success:function (data){
                        $('#umWarn').html(data)
                        if(data==='ok'){
                            $('#umWarn').css('color','blue')
                        }else{
                            $('#umWarn').css('color','red')
                        }
                    },
                })
            })
            $('#userAge').change(function (){
                $.post({
                    url:"${pageContext.request.contextPath}/ageWarn",
                    data:{
                        "userAge":$('#userAge').val(),
                        "userName":$('#userName').val()
                    },
                    success:function (data){
                        $('#ageWarn').html(data)
                        if(data==='ok'){
                            $('#ageWarn').css('color','blue')
                        }else{
                            $('#ageWarn').css('color','red')
                        }
                    },
                })
            })

        })
    </script>
</head>
<body>
<form id="myForm" action="${pageContext.request.contextPath}/login" method="post" >
  <label for="userName">用户名</label><input id="userName" name="username",type="text" required><span id="umWarn"></span><br>
  <label for="userAge">年龄</label><input id="userAge" name="age" type="number" required><span id="ageWarn"></span><br>
    <span></span><br>
  <button type="submit" class="btn btn-primary">登录</button>

</form>
</body>
</html>
