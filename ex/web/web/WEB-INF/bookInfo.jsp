<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/16
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
	<title>书籍信息</title>
</head>
<%
	//获取由getBookById传来的书籍信息然后填到下面的相应标签内
%>

<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark"
	 style="margin-bottom: 30px">
	<a class="navbar-brand" href="#">书籍信息</a>

</nav>
<div class="container">
	<a class="btn btn-success" href="book/list"> <i
			class="fa fa-arrow-left fa-lg"></i> 返回
	</a>
	<br><br>
	<form class="form" name="form" method="post" action="book/update">
		<!-- 以下所有的value后面的值都是由上面的逻辑代码取出的，使用表达式元素显示即可
            texarea中的value直接写在结束标签之前即可
         -->
		<input type="hidden" name="id" value="${requestScope.book.id}"/>
		<div class="form-group">
			<label for="email">书名</label>
			<div class="controls">
				<input class="form-control" value="${requestScope.book.title}" type="text" name="bname" />
			</div>
		</div>

		<div class="form-group">
			<label for="email">作者</label>
			<div class="controls">
				<input type="text"  value="${requestScope.book.author}"class="form-control" name="bauthor" />
			</div>
		</div>
		<div class="form-group"><label for="email">价格</label>
			<input type="number"  value="${requestScope.book.price}"class="form-control" name="bprice" />
		</div>
		<div class="form-group"><label for="email">简介</label>
			<input type="text" value="${requestScope.book.description}" name="bdesc" class="form-control"/>
		</div>
		<div class="form-group">
			<input type="submit" value="修改" class="btn btn-primary" />
		</div>

	</form>
</div>


</body>
</html>