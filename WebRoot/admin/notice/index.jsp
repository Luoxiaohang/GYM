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
<title>公告发布 - 广东海洋大学体育馆网上系统</title>
<link href="../css/nav.css" rel="stylesheet" type="text/css" />
<script src="../js/nav.js" type="text/javascript"></script>
<script src="../js/focus.js" type="text/javascript"></script>
<script src="../plugin/kindeditor-4.1.4/kindeditor-min.js"></script>
<script src="../plugin/kindeditor-4.1.4/lang/zh_CN.js"></script>
<script src="../plugin/kindeditor-4.1.4/plugins/code/prettify.js"></script>
<link rel="stylesheet" href="../../plugin/kindeditor-4.1.4/themes/default/default.css" />
<link rel="stylesheet" href="../../plugin/kindeditor-4.1.4/plugins/code/prettify.css" />
<link href="../css/common.css" rel="stylesheet" type="text/css" />
<link href="../css/notice.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ include file="../include/header.jsp"%>
<div id="main">
  <div id="row_1">
    <div id="notice-editor">
      <form action="index.html" method="post">
        <table width="960px" cellspacing="10px">
          <tr>
            <td width="130px" align="right">标题</td>
            <td><input name="title" type="text" class="notice-release-title" /></td>
          </tr>
          <tr>
            <td align="right">正文</td>
            <td><textarea name="content" class="notice-release-content"></textarea></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><input name="action" type="hidden" value="add" />
              <input name="submit" type="submit" id="submit" value="提交"  /></td>
          </tr>
        </table>
      </form>
    </div>
  </div>
</div>
<script>
	var def = "6";
</script>
<%@ include file="../include/footer.jsp"%>
<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea', {
				cssPath : '../plugin/kindeditor-4.1.4/plugins/code/prettify.css',
				uploadJson : '../plugin/kindeditor-4.1.4/jsp/upload_json.jsp',
				fileManagerJson : '../plugin/kindeditor-4.1.4/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</body>
</html>
