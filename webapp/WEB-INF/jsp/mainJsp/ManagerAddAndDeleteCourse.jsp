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
            if(${courseIsExist==false}){
                $("#notExist").modal("show")
            }
            if(${countIsExist==true}){
                $("#exist").modal("show")
            }
            if(${success==true}){
                $("#success").modal("show")
            }
            $("#MyAdd").click(function(){
                if($("#courseName").val().length==0){
                    $("#courseName").attr("placeholder","用户名不能为空")
                    $("#courseName").focus()
                    return false;
                }
                if($("#begin").val().length==0){
                    $("#begin").attr("placeholder","密码不能为空")
                    $("#begin").focus()
                    return false;
                }
                if($("#end").val().length==0){
                    $("#end").attr("placeholder","名字不能为空")
                    $("#end").focus()
                    return false;
                }
                if($("#credit").val().length==0){
                    $("#credit").attr("placeholder","名字不能为空")
                    $("#credit").focus()
                    return false;
                }
                if($("#number").val().length==0){
                    $("#number").attr("placeholder","名字不能为空")
                    $("#number").focus()
                    return false;
                }
                if($("#classes").val().length==0){
                    $("#classes").attr("placeholder","名字不能为空")
                    $("#classes").focus()
                    return false;
                }
                else {
                    $("#form").submit()
                }
            })
            $("#MyDelete").click(function(){
                if($("#deleteCourseName").val().length==0){
                    $("#deleteCourseName").attr("placeholder","用户名不能为空")
                    $("#deleteCourseName").focus()
                    return false;
                }
                if($("#deleteTeacherName").val().length==0){
                    $("#deleteTeacherName").attr("placeholder","用户名不能为空")
                    $("#deleteTeacherName").focus()
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
        <%@include file="../ManagerJsp/CourseManage.jsp"%>
    </div>
    <div class="row col-lg-offset-4" id="add">
        <form class="form-horizontal" id="addForm"  role="form" action="/ManagerAddCourse" method="post">
            <div class="form-group ">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="courseName" name="courseName"
                           placeholder="请输入课程名">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <input type="date" class="form-control" id="begin" name="begin"
                           placeholder="请输入开始日期">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <input type="date" class="form-control" id="end" name="end"
                           placeholder="请输入结束日期">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="credit" name="credit"
                           placeholder="请输入学分数">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="classes" name="classes"
                           placeholder="请输入授课班级">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="number" name="number"
                           placeholder="请输入课程编号">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="teacherName" name="teacherName"
                           placeholder="请输入教师名称">
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
        <form class="form-horizontal" id="deleteForm"  role="form" action="/ManagerDeleteCourse" method="post">
            <div class="form-group ">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="deleteCourseName" name="courseName"
                           placeholder="请输入课程名">
                </div>
            </div>
            <div class="form-group ">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="deleteTeacherName" name="teacherName"
                           placeholder="请输入老师名">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-default" id="MyDelete">删除</button>
                </div>
            </div>
        </form>
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
                    <textarea class="form-control">课程已经存在</textarea>
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

    <div class="modal fade" id="notExist" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">警告</h4>
                </div>
                <div class="modal-body">
                    <p></p>
                    <textarea class="form-control">课程不存在</textarea>
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
