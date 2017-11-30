<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<script src="../../js/jquery/2.0.0/jquery.min.js"></script>
<link href="../../css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="../../js/bootstrap/3.3.6/bootstrap.min.js"></script>
<html>
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
