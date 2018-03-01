<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>首页左侧导航</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/public.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/public.js"></script>
<body id="bg">
<!-- 左边节点 -->
<div class="container">

    <div class="leftsidebar_box">
        <a href="/admin/main" target="main">
            <div class="line">
                <img src="${pageContext.request.contextPath}/resource/img/coin01.png"/>&nbsp;&nbsp;首页
            </div>
        </a>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="${pageContext.request.contextPath}/resource/img/coin07.png"/>
                <img class="icon2" src="${pageContext.request.contextPath}/resource/img/coin08.png"/>
                会员管理
                <img class="icon3" src="${pageContext.request.contextPath}/resource/img/coin19.png"/>
                <img class="icon4" src="${pageContext.request.contextPath}/resource/img/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="${pageContext.request.contextPath}/resource/img/coin111.png"/>
                <img class="coin22" src="${pageContext.request.contextPath}/resource/img/coin222.png"/>
                <a class="cks" href="/vip/user/page/1" target="main">会员管理</a>
                <img class="icon5" src="${pageContext.request.contextPath}/resource/img/coin21.png"/>
            </dd>
        </dl>

        <dl class="system_log">
            <dt>
                <img class="icon1" src="${pageContext.request.contextPath}/resource/img/coin03.png"/>
                <img class="icon2" src="${pageContext.request.contextPath}/resource/img/coin04.png"/>
                一级类目管理
                <img class="icon3" src="${pageContext.request.contextPath}/resource/img/coin19.png"/>
                <img class="icon4" src="${pageContext.request.contextPath}/resource/img/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="${pageContext.request.contextPath}/resource/img/coin111.png"/>
                <img class="coin22" src="${pageContext.request.contextPath}/resource/img/coin222.png"/>
                <a class="cks" href="/admin/main/category" target="main">一级类目管理</a>
                <img class="icon5" src="${pageContext.request.contextPath}/resource/img/coin21.png"/>
            </dd>
        </dl>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="${pageContext.request.contextPath}/resource/img/coin03.png"/>
                <img class="icon2" src="${pageContext.request.contextPath}/resource/img/coin04.png"/>
                二级类目管理
                <img class="icon3" src="${pageContext.request.contextPath}/resource/img/coin19.png"/>
                <img class="icon4" src="${pageContext.request.contextPath}/resource/img/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="${pageContext.request.contextPath}/resource/img/coin111.png"/>
                <img class="coin22" src="${pageContext.request.contextPath}/resource/img/coin222.png"/>
                <a class="cks" href="/admin/main/category_second" target="main">二级类目管理</a>
                <img class="icon5" src="${pageContext.request.contextPath}/resource/img/coin21.png"/>
            </dd>
        </dl>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="${pageContext.request.contextPath}/resource/img/coin03.png"/>
                <img class="icon2" src="${pageContext.request.contextPath}/resource/img/coin04.png"/>
                商品管理
                <img class="icon3" src="${pageContext.request.contextPath}/resource/img/coin19.png"/>
                <img class="icon4" src="${pageContext.request.contextPath}/resource/img/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="${pageContext.request.contextPath}/resource/img/coin111.png"/>
                <img class="coin22" src="${pageContext.request.contextPath}/resource/img/coin222.png"/>
                <a class="cks" href="/admin/main/product" target="main">商品管理</a>
                <img class="icon5" src="${pageContext.request.contextPath}/resource/img/coin21.png"/>
            </dd>
        </dl>
        <dl class="system_log">
            <dt>
                <img class="icon1" src="${pageContext.request.contextPath}/resource/img/coin03.png"/>
                <img class="icon2" src="${pageContext.request.contextPath}/resource/img/coin04.png"/>
                订单管理
                <img class="icon3" src="${pageContext.request.contextPath}/resource/img/coin19.png"/>
                <img class="icon4" src="${pageContext.request.contextPath}/resource/img/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="${pageContext.request.contextPath}/resource/img/coin111.png"/>
                <img class="coin22" src="${pageContext.request.contextPath}/resource/img/coin222.png"/>
                <a class="cks" href="/admin/main/order" target="main">订单管理</a>
                <img class="icon5" src="${pageContext.request.contextPath}/resource/img/coin21.png"/>
            </dd>
        </dl>
    </div>

</div>
</body>
</html>
