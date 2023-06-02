<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String keyword = (String)request.getAttribute("keyword");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.page{
		margin: 0;
		padding: 0;
		justify-content: center;
	}
</style>
</head>
<body>
	<div class="wrap">
		<%@ include file="../../views/common/header.jsp"%>	
		
		<br>
		<br>
		<br>
		
		<div align="center" class="container text-center" style="text-align: center;">
			<div align="center" class="page row">
				<div class="col-md-auto" style="color: red; font-size: 26px;">
					'<%= keyword %>'
				</div>
				<div class="col-md-auto my-2" style="margin-left: -10px;">
					에 대한 검색결과가 없습니다.
				</div>
			</div>
		</div>
	</div>
</body>
</html>