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
                if($("#userName").val().length==0){
                    $("#userName").attr("placeholder","用户名不能为空")
                    $("#userName").focus()
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
        <%@include file="../ManagerJsp/TeacherManagerLeft.jsp"%>
        <div class="col-lg-offset-2 col-lg-6" id="search">
            <form class="form-horizontal" id="form"  role="form" action="/TeacherSearch" method="post">
                <div class="form-group ">
                    <div class="col-md-6">
                        <input type="text" class="form-control" id="userName" name="username"
                               placeholder="老师账号名">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-2">
                        <button type="button" class="btn btn-default" id="mySubmit">搜索</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="col-lg-offset-2 col-lg-6" id="property">
            <style>
                div.well{
                    margin:10px;
                }
            </style>
            <a class="btn btn-info" role="button" data-toggle="collapse" href="#basicInfo" aria-expanded="false" aria-controls="collapseExample">
                基本信息
            </a>
            <button class="btn btn-info" type="button" data-toggle="collapse" data-target="#science" aria-expanded="false" aria-controls="collapseExample">
                科研经历
            </button>
            <button class="btn btn-info" type="button" data-toggle="collapse" data-target="#rewardAndPunish" aria-expanded="false" aria-controls="collapseExample">
                奖惩信息
            </button>
            <button class="btn btn-info" type="button" data-toggle="collapse" data-target="#career" aria-expanded="false" aria-controls="collapseExample">
                职业生涯
            </button>
            <button class="btn btn-warning" id="research" type="button">重新搜索</button>

            <div class="collapse" id="basicInfo">
                <div class="well">
                    <div class="container">
                        <div class="row">
                            <c:forEach items="${propertyAndValue}" var="PAV" varStatus="status">
                                <c:if test="${PAV.key=='basicInfo'}">
                                    <div class="col-xs-6 ">${PAV.value}</div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

            <div class="collapse" id="science">
                <div class="well">
                    <div class="container">
                        <div class="row">
                            <c:forEach items="${propertyAndValue}" var="PAV" varStatus="status">
                                <c:if test="${PAV.key=='science'}">
                                    <div class="col-xs-6 ">${PAV.value}</div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="collapse" id="rewardAndPunish">
                <div class="well">
                    <div class="container">
                        <div class="row">
                            <c:forEach items="${propertyAndValue}" var="PAV" varStatus="status">
                                <c:if test="${PAV.key=='rewardAndPunish'}">
                                    <div class="col-xs-6 ">${PAV.value}</div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="collapse" id="career">
                <div class="well">
                    <div class="container">
                        <div class="row">
                            <c:forEach items="${propertyAndValue}" var="PAV" varStatus="status">
                                <c:if test="${PAV.key=='career'}">
                                    <div class="col-xs-6 ">${PAV.value}</div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

            <div style="height:100px"></div>
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
    </div>
    </div>
</div>
</body>
</html>