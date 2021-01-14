<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/16
  Time: 16:06
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
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<link rel="stylesheet"
		  href="css/font-awesome-4.7.0/css/font-awesome.css" type="text/css" />
	<style type="text/css">
		.product-buyer-name {
			max-width: 110px;
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap;  //文本不换行，这样超出一行的部分被截取，显示...
		}
	</style>
	<title>查看书籍</title>
</head>

<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark"
	 style="margin-bottom: 30px">
	<a class="navbar-brand" href="#">图书列表</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
</nav>


<div class="container">
	<a class="btn btn-success" href="book/form"> <i
			class="fa fa-plus fa-lg"></i> 添加书籍
	</a>
	<br><br>

	<table class="table table-hover">
		<tr>
			<th class="text-center">书名</th>
			<th class="text-center">作者</th>
			<th class="text-center">单价</th>
			<th class="text-center">详细信息</th>
			<th class="text-center">操作</th>
			<th class="text-center"></th>
		</tr>
		<c:forEach items="${requestScope.books}" var="book">
			<tr>
				<td class="text-center">${book.title}</td>
				<td class="text-center">${book.author}</td>
				<td class="text-center">${book.price}</td>
				<td class="text-center product-buyer-name">${book.description}</td>
				<td>
					<a class="btn btn-primary btn-sm" href="book/get?id=${book.id}">
						<i class="fa fa-search-plus"></i>查看</a>
				</td>
				<td>
					<a class="btn-sm btn btn-danger" href="book/delete?id=${book.id}">
						<i class="fa fa-trash"></i>删除</a>
				</td>
			</tr>
		</c:forEach>

	</table>

</div>

</body>
</html>