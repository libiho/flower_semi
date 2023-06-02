<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문번호 찾기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="./checkBox.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<style>
    #contentBox {
        width: 100%;
        height: 2000px;
  /* background-color: #80c2e1; */
  /* background-color: #a05388; */
  /*background-color: #e5dbdb;*/
   background-color: #f1e9e9;
  font-family: "Asap", sans-serif;
}

.login1 {
  overflow: hidden;
  background-color: white;
  padding: 40px 30px 30px 30px;
  border-radius: 10px;
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  -webkit-transform: translate(-50%, -50%);
  -moz-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  -o-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
  -webkit-transition: -webkit-transform 300ms, box-shadow 300ms;
  -moz-transition: -moz-transform 300ms, box-shadow 300ms;
  transition: transform 300ms, box-shadow 300ms;
  box-shadow: 5px 10px 10px rgba(2, 128, 144, 0.2);
  margin-top: 30px;
}
.login1::before, .login1::after {
  content: "";
  position: absolute;
  width: 600px;
  height: 600px;
  border-top-left-radius: 40%;
  border-top-right-radius: 45%;
  border-bottom-left-radius: 35%;
  border-bottom-right-radius: 40%;
  z-index: -1;
}
.login1::before {
  left: 40%;
  bottom: -130%;
  background-color: rgba(69, 105, 144, 0.15);
  -webkit-animation: wawes 6s infinite linear;
  -moz-animation: wawes 6s infinite linear;
  animation: wawes 6s infinite linear;
}
.login1::after {
  left: 35%;
  bottom: -125%;
  background-color: rgba(2, 128, 144, 0.2);
  -webkit-animation: wawes 7s infinite;
  -moz-animation: wawes 7s infinite;
  animation: wawes 7s infinite;
}
.login1 > input {
  font-family: "Asap", sans-serif;
  display: block;
  border-radius: 5px;
  font-size: 16px;
  background: white;
  width: 100%;
  border: 0;
  padding: 10px 10px;
  margin: 15px -10px;
}
.login1 > button {
  font-family: "Asap", sans-serif;
  cursor: pointer;
  color: #fff;
  font-size: 13px;
  text-transform: uppercase;
  width: 90px;
  height: 45px;
  border: 0;
  padding: 10px 0;
  margin-top: 10px;
  margin-left: 240px;
  border-radius: 5px;
  background-color: #3077ab;
  -webkit-transition: background-color 300ms;
  -moz-transition: background-color 300ms;
  transition: background-color 300ms;
}
.login1 > button:hover {
  background-color: #140ebc;
}

@-webkit-keyframes wawes {
  from {
    -webkit-transform: rotate(0);
  }
  to {
    -webkit-transform: rotate(360deg);
  }
}
@-moz-keyframes wawes {
  from {
    -moz-transform: rotate(0);
  }
  to {
    -moz-transform: rotate(360deg);
  }
}
@keyframes wawes {
  from {
    -webkit-transform: rotate(0);
    -moz-transform: rotate(0);
    -ms-transform: rotate(0);
    -o-transform: rotate(0);
    transform: rotate(0);
  }
  to {
    -webkit-transform: rotate(360deg);
    -moz-transform: rotate(360deg);
    -ms-transform: rotate(360deg);
    -o-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}
input::placeholder {
  color: rgb(146, 139, 139);
  font-size: smaller;
}
#headerLetter{
    color: rgb(126, 120, 120);
    font-weight: bolder;
    font-size: 40px
}
#orderNoHeader{
    padding-top: 30px;
    text-align: center;
    margin-bottom:30px
}
/*
a {
  text-decoration: none;
  color: rgba(255, 255, 255, 0.6);
  position: absolute;
  right: 10px;
  bottom: 10px;
  font-size: 12px;
}
*/
</style>

<body>

<div class="wrap">

<%@ include file="../common/header.jsp"%>

<div id="contentBox">

            <div id="orderNoHeader">
                <h2 id="headerLetter">주문번호 찾기</h2>
            </div>


            <form action="/fleuryoungProject/FindOrderNo.me" class="login1" name="orderNoFind">
                <input type="text" placeholder="수령자 이름을 입력해주세요" name="receiverName">
                <input type="text" placeholder="수령자 전화번호를 -없이 숫자만 입력해주세요" name="receiverPhone">
                <button type="submit" id="findOrderNoBtn" onClick="return orderNo_search()">주문번호 찾기</button>
              </form> 
              
               <script>
          function orderNo_search(){ 
          var frm = document.orderNoFind;

          if (frm.receiverName.value.length < 1) {
            alert("이름을 입력해주세요");
            return false;
          }
          if (frm.receiverPhone.value.length < 1) {
            alert("이메일을 입력해주세요");
            return false;
          }
          }
          </script>
        </div>
        
      </div>
      
      
        

</body>
 <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
</html>