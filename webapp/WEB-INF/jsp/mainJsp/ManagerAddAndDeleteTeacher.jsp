<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<script src="../../../js/jquery/2.0.0/jquery.min.js"></script>
<link href="../../../css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="../../../js/bootstrap/3.3.6/bootstrap.min.js"></script>
<html>
<head>
    <script>
        $(function () {
            if(${add==true}){
                $("#delete").hide();
                $("#add").show();
            } else if(${delete==true}){
                $("#add").hide();
                $("#delete").show();
            }
            if(${teacherIsExist==false}){
                $("#notExist").modal("show")
            }
            if(${countIsExist==true}){
                $("#exist").modal("show")
            }
            if(${success==true}){
                $("#success").modal("show")
            }
            if(${addSuccess==true}){
                $("#success").modal("show")
            }
            $("#MyAdd").click(function(){
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
            $("#MyDelete").click(function(){
                if($("#deleteName").val().length==0){
                    $("#deleteName").attr("placeholder","用户名不能为空")
                    $("#deleteName").focus()
                    return false;
                }
                else {
                    $("#form").submit()
                }
            })
            $("#logOff").click(function () {
                var confirmDelete = confirm("确认要注销?");
                if(confirmDelete)
                    return true;
                return false;
            })
            $("a").click(function(){
                var deleteLink = $(this).attr("deleteLink");
                var addLink=$(this).attr("addLink");
                console.log(deleteLink);
                if("true"==deleteLink){
                    var confirmDelete = confirm("确认要删除");
                    if(confirmDelete)
                        return true;
                    return false;

                }
                else if(addLink=="true"){
                    var confirmDelete = confirm("确认要添加");
                    if(confirmDelete)
                        return true;
                    return false;
                }
            })
        });
    </script>
</head>
<body>
<div class="container">
    <%@include file="../ManagerJsp/head.jsp"%>
    <div class="row" >
        <%@include file="../ManagerJsp/TeacherManagerLeft.jsp"%>
    </div>
    <div class="row col-lg-offset-4" id="add">
        <form class="form-horizontal" id="addForm"  role="form" action="/ManagerAddTeacher" method="post">
            <div class="form-group ">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="userName" name="username"
                           placeholder="请输入用户名">
                </div>
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
                           placeholder="请输入账户名字">
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-default" id="MyAdd">添加</button>
                </div>
            </div>
        </form>
    </div>

    <div class="row col-lg-offset-4" id="delete">
        <form class="form-horizontal" id="deleteForm"  role="form" action="/ManagerDeleteTeacher" method="post">
            <div class="form-group ">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="deleteName" name="username"
                           placeholder="请输入老师账户">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-default" id="MyDelete">删除</button>
                </div>
            </div>
        </form>
    </div>



    <div class="modal fade" id="notExist" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">警告</h4>
                </div>
                <div class="modal-body">
                    <p></p>
                    <textarea class="form-control">老师账户不存在</textarea>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="exist" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">警告</h4>
                </div>
                <div class="modal-body">
                    <p></p>
                    <textarea class="form-control">老师账户已经存在</textarea>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="success" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">警告</h4>
                </div>
                <div class="modal-body">
                    <p></p>
                    <textarea class="form-control">操作成功</textarea>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                </div>
            </div>
        </div>
    </div>


</div>
</body>
</html>
