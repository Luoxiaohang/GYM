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
<title>学生用户管理 - 广东海洋大学体育馆网上系统后台</title>
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
    <!--<form action="" method="post">
      姓名：
      <input name="username" type="text" />
      &nbsp;&nbsp;
      学号：
      <input name="userid" type="text" />
      <input type="submit" value="查询" />
    </form>-->
    <table class="user-list" cellspacing="2px">
      <tr>
        <th scope="col">用户卡号</th>
        <th scope="col">姓名</th>
        <th scope="col">邮箱</th>
        <th scope="col">身份证</th>
        <th scope="col">状态</th>
        <th scope="col">操作</th>
      </tr>
      <c:forEach items="${requestScope.userList}" var="list">
        <tr>
          <td>${list.getuId()}</td>
          <td>${list.getuName()}</td>
          <td>${list.getuEmail()}</td>
          <td>${list.getuIdCard()}</td>
           <td>${list.getStatus()}</td>
          <td><a href="index.html?action=deluser&uid=${list.getuId()}">封禁</a></td>
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
