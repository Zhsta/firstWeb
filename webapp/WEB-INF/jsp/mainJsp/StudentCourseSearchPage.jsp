<%@include file="../jspUtil/scriptAndLink.jsp"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<script>
    $(function(){
        var error=${error}
        if(error==0){
            $("#myModal").modal('show');
        }else{
            $("#myModal").modal('hide');
        }
    });
</script>

<div class="container">
    <%@include file="../jspUtil/head.jsp"%>
    <div class="row">
        <%@include file="../jspUtil/Com_SeacherLeft.jsp"%>
    </div>
    <div class="row">
        <form class="form-horizontal" id="form"  role="form" action="/CourseSearch" method="post">
            <div class="form-group ">
                <label for="courseName" class="col-md-2 control-label">课程名</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="courseName" name="courseName"
                           placeholder="请输入课程名">
                </div>
            </div>
            <div class="form-group">
                <label for="teacherName" class="col-md-2 control-label">老师</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" id="teacherName" name="teacherName"
                           placeholder="请输入老师的名字">
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
                    <h4 class="modal-title">注意</h4>
                </div>
                <div class="modal-body">
                    <p>课程不存在</p>
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
