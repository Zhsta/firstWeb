<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
<head>
    <script>
        $(function () {
            $("#mySubmit").click(function(){
                if($("#userName").val().length==0){
                    $("#userName").attr("placeholder","用户名不能为空")
                    $("#userName").focus()
                    return false;
                }
                if($("#password").val().length==0){
                    $("#password").attr("placeholder","密码不能为空")
                    $("#password").focus()
                    return false;
                }
                if($("#name").val().length==0){
                    $("#name").attr("placeholder","名字不能为空")
                    $("#name").focus()
                    return false;
                }
                else {
                    $("#form").submit()
                }
            })
        });
    </script>
</head>
<body>
<h1> ${errorMessage}  </h1>
<div class="container">
    <div class="row">
        <form class="form-horizontal" id="form"  role="form" action="/welcome" method="post">
            <div class="form-group ">
                <label for="userName" class="col-md-2 control-label">用户名</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="userName" name="userName"
                           placeholder="userName">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-md-2 control-label">密码</label>
                <div class="col-md-6">
                    <input type="password" class="form-control" id="password" name="password"
                           placeholder="password">
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button id="mySubmit" class="btn btn-default" >登录</button>
                    <a class="btn btn-default" href="/registerPage">注册</a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>