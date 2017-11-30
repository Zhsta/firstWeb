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
            if(${listIsExist==true}){
                $("#myModal3").modal("show")
            }
            $("#MyAdd").click(function(){
                if($("#username").val().length==0){
                    $("#username").attr("placeholder","用户名不能为空")
                    $("#username").focus()
                    return false;
                }
                if($("#reason").val().length==0){
                    $("#reason").attr("placeholder","理由不能为空")
                    $("#reason").focus()
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
        })
    </script>
</head>
<body>
<div class="container">
    <%@include file="../ManagerJsp/head.jsp"%>
    <div class="row" >
        <%@include file="../ManagerJsp/BlackListLeft.jsp"%>
    </div>
    <div class="row col-lg-offset-4" id="add">
        <form class="form-horizontal" id="addForm"  role="form" action="/blackListAdd" method="post">
            <div class="form-group ">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="username" name="username"
                           placeholder="请输入账户名">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="reason" name="reason"
                           placeholder="请输入封禁理由">
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-default" id="MyAdd">添加</button>
                </div>
            </div>
        </form>
    </div>


    <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">警告</h4>
                </div>
                <div class="modal-body">
                    <p></p>
                    <textarea class="form-control">账户已经在黑名单中</textarea>
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
