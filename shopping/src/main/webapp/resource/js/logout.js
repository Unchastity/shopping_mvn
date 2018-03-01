$(function () {
    $("a[class = 'goOut']").click(function () {
        $.get("/admin/exit", function (data, status) {
            if (status == "success") {
                if (data.result == "success") {
                    window.top.location.href = "/admin/login";
                }
            }
        });
    });
});