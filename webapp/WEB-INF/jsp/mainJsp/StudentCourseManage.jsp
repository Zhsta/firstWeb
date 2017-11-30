<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@include file="../jspUtil/scriptAndLink.jsp"%>
<div class="container">
    <%@include file="../jspUtil/head.jsp"%>
    <script>
        $(function(){
            $("CourseManage").attr("class","active")
        });
    </script>
    <div class="row">
        <%@include file="../jspUtil/CourseManageLeft.jsp"%>
    </div>
</div>
</body>
</html>
