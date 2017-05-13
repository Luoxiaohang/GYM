<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path2 = request.getContextPath();
	String basePath2 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path2 + "/";
%>

<!--header-->

<div id="header">
	<div class="content">
		<div class="logo">
			<a href="<%=basePath2%>admin/index.html"><img
				src="<%=basePath2%>admin/images/logo.png" width="100" height="100" />
			</a>
		</div>
		<div class="name">
			<h1>广东海洋大学体育馆网上系统后台</h1>
			<span class="version">beta1.0</span>
		</div>
		<div class="banner">
			<img src="<%=basePath2%>admin/images/banner.png" />
		</div>
	</div>
</div>

<!--navigation-->
<div id="menu">
	<ul>
		<li class="m_line"><img
			src="<%=basePath2%>admin/images/line1.gif" /></li>
		<li id="m_1" class='m_li' onmouseover='mover(1);'
			onmouseout='mout(1);'><a href="<%=basePath2%>admin/index.html">首页</a>
		</li>
		<li class="m_line"><img
			src="<%=basePath2%>admin/images/line1.gif" /></li>
		<li id="m_2" class='m_li' onmouseover='mover(2);'
			onmouseout='mout(2);'><a
			href="<%=basePath2%>admin/personnel/index.html">人员管理</a></li>
		<li class="m_line"><img
			src="<%=basePath2%>admin/images/line1.gif" /></li>
		<li id="m_3" class='m_li' onmouseover='mover(3);'
			onmouseout='mout(3);'><a
			href="<%=basePath2%>admin/match/index.html">赛事管理</a></li>
		<li class="m_line"><img
			src="<%=basePath2%>admin/images/line1.gif" /></li>
		<li id="m_4" class='m_li' onmouseover='mover(4);'
			onmouseout='mout(4);'><a
			href="<%=basePath2%>admin/ground/index.html">场地管理</a></li>
		<li class="m_line"><img
			src="<%=basePath2%>admin/images/line1.gif" /></li>
		<li id="m_5" class='m_li' onmouseover='mover(5);'
			onmouseout='mout(5);'><a
			href="<%=basePath2%>admin/equipment/index.html">器材管理</a></li>
		<li class="m_line"><img
			src="<%=basePath2%>admin/images/line1.gif" /></li>
		<li id="m_6" class='m_li' onmouseover='mover(6);'
			onmouseout='mout(6);'><a
			href="<%=basePath2%>admin/notice/index.html">公告发布</a></li>
		<li class="m_line"><img
			src="<%=basePath2%>admin/images/line1.gif" /></li>
		<li id="m_7" class='m_li' onmouseover='mover(7);'
			onmouseout='mout(7);'><a
			href="<%=basePath2%>admin/report/index.html">报表查询</a></li>
		<li class="m_line"><img
			src="<%=basePath2%>admin/images/line1.gif" /></li>
	</ul>
</div>
<div style="height: 32px; background-color: #F1F1F1;">
	<ul class="smenu">
		<li style="padding-left: 29px;" id="s_1" class='s_li'
			onmouseover='mover(1);' onmouseout='mout(1);'></li>
		<li style="padding-left: 141px;" id="s_2" class='s_li'
			onmouseover='mover(2);' onmouseout='mout(2);'><a
			href="<%=basePath2%>admin/personnel/index.html?action=addadmin">添加管理员</a>
			<span class="split">|</span> <a
			href="<%=basePath2%>admin/personnel/index.html?action=admin">管理员管理</a>
			<span class="split">|</span> <a
			href="<%=basePath2%>admin/personnel/index.html?action=user">学生用户管理</a>
		</li>
		<li style="padding-left: 252px;" id="s_3" class='s_li'
			onmouseover='mover(3);' onmouseout='mout(3);'><a
			href="<%=basePath2%>admin/match/index.html?action=add">添加赛事</a></li>
		<li style="padding-left: 364px;" id="s_4" class='s_li'
			onmouseover='mover(4);' onmouseout='mout(4);'><a
			href="<%=basePath2%>admin/ground/index.html?action=add">添加场地</a> <span
			class="split">|</span> <a
			href="<%=basePath2%>admin/ground/index.html?action=delete">删除场地</a> <span
			class="split">|</span> <a
			href="<%=basePath2%>admin/ground/index.html?action=setting">场地设置</a>
			<span class="split">|</span> <a
			href="<%=basePath2%>admin/ground/index.html?action=punchcard">场地使用打卡</a>
		</li>
		<li style="padding-left: 476px;" id="s_5" class='s_li'
			onmouseover='mover(5);' onmouseout='mout(5);'><a
			href="<%=basePath2%>admin/equipment/index.html?action=add">添加器材</a> <span
			class="split">|</span> <a
			href="<%=basePath2%>admin/equipment/index.html?action=delete">删除器材</a>
			<span class="split">|</span> <a
			href="<%=basePath2%>admin/equipment/index.html?action=setting">器材设置</a>
			<span class="split">|</span> <a
			href="<%=basePath2%>admin/equipment/index.html?action=punchcard">器材租借打卡</a>
		</li>
		<li style="padding-left: 588px;" id="s_6" class='s_li'
			onmouseover='mover(6);' onmouseout='mout(6);'></li>
		<li style="padding-left: 580px;" id="s_7" class='s_li'
			onmouseover='mover(7);' onmouseout='mout(7);'><a
			href="<%=basePath2%>admin/report/index.html?action=ground">场地租用收入</a>
			<span class="split">|</span> <a
			href="<%=basePath2%>admin/report/index.html?action=equipment">器材租用收入</a>
		</li>



	</ul>
</div>

<!--header-->