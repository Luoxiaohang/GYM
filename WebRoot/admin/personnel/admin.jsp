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
<title>管理员管理 - 广东海洋大学体育馆网上系统后台</title>
<link href="../css/nav.css" rel="stylesheet" type="text/css" />
<script src="../js/nav.js" type="text/javascript"></script>
<script src="../js/focus.js" type="text/javascript"></script>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/personnel.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="../include/header.jsp"%>
	<div id="main">
		<div id="row_1">
			<table class="admin-list" cellspacing="2px">
				<tr>
					<th scope="col">工号</th>
					<th scope="col">姓名</th>
					<th scope="col">权限</th>
					<th scope="col">手机号码</th>
					<th scope="col">入职日期</th>
					<th scope="col">状态</th>
					<th scope="col">操作</th>
				</tr>
				<c:forEach items="${requestScope.adminList}" var="list">
					<tr>
						<td>${list.getaId()}</td>
						<td>${list.getaName()}</td>
						<td>${list.getPower()}</td>
						<td>${list.getPhone()}</td>
						<td>${list.getaEntry()}</td>
						<td>${list.getStatus()}</td>
						<td><a href="index.html?action=deladmin&aId=${list.getaId()}">禁用</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script>
		var def = "2";
	</script>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>
