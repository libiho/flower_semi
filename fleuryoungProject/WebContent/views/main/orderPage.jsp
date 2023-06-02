<%@page import="com.kh.member.model.vo.Coupon"%>
<%@page import="com.kh.product.model.vo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member)request.getAttribute("member");
	int deliveryPrice = (int)request.getAttribute("delivery");
	ArrayList<Cart> cartList = (ArrayList<Cart>)request.getAttribute("cartList");
	ArrayList<Coupon> couponList = (ArrayList<Coupon>)request.getAttribute("couponList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderPage</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/nonOrder.css">

<style>
	.btn-danger {
	  	background-color: rgb(248, 178, 188);
	}
	
	.delete-btn{
		    width: 30px;
		    height: 30px;
		    display: inline-block;
		    background-image: url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMzAiIGhlaWdodD0iMzAiIHZpZXdCb3g9IjAgMCAzMCAzMCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGQ9Ik0yMSA5Ljc2MiAyMC4yMzggOSAxNSAxNC4yMzggOS43NjIgOSA5IDkuNzYyIDE0LjIzOCAxNSA5IDIwLjIzOGwuNzYyLjc2MkwxNSAxNS43NjIgMjAuMjM4IDIxbC43NjItLjc2MkwxNS43NjIgMTV6IiBmaWxsPSIjQ0NDIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiLz4KPC9zdmc+Cg==);
		    background-size: cover;
		    background-position: center center;
		    cursor: pointer;
	}
</style>

