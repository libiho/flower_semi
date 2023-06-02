<%@page import="com.kh.board.model.vo.FAQ"%>
<%@page import="com.kh.board.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	ArrayList<Notice> noticeList = (ArrayList<Notice>)request.getAttribute("noticeList");
	ArrayList<FAQ> faqList = (ArrayList<FAQ>)request.getAttribute("faqList");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Fleuryoung</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css">
</head>

<body style="padding-right: 0px;">

	<div class="wrap">

		<%@ include file = "../common/header.jsp" %>

		<!-- content 시작 -->
		<div class="container">
            
        </div>
		<div class="notice">
			<div class="noticeMenu">
				<div class="noticeTitle">고객센터</div>
				<ul class="tabs-nav">
					<li><a href="#tab1" class="noticeCategory">공지사항</a></li>
					<li><a href="#tab2" class="noticeCategory">자주하는 질문</a></li>
				</ul>
			</div>
			<div class="noticeContent">
				<section class="tabs-panel" id="tab1">
					<div class="noticeContentTitle">
						<div id="ncTitle">
							<h2>공지사항</h2>
						</div>
					</div>
					<div class="ncColumn">
						<div class="colNum">번호</div>
						<div class="colTitle">제목</div>
						<div class="colDate">작성일</div>
					</div>
					<ul class="contentNo">
					
						<!-- db에서 가져옴? -->
						<% for (Notice n : noticeList) { %>
							<li class="row-li"><a href="#">
								<div class="contentRow">
									<div class="rowNo"><%= n.getNoticeId() %></div>
									<div class="rowTitle"><%= n.getNoticeTitle() %></div>
									<div class="rowDate"><%= n.getNoticeRegDate() %></div>
								</div>
							</a></li>
							<li class="hidden-li">
								<div class="hidden-div"><%= n.getNoticeComment() %></div>
							</li>
						<% } %>
						
				</section>

				<section class="tabs-panel" id="tab2" style="display: none;">
					<div class="noticeContentTitle">
						<div id="ncTitle">
							<h2>자주하는 질문</h2>
						</div>
					</div>
					<div class="ncColumn">
						<div class="colNum2">번호</div>
						<div class="colCategory">카테고리</div>
						<div class="colTitle2">제목</div>
					</div>
					<ul class="contentNo">
						<!-- DB에서 가져옴? -->
						<% for (FAQ f : faqList) { %>
							<li class="row-li"><a href="#">
								<div class="contentRow">
									<div class="rowNo"><%= f.getFaqId() %></div>
									<div class="rowCategory"><%= f.getFaqCategory() %></div>
									<div class="rowTitle2"><%= f.getFaqTitle() %></div>
								</div>
							</a></li>
							<li class="hidden-li">
								<div class="hidden-div"><%= f.getFaqComment() %></div>
							</li>
						<% } %>
					</ul>
				</section>

			</div>

			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br>
		</div>

		<script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
</body>

</html>