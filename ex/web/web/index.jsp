<%--
  Created by IntelliJ IDEA.
  User: 卢瑞龙
  Date: 2020/10/18
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>

    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/popper.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <link rel="stylesheet"
          href="css/font-awesome-4.7.0/css/font-awesome.css" type="text/css" />
    <title>首页</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark"
     style="margin-bottom: 30px">
    <a class="navbar-brand" href="#">我的书店</a>
    <div class="collapse navbar-collapse justify-content-end"
         id="navbarSupportedContent">
        <ul class="navbar-nav" id="headerNav">

                <c:set var="user" value="${sessionScope.loginUser}"/>

            <c:if test="${user==null}">
                    <a class="nav-link" href="user/login">你好！请登陆 </a>
            </c:if>
            <c:if test="${user!=null}">
                <li class="nav-link">欢迎您！${user.username}</li>
                <li class="nav-item" id="navMainPage"><a class="nav-link" href="${pageContext.request.contextPath}/user/logout"> 注销 </a></li>
            </c:if>
            </li>
            <li class="nav-item" id="navMainPage"><a class="nav-link"
                                                     href="/bookJdbc/WEB-INF/cart.jsp"> 购物车 </a></li>
        </ul>
    </div>

</nav>



<div class="container">
    <table class="table table-hover">
        <tr>
            <th class="text-center">书名</th>
            <th class="text-center">作者</th>
            <th class="text-center">单价（元）</th>
            <th class="text-center">操作</th>
        </tr>
        <!-- 以下代码遍历DataBase中的 所有书籍并以表格形式显示到页面上 -->
        <c:forEach items="${requestScope.books}" var="book">
        <tr>
            <td class="text-center">${book.title}</td>
            <td class="text-center">${book.author}</td>
            <td class="text-center">${book.price}</td>
            <form action="cart/addCart" method="post">
                <c:if test="${not empty user}">
                    <input type="hidden" name="uid" value="${user.id}" />
                </c:if>
                <input type="hidden" name="price" value="${book.price}" />
                <input type="hidden" name="bookName" value="${book.title}" />
                <input type="hidden" name="sum" value="${book.price}" />
                <input type="hidden" name="quantity" value="1" />
                    <td class="text-center">
                        <li class="btn btn-primary btn-sm" data-toggle="tooltip" title="加入购物车"> <i class="fa fa-cart-plus">
                            <input type="submit" value="加入购物车" class="btn btn-primary btn-sm" data-toggle="tooltip" />
                        </i>
                        </li>
                    </td>
            </form>
        </tr>
        </c:forEach>
    </table>
</div>
<script>
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>
</body>
</html>