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
<title>添加场地 - 广东海洋大学体育馆网上系统</title>
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
			<div id="ground-add">
				<form action="index.html" method="post">
					<p>
						类型 <select name="type" class="input_text">
							<c:forEach items="${requestScope.groundTypeList}" var="list">
								<option value="${list.gettId()}">${list.gettName()}</option>
							</c:forEach>
						</select>
					</p>
					<p>
						名称 <input name="name" type="text" class="input_text" />
					</p>
					<p>
						资费 <input name="fee" type="text" class="input_text" />
					</p>
					<p>
						备注 <input name="remark" type="text" class="input_text" />
					</p>
					<p>
						<input name="action" type="hidden" value="add" /> <input
							name="submit" type="submit" class="btn_submit" value="添加" /> <input
							name="" type="reset" class="btn_submit" value="重置" />
					</p>
				</form>
			</div>
		</div>
	</div>
	<script>
		var def = "4";
	</script>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>
