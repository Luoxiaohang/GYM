<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>广东海洋大学体育馆管理系统后台</title>
<link href="css/nav.css" rel="stylesheet" type="text/css" />
<script src="js/nav.js" type="text/javascript"></script>
<script src="js/focus.js" type="text/javascript"></script>
<link href="css/common.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="include/header.jsp"%>
	<div id="main">
		<div id="row_1">
			<%
				if (null == request.getSession().getAttribute("aId")) {
			%>
			<div id="admin-login">
				<form action="" method="post">
					<p>
						工号&nbsp;&nbsp; <input name="aid" type="text" class="input_text" />
					</p>
					<p>
						密码&nbsp;&nbsp; <input name="password" type="password"
							class="input_text" />
					</p>
					<p>
						<input name="action" type="hidden" value="admin_login" /> <input
							name="" type="submit" value="登录" class="btn_submit" /> <input
							name="" type="reset" value="重置" class="btn_submit" />
					</p>
				</form>
			</div>
			<%
				} else {
			%>
			<table class="admin-info" cellspacing="2px">
				<c:forEach items="${requestScope.adminList}" var="list">
					<tr>
						<th scope="row">编号</th>
						<td>${list.getaId()}</td>
					</tr>
					<tr>
						<th scope="row">姓名</th>
						<td>${list.getaName()}</td>
					</tr>
					<tr>
						<th scope="row">身份证号</th>
						<td>${list.getIdCardNo()}</td>
					</tr>
					<tr>
						<th scope="row">出生日期</th>
						<td>${list.getBirthdate()}</td>
					</tr>
					<tr>
						<th scope="row">权限</th>
						<td>${list.getPower()}</td>
					</tr>
					<tr>
						<th scope="row">手机号码</th>
						<td>${list.getPhone()}</td>
					</tr>
					<tr>
						<th scope="row">入职日期</th>
						<td>${list.getaEntry()}</td>
					</tr>
					<tr>
						<th scope="row">状态</th>
						<td>${list.getStatus()}</td>
					</tr>
				</c:forEach>
			</table>
			<br /> <br />
			<h3 class="align-center">
				<a href="index.html?action=logout">退出登录</a>
			</h3>
			<%
				}
			%>
		</div>
	</div>
	<script>
		var def = "1";
	</script>
	<%@ include file="include/footer.jsp"%>
</body>
</html>
