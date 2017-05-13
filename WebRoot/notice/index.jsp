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
<title>公告 - 广东海洋大学体育馆网上系统</title>
<link href="../css/nav.css" rel="stylesheet" type="text/css" />
<script src="../js/nav.js" type="text/javascript"></script>
<script src="../js/focus.js" type="text/javascript"></script>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/notice.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ include file="../include/header.jsp"%>
<div id="main">
  <div id="row_1">
    <ul id="match-list">
      <c:forEach items="${requestScope.noticeList}" var = "list">
        <li>
          <h2 class="color-red"> <a href="index.html?nid=${list.getnId()}">${list.getnTitle()}</a> </h2>
          <div class="match-summary">${list.getnText()} </div>
          <div class="align-right color-gray"> 发布时间：${list.getnDate()} </div>
        </li>
      </c:forEach>
    </ul>
  </div>
</div>
<script>
	var def = "6";
</script>
<%@ include file="../include/footer.jsp"%>
</body>
</html>
