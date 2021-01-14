<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet"
	href="css/font-awesome-4.7.0/css/font-awesome.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货币兑换</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark"
		style="margin-bottom: 30px"> <a class="navbar-brand" href="#">货币兑换</a>

	</nav>
	<div class="container">
	<a class="btn btn-success" href="index.jsp"> <i
			class="fa fa-arrow-left fa-lg"></i> 返回
		</a> 
		<br><br>
		<form class="form" id="f1" method="get" action="changer.jsp">
			<div class="form-group">
				<label> 请输入兑换金额(单位：元)</label>
			
			<div class="control">
					<input type="text" class="form-control" name="values" />
			</div>
			</div>
				
			
			<div class="form-group">
				<label for="sel1">兑换方式:</label> <select class="form-control"
					id="sel1" name="direction">
					<option value="U2C">美元兑人民币</option>
					<option value="C2U">人民币兑美元</option>

				</select>
			</div>
		<input type="submit" class="btn btn-primary" value="OK" />
		</form>
	</div>

	<%
		
		
		
		
		
		
		/*message是显示提示框信息的字符串，期中的toReplace是需要用换算后的结果替换的，使用
	      out对象输出到页面上，输出内容为message.replace("toReplace",换算后的结果字符串)
		*/
		String message = "<br><div class='container'><div class='alert alert-success'> toReplace</div></div>";
		/*换算逻辑
		  注意：看清换算方向，选取不同的值从而达到换算的目的 
		*/
	    String valueString = request.getParameter("values");
		String direction = request.getParameter("direction");
		if(null!=valueString){
			double value = Double.parseDouble(valueString);
			if("U2C".equals(direction)){
				value*=7;
			}else{
				value/=7;
			}
			
			out.print(message.replace("toReplace","结果："+value+""));
		}
	%>
</body>
</html>