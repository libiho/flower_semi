<%@page import="com.kh.product.model.vo.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.kh.product.model.vo.Product"%>
    <%@page import="java.util.ArrayList"%>
   <%
    String categoryName = (String)request.getAttribute("categoryName");
	String title = (String)request.getAttribute("title");
    ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
    int orderNum = (int)request.getAttribute("orderSelect");
    int value = (int)request.getAttribute("value");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




    <%@ include file = "../common/header.jsp" %>   
    
    
    
    
    <br><br><br>
        <button class="w-btn w-btn-gra1 w-btn-gra-anim side minibtn" type="button" align="center">
	<%=categoryName %>
    </button>
       <br><br><br>
    
	<div class="container text-center">
		<div class="row">
			<div class="col">
				<div align="right" class="container px-4 px-lg-5 mt-5">
					<form action="<%=contextPath%>/typePage.mi" method="get">
						<input type="hidden" id="valueInput" name="value"  value="<%= Integer.toString(value) %>">
						<input type="hidden" id="categoryInput" name="categoryName" value="<%= categoryName %>">
						<input type="hidden" id="orderSelectInput" name="orderSelect" value="1">
						<select style="width: 200px" class="form-select" id="orderSelect"
							name="orderSelect" aria-label="Default select example">
							<option selected disabled value="<%=orderNum%>"><%=title %></option>
							<option value="1">최신순</option>
							<option value="2">판매순</option>
							<option value="3">리뷰순</option>
						</select>
						<button type="submit" style="display: none"></button>
					</form>
				</div>
			</div>
		</div>
	</div>

    
    <script>
    $(document).ready(function() {
    	
    
    	  
    	  // select 변경 시 hidden input의 값을 해당 select의 value로 변경하고 form을 submit
    	  $("#orderSelect").change(function () {
    	    var value = $("#valueInput").val();
			var categoryName = $("#categoryInput").val();
    	    var orderSelect = $(this).val();
    	    
    	    updateHiddenInputs(value, orderSelect, categoryName);
    	    $("form").submit();
    	  });
    	});

    	function updateHiddenInputs(value, orderSelect, categoryName) {
    	  $("#valueInput").val(value);
    	  $("#orderSelectInput").val(orderSelect);
    	   $("#categoryInput").val(categoryName);
    
    	}

    
    
  
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
						$(function(){
							// 상품 이미지 클릭시 상품 상세 페이지로 이동
							$('.card-img-top').click(function(){
								location.href = '<%=contextPath%>/pdetail.p?pid=' + $(this).prev().html();
							})
						})
					</script>




				</div>
			</div>
		</section>
	</div>


 <!-- 업버튼 -->
<div id="upBtn" class="up-btn">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-up-circle"
	viewBox="0 0 16 16">
	<path fill-rule="evenodd"
		d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-7.5 3.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z" />
</svg>
</div>







<script>

const upBtn = document.getElementById("upBtn");

window.addEventListener("scroll", () => {
    if (window.pageYOffset > 300) {
        upBtn.classList.add("show");
    } else {
        upBtn.classList.remove("show");
    }
});

upBtn.addEventListener("click", () => {
    window.scrollTo(0, 0);
});



</script>


</body>
</html>