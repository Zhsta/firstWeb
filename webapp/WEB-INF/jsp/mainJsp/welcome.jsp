<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="../jspUtil/scriptAndLink.jsp"%>
<script>
    $(function () {
        if(${errorMessage==0}){
            $("#myModal").modal("show")
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
            else {
                $("#form").submit()
            }
        })
    });
</script>
<div class="container">
    <div class="row">
        <form class="form-horizontal" id="form"  role="form" action="/welcome" method="post">
            <div class="form-group ">
                <label for="userName" class="col-md-2 control-label">用户名</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="userName" name="userName"
                           placeholder="userName">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-md-2 control-label">密码</label>
                <div class="col-md-6">
                    <input type="password" class="form-control" id="password" name="password"
                           placeholder="password">
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-default" >登录</button>
                    <a class="btn btn-default" href="/registerPage">注册</a>
                </div>
            </div>
        </form>
    </div>


    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">注意</h4>
                </div>
                <div class="modal-body">
                    <p>账户不存在</p>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>

</div>




</body>
</html>