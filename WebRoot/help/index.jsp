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
<title>帮助 - 广东海洋大学体育馆网上系统</title>
<link href="../css/nav.css" rel="stylesheet" type="text/css" />
<script src="../js/nav.js" type="text/javascript"></script>
<script src="../js/focus.js" type="text/javascript"></script>
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/help.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ include file="../include/header.jsp"%>
<div id="main">
  <div id="row_1">
    <h1 class="align-center color-red">帮助中心</h1>
    <dl id="help-doc">
      <dt> 如何预约场地； </dt>
      <dd> 1.点击场地预订导航栏</dd>
      <dd> 2.选择自己需要预定的场地，然后后点击其后面的“预定”；</dd>
      <dd> 3.选择需要预定的起止时间，点击提交。</dd>
  
      <dt> 如何租借器材； </dt>
      <dd> 1.点击器材租借导航栏</dd>
      <dd> 2.选择自己需要租借的器材，然后点击其后面的“租借”； </dd>
      <dd> 3.选择需要租借的起止时间，点击提交。 </dd>
      
      <dt> 惩罚措施 </dt>
      <dd> 1.如果预约场地失约（即预约了没有在预约时间内到场使用），则需要缴清预约费用，并加收10%违约金。</dd>
      <dd> 2.如果失约没有缴清预约费用和违约金，则账户会被冻结，无法继续使用此系统，并且毕业后由学校统一补收。</dd>
    </dl>
  </div>
</div>
<script>
	var def = "7";
</script>
<%@ include file="../include/footer.jsp"%>
</body>
</html>
