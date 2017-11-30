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
            if(${checked==true}){
                $("#search").hide();
                $("#property").show();
            } else{
                $("#property").hide();
            }
            if(${teacherIsExist=false}){
                $("#myModal2").modal("show")
            }

            $("#research").click(function(){
                $("#search").show();
                $("#property").hide();
            })

            $("#mySubmit").click(function(){
                if($("#courseName").val().length==0){
                    $("#courseName").attr("placeholder","课程名不能为空")
                    $("#courseName").focus()
                    return false;
                }
                if($("#teacherName").val().length==0){
                    $("#teacherName").attr("placeholder","教师名不能为空")
                    $("#teacherName").focus()
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
        });
    </script>
</head>
<body>
<div class="container">
    <%@include file="../ManagerJsp/head.jsp"%>
    <div class="row">
        <%@include file="../ManagerJsp/CourseManage.jsp"%>
    <div class="col-lg-offset-2 col-lg-6" id="search">
        <form class="form-horizontal" id="form"  role="form" action="/ManagerCourseSearch" method="post">
            <div class="form-group ">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="courseName" name="courseName"
                           placeholder="课程名称">
                </div>
            </div>
            <div class="form-group ">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="teacherName" name="teacherName"
                           placeholder="教师名称">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-2">
                    <button type="button" class="btn btn-default" id="mySubmit">搜索</button>
                </div>
            </div>
        </form>
    </div>
    </div>
    <div class="row col-lg-8" id="property">
        <table class="table table-striped table-bordered table-hover table-condensed col-lg-offset-2 col-lg-6">
            <thead>
            <th>课程名</th>
            <th>开始时间</th>
            <th>课程号</th>
            <th>学分数</th>
            <th>班级</th>
            <th>教师</th>
            </thead>
            <tbody>
            <c:forEach items="${courseAndValue}" var="CAV">
                <tr>
                    <td>${CAV.key.course_name}</td>
                    <td>${CAV.value.begin}</td>
                    <td>${CAV.value.number}</td>
                    <td>${CAV.value.credit}</td>
                    <td>${CAV.value.classes}</td>
                    <td>${CAV.value.teachername}</td>
                    <td>${CAV.key.teacher.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <td><button  id="research" class="btn-warning col-lg-offset-2">重新搜索</button></td>
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
                    <textarea class="form-control">课程不存在</textarea>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                </div>
            </div>
        </div>
    </div>

</div>
</div>
</body>
</html>