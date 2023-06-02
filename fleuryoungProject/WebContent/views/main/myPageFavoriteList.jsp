<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
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
		        		<li style="font-weight: bold; font-size: 30px; margin-bottom: 20px;">찜한 상품</li> <br>
		        		<% for (Product p : list) {%>
		        		<li>
			        		<div class="row" style="border: 1px solid lightgray; padding: 10px; box-sizing: border-box; width: 95%;">
			        			<div class="col-sm" style="width: 20%;" >
                                    <a href="#" style="font-size: 20px;">
                                        <img class="pId" src="${pageContext.request.contextPath}<%= p.getMainImg() %>" width="120px" height="120px">
                                        <h1 hidden><%= p.getpId()%></h1>
                                    </a>
                                </div>
                                
                                	<div class="orderInfo" style="width:80%;">
                                    <p>상품명 : <%= p.getpName() %></p>
                                    <p>할인율 : <%= p.getDiscountRate() %>%</p>
                                    <p style="text-decoration-line: line-through; color: lightgray;"><%= p.getpNetPrice() %>원</p>
                                    <p>가격 : <%= p.getTotal() %>원</p>
                                </div>
                                
                               
			        		</div>
		        		</li>
		        		<% } %>
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
            
            $(".pId").each(function(){
            	$(this).click(function(){
					location.href = '<%=contextPath%>/pdetail.p?pid=' + $(this).next().html();
            	})
            })
        });
    </script>
</body>
</html>