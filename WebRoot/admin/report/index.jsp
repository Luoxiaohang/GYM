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
<title>报表查询 - 广东海洋大学体育馆网上系统</title>
<link href="../css/nav.css" rel="stylesheet" type="text/css" />
<script src="../js/nav.js" type="text/javascript"></script>
<script src="../js/focus.js" type="text/javascript"></script>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/report.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ include file="../include/header.jsp"%>
<div id="main">
  <div id="row_1">
    <table class="report-list" cellspacing="2px">
      <tr>
        <th scope="col">编号</th>
        <th scope="col">支出</th>
        <th scope="col">收入</th>
        <th scope="col">日期</th>
        <th scope="col">备注</th>
      </tr>
      <c:forEach items="${requestScope.reportList}" var="list">
        <tr>
          <td>${list.getfId()}</td>
          <td>${list.getfOut()}</td>
          <td>${list.getfIn()}</td>
          <td>${list.getDate()}</td>
          <td>${list.getNotes()}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
<script>
	var def = "7";
</script>
<%@ include file="../include/footer.jsp"%>
</body>
</html>
