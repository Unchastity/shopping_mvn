<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <meta name="viewport" >
    <title>首页头部</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/public.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/public.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/logout.js"></script>
</head>

<body>
<!-- 头部 -->
<div class="head">
    <div class="headL">
        <img class="headLogo" src="${pageContext.request.contextPath}/resource/img/headLogo.png"/>
    </div>
    <div class="headR">
        <p class="p1">
            欢迎，
            <?php echo cookie('name')?>
        </p>
        <p class="p2">
            <a class="resetPWD">重置密码</a>&nbsp;&nbsp;
            <a class="goOut">退出</a>
        </p>
    </div>
</div>

<div class="closeOut">
    <div class="coDiv">
        <p class="p1">
            <span>X</span>
        </p>
        <p class="p2">确定退出当前用户？</p>
        <P class="p3">
            <a class="ok yes" href="#">确定</a><a class="ok no" href="#">取消</a>
        </p>
    </div>
</div>


</body>
</html>