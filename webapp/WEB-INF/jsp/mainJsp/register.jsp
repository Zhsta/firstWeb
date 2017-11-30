<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@include file="../jspUtil/scriptAndLink.jsp"%>

<div class="container">
    <div class="row">
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">注册中心</h3>
    </div>
    <div class="panel-body col-md-6">
                <form class="form-horizontal" id="form" role="form" action="/register" method="post">
                    <div class="form-group ">
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="username" name="username"
                                   placeholder="请输入你的用户名">
                        </div>
                        <p style="color: red">${userExsist}</p>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="请输入你的名字">
                        </div>
                    </div>

                    <div class="form-group">
                        <div>
                            <label for="name" class="col-md-2 control-label">账户类型</label>
                        </div>
                    </div>

                    <div class="form-group">

                        <div class="radio">
                        <label >
                            <input type="radio" id="inlineCheckbox1" value="Student" name="role" checked="checked"> 学生
                        </label>
                        <label>
                            <input type="radio" id="inlineCheckbox2" value="Teacher" name="role"> 老师
                        </label>
                        <label >
                            <input type="radio" id="inlineCheckbox3" value="Manager" name="role"> 管理员
                        </label>
                        </div>

                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-md-10">
                            <button class="btn btn-default"><a href="/welcomePage">返回</a></button>
                            <button  class="btn btn-default" id="mySubmit">注册</button>
                        </div>
                    </div>
                </form>

    </div>
</div>
    </div>
</div>
</body>
</html>
