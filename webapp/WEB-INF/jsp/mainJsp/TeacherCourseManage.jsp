<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@include file="../jspUtil/scriptAndLink.jsp"%>
<script>
    $(function(){
        $(".detail").click(function(){
            var courseId=$(this).attr("courseId")
            $("#myModal"+courseId).modal('show')
        })
    });
</script>
<div class="container">
    <%@include file="../TeacherJspUtil/head.jsp"%>
    <div class="row">
    <%@include file="../TeacherJspUtil/TeacherCourseManageLeft.jsp"%>
        <table class="table table-striped table-bordered table-hover col-lg-offset-2 col-lg-6 table-condensed">
            <thead>
            <th>课程名</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>课程号</th>
            <th>学分数</th>
            <th>班级</th>
            <th>教师</th>
            <th>学生列表</th>
            </thead>
            <tbody>
            <c:forEach items="${CourseAndValue}" var="CAV" varStatus="status">
            <tr>
                <td>${CAV.key.course_name}</td>
                <td>${CAV.value.begin}</td>
                <td>${CAV.value.end}</td>
                <td>${CAV.value.number}</td>
                <td>${CAV.value.credit}</td>
                <td>${CAV.value.classes}</td>
                <td>${CAV.value.teachername}</td>
                <td>${CAV.key.teacher.name}</td>
                <td><a href="/CourseStudentList?courseId=${CAV.key.course_id}">学生列表</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
