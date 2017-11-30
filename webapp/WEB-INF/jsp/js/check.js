
$(function () {
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


