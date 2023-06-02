<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String alertMsg = (String)session.getAttribute("alertMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/myPage2.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<% if(alertMsg != null){%>
        <script type="text/javascript">
            alert("<%=alertMsg%>");
        </script>
    <%} %>
    <% session.setAttribute("alertMsg", null); //removeAttribute("alertMsg") %>
	<div class="wrap">
		<%@ include file = "../common/header.jsp" %>
		
		<br><br>
        
        <br><br>
        <div id="content-body">
	        <div class="sidebar">
	            <div class="hero__categories">
	                <div class="hero__categories__all">
	                    <i class="fa fa-bars"></i>
	                    <span>My Menu</span>
	                </div>
	                <ul style="height: 800px;">
	                    <li><a href="<%= contextPath %>/myPageInfo.my">회원정보관리</a></li> <br>
	                    <li><a href="<%= contextPath %>/myPageOrderList.my">주문내역</a></li> <br>
	                    
	                    <li>관심리스트<br>
	                            <li><a href="<%= contextPath %>/myPageFavoriteList.my">찜한 상품</a></li>
	                    </li>
	                    <li>후기<br>
	                            <li><a href="<%= contextPath %>/myPageReviewWrite.my">내가 쓴 리뷰 보기</a></li>
	                            <li><a href="<%= contextPath %>/myPageReviewChange.my">내가 쓴 리뷰 수정</a></li> <br>
	                    </li>
	                </ul>
	            </div>
	        </div>
            
            <div class="content"> 
                <div id="form">
                    <div class="userForm" align="center" style="height: 846px; width: 600px;">
                        <h5>회원정보 관리</h5> <br>
                        
                        <form id="mypage-form" action="<%= contextPath %>/myPageInfoUpdate.my" method="post">

                            <%-- <img src="<%= loginUser.getMemImg() %>" style="width: 150px; height: 150px;"> <br><br> --%>
                            
                            <table>
                                <tr>
                                    <td>아이디</td>
                                    <td><input type="text" name="userId" maxlength="12" style="width: 350px" value = "<%= loginUser.getMemId() %>" readonly></td>
                                </tr>
                                <tr>
                                    <td>이메일</td>
                                    <td><input type="email" name="email" style="width: 350px" value = "<%= loginUser.getEmail() %>"></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>전화번호</td>
                                    <td><input type="text" name="phone" placeholder="- 포함해서 입력"  style="width: 350px" value = "<%= loginUser.getPhone() %>"></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>이름</td>
                                    <td><input type="text" name="userName" maxlength="6" style="width: 350px" value = "<%= loginUser.getMemName() %>" required></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>주소</td>
                                    <td><input type="text" name="street" style="width: 350px" value = "<%= loginUser.getStreet() %>"></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>상세주소</td>
                                    <td><input type="text" name="address" style="width: 350px" value = "<%= loginUser.getAddress() %>"></td>
                                    <td></td>
                                </tr>
                                
                                
                            </table>
                            
            
                           <br><br>
            
                           <div align="center">
                                <button type="submit" class="btn btn-sm btn-secondary">정보변경</button>
                                <button type="button" class="btn btn-sm btn-warning" data-toggle="modal" data-target="#updatePwdModal">비밀번호 변경</button>
                                <button type="button" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#deleteModal">회원탈퇴</button>
                            </div>
                            </form>
                     </div>
                </div>
            </div>


        </div>
	</div>
	
	<!-- 비밀번호 변경용 Modal -->
<div class="modal" id="updatePwdModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">비밀번호 변경</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" align="center">
		<form action="<%= contextPath %>/myPagePwdUpdate.my" method="post">
		<input type="hidden" name="userId" value="<%= loginUser.getMemId() %>">
 			<table>
                <tr>
                    <td>현재 비밀번호</td>
                    <td><input type="password" name="userPwd" required></td>
                </tr>
                <tr>
                    <td>변경할 비밀번호</td>
                    <td><input type="password" name="updatePwd" id="pwdInput" required></td>
                </tr>
                <tr>
                    <td>변경할 비밀번호 확인</td>
                    <td><input type="password" name="checkPwd" id="pwdInputCheck" required></td>
                </tr>
            </table>
            
            <br>

            <button type="submit" class="btn btn-sm btn-secondary" onclick="return userEnroll();">비밀번호 변경</button>
        </form>
      </div>

      <script>
	      function userEnroll() {
	          const pwdInput = document.getElementById("pwdInput"); //pwdInput -> 비밀번호 
	          const pwdInputCheck = document.querySelector("#pwdInputCheck"); //pwdInputCheck -> 비밀번호 확인
	          
	          // 비밀번호 : 영문 소문자/대문자,숫자 각각 한개 이상 포함하는 6~15자 길이
	          let regExp1 = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,15}$/;
	    
	          if (!regExp1.test(pwdInput.value)) {
	             alert('유효하지 않은 비밀번호를 입력하셨습니다');
	             pwdInput.value = "";
	             pwdInput.focus();
	             return false;
	          }
	    
	          // 비밀번호 확인
	          if (pwdInput.value != pwdInputCheck.value) {
	             alert("비밀번호 확인이 일치하지 않습니다.");
	             pwdInputCheck.value = "";
	             pwdInputCheck.focus();
	             return false;
	    
	          }
	       }
      </script>

    </div>
  </div>
</div>

  <!-- 회원탈퇴용 Modal -->
<div class="modal" id="deleteModal">
    <div class="modal-dialog">
      <div class="modal-content">
  
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">회원탈퇴</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
  
        <!-- Modal body -->
        <div class="modal-body" align="center">
          <form action="<%= contextPath %>/myPageDelete.my" method="post">
          <input type="hidden" name="userId" value="<%= loginUser.getMemId() %>">
            <b>탈퇴 후 복구가 불가능 합니다.<br> 정말로 탈퇴하시겠습니까?</b> <br><br> 
          
            비밀번호: <input type="password" name="userPwd" required> <br><br>
            <button type="submit" class="btn btn-sm btn-danger">탈퇴하기</button>
         </form>
        </div>
  
        
  
      
    </div>
</div>
</div>
	
	<script>
        $(function(){
            $('.subMenu').hide();
            $('.hero__categories>ul>li').mouseenter(function(){
                $(this).find('.subMenu').slideDown();
            }).mouseleave(function(){
                $('.subMenu').stop().slideUp();
            });
            
            let items = document.querySelectorAll('.carousel .carousel-item')

            items.forEach((el) => {
                const minPerSlide = 4
                let next = el.nextElementSibling
                for (var i=1; i<minPerSlide; i++) {
                    if (!next) {
                        // wrap carousel by using first child
                    	next = items[0]
                  	}
                    let cloneChild = next.cloneNode(true)
                    el.appendChild(cloneChild.children[0])
                    next = next.nextElementSibling
                }
            })
            
        });
        
        function validatePwd(){
            if($("input[name=updatePwd]").val() != $("input[name=checkPwd]").val()){
                alert("변경할 비밀번호가 일치하지 않습니다.");

                return false;
            };
        };
    </script>   

</body>
</html>