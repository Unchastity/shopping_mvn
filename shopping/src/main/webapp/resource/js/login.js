
$(function() {
    $("#yzmImg").click(function () {
        $.get("/getyzm", function (data, status, xhr) {
            if (status == "success") {
                console.log(console.log(JSON.stringify(data)));
                $("#yzmImg").attr("src", "/resource/img/yzm/" + data.yzmImg);
            }
        }, "json");
    });

    $("#yzmImg").click();

    $("#loginBtn").click(function () {
        $("form").submit(function () {
            if ($.trim($("#username").val()).length ==0) {

                $("#usernameWarn").text("用户名不能为空");
                return false;
            }else {
                $("#usernameWarn").text("");
            }

            if ($.trim($("#password").val()).length == 0) {
                $("#passwordWarn").text("密码不能为空");
                return false;
            }else {
                $("#passwordWarn").text("");
            }

            if ($.trim($("#yzm").val()).length == 0) {
                $("#yzmWarn").text("验证码不能为空");
                return false;
            }else {
                $("#yzmWarn").text("");
            }
            return true;
        });
    });
})


