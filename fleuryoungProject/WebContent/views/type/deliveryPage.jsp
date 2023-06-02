<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="com.kh.product.model.vo.Product"%>
    <%@page import="java.util.ArrayList"%>
    <%

    ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@ include file = "../common/header.jsp" %>   
    
    
    
    
    
    
    
    
    
    
    <!-- 배너 시작 -->
		<div id="carouselExampleAutoplaying" class="carousel slide b"
			data-bs-ride="carousel" style="z-index: 1;">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="${pageContext.request.contextPath}/resources/image/flowerbannwer2.png"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/resources/image/flowerbanner1.webp"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/resources/image/flowerbannwer2.png"
						class="d-block w-100" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
		<!-- 배너 끝 -->
    
    
    
    
    
    
    
  <br><br><br>

 

  <div align="center" class="butes">

    <button class="w-btn w-btn-gra1 w-btn-gra-anim side delivery" type="button" value="전체">
      전체
    </button>
    <button class="w-btn w-btn-gra1 w-btn-gra-anim side delivery" type="button" value="꽃">
      꽃다발
    </button>
    <button class="w-btn w-btn-gra1 w-btn-gra-anim side delivery" type="button" value="화환">
      화환
    </button>
    <!-- 
    <button class="w-btn w-btn-gra1 w-btn-gra-anim side delivery" type="button">
      축하화환
    </button>
     -->
    <button class="w-btn w-btn-gra1 w-btn-gra-anim side delivery" type="button" value="란">
      승진/개업
    </button>
    <button class="w-btn w-btn-gra1 w-btn-gra-anim side delivery" type="button" value="식물">
	식물
    </button>
 <button class="w-btn w-btn-gra1 w-btn-gra-anim side delivery" type="button" value="소품">
      소품
    </button>

  </div>
    
    
    <script >
    
    
    $(function() {
    	  // 카테고리 버튼 클릭 이벤트
    	  $('.delivery').click(function() {
    	    var categoryName = $(this).val().trim(); // 클릭한 버튼의 value를 가져옴

    	    console.log(categoryName);
    	    
    	    $.ajax({
    	      url: '<%=contextPath%>/delivery.de',
    	      type: 'POST',
    	      data: {
    	        categoryName: categoryName
    	      },
    	      success: function(html) {
    	        $('body').html(html); // 받은 HTML 코드로 현재 페이지를 새로 그림
    	      },
    	      error: function() {
    	        alert('에러 발생!');
    	      }
    	    });
    	  });
    	});

    
    
    </script>
    
    
    
    
    
      
  	<!-- Section-->
		<section class="py-5">
			<div class="container px-4 px-lg-5 mt-5">
				<div
					class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-start">

					<%
						for (Product p : list) {
					%>
					<!-- 상품시작 -->
					<!-- 일반 배송 + 할인 없는 제품 -->
					<div class="productbox col mb-5">
						<div class="card h-100">
							<% if (p.getpDayDelivery().charAt(0) == 'Y') { %>
								<div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; left: 0.5rem">당일배송
            					</div>
							<%} %>
							<!-- Product image-->
							<input class="hPid" type="hidden" name="pid" value="<%=p.getpId()%>">
							<h1 class="pid" hidden><%= p.getpId() %></h1>

							<img class="card-img-top"
								src="${pageContext.request.contextPath}<%=p.getMainImg() %>"
								alt="..." />
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 style="font-size: 15px" class="fw-bolder">
										<%=p.getpName()%>
									</h5>
									<div
										class="d-flex justify-content-center small text-warning mb-2">

										<%
											for (int i = 0; i < p.getReviewRating(); i++) {
										%>
										<div class="bi-star-fill"></div>
										<%
											}
										%>
										<span>&nbsp;(<%=p.getReviewCount()%>)
										</span>
									</div>
									<!-- Product price-->
									<!-- <span>58,000원</span> -->
									<span> <%=p.getpNetPrice()%>원
									</span>
								</div>
							</div>
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<!-- 찜하기, 장바구니 아이콘 -->
								<div class="container text-center">
									<div class="row">
										<div class="col">

											<!-- 클릭될때 찜하기 목록 추가(db에 담겨야함) + 아이콘 변화 -->
											<img class="mini_like" id="mini-like"
												src="${pageContext.request.contextPath}/resources/image/icon/like.png"
												alt="">

										</div>
										<!--
										 -->
									</div>
								</div>

							</div>
						</div>
					</div>
					<!-- 상품끝 -->
					<%
						}
					%>
  	
						<script>
							$(function () {
								// 상품 이미지 클릭시 상품 상세 페이지로 이동
								$('.card-img-top').click(function () {
									location.href = '<%=contextPath%>/pdetail.p?pid=' + $(this).prev().html();
								})
							})
						</script>
						
						
						
						
						</div>
						</div>
						</section>
						</div>

    
    
    
    
    
    
    
	<!-- 업버튼튼 -->
	<div id="upBtn" class="up-btn">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-up-circle"
			viewBox="0 0 16 16">
			<path fill-rule="evenodd"
				d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-7.5 3.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z" />
		</svg>
	</div>

    
    
    
    
    
    
    
    
    
    
    
    
    
    
</body>
</html>