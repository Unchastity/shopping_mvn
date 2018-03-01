<%--
  Created by IntelliJ IDEA.
  User: manguangji
  Date: 3/1/18
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>会员信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/css.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/vip.js"></script>
</head>
<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="${pageContext.request.contextPath}/resource/img/coin02.png"/><span><a href="#">首页</a>&nbsp;-&nbsp;<a
                href="#">会员管理</a>&nbsp;-</span>&nbsp;会员信息修改
        </div>
    </div>
    <div class="page ">
        <!-- 上传广告页面样式 -->
        <div class="banneradd bor">
            <div class="baTopNo">
                <span>会员信息修改</span>
            </div>
            <form:form id="userForm" action="/vip/user/toUpdate" method="post" modelAttribute="user">
                <div class="baBody">
                    <form:hidden path="uid"/>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;会员昵称：
                        <form:input path="userName" cssClass="input3"/>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;会员姓名：
                        <form:input path="realName" cssClass="input3"/>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;会员年龄：
                        <form:input path="age" cssClass="input3"/>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机号码：
                        <form:input path="phone" cssClass="input3"/>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;会员邮箱：
                        <form:input path="email" cssClass="input3"/>
                    </div>

                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所在地址：
                        <form:input path="addr" cssClass="input3"/>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;家庭地址：
                        <form:input path="homeAddr" cssClass="input3"/>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;会员状态：
                        <form:radiobutton path="status" value="0" label="锁定"/>
                        <form:radiobutton path="status" value="1" label="正常"/>
                    </div>
                    <div class="bbD">
                        <p class="bbDP">
                            <button class="btn_ok btn_yes">提交</button>
                            <a class="btn_ok btn_no">取消</a>
                        </p>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
