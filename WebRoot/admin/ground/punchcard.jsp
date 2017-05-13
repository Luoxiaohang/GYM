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
<title>场地使用打卡 - 广东海洋大学体育馆网上系统后台</title>
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
    <div class="punchcard-ground">
      <form action="" method="post">
        卡&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号
        <input name="uid" type="text" />
        <input name="" type="submit" value="模拟打卡" />
      </form>
      <c:if test="${requestScope.bookList!=null}">
        <table class="ground-list" cellspacing="2px">
          <tr>
            <th scope="col">器材编号</th>
            <th scope="col">起始时间</th>
            <th scope="col">结束时间</th>
            <th scope="col">资费</th>
            <th scope="col">状态</th>
            <th scope="col" class="book">操作</th>
          </tr>
          <c:forEach items="${requestScope.bookList}" var="list">
            <tr>
              <td>${list.getgId()}</td>
              <td>${list.getbStartTime()}</td>
              <td>${list.getbEndTime()}</td>
              <td>${list.getbFee()}</td>
              <td>${list.getbStatus()}</td>
              <td class="align-center"><a href="index.html?action=use&uid=${list.getuId()}&gid=${list.getgId()}&bid=${list.getbId()}">使用</a></td>
            </tr>
          </c:forEach>
        </table>
      </c:if>
    </div>
  </div>
</div>
<script>
	var def = "4";
</script>
<%@ include file="../include/footer.jsp"%>
</body>
</html>
