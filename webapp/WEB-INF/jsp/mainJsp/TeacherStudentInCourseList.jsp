<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@include file="../jspUtil/scriptAndLink.jsp"%>
<script>
    $(function(){
        var student_id
        $(".grade").click(function(){
            student_id=$(this).attr("number")
            $("#myModal").modal('show')
        })
        $("#logOff").click(function () {
            var confirmDelete = confirm("确认要注销?")
            if(confirmDelete)
                return true;
            return false;
        })
        $("#newSubmit").click(function () {
            var number=$(this).attr("number")
            if($("#grade").val().length==0){
                alert("请打分")
                return false
            }else if($("#grade").val()<0){
                alert("请输入正数")
                return false
            }
            else {
                $("#form").attr("action","/addGrade?grade="+$("#grade").val()+"&studentId="+student_id+"&courseId="+${courseId})
                $("#form").submit()
            }
        })
    });
</script>

<div class="container">
    <%@include file="../TeacherJspUtil/head.jsp"%>
    <div class="row">
        <%@include file="../TeacherJspUtil/TeacherCourseManageLeft.jsp"%>
        <table class="table table-striped table-bordered table-hover table-condensed col-lg-4 col-lg-offset-2">
            <thead>
            <th>学号</th>
            <th>姓名</th>
            <th>删除学生</th>
            <th>成绩</th>
            </thead>
            <tbody>
            <c:forEach items="${studentAndScore}" var="SAS" varStatus="status">
            <tr>
                <td>${SAS.key.username}</td>
                <td>${SAS.key.name}</td>
                <td><a deleteLink="true" href="/TeacherDeleteStudent?username=${SAS.key.username}&courseId=${courseId}">删除</a></td>
                <td>
                    <c:choose>
                        <c:when test="${SAS.value!=-1.0}">
                            ${SAS.value}
                        </c:when>
                    <c:when test="${SAS.value==-1.0}">
                           <button class="grade" number="${SAS.key.student_id}">打分</button>
                    </c:when>
                    </c:choose>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">注意</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="form"  role="form" action="" method="post">
                    <div class="form-group ">
                        <label for="grade" class="col-md-2 control-label">请打分</label>
                        <div class="col-md-6">
                            <input type="number" class="form-control" id="grade" name="grade"
                                   placeholder="分数">
                        </div>
                    </div>
                    <div class="form-group">
                         <button  class="btn btn-default " type="button" id="newSubmit">提交</button>
                    </div>
                </form>

            </div>
        </div>
        <div class="modal-footer">
        </div>
    </div>
</div>
</div>
</body>
</html>
