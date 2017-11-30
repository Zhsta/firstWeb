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
            if(${notInBlackList==true}){
                $("#myModal2").modal("show")
            }

            $("#research").click(function(){
                $("#search").show();
                $("#property").hide();
            })

            $("#mySubmit").click(function(){
                if($("#username").val().length==0){
                    $("#courseName").attr("placeholder","课程名不能为空")
                    $("#courseName").focus()
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
        <%@include file="../ManagerJsp/BlackListLeft.jsp"%>
    <div class="col-lg-offset-2 col-lg-6" id="search">
        <form class="form-horizontal" id="form"  role="form" action="/blackListSearch" method="post">
            <div class="form-group ">
                <div class="col-md-6">
                    <input type="text" class="form-control" id="username" name="username"
                           placeholder="账户名">
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
    <div class="row" id="property">
        <table class="table table-striped table-bordered table-hover table-condensed col-lg-offset-2 col-lg-8">
            <thead>
            <th>账户名</th>
            <th>被封理由</th>
            </thead>
            <tbody>
                <tr>
                    <td>${blackList.username}</td>
                    <td>${blackList.reason}</td>
                </tr>
            </tbody>
        </table>
        <button id="research" class="btn-warning">重新搜索</button>
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
                    <textarea class="form-control">该账户并未被拉入黑名单</textarea>
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