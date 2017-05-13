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
<title>赛事管理 - 广东海洋大学体育馆网上系统</title>
<link href="../css/nav.css" rel="stylesheet" type="text/css" />
<script src="../js/nav.js" type="text/javascript"></script>
<script src="../js/focus.js" type="text/javascript"></script>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/match.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ include file="../include/header.jsp"%>
<div id="main">
  <div id="row_1"> 
    <!--    <form action="" method="post" class="align-right">
      关键词：
      <input name="username" type="text" />
      <input type="submit" value="查询" />
    </form>
-->
    <table class="match-list" cellspacing="2px">
      <tr>
        <th scope="col" class="match-title">标题</th>
        <th scope="col">发布者ID</th>
        <th scope="col">发布时间</th>
        <th scope="col">操作</th>
      </tr>
      <c:forEach items="${requestScope.matchList}" var="list">
        <tr>
          <td><a href="../../match/index.html?mid=${list.getmId()}">${list.getmName()}</a></td>
          <td>${list.getaId()}</td>
          <td>${list.getmDate()}</td>
          <td><a href="index.html?action=delete&mid=${list.getmId()}" onclick="return confirm('确认删除该赛事？');">删除</a></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
<script>
	var def = "3";
</script>
<%@ include file="../include/footer.jsp"%>
</body>
</html>
