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
			<a href="<%=basePath2%>"><img src="<%=basePath2%>images/logo.png"
				width="100" height="100" /></a>
		</div>
		<div class="name">
			<h1>广东海洋大学体育馆网上系统</h1>
			<span class="version">beta1.0</span>
		</div>
		<div class="banner">
			<img src="<%=basePath2%>images/banner.png" />
		</div>
	</div>
</div>

<!--navigation-->
<div id="menu">
	<ul>
		<li class="m_line"><img src="<%=basePath2%>images/line1.gif" />
		</li>
		<li id="m_1" class='m_li' onmouseover='mover(1);'
			onmouseout='mout(1);'><a href="<%=basePath2%>">首页</a></li>
		<li class="m_line"><img src="<%=basePath2%>images/line1.gif" />
		</li>
		<li id="m_2" class='m_li' onmouseover='mover(2);'
			onmouseout='mout(2);'><a href="<%=basePath2%>match/index.html">体育赛事</a>
		</li>
		<li class="m_line"><img src="<%=basePath2%>images/line1.gif" />
		</li>
		<li id="m_3" class='m_li' onmouseover='mover(3);'
			onmouseout='mout(3);'><a href="<%=basePath2%>ground/index.html">场地预定</a>
		</li>
		<li class="m_line"><img src="<%=basePath2%>images/line1.gif" />
		</li>
		<li id="m_4" class='m_li' onmouseover='mover(4);'
			onmouseout='mout(4);'><a
			href="<%=basePath2%>equipment/index.html">器材租借</a></li>
		<li class="m_line"><img src="<%=basePath2%>images/line1.gif" />
		</li>
		<li id="m_5" class='m_li' onmouseover='mover(5);'
			onmouseout='mout(5);'><a href="<%=basePath2%>user/index.html">个人中心</a>
		</li>
		<li class="m_line"><img src="<%=basePath2%>images/line1.gif" />
		</li>
		<li id="m_6" class='m_li' onmouseover='mover(6);'
			onmouseout='mout(6);'><a href="<%=basePath2%>notice/index.html">公告</a>
		</li>
		<li class="m_line"><img
			src="<%=basePath2%>admin/images/line1.gif" /></li>
		<li id="m_7" class='m_li' onmouseover='mover(7);'
			onmouseout='mout(7);'><a href="<%=basePath2%>help/index.html">帮助</a>
		</li>
	</ul>
</div>
<div style="height: 32px; background-color: #F1F1F1;">
	<ul class="smenu">
		<li style="padding-left: 29px;" id="s_1" class='s_li'
			onmouseover='mover(1);' onmouseout='mout(1);'>欢迎光临广东海洋大学体育馆网上系统
			<%
			if (null == request.getSession().getAttribute("uName")) {
		%> <span class="login"><a href="<%=basePath2%>login.html">登录</a>
		</span> <span class="reg"><a href="<%=basePath2%>regist.html">注册</a> </span>
			<%
				} else {
					out.print(request.getSession().getAttribute("uName"));
			%> <a href="<%=basePath2%>login.html?action=logout">退出登录</a> <%
 	}
 %>
		</li>
		<li style="padding-left: 141px;" id="s_2" class='s_li'
			onmouseover='mover(2);' onmouseout='mout(2);'></li>
		<li style="padding-left: 252px;" id="s_3" class='s_li'
			onmouseover='mover(3);' onmouseout='mout(3);'></li>
		<li style="padding-left: 364px;" id="s_4" class='s_li'
			onmouseover='mover(4);' onmouseout='mout(4);'></li>
		<li style="padding-left: 476px;" id="s_5" class='s_li'
			onmouseover='mover(5);' onmouseout='mout(5);'><a
			href="<%=basePath2%>user/index.html?action=alterinfo">修改信息</a> <span
			class="split">|</span> <a
			href="<%=basePath2%>user/index.html?action=resetpwd">修改密码</a> <span
			class="split">|</span> <a
			href="<%=basePath2%>user/index.html?action=mybook">我的预约</a> <span
			class="split">|</span> <a
			href="<%=basePath2%>user/index.html?action=myrent">我的租借</a></li>
		<li style="padding-left: 588px;" id="s_6" class='s_li'
			onmouseover='mover(6);' onmouseout='mout(6);'></li>
		<li style="padding-left: 700px;" id="s_7" class='s_li'
			onmouseover='mover(7);' onmouseout='mout(7);'></li>
	</ul>
</div>

<!--header-->