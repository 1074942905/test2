<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/16
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>

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
    <title>添加书籍</title>
</head>


<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark"
     style="margin-bottom: 30px">
    <a class="navbar-brand" href="#">添加图书</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>
<div class="container">
    <a class="btn btn-success" href="book/list"> <i
            class="fa fa-arrow-left fa-lg"></i> 返回
    </a>
    <br><br>
    <form class="form" id="f1" method="post" action="book/save">

        <div class="form-group">
            <label for="email">书名</label>
            <div class="controls">
                <input class="form-control" type="text" name="bname" />
            </div>
        </div>

        <div class="form-group">
            <label for="email">作者</label>
            <div class="controls">
                <input type="text" class="form-control" name="bauthor" />
            </div>
        </div>

        <div class="form-group"><label for="email">价格</label>
            <input type="number" class="form-control" name="bprice" />
        </div>
        <div class="form-group"><label for="email">简介</label>
            <textarea
                    name="bdesc" class="form-control" />
            </textarea>
        </div>
        <button type="submit" class="btn btn-primary">
            <i class="fa fa-check">确认</i>
        </button>
        <button type="reset" class="btn btn-danger">
            <i class="fa fa-trash">清空</i>
        </button>

    </form>
</div>


</body>
</html>