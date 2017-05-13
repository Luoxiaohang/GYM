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
<title>修改信息 - 广东海洋大学体育馆网上系统</title>
<link href="../css/nav.css" rel="stylesheet" type="text/css" />
<script src="../js/nav.js" type="text/javascript"></script>
<script src="../js/focus.js" type="text/javascript"></script>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/account.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ include file="../include/header.jsp"%>
<div id="main">
  <div id="row_1">
    <div id="reset_banner"></div>
    <div id="reset_div">
      <c:forEach items="${requestScope.userList}" var="list">
        <form action="index.html" method="post">
          姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
          <input name="name" type="text" class="input_text" value="${list.getuName()}" />
          <br />
          邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱
          <input name="email" type="text" class="input_text" value="${list.getuEmail()}" />
          <br />
          手机号码
          <input name="phone" type="text" class="input_text" value="${list.getuPhone()}" />
          <br />
          身份证号
          <input name="idcard" type="text" class="input_text" value="${list.getuIdCard()}" />
          <br />
          <br />
          <br />
          <input name="action" type="hidden" value="alter" />
          <input type="submit" value="确定" class="btn" />
          <input type="reset" value="重置" class="btn" />
        </form>
      </c:forEach>
    </div>
  </div>
</div>
<script>
	var def = "5";
</script>
<%@ include file="../include/footer.jsp"%>
</body>
</html>
