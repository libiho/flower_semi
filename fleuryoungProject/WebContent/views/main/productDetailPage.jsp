<%@page import="com.kh.product.model.vo.Inquiry"%>
<%@page import="oracle.net.aso.r"%>
<%@page import="com.kh.product.model.vo.Review"%>
<%@page import="com.kh.product.model.vo.ProductOption"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Product p = (Product) request.getAttribute("product");

	ArrayList<ProductOption> optList = (ArrayList<ProductOption>) request.getAttribute("optList");
	ArrayList<Review> reviewList = (ArrayList<Review>) request.getAttribute("reviewList");
	int check = (int)request.getAttribute("check");
	int reviewCount = (int)request.getAttribute("reviewCount");
	ArrayList<Inquiry> inquiryList = (ArrayList<Inquiry>) request.getAttribute("inquiryList");
	
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">

<!-- 스피너 -->
<link
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.css"
	rel="stylesheet">


<style>
.yellow-color {
	color: rgb(238, 238, 6);
}

.add-option {
	margin-top: 5px;
}

.minus, .plus {
	margin-bottom: 4px;
	line-height: 20px;
}

.inp {
	width: 50px;
	height: 35px;
}
</style>

</head>
<body>
	<div class="wrap">
		<%@ include file="../common/header.jsp"%>

		<div class="pd-wrap mx-auto" style="width: 1050px;">
			<div class="mt-5 container text-center">
				<div class="d-flex flex-row mb-3">
					<div class="row" style="margin-left: -30px;">
						<!-- <div class="px-2 col" style="width: 150px;">카테고리1</div>
                    <div class="col-md-auto" style="padding: 0;">></div>
                    <div class="px-2 col" style="width: 100px;">카테고리2</div>
                    <div class="col-md-auto" style="padding: 0;">></div>
                    <div class="px-2 col" style="width: 100px;">꽃다발</div> -->
					</div>
				</div>
				<div class="row">

					<%
						String[] mimgs = p.getImages().split(",");
					%>
					<!-- 사진 -->
					<div class="col-6">
						<div class=" row">
							<img class="pd-main rounded shadow p-1 mb-3 bg-body-tertiary"
								src="${pageContext.request.contextPath}<%=mimgs[0] %>"
								style="height: 500px;">
						</div>
						<div class="d-flex justify-content-start">
							<div class="text-center"
								style="margin-left: -12px; margin-top: 5px;">
								<img class="col pd-btn shadow-sm p-1 rounded"
									src="${pageContext.request.contextPath}<%= mimgs[0] %>"
									style="width: 70px; height: 70px;"> <img
									class="col pd-btn shadow-sm p-1 rounded"
									src="${pageContext.request.contextPath}<%= mimgs[1] %>"
									style="width: 70px; height: 70px;"> <img
									class="col pd-btn shadow-sm p-1 rounded"
									src="${pageContext.request.contextPath}<%= mimgs[2] %>"
									style="width: 70px; height: 70px;"> <img
									class="col pd-btn shadow-sm p-1 rounded"
									src="${pageContext.request.contextPath}<%= mimgs[3] %>"
									style="width: 70px; height: 70px;"> <img
									class="col pd-btn shadow-sm p-1 rounded"
									src="${pageContext.request.contextPath}<%= mimgs[4] %>"
									style="width: 70px; height: 70px;">
							</div>
						</div>
					</div>
					<div style="width: 10px; margin-left: 20px;"></div>
					<!-- 상품 정보 -->
					<div class="col-5 pd-info">
						<p class="row" style="font-size: 13px; margin-bottom: -1px;"><%=p.getStoreName()%></p>
						<div class="row" style="font-size: 17px; font-weight: bolder;"><%=p.getpName()%></div>
						<div class="row">
							<%
								int count = 5;
							%>
							<%
								for (int i = 0; i < p.getReviewRating(); i++) {
							%>
							<img
								src="${pageContext.request.contextPath}/resources/image/icon/star.png"
								style="margin-top: 5px; padding: 0; width: 15px; height: 15px;">
							<%
								count--;
							%>
							<%
								}
							%>
							<%
								for (int j = 0; j < count; j++) {
							%>
							<img
								src="${pageContext.request.contextPath}/resources/image/icon/empty-star.png"
								style="margin-top: 5px; padding: 0; width: 15px; height: 15px;">
							<%
								}
							%>
							(<%=p.getReviewCount()%>)
						</div>
						<div class="d-flex flex-column">
							<div class="mt-2 row" style="margin-bottom: -10px;">
								<!-- <div class="col-1" style="padding: 0; margin-left: -1px; font-weight: bold;">10%</div>
                            	<div class="col-1" style="text-decoration: line-through;">30,000</div> -->
								<div class="col-8"></div>
							</div>
							<div class="row fs-3" style="font-weight: bolder;"><%=p.getpNetPrice()%>원
							</div>
						</div>
						<div class="row" style="margin-top: 5px;">
							<%
								if (p.getpDayDelivery().charAt(0) == 'Y') {
							%>
							<div class="col-5"
								style="margin-left: -18px; font-size: 12px; font-weight: bolder;">50,000원 이상시 무료배송
							</div>
							
							<div class="row"
								style="margin-left: -10px; font-size: 13px; font-weight: bolder; color: rgb(248, 178, 188);">당일배송
							</div>
							<%
								} else {
							%>
							<div class="col"
								style="margin-left: -100px; font-size: 13px; font-weight: bolder;">50,000원 이상시 무료배송</div>
							<%
								}
							%>
							<div class="col-5"></div>
						</div>
						<div class="mt-4 row">
							<hr>
						</div>

						<!-- 옵션 -->
						<%
							if (!optList.isEmpty()) {
						%>
						<%
							String title = optList.get(0).getOptTitle();
						%>
						<div class="mt-4 row">
							<select
								class="option-select form-select form-select-sm --bs-danger-bg-subtle"
								aria-label=".form-select-sm example" id="selectBox"
								name="selectBox">
								<option selected><%=title%></option>
								<%
									for (ProductOption opt : optList) {
								%>
								<option value="<%=opt.getOpt2ndNo()%>"><%=opt.getOptContent()%>
									+<%=opt.getOptPrice()%>원
								</option>
								<%
									}
								%>
							</select>
						</div>
						<%
							}
						%>
						<br>
						<div class="connect"></div>

						<!-- 옵션 추가시 나올 div -->
						<div class="add-option container text-center"
							style="background-color: #f5f5f5; width: 437px; margin-left: -12px; display: none">
							<div class="row">
								<div style="font-weight: bolder;" align="left" class="py-2 col">
									옐로우</div>
								<div align="right" class="col">
									<img class="option-delete"
										src="${pageContext.request.contextPath}/resources/image/close.png"
										style="cursor: pointer; width: 15px; height: 15px">
								</div>
							</div>
							<div class="row">

								<div align="left" class="col">
									<div class="count-wrap _count">
										<button type="button" class="minus btn btn btn-light">
											<img
												src="${pageContext.request.contextPath}/resources/image/icon/minus.png">
										</button>
										<input type="text" id="inp" class="inp" value="1" />
										<button type="button" class="plus btn btn btn-light">
											<img
												src="${pageContext.request.contextPath}/resources/image/icon/plus.png">
										</button>
									</div>
								</div>

								<div class="col">
									<div align="right" class="py-2 col">+ 5000</div>

								</div>
							</div>
						</div>

						<script>
						let opArr = [];
						let price = Number(onlyNo("<%= p.getpNetPrice()%>"));
						let count = 1;
						//천단위 콤마 펑션
					   	function comma(str) {
					        return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
					    }
						
					   	function onlyNo(str) {
					   		return str.replace(/[^0-9]/g, '');
					   	}			   	
					   	
					   	function onlyStr(str){
					   		return str.replace(/[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g, '');
					   	}
					   	
						$(function() {
							// 감소
							$(document).on("click", ".minus", function(){
								if (Number($(this).next().val()) > 1){
									let tmp = $(this).next().val(Number($(this).siblings('.inp').val()) - 1);
									let optget = $(this).parents(".add-option").find(".hideOptPrice").html();
									let optNum = $(this).parents(".add-option").find(".optPrice");
									
									// 숫자만
									console.log("이거 : " + onlyStr(optget));
									console.log("여기" + typeof(onlyNo(optget)));
									
									console.log("optList : " + '<%=optList%>');
									// 결과
									<%if (!optList.isEmpty()) {%>
										optNum.html(comma((Number(onlyNo(optNum.html())) - (Number(optget) + price))+"") + "원");
									<% } else { %>
										optNum.html(comma((Number(onlyNo(optNum.html())) - Number(optget))+"") + "원");
									<% } %>
									
									count = tmp.val();
									console.log("수량: " + count);
								}
							});
							
							// 증가
							$(document).on("click", ".plus", function(){
								let tmp = $(this).prev().val(Number($(this).siblings('.inp').val()) + 1);
								let optget = $(this).parents(".add-option").find(".hideOptPrice").html();
								let optNum = $(this).parents(".add-option").find(".optPrice"); 
						        
								// 결과
								<%if (!optList.isEmpty()) {%>
									optNum.html(comma(((Number(optget) + price) * Number(tmp.val()))+"") + "원");
								<% } else { %>
									optNum.html(comma((Number(optget) * Number(tmp.val()))+"") + "원");
								<% } %>
								
								count = tmp.val();
								console.log("수량: "+ count);
							});
							
							// 수량 변경 감지, 총 주문금액
							$(document).on("click", ".minus, .plus, .option-select", function(){
								let sum = 0;
								$(".optPrice").each(function(){
									sum += Number(onlyNo($(this).html()));
								})
								
								$(".opt-total").html(comma(sum+"")+"원");
								console.log(opArr);
							})
							
							// 삭제
							Array.prototype.remove = function(value) {
							    this.splice(this.indexOf(value), 1);
							}
							
							$(document).on("click", ".option-delete", function(){
								let optNum = Number(onlyNo($(this).parents(".add-option").find(".optPrice").html()));
								let total = Number(onlyNo($(".opt-total").html()));
								
								$(".opt-total").html(comma((total-optNum)+"")+"원");
								
								let optTitle = $(this).parents(".add-option").find(".opt-title").html();
								
								opArr.remove(optTitle);
								console.log(opArr);
								
								$(this).parents(".add-option").remove();
							})
							
						})
						
						
						$(document).ready(function(){
														
							<%if (!optList.isEmpty()) {%>
								$("#selectBox").on('change', function(){
									
									let optTitle = $("#selectBox option:selected").html();
									let tmp = $("#selectBox option:selected").html();
										tmp = tmp.split("+");
									
									if (!opArr.includes(tmp[0])){
										
										// 한글만 추출
										let kor = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
										let onlyTitle = tmp[0].replace(kor, '');
										
										// 숫자만 추출
										let n = /[^0-9]/g;
										let onlyNum = tmp[1].replace(n, '');
										
										if(optTitle != '<%=optList.get(0).getOptTitle()%>'){
												
												opArr.push(tmp[0]);	
												
												console.log($(this).val());
												$('.connect').append("<div class=\"add-option container text-center\" style=\"background-color: #f5f5f5; width: 437px; margin-left: -12px; \"><div class=\"row\"><div style=\"font-weight: bolder;\" align=\"left\" class=\"opt-title py-2 col\">"+ tmp[0] +"</div><div align=\"right\" class=\"col\" ><img class=\"option-delete\" src=\"${pageContext.request.contextPath}/resources/image/close.png\" style=\"cursor: pointer; width: 15px; height: 15px\"></div></div><div class=\"row\"><div align=\"left\" class=\"col\"><div class=\"count-wrap _count\"><button type=\"button\" class=\"minus btn btn btn-light\"><img src=\"${pageContext.request.contextPath}/resources/image/icon/minus.png\"></button><input type=\"text\" id=\"inp\" class=\"inp\" value=\"1\" readonly /><button type=\"button\" class=\"plus btn btn btn-light\"><img src=\"${pageContext.request.contextPath}/resources/image/icon/plus.png\"></button></div></div><div class=\"col\"><div align=\"right\" class=\"optPrice py-2 col\">" + comma((Number(onlyNum) + price) + "") + "원" + "</div><h1 class=\"hideOptPrice\" style=\"display: none\";>"+ onlyNum +"</h1></div><h1 class=\"hideOptNo\" style=\"display: none\";>"+ $(this).val() +"</h1><h1 class=\"hideOptTitle\" style=\"display: none\";>"+ $.trim(tmp[0]) +"</h1></div></div></div>");
												
												$('#selectBox').val('<%=optList.get(0).getOptTitle()%>').trigger('change');
											}	
										
										} else {
											alert('이미 추가한 옵션입니다.');
										}
									})
								<%} else {%>
								
									let optNonePrice = $.trim('<%=p.getpNetPrice()%>') + "원";
									let onlyNum = onlyNo(optNonePrice);
									
									$('.connect').append("<div class=\"add-option container text-center\" style=\"background-color: #f5f5f5; width: 437px; margin-left: -12px; \"><div class=\"row\"><div style=\"font-weight: bolder;\" align=\"left\" class=\"py-2 col\">기본</div><div class=\"row\"><div align=\"left\" class=\"col\"><div class=\"count-wrap _count\"><button type=\"button\" class=\"minus btn btn btn-light\"><img src=\"${pageContext.request.contextPath}/resources/image/icon/minus.png\"></button><input type=\"text\" id=\"inp\" class=\"inp\" value=\"1\" readonly/><button type=\"button\" class=\"plus btn btn btn-light\"><img src=\"${pageContext.request.contextPath}/resources/image/icon/plus.png\"></button></div></div><div class=\"col\"><div align=\"right\" class=\"optPrice py-2 col\">" + optNonePrice + "</div><h1 class=\"hideOptPrice\" style=\"display: none\";>"+ onlyNum +"</h1></div></div></div>");
								<%}%>

							});
						</script>

						<div class="mt-5 row">
							<div class="col"
								style="margin-left: -60px; padding-top: 10px; font-weight: bolder; font-size: 14px;">총
								주문금액</div>
							<div class="col-4"></div>
							<%
								if (optList.isEmpty()) {
							%>
							<div class="opt-total col"
								style="margin-right: -30px; font-weight: bolder; font-size: 25px;"><%=p.getpNetPrice()%>원
							</div>
							<%
								} else {
							%>
							<div class="opt-total col"
								style="margin-right: -50px; font-weight: bolder; font-size: 25px;">
								0원
							</div>
							<%
								}
							%>
						</div>

						<div class="mt-3 row">
							<button class="add-cart rounded py-3" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal"
								style="font-weight: bolder; color: rgb(248, 178, 188); background-color: white; border: 1px solid rgb(248, 178, 188);">장바구니
							</button>
							<!-- 장바구니 알림 모달 -->
							<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
							  <div class="modal-dialog">
							  <!-- 옵션 있을때 -->
							    <div class="cart-modal modal-content" style="display: none">
							      <div class="modal-header">
							        <h1 class="modal-title fs-5" id="exampleModalLabel">장바구니에 상품이 담겼습니다</h1>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-body">
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
							        <button type="button" class="go-to-cart btn btn-primary">장바구니 이동</button>
							      </div>
							    </div>
							    
							    <!-- 옵션 있을때 -->
							    <div class="cart-modal-none modal-content" style="display: none">
							      <div class="modal-header">
							        <h1 class="modal-title fs-5" id="exampleModalLabel">옵션을 선택해주세요</h1>
							        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
							      </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">확인</button>
							      </div>
							    </div>
							    
							  </div>
							</div>
							

						</div>
					</div>
				</div>
			</div>
			
			<script>
				$(document).ready(function(){
					console.log(opArr);
					$(".add-cart").click(function(){
						
						let selNo = '<%=p.getSelNo() %>';
						let pId = '<%=p.getpId()%>';
						let memId = "";
						let optFirstNo = 0;
						let cartList = [];
						
						<% if(loginUser != null) {%>
							memId = '<%=loginUser.getMemId()%>';
						<% }%>
						
						<% if( !optList.isEmpty()) { %>  // 옵션 있을때
							optFirstNo = "<%=optList.get(0).getOpt1ndNo()%>"
								
								if (opArr != ""){ // 장바구니에 옵션이 있을때

									$(".add-option").each(function(index){
										let optNo = $(this).find(".hideOptNo").html();
										let optCount = $(this).find(".inp").val();
										let optTitle = $(this).find(".hideOptTitle").html();
										let optPrice = Number($(this).find(".hideOptPrice").html());
										if (optNo != null){
											cartList[index] = {opt2ndNo:optNo, optCount:optCount, optTitle:optTitle, optPrice:optPrice};	
										}
									})
									
									// 판매자No, 상품ID, 옵션명, 옵션수량,  옵션가격, 
									//location.href = '/fleuryoungProject/startPage.p?num=1';
									$(".cart-modal").show();
									$(".cart-modal-none").hide();
								} else {
									$(".cart-modal").hide();
									$(".cart-modal-none").show();
								}
						<% } else { %> // 옵션 없을때
								$(".cart-modal").show();
								$(".cart-modal-none").hide();
						<% }%>
						
						
						console.log("요기다 : " + count);
						let jsonData = JSON.stringify(cartList);
						
						// 장바구니 추가 
		                $.ajax({
		                    // 요청보내기
		                    url : "addCart.p", // 어느 url로 보낼 건지
		                    type : "post", // 요청방식 지정
		                    traditional :true,	
		                    //dataType : "json",
		                    data : {jsonData:jsonData, selNo:selNo, pId:pId, opt1stNo:optFirstNo, memId:memId, count:count}, 
		                    success : function(result) { // 성공시 응답 데이터가 자동으로 매개변수로 넘어옴
		                        console.log("ajax 통신 성공!");
		                    },

		                    error : function(){
		                        console.log("ajax 통신 실패");
		                    },

		                    complete : function(){
		                        console.log("ajax 통신 성공 여부와 상관없이 무조건 호출!")
		                    }
		                    
		                }); 
					})
					
				})
				
				// 장바구니로 이동
				$(function() {
					$(".go-to-cart").click(function() {
						<% if (loginUser != null && !loginUser.equals("")) {%>
							location.href = '<%=contextPath%>/cartpage.me?memId=<%=loginUser.getMemId()%>';
						<% } %>
					})
				})
			</script>
			
			<div class="pd-tabs">
				<!-- Nav tabs -->
				<ul style="margin-top: 56px; border-bottom: none; border-radius: 0;"
					class="nav nav-tabs" id="myTab" role="tablist">
					<li class=" nav-item" role="presentation">
						<button
							style="background-color: white; width: 150px; color: black;"
							class="pd1 pd-mv-btn nav-link active" id="home-tab"
							data-bs-toggle="tab" data-bs-target="#home" type="button"
							role="tab" aria-controls="home" aria-selected="true">상품상세정보</button>
					</li>
					<li class="nav-item" role="presentation">
						<button
							style="background-color: white; width: 150px; color: black;"
							class="pd2 pd-mv-btn nav-link" id="profile-tab"
							data-bs-toggle="tab" data-bs-target="#profile" type="button"
							role="tab" aria-controls="profile" aria-selected="false">리뷰</button>
					</li>
<!-- 					<li class="nav-item" role="presentation">
						<button
							style="background-color: white; width: 150px; color: black;"
							class="pd3 pd-mv-btn nav-link" id="messages-tab"
							data-bs-toggle="tab" data-bs-target="#messages" type="button"
							role="tab" aria-controls="messages" aria-selected="false">문의</button>
					</li> -->
					<li class="nav-item" role="presentation">
						<button
							style="background-color: white; width: 160px; color: black;"
							class="pd4 pd-mv-btn nav-link" id="settings-tab"
							data-bs-toggle="tab" data-bs-target="#settings" type="button"
							role="tab" aria-controls="settings" aria-selected="false">교환
							및 반품안내</button>
					</li>
				</ul>

			</div>
			<div class="t1"></div>
			<!-- Tab panes -->

			<br> <br>
			<div align="left"
				style="font-size: 30px; font-weight: bolder; margin-top: 70px;">상품상세정보</div>
			<div class="pd-info-content" style="margin-top: 50px;">
				<%
					String[] tmp = p.getImages().split(",");
				%>
				<% for (int i = 0; i < 5; i++) { %>
					<%if (!tmp[i].equals("")) {%>
					<img style="margin-top: 20px; widtsh: 500px; height: 500px"
						src="${pageContext.request.contextPath}<%= tmp[i] %>"
						class="rounded mx-auto d-block" alt="...">
					<% } %>
				<% }%>
			</div>

			<div class="t2"></div>
			<div class="pd-info-review" style="margin-top: 100px;">
				<div align="left"
					style="font-size: 30px; font-weight: bolder; margin-top: 50px;">리뷰(<%= reviewCount %>)</div>
				<div style="margin-left: -20px;" class="container text-center">
					<hr>
					<div style="margin-left: -15px;" class="d-flex mb-3">
						<button class="review review-high mx-3 p-2">평점 높은 순</button>
						<input type="hidden" value="decs">
						<button class="review review-low mx-3 p-2">평점 낮은 순</button>
						<input type="hidden" value="asc">
						<button class="reivew-best mx-5 p-2"></button>
						<button class="reivew-latest mx-5 p-2"></button>
						<% if (check == 0 || loginUser == null) { %>
							<button type="button" style="margin-left: 420px;" class="addReview-btn btn btn-primary" data-bs-toggle="modal" data-bs-target="#addReivew" data-bs-whatever="@mdo" disabled>리뷰작성</button>		
						<% } else { %>
							<button type="button" style="margin-left: 420px;" class="addReview-btn btn btn-primary" data-bs-toggle="modal" data-bs-target="#addReivew" data-bs-whatever="@mdo">댓글작성하기</button>
						<% } %>
						<div class="modal fade" id="addReivew" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true;">
						  <!-- 댓글작성 모달 -->
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h1 class="modal-title fs-5" id="exampleModalLabel">댓글작성하기</h1>
						        <button type="button" class="close-btn btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body">
						      <div class="d-flex mb-3" style="justify-content: flex-end">
						      	<div class="p-1" style="font-weight: bolder; margin-top: 7px; font-size: 16px;">평점</div>
						      	<div class="p-1">
						      	<select class="review-select form-select " aria-label="Default select example">
								  <option value="1">1</option>
								  <option value="2">2</option>
								  <option value="3">3</option>
								  <option value="4">4</option>
								  <option value="5">5</option>
								</select>
						      	</div>
						      </div>
						          <div class="mb-3" style="margin-top: -3px;">
						            <label for="message-text" class="col-form-label"></label>
						            <textarea class="textBox form-control" id="message-text" maxlength="100"></textarea>
						          </div>
						        
						        
						        <div style="margin-left: 350px">
						        	<label class="textCount">0자</label>
    								<label class="textTotal">/100자</label>
						        </div>
						        
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="close-btn btn btn-secondary" data-bs-dismiss="modal">취소</button>
						        <button type="button" class="review-btn btn btn-primary">작성하기</button>
						      </div>
						    </div>
						  </div>
						</div>
					</div>
					

					<hr>

					<!-- 리뷰시작 -->
					<%
						for (Review r : reviewList) {
					%>
					<div class="review-wrap d-flex align-items-start flex-column mb-3">
						<input class="hPid" type="hidden" value="<%= r.getpId()%>">
						<div style="margin-bottom: -10px;" class="p-2">
							<div class="reviewRating row">
								<%
									for (int i = 0; i < r.getReviewRating(); i++) {
								%>
								<span class="bi bi-star-fill yellow-color"> </span>
								<%
									}
								%>
							</div>

						</div>
						<div class="p-2">
							<div class="row">
								<%
									String maskingId = r.getMemId().replaceAll("(?<=.{3}).", "*");
								%>

								<div style="text-align: left; width: 250px;" class="userId col"><%=maskingId%></div>
								<div style="font-size: 13px; margin-left: -150px;" class="date col"><%=r.getDate()%></div>
								
							</div>
						</div>
						<div class="p-2">
							<div class="row grid text-center">
								<div class="content g-col-6 .g-col-md-4"
									style="margin: auto; padding: auto">
									<%=r.getContent()%>
								</div>
								<div class="g-col-6 .g-col-md-4"></div>
								<div class="g-col-6 .g-col-md-4"></div>
							</div>
						</div>

					</div>
					<hr>
					<br>

					<%
						}
					%>
					<!-- 리뷰 끝 -->
				</div>
			</div>


<%-- 			<div class="t3"></div>
			<br> <br>
			<!-- 문의 시작 -->
			<div align="left"
				style="font-size: 30px; font-weight: bolder; margin-top: 50px;">문의</div>

			<br>

			<table style="margin-left: -20px;" class="table">
				<thead style="text-align: center;">
					<tr>
						<th scope="col">번호</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th style="width: 500px;" scope="col">제목</th>
						<th scope="col">유형</th>
						<th scope="col">작성상태</th>
					</tr>
				</thead>
				<tbody style="text-align: center;">
					<% for (Inquiry i : inquiryList) { %>
					<%
						String maskingName = i.getMemName().replaceAll("(?<=.{1}).", "*");
					%>
					<tr class="call-tr">
						<th scope="row">1</th>
						<td><%= maskingName %></td>
						<td>2022.01.01</td>
						<td style="text-align: left;"><%= i.getInquiryTitle() %></td>
						<td><%= i.getInquiryType() %></td>
						<td>답변완료</td>
					</tr>
					
					<tr
						style=" display: none; font-size: 14px; text-align: left; background-color: #f5f5f5;">
						<td colspan="6" style="padding-left:200px; padding-right:100px;">
							<%=i.getInquiryContent() %>
						</td>
						
					</tr>
					
					<tr style="margin-left:30px; display: none; background-color: #f5f5f5;">
						<th></th>
						<th>판매자</th>
						<td>2022.01.02</td>
						<td colspan="3"></td>
					</tr>
					
					<tr style=" display: none; font-size: 14px; text-align: left; background-color: #f5f5f5;">
						<td colspan="6" style="padding-left:200px; padding-right:100px;">
							아이고;당황했습니다;; 주문확인이나 배송시간 지연부분에 관한 양해사항으로 미리 연락주신 점은 좋았어요. 서비스적인 부분은
							정말 흡족하나 생화가 아닌 부분이 너무 아쉽게 남습니다"
						</td>
					</tr>
				<% } %>
				</tbody>
			</table> --%>


			<div class="t4"></div>
			<br> <br>
			<!-- 교환 및 반품안내 -->
			<div align="left"
				style="font-size: 30px; font-weight: bolder; margin-top: 50px;">교환
				및 반품안내</div>
			<img style="margin-top: 20px;"
				src="http://image.hanflower.com/data/image/view/customer_center.gif"
				class="rounded mx-auto d-block" alt="..."> <br>
		</div>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	
	<script>
		$(document).ready(function(){
			$('.textBox').keyup(function (e) {
				let content = $(this).val();
			    // 글자수 세기
			    if (content.length == 0 || content == '') {
			    	$('.textCount').text('0자');
			    } else {
			    	$('.textCount').text(content.length + '자');
			    }
			    
			    // 글자수 제한
			    if (content.length > 100) {
			    	// 200자 부터는 타이핑 되지 않도록
			        $(this).val($(this).val().substring(0, 100));
			        // 200자 넘으면 알림창 뜨도록
			        alert('글자수는 100자까지 입력 가능합니다.');
			    };
			});		
			
			$(".close-btn").click(function(){
				$(".textBox").val("");
				$('.textCount').text('0자');
				$('.review-select').val('1').trigger('change');
			})
			
			
			$(".review-btn").click(function(){
				console.log("리뷰 버튼 클릭");
				let memId = "";
				
				<% if (loginUser != null && !loginUser.getMemId().equals("")){ %>
					memId = "<%=loginUser.getMemId()%>";
				<% } %>
				
				let pId = "<%=p.getpId()%>";
				let rating = $(".review-select option:selected").val();
				let textBox = $(".textBox").val();
				
				console.log("아이디 : " + memId);
				console.log("상품 : " + pId);
				console.log("평점 : " + rating);
				console.log("내용 : " + textBox);
				
				// 리뷰 작성하기
 				$.ajax({
	                 // 요청보내기
	                 url : "insertReivew.p", // 어느 url로 보낼 건지
	                 type : "post", // 요청방식 지정
	                 traditional :true,	
	                 //dataType : "json",
	                 data : {memId:memId, pId:pId, rating:rating, textBox:textBox}, 
	                 success : function(result) { // 성공시 응답 데이터가 자동으로 매개변수로 넘어옴
	                	 if (result > 0){
	                		 location.reload();	 
	                	 } else {
	                		 alert("리뷰작성실패");
	                	 }
	                	 
	                 },

	                 error : function(){
	                     console.log("ajax 통신 실패");
	                 },

	                 complete : function(){
	                     console.log("ajax 통신 성공 여부와 상관없이 무조건 호출!")
	                 }
	                 
	             });   
				
			})
			
			
<%--  			// 평점 높은 순, 평점 낮은 순
			$(".review").click(function(){
				let tmp = "";
				let pId = "<%=p.getpId()%>";
				if ($(this).hasClass("review-high")){
					tmp = 'desc';
				} else if ($(this).hasClass("review-low")) {
					tmp = 'acs';
				}
				
                $.ajax({
                    url : "reviewSort.p",
                    type : "post",
                    traditional :true,	
                    data : {pId:pId, tmp:tmp}, 
                    success : function(list) {
                    		for (let i = 0; i < list.length; i++){
                    			$(".hPid").each(function(){
                    				let rating = $(this).parents(".review-wrap").find(".reviewRating");
                    				let userId = $(this).parents(".review-wrap").find(".userId");
                    				let date = $(this).parents(".review-wrap").find(".date");
                    				let content = $(this).parents(".review-wrap").find(".content");
                    				
                    				rating.children("span").remove();
                    				for (let j = 0; j < list[i].reviewRating; j++){
                    					rating.append("<span class=\"bi bi-star-fill yellow-color\"> </span>");
                    				}
                    				userId.html(list[i].memId);
                    				date.html(list[i].date);
                    				content.html(list[i].content);
                    				console.log(list[i].memId);
  			                  	})
                       		}
                    	
                    },

                    error : function(){
                        console.log("ajax 통신 실패");
                    },

                    complete : function(){
                        console.log("ajax 통신 성공 여부와 상관없이 무조건 호출!")
                    }
                    
                }); 
			})  --%>
		})
		
		
	</script>
</body>
</html>











