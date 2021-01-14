<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>

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
	<title>购物车</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark"
	 style="margin-bottom: 30px">
	<a class="navbar-brand" href=" ">我的书店</a>


</nav>



<div class="container">
	<table class="table table-hover">
		<tr>
			<th class="text-center">书名</th>
			<th class="text-center">单价</th>
			<th class="text-center">数量</th>
			<th class="text-center">小计（元）</th>
		</tr>
		<!-- 以下填写代码，从cookie中查找书籍,并根据cookie-->
		<c:forEach items="${sessionScope.listCartSession}" var="item">
		<tr>
			<td class="text-center"><C:out>${item.bookName}</C:out></td>
			<td class="text-center">${item.price}</td>
			<td class="text-center">${item.quantity}</td>
			<td class="text-center">${item.sum}</td>
		<tr>
			</c:forEach>
			<c:set var="sum" value="0"></c:set>
			<c:forEach items="${sessionScope.listCartSession}" var="item">

				<c:set var="sum" value="${sum+item.sum}"></c:set>
			</c:forEach>
		<tr>
			<td class="text-center"></td>
			<td class="text-center"></td>
			<th class="text-center">总计（元）:</th>
			<td class="text-center">${sum}</td>
		</tr>

		<tr class="text-center">
			<td class="text-center" colspan="3">
				<a class="btn btn-primary btn-sm" href="cart/Continue"><i class="fa fa-cart-plus">继续</i></a>
				<a class="btn btn-danger btn-sm" href="cart/clear"><i class="fa fa-trash">清空</i></a>
				<a class="btn btn-info btn-sm" href=""><i class="fa fa-yen">结算</i></a>
			</td>
		</tr>
	</table>
</div>
<script>
	$(document).ready(function(){
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
</body>
</html>
