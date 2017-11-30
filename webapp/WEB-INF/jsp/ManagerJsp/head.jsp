<%@page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>

<div class="row">
    <div class="col-lg-8">
        <a href="/ManagerPage"><h1>教务系统</h1></a>
    </div>
</div>
<div class="row ">
    <div class="col-lg-8">
        <ul class="nav nav-pills">
            <li  id="StudentManage" role="presentation"><a href="/ManagerStudentPage">学生管理</a></li>
            <li  id="TeacherManage" role="presentation"><a href="/TeacherSearchPage">教师管理</a></li>
            <li id="CourseManage" role="presentation"><a href="/ManagerCourseSearchPage">课程管理</a></li>
            <li role="presentation"><a href="/blackListSearchPage">处分管理</a> </li>
            <li role="presentation"><a href="#">杂项</a> </li>
        </ul>
    </div>
    <p class="col-lg-offset-8">欢迎 ${user.name}   <a href="/logOff" deleteLink="true">注销</a></p>
    <hr style="height:3px;border:none;border-top:3px groove deepskyblue;" />
</div>