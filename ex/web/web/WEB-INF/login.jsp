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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/login.css" rel="stylesheet">
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<title>登录</title>
</head>
<body class="text-center">

<div class="container">
	      
	<form class="form-signin" action="${pageContext.request.contextPath}/user/login" method="post" >

		<h2 class="form-signin-heading font-weight-bold">登录</h2>
		<label class="sr-only">用户名</label>
		<input
				type="text" id="username" name="username" class="form-control" placeholder="用户名"
				required autofocus>

		<label class="sr-only">密码</label>
		<input type="password" name="password" id="password"
			   class="form-control" placeholder="密码" required>

		<button class="btn btn-lg btn-primary btn-block" id="check"
				type="submit">登录</button>
		<button class="btn btn-lg btn-primary btn-block" id="check"
				type="reset">重置</button>
	</form>
</div>
</body>
</html>