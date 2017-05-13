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
<title>场地预留 - 广东海洋大学体育馆网上系统后台</title>
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
    <form action="" method="post" class="align-right">
      姓名：
      <input name="username" type="text" />
      &nbsp;&nbsp;
      学号：
      <input name="userid" type="text" />
      &nbsp;&nbsp;
      <input type="submit" value="查询" />
    </form>
    <table class="ground-list" cellspacing="2px">
      <tr>
        <th scope="col">场地编号</th>
        <th scope="col">类型</th>
        <th scope="col">名称</th>
        <th scope="col">资费</th>
        <th scope="col">操作</th>
      </tr>
      <tr>
        <td>1000561456</td>
        <td>羽毛球</td>
        <td>羽毛球1-1</td>
        <td>10/小时</td>
        <td><a href="#">预留</a></td>
      </tr>
    </table>
  </div>
</div>
<script>
	var def = "4";
</script>
<%@ include file="../include/footer.jsp"%>
</body>
</html>
