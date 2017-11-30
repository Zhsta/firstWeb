<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@include file="../jspUtil/scriptAndLink.jsp"%>
<script>
    $(function () {
        if(${find}){
            $("#myModal").modal("show")
        }
        if(${studentIsExist==false}){
            $("#myModal2").modal("show")
        }
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

        $("#logOff").click(function () {
            var confirmDelete = confirm("确认要注销?");
            if(confirmDelete)
                return true;
            return false;
        })
    });

</script>
<div class="container">
    <%@include file="../TeacherJspUtil/head.jsp"%>
    <div class="row">
        <%@include file="../TeacherJspUtil/TeacherComprehensiveSearchLeft.jsp"%>
    </div>
    <div class="row">
        <form class="form-horizontal" id="form"  role="form" action="/TeacherComprehensiveSearch?teacherName=${teacherName}" method="post">
            <div class="form-group ">
                <label for="userName" class="col-md-2 control-label">学生姓名</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="userName" name="username"
                           placeholder="学生姓名">
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-default" >搜索</button>
                </div>
            </div>
        </form>
    </div>

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">学生存在</h4>
                    </div>
                    <div class="modal-body">
                        <p>学生信息</p>
                        <textarea class="form-control">学生选择了<c:forEach items="${Course}" var="C" >${C.course_name} </c:forEach>
                        </textarea>
                    </div>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                    </div>
                </div>
            </div>
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
                        <textarea class="form-control">学生不存在</textarea>
                    </div>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                    </div>
                </div>
            </div>
        </div>


</div>
</body>
</html>

