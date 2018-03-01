<%--
  Created by IntelliJ IDEA.
  User: manguangji
  Date: 2/27/18
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>商城管理系统首页</title>

    <style>
        * {
            margin: 0;
            padding: 0;
        }
        .header {
            width: 100%;
            height: 100px;
            position: relative;
        }

        iframe {
            width: 100%;
            height: 99%;
        }

        .container {
            position: absolute;
            top: 100px;
            right: 0;
            bottom: 0;
            left: 0;
        }

        .container .leftsidebar {
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            width: 220px;
        }

        .container .content {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 220px;
        }
    </style>

</head>
<body>
    <div class="header">
        <iframe src="/admin/header" frameborder="0" scrolling="no"></iframe>
    </div>
    <div class="container">
        <div class="leftsidebar">
            <iframe src="/admin/left" frameborder="0" scrolling="auto"></iframe>
        </div>
        <div class="content">
            <iframe name="main" src="/admin/main" frameborder="0" scrolling="auto"></iframe>
        </div>
    </div>
</body>
</html>
