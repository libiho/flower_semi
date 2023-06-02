<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String alertMsg = (String)request.getAttribute("alertMsg");	
	// 서비스 요청 전 menubar.jsp 로딩시 : null
	// 서비스 성공 후 menubar.jsp 로싱시 : alert로 띄어줄 메세지 문구
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css">
</head>

<body>

	<%@ include file="../common/header.jsp"%>
	
		<% if (alertMsg != null) { %>
	<script> 
		$(function (){
			$('.inputId').focus();
		});
	</script>
	<% session.removeAttribute("alertMsg"); %>
	<% } %>

	<div class="section pb-5 pt-5 pt-sm-2 text-center">
		<h6 class="mb-0 pb-3" style="margin-left:50px">
			<span style="text-align: center; color: rgb(77, 76, 85); font-size: 40px; margin-right: 50px;"> 로그인 </span> 
		</h6>
		<input class="checkbox" type="checkbox" id="reg-log" name="reg-log" />
		
		<!-- <label for="reg-log" ></label> -->
		<div class="card-3d-wrap mx-auto">
			<div class="card-3d-wrapper">
				<div class="card-front">
					<div class="center-wrap">
						<div class="section text-center">
						<!-- -------------------------------------- -->
							<form action="/fleuryoungProject/login.me" method="post" name="logInScreen">
								<h4 class="mb-4 pb-3" id="loginLetter">회원로그인</h4>
								<div class="form-group">
									<input type="text" name="userId" class="form-style inputId"
										placeholder="아이디를 입력하세요" id="logemail" autocomplete="off">
									<i class="input-icon uil uil-at"></i>
								</div>
								<div class="form-group mt-2">
									<input type="password" name="userPwd" class="form-style"
										placeholder="비밀번호를 입력하세요" id="logpass" autocomplete="off">
									<i class="input-icon uil uil-lock-alt"></i>
								</div>
								<!-- <a href="#" class="btn mt-4">로그인</a> <br> -->
								<button type="submit" id="logInButton" class="btn mt-4" onClick="return logIn()">로그인</button>
								<br>

							</form>
							<script>
	          function logIn() { 
	          var frm = document.logInScreen;
	
	          if (frm.userId.value.length < 1) {
	            alert("아이디를 입력해주세요");
	            return false;
	          }
	          if (frm.userPwd.value.length < 1) {
	            alert("비밀번호를 입력해주세요");
	            return false;
	          }
	          
	        }
        </script>
							<p class="mb-0 mt-4 text-center">
								<a href="<%= contextPath %>/findIdPage.me" class="link" style="text-decoration: none;">아이디찾기 | 비밀번호찾기</a>
							</p>
							
						</div>
					</div>
				</div>
				
				
			</div>
		</div>
	</div>
	
	
	
</body>

</html>