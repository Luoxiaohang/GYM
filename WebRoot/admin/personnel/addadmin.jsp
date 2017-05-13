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
<title>管理员管理 - 广东海洋大学体育馆网上系统后台</title>
<link href="../css/nav.css" rel="stylesheet" type="text/css" />
<script src="../js/nav.js" type="text/javascript"></script>
<script src="../js/focus.js" type="text/javascript"></script>
<script src="../js/timepicker.js" type="text/javascript"></script>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/personnel.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="../include/header.jsp"%>
	<div id="main">
		<div id="row_1">
			<div id="admin-add">
				<form action="index.html" method="post">
					<p>
						姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名 <input name="name"
							type="text" class="input_text" /> *
					</p>
					<p>
						密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 <input name="password"
							type="password" class="input_text" /> *
					</p>
					<p>
						手机号码 <input name="phone" type="text" class="input_text" /> *
					</p>
					<p>
						电子邮箱 <input name="email" type="text" class="input_text" /> *
					</p>
					<p>
						身份证号 <input name="idcard" type="text" class="input_text" /> *
					</p>
					<p>
						出生日期 <input name="birthdate" type="text" class="input_text"
							onClick="setDayHM(this);" readonly="readonly" />
					</p>
					<p>
						<input name="action" type="hidden" value="add" /> <input name=""
							type="submit" value="提交" class="btn_submit" /> <input name=""
							type="reset" value="重置" class="btn_submit" />
					</p>
				</form>
			</div>
		</div>
	</div>
	<script>
		var def = "2";
	</script>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>
