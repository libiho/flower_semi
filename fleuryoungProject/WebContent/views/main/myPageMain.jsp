<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int c = (int)request.getAttribute("c");
%>    

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
<title>Insert title here</title>
</head>
<body>
	
	<div class="wrap">
		<%@ include file = "../common/header.jsp" %>    
		
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
        
	        <div style="padding-left: 15px; float: left;">
		        <div class="hero__categories">
		        	<ul style="width: 800px; height: 846px;">
		        		<li style="font-weight: bold; font-size: 30px; margin-bottom: 20px;">내 정보</li>
		        		<li>
			        		<div class="row">
			        			<div class="col-sm" style="text-align: center;"><a href="#" style="font-size: 30px;">마일리지 <font style="color: rgb(248, 178, 188); font-size: ;"><%= loginUser.getMileage() %></font></a></div>
			        			<input type="hidden" name="userId" value="<%= loginUser.getMemId() %>">
			        			<div class="col-sm" style="text-align: center;"><a href="#" style="font-size: 30px;">쿠폰<font style="color: rgb(248, 178, 188);"> <%= c %>장</font></a></div>
			        		</div>
		        		</li>
		        	</ul>
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
	       

    </script>
</body>
</html>