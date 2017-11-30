<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@include file="../jspUtil/scriptAndLink.jsp"%>
 <div class="container">
     <%@ include file="../jspUtil/head.jsp" %>
     <div class="row">
     <ul class="nav nav-pills nav-stacked" style="width:100px">
         <li role="presentation"><a href="/CourseList?username=${user.username}&start=0">课程查询</a></li>
     </ul>
     </div>
 </div>
</body>
</html>
