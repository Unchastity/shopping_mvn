<%--
  Created by IntelliJ IDEA.
  User: manguangji
  Date: 2/27/18
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>商城会员登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/page.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/public.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/login.js"></script>
</head>
<body>

<div class="logHead">
    <img src="${pageContext.request.contextPath}/resource/img/logLOGO.png" alt="XXXX">
</div>
<div class="logDiv">
    <img class="logBanner" src="${pageContext.request.contextPath}/resource/img/logBanner.png" alt="">
    <form:form action="${pageContext.request.contextPath}/shopping/tologin" method="post" modelAttribute="user">
        <div class="logGet">
            <!-- 头部提示信息 -->
            <div class="logD logDtip">
                <p class="p1">商城会员登录</p>
                <p class="p2">会员登录</p>
            </div>
            <!-- 输入框 -->
            <div class="lgD">
                <img class="img1" src="${pageContext.request.contextPath}/resource/img/logName.png"/>
                <form:input path="userName" placeholder="输入用户名" /> <br>
                <form:errors path="userName" cssClass="warn"/>
            </div>
            <div class="lgD">
                <img class="img1" src="${pageContext.request.contextPath}/resource/img/logPwd.png"/>
                <form:password path="password" placeholder="输入用户密码"/> <br>
                <form:errors path="password" cssClass="warn" />
            </div>
            <div class="lgD logD2">
                <input id="yzm" name="yzm" class="getYZM" type="text" placeholder="验证码"/>
                <div class="logYZM">
                    <img id="yzmImg" class="yzm" src="" alt="验证码"/>
                </div>
                <p id="yzmWarn" class="warn">${yzm}</p>
            </div>
            <div class="logC">
                <input type="submit" value="登 录">
            </div>
        </div>
    </form:form>

</div>
<div class="logFoot">
    <p class="p1">版权所有：上海XXXX有限公司</p>
    <p class="p2">上海XXXX有限公司 @CopyRight 2018~2020</p>
</div>
</body>
</html>
