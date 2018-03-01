<%--
  Created by IntelliJ IDEA.
  User: manguangji
  Date: 2/28/18
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>会员管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/css.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/vip.js"></script>
</head>
<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="${pageContext.request.contextPath}/resource/img/coin02.png"/><span><a href="#">首页</a>&nbsp;-&nbsp;<a
                href="#">会员管理</a>&nbsp;-</span>&nbsp;会员管理
        </div>
    </div>

    <div class="page">
        <!-- vip页面样式 -->
        <div class="vip">
            <div class="conform">
                <form>
                    <div class="cfD">
                        <input class="addUser" type="text" placeholder="输入用户名/ID/手机号"/>
                        <button class="button">搜索</button>
                        <a class="addA addA1" href="vipadd.html">新增会员+</a> <a
                            class="addA addA1 addA2" href="vipadd.html">密码重置</a>
                    </div>
                </form>
            </div>
            <!-- vip 表格 显示 -->
            <div class="conShow">
                <table border="1" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="80px" class="tdColor tdC">编号</td>
                        <td width="150px" class="tdColor">姓名</td>
                        <td width="150px" class="tdColor">真实姓名</td>
                        <td width="180px" class="tdColor">手机号码</td>
                        <td width="370px" class="tdColor">会员余额</td>
                        <td width="350px" class="tdColor">所在城市</td>
                        <td width="160px" class="tdColor">状态</td>
                        <td width="260px" class="tdColor">操作</td>
                    </tr>

                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td class="tdColor tdC">${user.uid}</td>
                            <td class="tdColor">${user.userName}</td>
                            <td class="tdColor">${user.realName}</td>
                            <td class="tdColor">${user.phone}</td>
                            <td class="tdColor" style="text-align: right;padding-right: 5px;">${user.wallet.money}
                                <input class="vipinput" type="text" />
                                <a class="vsAdd">增加</a>
                            </td>
                            <td class="tdColor">${user.addr}</td>
                            <td class="tdColor">
                                <c:if test="${user.status == 0}">
                                    锁定
                                </c:if>
                                <c:if test="${user.status == 1}">
                                    正常
                                </c:if>
                            </td>
                            <td>
                                <a href="/vip/user/update/${user.uid}">
                                    <img class="operation" src="${pageContext.request.contextPath}/resource/img/update.png">
                                </a>
                                <img class="operation delban" src="${pageContext.request.contextPath}/resource/img/delete.png">
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="paging">
                    第${currentPage}/${pages}页
                    <a href="/vip/user/page/1">首页</a>
                    <c:if test="${currentPage > 1}">
                        <a href="/vip/user/page/${currentPage - 1}"  >上一页</a>
                    </c:if>
                    <c:if test="${currentPage < pages}">
                        <a href="/vip/user/page/${currentPage + 1}" >下一页</a>
                    </c:if>
                    <a href="/vip/user/page/${pages}">尾页</a>
                </div>
            </div>
            <!-- vip 表格 显示 end-->
        </div>
        <!-- vip页面样式end -->
    </div>

</div>


<!-- 删除弹出框 -->
<div class="banDel">
    <div class="delete">
        <div class="close">
            <a><img src="img/shanchu.png"/></a>
        </div>
        <p class="delP1">你确定要删除此条记录吗？</p>
        <p class="delP2">
            <a href="#" class="ok yes">确定</a><a class="ok no">取消</a>
        </p>
    </div>
</div>
<!-- 删除弹出框  end-->
</body>
</html>
