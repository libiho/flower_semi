<%@page import="com.kh.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("cache-control","no-store");
	response.setHeader("expires","0");
	response.setHeader("pragma","no-cache");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Fleuryoung</title>
<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/scripts.js"></script>
<body style="padding-right: 0px;">
	<script>
		$(function() {
			location.href = '/fleuryoungProject/startPage.p?num=1';
		})
	</script>

</body>

</html>