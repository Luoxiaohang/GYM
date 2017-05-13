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
<title>场地预约 - 广东海洋大学体育馆网上系统</title>
<link href="../css/nav.css" rel="stylesheet" type="text/css" />
<script src="../js/nav.js" type="text/javascript"></script>
<script src="../js/focus.js" type="text/javascript"></script>
<script src="../js/timepicker.js" type="text/javascript"></script>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/ground.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ include file="../include/header.jsp"%>
<div id="main">
  <div id="row_1"> 
    
    <!--filter --> 
    <!-- <form action="" method="post" id="filter">
      场地类型
      <select name="">
        <option value="羽毛球"> 羽毛球 </option>
        <option value="篮球"> 篮球 </option>
        <option value="乒乓球"> 乒乓球 </option>
      </select>
      &nbsp;&nbsp;排序
      <select name="">
        <option value="编号从大到小"> 编号从大到小 </option>
        <option value="编号从小到大"> 编号从小到大 </option>
        <option value="资费从大到小"> 资费从大到小 </option>
        <option value="资费从小到大"> 资费从小到大 </option>
      </select>
      &nbsp;&nbsp; 起始时间
      <input type="text" name="datehm" readOnly onClick="setDayHM(this);">
      &nbsp;&nbsp; 结束时间
      <input type="text" name="datehm" readOnly
							onClick="setDayHM(this);">
      &nbsp;&nbsp;
      <input name="empty" type="checkbox" id="empty" />
      只显示空闲场地
      &nbsp;&nbsp;
      <input type="submit" value="查询" />
    </form>--> 
  </div>
  <div id="row_2">
    <table class="ground-list" cellspacing="2px">
      <tr>
        <th scope="col"> 编号 </th>
        <th scope="col"> 名称 </th>
        <th scope="col"> 类型 </th>
        <th scope="col"> 资费 </th>
        <th scope="col"> 状态 </th>
        <th scope="col"> 备注 </th>
        <th scope="col" class="book"> 操作 </th>
      </tr>
      <c:forEach items="${requestScope.groundList}" var="list">
        <tr>
          <td> ${list.getgId()} </td>
          <td> ${list.getgName()} </td>
          <td> ${list.gettName()} </td>
          <td> ${list.getgFee()} </td>
          <td> ${list.getgStatus()} </td>
          <td> ${list.getgRemark()} </td>
          <td class="align-center"><a href="index.html?action=book&gid=${list.getgId()}">预定</a></td>
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
