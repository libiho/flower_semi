<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/nonOrderResult.css">
</head>
<body>
	<div class="wrap">
	    <%@ include file = "../common/header.jsp" %> 
	    
	        <div class="cart-wrap">
        <div class="order-header-panel">
            <div class="order-header">
                <div>
                    <span style="color: lightgray;"><strong>01</strong> 장바구니</span>
                    <span style="color: lightgray;"><strong>02</strong> 주문서작성/결제</span>
                    <span style="font-size: 25px;"><strong>03</strong> 주문완료</span>
                </div>
            </div>
        </div>

        <div class="cart-content">
            <div class="cart-content-panel">
                <section class="non-header">
                    <table>
                        <tr>
                            <td>
                                <img src="${pageContext.request.contextPath}/resources/image/check.png" alt="">
                            </td>
                            <td class="text-content">
                                <div>
                                    <span class="span1">고객님의 주문이 완료되었습니다.</span> <br>
                                    <span class="span2">주문내역 및 배송에 관련 안내는 주문조회를 통하여 확인 가능합니다.</span>
                                    <br>
                                    <!-- <span class="span3">주문번호 : 20230128-00000001</span> <br> -->
                                    <!-- <span class="span3">주문일자 : 2023-01-28 14:35:12</span> --> 
                                     <br>
                                </div>
                                <div class="atag">
                                    <a class="a1" href="#">쇼핑 더하기</a>
                                    <a class="a2" href="<%= contextPath %>/myPageOrderList.my">주문조회</a>
                                </div>
                            </td>
                        </tr>
                    </table>
                </section>
            </div>
            
        </div>

    </div>
    </div>
    
    <script>
	    $(function() {
	    	$(".a1").click(function(){
				location.href = '<%=contextPath%>/startPage.p?num=1';
	    	})
		})
    </script>
</body>
</html>