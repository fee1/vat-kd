<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='/public/include/header.jsp'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>平台错误信息</title>
</head>
<body>
	<div class="easyui-panel" title="报错信息" style="width: auto;"
			align="justify">
			<form id="ff" method="post" action="<c:url value='/exception/downLoad'/>">
				<center><h2 style="color: red;">您访问的页面不存在或已删除！</h2></center>
			</form>
		</div>
	
</body>
<script type="text/javascript">
	function downLoad(){
		$('#ff').submit();
	}
</script>
</html>