<%@page import="com.kh.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
	
	ArrayList<Product> updateList = (ArrayList<Product>) request.getAttribute("updateList"); 	

	String title = (String)request.getAttribute("title");
	
	response.setHeader("cache-control","no-store");
	response.setHeader("expires","0");
	response.setHeader("pragma","no-cache");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Core theme CSS (includes Bootstrap)-->
<link
	href="${pageContext.request.contextPath}/resources/css/main_product_mini.css"
	rel="stylesheet" />

<!-- 이게 있어야지 별이 나온다 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">

<!-- 업버튼 -->


<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<style>
.mini_like {
	cursor: pointer;
	
}

h5 {
	text-overflow: ellipsis;
	overflow: hidden;
	display: -webkit-box;
	-webkit-line-clamp: 3;
	-webkit-box-orient: vertical;
}

.productbox{
	cursor: pointer;
}
</style>
</head>

<body>

	<div class="wrap">

		<%@ include file="../../views/common/header.jsp"%>

		<script>

		</script>


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
		<!-- 드롭다운 -->

		<div class="container text-center">
		  <div class="row">
		    
		    <div class="col">
		      <div align="right" class="container px-4 px-lg-5 mt-5">
				<select style="width: 200px" class="form-select" 
				        id="orderSelect" name= orderSelect
					aria-label="Default select example">
					<option selected disabled><%=title%></option>
					<option value="1">최신순</option>
					<option value="2">판매순</option>
					<option value="3">리뷰순</option>
				</select>
				</div>
		    </div>
		  </div>
		</div>
		
		
		<script>
			$(function(){
				$("#orderSelect").on("change", function(){
					let setNum = $("#orderSelect option:selected").val();
					location.href = '<%=contextPath%>/startPage.p?num=' + setNum;
				})
				
				
			})
		</script>
		<!--  업버튼 -->

		<div id="wrap">
			<a id="back-to-top" style="text-decoration: none;"></a>
		</div>



		
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
						$(function(){
							// 상품 이미지 클릭시 상품 상세 페이지로 이동
							$('.card-img-top').click(function(){
								let memId = "";
								
								<% if (loginUser != null && !loginUser.getMemId().equals("")) {%>
									memId = '<%= loginUser.getMemId()%>';
								<% }%>
								
								location.href = '<%=contextPath%>/pdetail.p?pid=' + $(this).prev().html() + "&memId=" + memId;
							})
							
							
							

						})
					</script>




				</div>
			</div>
		</section>
	</div>
	
	

</body>


</html>