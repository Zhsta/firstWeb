<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>

<div class="row">
    <div class="col-lg-8">
        <a href="/TeacherManage?username=${user.username}&name=${user.name}"><h1>教务系统</h1></a>
    </div>
</div>
<div class="row ">
    <div class="col-lg-8">
        <ul class="nav nav-pills">
            <li  id="PersonManage" role="presentation"><a href="/TeacherManage?username=${user.username}&name=${user.name}">个人管理</a></li>
            <li id="CourseManage"   role="presentation"><a href="/TeacherCourseManage?username=${user.username}">课程管理</a></li>
            <li role="presentation"><a href="/TeacherComprehensiveSearchPage">综合查询</a> </li>
        </ul>
    </div>
    <p class="col-lg-offset-8">欢迎 ${user.name}<a href="/logOff" deleteLink="true">注销</a></p>
    <hr style="height:3px;border:none;border-top:3px groove deepskyblue;" />
</div>