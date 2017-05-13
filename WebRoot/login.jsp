<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录 - 广东海洋大学体育馆网上系统</title>
<link href="css/nav.css" rel="stylesheet" type="text/css" />
<script src="js/nav.js" type="text/javascript"></script>
<script src="js/focus.js" type="text/javascript"></script>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/account.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="include/header.jsp"%>
	<div id="main">
		<div id="row_1">
			<div id="login_banner">
				<img src="images/login_banner.jpg" />
			</div>
			<div id="login_div">
				<form action="login.html" method="post">
					<span class="tmp">用户名：</span> <input name="uid" type="text"
						class="input_text" /> <br /> 密&nbsp;&nbsp;&nbsp;码： <input
						name="password" type="password" class="input_text" /> <br /> <br />
					<br /> <input type="submit" value="登录" class="btn" /> <input
						type="reset" value="重置" class="btn" />
				</form>
			</div>
		</div>
	</div>
	<script>
		var def = "1";
	</script>
	<%@ include file="include/footer.jsp"%>
</body>
</html>