</head>
<body>
	<div class="wrap">
        
    <%@ include file = "../common/header.jsp" %> 
    
    <div class="cart-wrap">
        <div class="order-header-panel">
            <div class="order-header">
                <div>
                    <span style="color: lightgray;"><strong>01</strong> 장바구니</span>
                    <span style="font-size: 25px;"><strong>02</strong> 주문서작성/결제</span>
                    <span style="color: lightgray;"><strong>03</strong> 주문완료</span>
                </div>
            </div>
        </div>

        <div class="cart-content">

            <div class="cart-content-panel">
                <% if(loginUser == null || loginUser.getMemId().equals("")){ %>
	                <section class="non-header">
	                    <div class="css-xfz6k8 e19imkju1">
	                        이벤트 및 쿠폰 할인 받으시려면 회원가입을 진행 하셔야 합니다. <br>
	                    </div>
	                    <a href="#">회원가입 하러가기</a>
	                </section>
                <%} %>

                <section class="non-order-panel">
                    <section>
                        <div class="non-order-title">주문자 정보</div>
                        <div></div>
                    </section>
                    <br>
                    <div class="row">
                    	<div class="col-md-auto py-2" style="">
                    		<div class="form-check">
							  <input class="form-check-input" type="radio" name="addressRadio" id="exampleRadios1" value="default" checked>
							  <label class="form-check-label" for="exampleRadios1">
							   기본배송지
							  </label>
							</div>
                    	</div>
                    	<div class="col-md-auto py-2">
                    		<div class="form-check">
							  <input class="form-check-input" type="radio" name="addressRadio" id="exampleRadios2" value="userInput">
							  <label class="form-check-label" for="exampleRadios2">
							    직접입력
							  </label>
							</div>
                    	</div>
                    </div>
					
                    <div class="non-order-content-panel">
                        <section>
                            <!-- 이름 입력 시작-->
                            <label class="non-name-label">
                                <div class="non-name-div">이름</div>
                                <div class="non-name-input-panel">
                                    <input class="non-name-input" name="name" maxlength="10" value="<%= m.getMemName() %>">
                                    <input class="userName" type="hidden" value="<%= m.getMemName() %>">
                                </div>
                            </label>
                            <!-- 이름 입력 끝 -->

                            <!-- 이메일 입력 시작 -->
                            <% String getEmail = m.getEmail(); %>
                            <% String[] email = getEmail.split("@"); %>
                            <label class="non-email-label">
                                <div class="non-email-div">이메일</div>
                                <div class="non-email-input-panel1">
                                    <div class="non-email-input-panel2">
                                        <div class="non-email-input-panel3">
                                            <div class="non-email-input-panel4">
                                                <input class="non-email-input" type="email" placeholder="이메일"
                                                    title="이메일 앞부분" maxlength="20" value="<%= email[0] %>">
                                                 <input class="userEamil1" type="hidden" value="<%= email[0] %>">
                                            </div>
                                            <span class="non-email-at">@</span>
                                        </div>
                                        <div class="non-email-detail-panel1">
                                            <div class="non-email-detail-panel2">
                                                <div class="non-email-detail-panel3">
                                                	<input class="userEamil2" type="hidden" value="<%= email[1] %>">
                                                    <select class="non-email-select">
                                                        <option value="1">선택하세요</option>
                                                        <option value="2">naver.com</option>
                                                        <option value="3">hanmail.net</option>
                                                        <option value="4">daum.net</option>
                                                        <option value="5">gmail.com</option>
                                                        <option value="6">kakao.com</option>
                                                        <option value="7">nate.com</option>
                                                        <option value="8">hotmail.com</option>
                                                        <option value="9">outlook.com</option>
                                                        <option value="10">icloud.com</option>
                                                    </select>
                                                    <svg width="1em" height="1em" viewBox="0 0 10 10"
                                                        fill="currentColor" class="IgBXR">
                                                        <path d="M0 3l5 5 5-5z"></path>
                                                    </svg>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </label>
                            <!-- 이메일 입력 끝 -->

                            <label class="non-phone-label">
                                <div class="non-phone-div">휴대전화</div>
                                <div class="non-phone-input-panel1">
                                    <div class="non-phone-input-panel2">
                                        <div class="non-phone-input-panel3">
                                            <div class="non-phone-input-panel4">
                                            	<% String getPhone = m.getPhone(); %>
                                                <select class="non-phone-select" name="phone1">
                                                    <option value="0" selected>선택</option>
                                                    <option value="1">010</option>
                                                    <option value="2">011</option>
                                                    <option value="3">016</option>
                                                    <option value="4">017</option>
                                                    <option value="5">018</option>
                                                    <option value="6">019</option>
                                                </select>
                                                
                                                <svg width="1em" height="1em" viewBox="0 0 10 10" fill="currentColor"
                                                    class="IgBXR yPMDv">
                                                    <path d="M0 3l5 5 5-5z"></path>
                                                </svg>
                                            </div>
                                        </div>
                                        <input class="userPhone1" type="hidden" value="<%= getPhone.substring(0, 3) %>">
                                        <div class="non-phone-input-panel5">
                                            <input class="non-phone-input" type="tel" placeholder="입력해주세요" size="1"
                                                maxlength="9" value="<%=getPhone.substring(3, 11)%>">
                                            <input class="userPhone2" type="hidden" value="<%= getPhone.substring(3, 11) %>">
                                        </div>
                                    </div>
                                    
                                </div>
                            </label>

                            <label class="non-address-label">
                                <div class="non-address-title">주소</div>
                                <div class="non-address-panel">
                                    <div>
                                        <div class="non-address-find-panel">
                                            <button class="non-address-find-button" type="button">주소찾기</button>
                                            <input class="non-address-input" disabled="" value="<%= m.getPostal()%>">
                                            <input class="postal" type="hidden" value="<%= m.getPostal() %>">
                                        </div>
                                        <div class="non-address-detail-panel">
                                            <textarea class="non-address-detail" disabled="" rows="1"
                                                style="overflow: hidden; overflow-wrap: break-word; height: 39.8182px;"><%= m.getStreet() %>
												
                                            </textarea>
                                            <input class="street" type="hidden" value="<%= m.getStreet() %>">
                                        </div>
                                    </div>
                                    <input class="non-address-detail-input" name="extraAddress" placeholder="상세주소 입력"
                                        maxlength="50" value="<%= m.getAddress()%>">
                                    <input class="addressDetail" type="hidden" value="<%= m.getAddress() %>">
                                </div>
                            </label>

                        </section>
                    </div>
                </section>


                <section class="non-product-panel">
                    <section>
                        <div class="non-product-header-title">주문 상품</div>
                        <div></div>
                    </section>

                    <!-- 가게 하나 주문 상품 시작 for문 시작 -->
                    <% for (Cart c : cartList) { %>
                    <div class="non-product-content-panel">
                        <section>
                            <div class="non-product-title-panel1">
                                <div class="non-product-title-panel2">
                                    <div class="non-product-title-panel3">
                                        <div class="non-product-title"><%= c.getStoreName() %></div>
                                    </div>
                                </div>
                                <div>
                                    <!-- 해당가게에서 산 품목 갯수 for문 -->
                                    <div class="non-product-detail-panel">
                                        <img src="<%=contextPath %><%= c.getImg() %>" alt="">
                                        <div>
                                            <div class="non-product-name"><%= c.getpName() %></div>
                                            <% if (c.getOpt1stNo() != 0) { %>
                                            <div class="non-product-option" style="font-size: 12px;"><%= c.getOpt1Title()%> : <%= c.getOpt2Title() %></div>
                                            <div class="non-product-price-panel">
                                                <span class="non-product-price"><%= c.getOptCount() * (c.getOptPrice() + c.getpNetPrice()) %></span>
                                                <div></div>
                                                <span class="non-product-count"><%= c.getOptCount() %>개</span>
										    <% } else { %>
                                            <div class="non-product-price-panel">
                                                <span class="non-product-price"><%= c.getpNetPrice() * c.getNoneOptCount() %></span>
                                                <div></div>
                                                <span class="non-product-count"><%= c.getNoneOptCount() %>개</span>
										    <% } %>
                                                <!-- 카드쓰기 버튼 시작 -->
                                                
                                                <div class="modal fade" id="exampleModal" tabindex="-1"
                                                    aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h1 class="modal-title fs-5" id="exampleModalLabel">
                                                                    선물용 꽃다발
                                                                </h1>
                                                                <button type="button" class="btn-close"
                                                                    data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <form>
                                                                <div class="modal-body">

                                                                    <div class="mb-3">
                                                                        <label for="message-text"
                                                                            class="col-form-label">메세지:</label>
                                                                        <textarea class="form-control"
                                                                            id="message-text"></textarea>
                                                                    </div>

                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary"
                                                                        data-bs-dismiss="modal">닫기</button>
                                                                    <button type="button" class="btn btn-primary"
                                                                        style="background-color: rgb(248, 178, 188); border-color: rgb(248, 178, 188);">완료
                                                                    </button>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- 카드쓰기 버튼 시작 -->

                                            </div>
                                        </div>
                                    </div>
                                    
                                    <!--갯수 for문끝  -->
                                </div>
                            </div>
                        </section>
                    </div>
                    <!-- 주문 상품 끝 for문끝 -->
                    <% } %>
                </section>
                
                <br>
                <br>
                <!-- 쿠폰 -->
                <section class="discount-panel">
                	<section>
                        <div class="non-order-title">쿠폰/마일리지</div>
                        <div></div>
                    </section>
                    <hr>
                    
                    <section>
                    	<div class="container text-center">
						  <div class="row row-cols-auto">
						    <div class="col">
						      <img src="${pageContext.request.contextPath}/resources/image/icon/coupon.png" style="width: 30px; height: 30px">
						    </div>
						    <div class="col" style="margin-left: -15px; margin-top: 5px; font-weight: bold; font-size: 14px">
						      쿠폰 적용
						    </div>
						    <div class="col-2"></div>
						    <div class="col-8">
						    	<select class="coupon-select form-select" name="coupon-select" aria-label="Default select example">
								  <option value="0">쿠폰을 선택해 주세요</option>
								  <% for (Coupon c : couponList) { %>
								  	<option value="<%= c.getCouId()%>"><%= c.getCouName() %></option>
								  	<input type="hidden" name="couDetail" value="<%=c.getCouDetail() %>">
								  	<input type="hidden" name="couRegDate" value="<%=c.getCouRegDate() %>">
								  	<input type="hidden" name="couExpire" value="<%=c.getCouExpire() %>">
								  	<input type="hidden" name="couDiscount" value="<%=c.getCouDiscount() %>">
								  <% } %>
								</select>
						    </div>
						  </div>
						</div>
						<br class="coupon-connet">
						
						<div class="coupon-panel container text-left shadow" style="display:none; border: 1px solid lightgray; width: 460px; height: 130px; margin-left: 260px;">
							<div class="row row-cols-auto">
								<div class="col-10 coupon-Name m-1" style="font-size: 14px; font-weight: bold; margin-left: 3px;">
								</div>
								<div class="col-1 delete-btn" style="margin-left: 30px">
									
								</div>
								
							</div>
							<div class="coupon-Detail row m-1" style="font-size: 12px">
								12월을 맞이해 회원님들께 드리는 특별한 화이트 세일! 눈내린 크리스마트 트리 어때요? 해당 상품들중 1 구매시 해당 값 50% 세일!
							</div>
							
							<div class="coupon-Disount row m-1" style="color: red; font-size: 14px; font-weight: bolder;">[15,000원 할인]</div>
							<div class="coupon-date row m-1" style="font-size: 14px; font-weight: bolder;">2020-01-01 ~ 2011-01-01</div>
						</div>
						
						<br>
						<br>
						
						<div class="container text-center">
						  <div class="row row-cols-auto">
						    <div class="col">
						      <img src="${pageContext.request.contextPath}/resources/image/icon/m.png" style="width: 20px; height: 20px; margin-left: 10px;">
						    </div>
						    <div class="col" style="margin-left: -15px; margin-top: 3px; font-weight: bold; font-size: 14px">
						      마일리지 적용
						    </div>
						    <div class="col-1" style="margin-left: 32px"></div>
						    <div class="col-5">
								<input class="m-input py-1" type="text" min="0" max="<%=m.getMileage()%>" style="width:175px; text-align: right">
								<button type="button" class="m-btn btn btn-danger" style="background-color: rgb(248, 178, 188); border-color: rgb(248, 178, 188); margin-bottom: 4px">모두사용</button>
						    </div>
						  </div>
						</div>
						
						<div class="container text-center">
						  <div class="row row-cols-auto" style="font-size:14px";>
						  	<div class="col-6 col-md-4"></div>
						  	<div class="col" style="">
						  		사용가능한 마일리지 
						  	</div>
						  	<div class="m-panel col" style="margin-left: -20px; font-weight: bolder">
						  		<%=m.getMileage()%>원
						  	</div>
						  </div>
						</div>
                    </section>
                </section>
                
                
            </div>

            <div class="cart-side-panel">
                <div class="cart-side-content">

                    <div class="cart-contents">
                        <div class="price-field">
                            <span class="ptitle">상품금액</span>
                            <span class="pprice">30,000
                                <span class="won">원</span>
                            </span>
                        </div>

						<div class="discount-field">
                            <span class="ptitle">베송비</span>
                            <span class="pprice"><%= deliveryPrice %>
                                <span class="won">원</span>
                            </span>
                        </div>

                        <div class="discount-field2">
                            <span class="ptitle">쿠폰할인</span>
                            <span class="pprice" style="color: red;">-&nbsp;0
                                <span class="won">원</span>
                            </span>
                        </div>
                        
                        <div class="discount-field3">
                            <span class="ptitle">마일리지사용</span>
                            <span class="pprice" style="color: red;">-&nbsp;0
                                <span class="won">원</span>
                            </span>
                        </div>

                        <div class="result-field">
                            <span class="result-title">결제 예정금액</span>
                            <span class="result-price">
                                <strong></strong>
                                <span class="won">원</span>
                            </span>
                        </div>

                    </div>

                    <div class="result-button-panel">
                        <button class="cart-access-button">
                            <b>결제하기</b>
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </div>
    </div>
    
    <script>
    	let updateMileage = 0;
		// 천단위 콤마 
	   	function comma(str) {
	        return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	    }
		
		// 숫자만
	   	function onlyNo(str) {
	   		return str.replace(/[^0-9]/g, '');
	   	}	
		
    	$(function(){
    		
    		function emailCheck(value){
    			
    			let emailChk = value;
    			
    			if (emailChk == 'naver.com'){
        			$(".non-email-select").val("2").trigger("change");
        		} else if (emailChk == 'hanmail.net'){
        			$(".non-email-select").val("3").trigger("change");
        		} else if (emailChk == 'daum.net'){
        			$(".non-email-select").val("4").trigger("change");
        		} else if (emailChk == 'gmail.com'){
        			$(".non-email-select").val("5").trigger("change");
        		} else if (emailChk == 'kakao.com') {
        			$(".non-email-select").val("6").trigger("change");
        		} else if (emailChk == 'nate.com') {
        			$(".non-email-select").val("7").trigger("change");
        		} else if (emailChk == 'hotmail.com') {
        			$(".non-email-select").val("8").trigger("change");
        		} else if (emailChk == 'outlook.com') {
        			$(".non-email-select").val("9").trigger("change");
        		} else {
        			$(".non-email-select").val("10").trigger("change");
        		}
    		}
    		
    		
    		function phoneCheck(value) {
    			let phoneChk = value;
    			
    			if (phoneChk == '010'){
        			$(".non-phone-select").val("1").trigger("change");
        		} else if (phoneChk == '011'){
        			$(".non-phone-select").val("2").trigger("change");
        		} else if (phoneChk == '016'){
        			$(".non-phone-select").val("3").trigger("change");
        		} else if (phoneChk == '017'){
        			$(".non-phone-select").val("4").trigger("change");
        		} else if (phoneChk == '018'){
        			$(".non-phone-select").val("5").trigger("change");
        		} else {
        			$(".non-phone-select").val("6").trigger("change");
        		}
    		}

    		
    		emailCheck('<%= email[1] %>');
    		phoneCheck('<%= getPhone.substring(0, 3)%>');
    		
    		let name = $(".non-name-input");
			let email1 = $(".non-email-input");
			let email2 = $(".non-email-select");
			let phone1 = $(".non-phone-select");
			let phone2 = $(".non-phone-input");
			let address1 = $(".non-address-input");
			let address2 = $(".non-address-detail");
			let address3 = $(".non-address-detail-input");
    		
			let hName = $(".userName");
			let hEmail1 = $(".userEamil1");
			let hEmail2 = $(".userEamil2");
			let hPhone1 = $(".userPhone1");
			let hPhone2 = $(".userPhone2");
			let hAddress1 = $(".postal");
			let hAddress2 = $(".street");
			let hAddress3 = $(".addressDetail");
			
    		$("input[name='addressRadio']").change(function(){
    			let isChk = $("input[name='addressRadio']:checked").val();
    			if (isChk == 'userInput'){
    				name.val("");
    				email1.val("");
    				email2.val("1").trigger("change");
    				phone1.val("0").trigger("change");
    				phone2.val("");
    				address1.val("");
    				address2.val("");
    				address3.val("");
    			} else {
    				name.val(hName.val());
    				email1.val(hEmail1.val());
    				
    				emailCheck(hEmail2.val());
    				phoneCheck(hPhone1.val());
    				phone2.val(hPhone2.val());
    				address1.val(hAddress1.val());
    				address2.val(hAddress2.val());
    				address3.val(hAddress3.val());
    			}		
    		});
    		
				
		});
			
		
		let sum = 0;
    	let price = $(".price-field").children(".pprice"); // 상품금액
    	let dPrice = $(".discount-field").children(".pprice"); // 배송비
    	let total = $(".result-price").children("strong"); // 결제 예정금액
    	
		$(document).ready(function() {
    		// 주문상품
    		$(".non-product-price").each(function(){
    			sum += Number($(this).html());
    			$(this).html(comma(Number($(this).html()) + "") +"원");
    		})
			// 결제 패널
    		price.html(comma(sum + "") +" 원")
    		
    		dPrice.html(comma(dPrice.html()));
    		
			total.html(comma(Number(onlyNo(price.html())) + Number(onlyNo(dPrice.html())) + "")); 
			
			console.log("처음 토탈 : " + total.html());
			
			// 쿠폰 적용
			let rdiscount;
			let rPrice = Number(onlyNo(total.html()));
			let couponPanel = $(".discount-field2").children(".pprice");
			$(".coupon-select").on("change", function(){
				if ($(this).val() != '0'){
					let couponVal = $(this).val();
					let couponDetail = $(this).next().val();
					let couponRegDate = $(this).next().next().val();
					let couponExpire = $(this).next().next().next().val();
					rdiscount = Math.floor($(this).next().next().next().next().val());
					
					if (couponExpire == "null"){
						couponExpire = " ";
					}
					let couponDiscount = "[" + comma(rdiscount+"") + "원 할인]";
					
					$(".coupon-panel").show();
					
					$(".coupon-Name").html($("select[name=coupon-select] option:selected").text());
					$(".coupon-Detail").html(couponDetail);
					$(".coupon-Disount").html(couponDiscount);
					$(".coupon-date").html(couponRegDate + " ~ " + couponExpire);
					
					console.log("쿠폰 : " + rdiscount);
					console.log("여기 : " + couponPanel.html());
					
					couponPanel.html("- " + comma(rdiscount + "") + " 원");
					total.html(comma((rPrice-rdiscount) + ""));
					console.log("쿠폰 적용 토탈 : " + total.html());
					rPrice = Number(onlyNo(total.html()));
					
				}
			})
			
			
			// 쿠폰 적용 취소
			$(".delete-btn").click(function(){
				$(this).parents(".coupon-panel").hide();
				$('.coupon-select').val('0').trigger('change');
				couponPanel.html("- 0 원");
				total.html(comma((rPrice+rdiscount) + ""));
				rPrice = Number(onlyNo(total.html()));
			})
			
			
			// 마일리지 적용
			$(".m-btn").click(function(){
				let mPanel = onlyNo($(".m-panel").html());
				$(".m-input").val(mPanel);
			})	
			
		    $(".m-input").keydown(function (key) {
		    	//let total = $(".result-price").children("strong");
		    	//let rPrice = Number(onlyNo(total.html()));
		    	iPrice = Number($(this).val());
		    	let mPanel = Number(onlyNo($(".m-panel").html()));
		    	
		        if (key.keyCode == 13) {
		        	if (iPrice > mPanel){
		        		alert("보유 금액 이상 사용은 불가능 합니다.");
		        		$(".m-input").val(mPanel);
		        	} else {
		        		$(".m-panel").html(comma((mPanel-iPrice)+"") +" 원");
		        		total.html(comma((rPrice-iPrice)+""));
		        		rPrice = Number(onlyNo(total.html()));
		        		$(".discount-field3").children(".pprice").html("- " + comma(iPrice + "") + " 원")
		        		
		        	}
		        }
		        let usedMileage = Number(onlyNo($(".m-panel").html()));
		        
		        console.log("원래 마일리지 : " + <%=m.getMileage()%>);
		        console.log("사용한 마일리지 " + usedMileage);
		        console.log("적립할 마일리지 : " + (rPrice * 0.05));
		        updateMileage = Math.floor((usedMileage + (rPrice * 0.05)));
		        console.log("업데이트할 마일리지 : " + updateMileage);
		    });
		});
    	</script>
    	
    	
    	
    	
    	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
    	<script>
			// 숫자만
		   	function onlyNo(str) {
		   		return str.replace(/[^0-9]/g, '');
		   	}	
    		
    		$(document).ready(function(){
    			
    			$(document).on("click", ".cart-access-button", function(){
    				// 장바구니 삭제
    	    		let pidArr = [];
    	    		let memId = "";
    	    		let memName = "";
    	    		let memEmail = "";
    	    		let memPhone = "";
    	    		let postal = "";
    	    		let street = "";
    	    		let address = "";
    	    		
    	    		<% if (m != null) {%>
	    	    		memId = '<%=m.getMemId()%>';
	    	    		memName = "<%=m.getMemName()%>";
	    	    		memEmail = "<%=m.getEmail()%>";
	    	    		memPhone = "<%=m.getPhone()%>";
	    	    		postal = "<%=m.getPostal()%>";
	    	    		street = "<%=m.getStreet()%>";
	    	    		address = "<%=m.getAddress()%>";
    	    		<% }%>
    	    		
    	    		
    	    		let i = 0;
    	    		<% for (Cart c : cartList) {%>
						pidArr[i] = {memId:'<%=c.getMemId()%>'
								   , pId:<%=c.getpId()%>
								   , opt1No:<%=c.getOpt1stNo()%>
						           , opt2No:<%=c.getOpt2ndNo()%>
						           , opt2Title:'<%=c.getOpt1Title()%>'
						           , opt2Content:'<%=c.getOpt2Title()%>'
						           , opt2Price:<%=c.getOptPrice()%>
						           , pNetPrice:<%=c.getpNetPrice()%>
						           , pCount:<%=c.getNoneOptCount()%>
						           , optCount:<%=c.getOptCount()%>
						           } 
						i++;
					<%}%>
					
					// 중복제거
    				//tmpArr = tmpArr.filter((v, i) => tmpArr.indexOf(v) === i);
					
					console.log(memId);
					console.log(memName);
					console.log(memEmail);
					console.log(memPhone);
					console.log(postal);
					console.log(street);
					console.log(address);
					
					
	    			let tPrice = Number(onlyNo($(".result-price").children("strong").html())); // 결제 예정금액
        			console.log("tPrice : " + tPrice);
	    			
 	    			
 	    			var IMP = window.IMP; 
        		    IMP.init('imp83417313'); 
        		    IMP.request_pay({
        		    	pg : "kakaopay", 
        		        pay_method : 'card',
        		        merchant_uid : 'merchant_' + new Date().getTime(),
        		        name : '결제',
        		        amount : tPrice,
        		        buyer_email : '구매자 이메일',
        		        buyer_name : '구매자 이름',
        		        buyer_tel : '구매자 번호',
        		        buyer_addr : '구매자 주소',
        		        buyer_postcode : '구매자 주소',
        		        m_redirect_url : 'redirect url'
        		    }, function(rsp) {
        		        if ( rsp.success ) {
        		        	let jsonData = JSON.stringify(pidArr);
     		               $.ajax({
     		                    // 요청보내기
     		                    url : "deleteCart.p", // 어느 url로 보낼 건지
     		                    type : "post", // 요청방식 지정
     		                    traditional :true,	
     		                    //dataType : "json",
     		                    data : {jsonData:jsonData, memberId:memId, memName:memName, memEmail:memEmail, memPhone:memPhone, postal:postal, street:street, address:address, Mileage:updateMileage}, 
     		                    success : function(result) { // 성공시 응답 데이터가 자동으로 매개변수로 넘어옴
     		                        location.href = "<%=contextPath%>/orderSuccessPage.p";
     		                    },

     		                    error : function(){
     		                        console.log("ajax 통신 실패");
     		                    },

     		                    complete : function(){
     		                        console.log("ajax 통신 성공 여부와 상관없이 무조건 호출!")
     		                    }
     		                    
     		                }); 
     		               
        		        } else {
        		            alert("결제를 실패하였습니다.");
        		        }
        		    }); 
    			})
    		})
    		
		    
    </script>
    
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>

















