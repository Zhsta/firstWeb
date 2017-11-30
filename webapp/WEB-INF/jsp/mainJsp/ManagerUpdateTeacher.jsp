<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<script src="../../../js/jquery/2.0.0/jquery.min.js"></script>
<link href="../../../css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="../../../js/bootstrap/3.3.6/bootstrap.min.js"></script>
<script src="js/json.js"></script>
<html>
<head>
    <script>
        $(function () {
            if(${!teacherIsExist}){
                $("#myModal2").modal("show")
            }
            if(${update==true}){
                $("#myModal3").modal("show")
            }
            $("#addProperty").click(function(){
                if($("#username").val().length==0){
                    $("#username").attr("placeholder","用户名不能为空")
                    $("#username").focus()
                    return false;
                }
                else {
                        $("#form").attr("action","/addTeacherProperty");
                        $("#form").submit();
                    }
            })
            $("#updateProperty").click(function(){
                if($("#username").val().length==0){
                    $("#username").attr("placeholder","用户名不能为空")
                    $("#username").focus()
                    return false;
                }
                else {
                        $("#form").attr("action","/updateTeacherProperty");
                        $("#form").submit();
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
    <div class="row col-lg-offset-3" id="add">

        <form class="form-horizontal" id="form"  role="form" action="" method="post">
            <div class="form-group">
                <label for="userName" class="col-md-2 control-label">老师用户名</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="username" name="username"
                           placeholder="老师用户名">
                </div>
            </div>
            <div class="form-group ">
                <label for="userName" class="col-md-2 control-label">基本信息</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="basicInfo" name="basicInfo"
                           placeholder="基本信息">
                </div>
            </div>
            <div class="form-group">
                <label for="science" class="col-md-2 control-label">科研经历</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="science" name="science"
                           placeholder="科研经历">
                </div>
            </div>
            <div class="form-group">
                <label for="rewardAndPunish" class="col-md-2 control-label">奖惩信息</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="rewardAndPunish" name="rewardAndPunish"
                           placeholder="奖惩信息">
                </div>
            </div>
            <div class="form-group">
                <label for="career" class="col-md-2 control-label">职业生涯</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="career" name="career"
                           placeholder="职业生涯">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button id="updateProperty" class="btn btn-default" data-toggle="tooltip" data-placement="top" title="将会覆盖点原有属性">更新属性</button>
                    <button id="addProperty" class="btn btn-default"data-toggle="tooltip" data-placement="top" title="会在原有基础上添加">添加属性</button>
                </div>
            </div>
        </form>
    </div>


    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">警告</h4>
            </div>
            <div class="modal-body">
                <p></p>
                <textarea class="form-control">老师不存在</textarea>
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
            </div>
        </div>
    </div>
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
                    <textarea class="form-control">更新成功</textarea>
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
