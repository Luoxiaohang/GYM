<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.util.HashMap" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	HashMap msgParam = new HashMap();

	msgParam.put("1000", "操作成功");
	msgParam.put("1001", "未知错误");
	msgParam.put("1002", "未登录");
	msgParam.put("1003", "两次输入密码不一致");
	msgParam.put("1004", "权限不足");
	msgParam.put("1010", "用户存在");
	msgParam.put("1011", "用户不存在");
	msgParam.put("1012", "用户密码错误");
	msgParam.put("1020", "管理员存在");
	msgParam.put("1021", "管理员不存在");
	msgParam.put("1022", "管理员密码错误");
	msgParam.put("1030", "必填参数为空");
	msgParam.put("1031", "日期时间错误");
	msgParam.put("1032", "预定或租借时间冲突");
	msgParam.put("1040", "场地无效");
	msgParam.put("1041", "器材无效");
	msgParam.put("1050", "您没有预定此场地");
	msgParam.put("1051", "您没有租借此器材");
	msgParam.put("1060", "非预定状态");
	msgParam.put("1061", "非使用状态");
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出错啦 - 广东海洋大学体育馆网上系统</title>
<link href="css/nav.css" rel="stylesheet" type="text/css" />
<script src="js/nav.js" type="text/javascript"></script>
<script src="js/focus.js" type="text/javascript"></script>
<link href="css/common.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ include file="include/header.jsp"%>
<div id="main">
  <div id="row_1">
    <div class="error-message">
      <p>错误代码：<%=request.getParameter("errorCode")%> </p>
      <p>错误原因：
        <% out.print(msgParam.get(request.getParameter("errorCode")));%>
      </p>
    </div>
  </div>
</div>
<script>
	var def = "0";
</script>
<%@ include file="include/footer.jsp"%>
</body>
</html>
