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
<title>场地资费设置 - 广东海洋大学体育馆网上系统后台</title>
<link href="../css/nav.css" rel="stylesheet" type="text/css" />
<script src="../js/nav.js" type="text/javascript"></script>
<script src="../js/focus.js" type="text/javascript"></script>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/ground.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="../include/header.jsp"%>
	<div id="main">
		<div id="row_1">
			<table class="ground-list" cellspacing="2px">
				<tr>
					<th scope="col">场地编号</th>
					<th scope="col">类型</th>
					<th scope="col">名称</th>
					<th scope="col">资费</th>
					<th scope="col">备注</th>
					<th scope="col">操作</th>
				</tr>
				<c:forEach items="${requestScope.groundList}" var="list">
					<form action="index.html" method="post"
						onsubmit="return confirm('确定修改该场地?');">
						<tr>
							<td>${list.getgId()}</td>
							<td><select name="type" id="select">
									<option value="${list.gettId()}">${list.gettName()}</option>
									<c:forEach items="${requestScope.groundTypeList}"
										var="typelist">
										<option value="${typelist.gettId()}">${typelist.gettName()}</option>
									</c:forEach>
							</select></td>
							<td><input name="name" type="text"
								value="${list.getgName()}" /></td>
							<td><input name="fee" type="text" value="${list.getgFee()}" />
								<input name="gid" type="hidden" value="${list.getgId()}" />
								元/小时</td>
							<td><input name="remark" type="text"
								value="${list.getgRemark()}" /></td>
							<td><input name="action" type="hidden" value="setting" /> <input
								name="submitsetting" type="submit" value="修改" /></td>
						</tr>
					</form>
				</c:forEach>
			</table>
		</div>
	</div>
	<script>
		var def = "4";
	</script>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>
