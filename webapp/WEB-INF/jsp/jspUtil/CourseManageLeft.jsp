<%@page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>

<div class="span2  col-xs-12 col-sm-3 col-lg-2">
    <ul class="nav nav-pills nav-stacked">
        <li role="presentation"><a href="/CourseList?username=${user.username}&start=0">已选课程</a></li>
        <li><a href="/notChoosedCourseList?username=${user.username}&start=0">课程选择</a></li>
    </ul>
</div>

