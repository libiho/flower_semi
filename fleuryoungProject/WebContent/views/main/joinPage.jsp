<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="./checkBox.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

	<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

<style>
#infoInputMeori {
	/* text-align: center; */
	margin-top: 100px;
	margin-left: 400px;
	margin-bottom: 50px;
	color: lightcoral;
}

#CreateAccount {
	padding-left: 10px;
}

small {
	color: red;
}

h6 {
	text-align: center;
}

#daejang {
	border: 1px solid lightgray;
	width: 40%;
	margin-left: auto;
	margin-right: auto;
	height: 1500px;
}

#info {
	width: 40%;
	border: 1px solid lightgray;
	margin: 0 auto;
	height: 1700px;
}

#infoHeader {
	height: 50px;
	border: 1px solid lightgray;
	line-height: 50px;
	background-color: lightgray;
}

label {
	width: 30%;
	text-align: right;
	padding-right: 8px;
	height: 100%;
	float: left;
	line-height: 37px;
}

#idArea, #pwdArea1, #pwdArea2, #birthDateArea, #genderArea, #nameArea {
	width: 100%;
	height: 80px;
	padding-top: 30px;
}

#phoneArea {
	width: 100%;
	height: 80px;
	padding-top: 30px;
}

#emailArea {
	width: 100%;
	height: 80px;
	padding-top: 30px;
}

#agreeArea {
	width: 70%;
	height: 300px;
	padding-top: 30px;
	margin: auto;
}

#agreeArea>* {
	margin: 0;
	padding: 0;
	box-sizing: border-box
}

body {
	background-color: #f7f7f7;
}

ul>li {
	list-style: none
}

a {
	text-decoration: none;
}

.clearfix::after {
	content: "";
	display: block;
	clear: both;
}

#joinForm {
	width: 460px;
	margin: 0 auto;
}

ul.join_box {
	border: 1px solid #ddd;
	background-color: #fff;
}

.checkBox, .checkBox>ul {
	position: relative;
}

.checkBox>ul>li {
	float: left;
}

.checkBox>ul>li:first-child {
	width: 85%;
	font-weight: 600;
	color: #888;
	padding: 15px 15px 5px 0px;
}

.checkBox>ul>li:nth-child(2) {
	position: absolute;
	top: 50%;
	right: 30px;
	margin-top: -12px;
}

.checkBox textarea {
	width: 96%;
	height: 90px;
	margin: 0 2%;
	background-color: #f7f7f7;
	color: #888;
	border: none;
}

.footBtwrap {
	margin-top: 15px;
}

.footBtwrap>li {
	float: left;
	width: 50%;
	height: 60px;
}

.footBtwrap>li>button {
	display: block;
	width: 98%;
	height: 100%;
	font-size: 20px;
	text-align: center;
	line-height: 60px;
}

.fpmgBt1 {
	background-color: #fff;
	color: #888;
	border-color: white;
	border: 1px solid lightgray;
	margin-right: 10px;
	margin-top: 70px;
}

.fpmgBt2 {
	background-color: lightsalmon;
	color: #fff;
	border-color: white;
	border: 1px solid lightgray;
	margin-top: 70px;
}

#emailButton, #phoneButton {
	width: 50%;
	height: 38%;
	margin-top: 5px;
	vertical-align: middle;
}

#addressArea {
	width: 100%;
	height: 150px;
	padding-top: 30px;
}

#pwdInput, #pwdInputCheck, #emailInput, #phoneInput, #nameInput {
	width: 50%;
	display: inline-block;
}
#birthDateInput{
    width: 30%;
    display: inline-block;
}

#idInput {
	width: 37%;
	display: inline-block;
}

#address1 {
	width: 20%;
	margin-bottom: 5px;
}

button {
	border: 1px solid gray;
	display: inline-block;
}

#addressDiv2 {
	width: 70%;
	height: 100%;
	/* display: inline; */
	float: left;
}

#address2, #address3 {
	width: 70%;
	margin-bottom: 5px;
}

#lastUl {
	margin-bottom: 45px;
}

::placeholder {
	font-size: 0.8em;
}

#pwdArea1>::placeholder {
	font-size: 0.3em;
}


 #male, #female{
    margin-top: 12px;
    margin-left: 7px;
 }
 #idCheckBtn, #btn-address{
	border: 1px solid lightgray;
    display: inline-block;

 }
</style>


    <script>
        window.onload = function () {
            const checkAll = document.getElementById('chkAll');
            const chks = document.querySelectorAll('.chk');
            const chkBoxLength = chks.length;

            checkAll.addEventListener('click', function (event) {
                if (event.target.checked) {
                    chks.forEach(function (value) {
                        value.checked = true;
                    })
                } else {
                    chks.forEach(function (value) {
                        value.checked = false;
                    })
                }
            });
            for (chks of chks) {
                chks.addEventListener('click', function () {
                    let count = 0;
                    chks.forEach(function (value) {
                        if (value.checked == true) {
                            count++;
                        }
                    })
                    if (count !== chkBoxLength) {
                        checkAll.checked = false;
                    } else {
                        checkAll.checked = true;
                    }
                })
            }
        }
    </script>
</head>
<body>

	<div class="wrap">

		<%@ include file="../common/header.jsp"%>

		<div id="infoInputMeori">
			<h3>
				<b> 회원 정보 입력 </b>
			</h3>
		</div>

		<h6>
			<small>*</small> 아래 항목들은 전부 필수 입력 항목입니다.
		</h6>
		<br>

		<div id="infoDaejang">

<!-- ------------------------------------------------------------------------------------------------------------------------------------------------- -->
			<div>
			<!-- id = "enroll-form" -->
			<!-- <small>*</small> -->
				<form id="enroll-form" action="/fleuryoungProject/insert.me"  method="post">
					<div id="info">

						<div id="infoHeader">
							<div id="CreateAccount">CreateAccount</div>
						</div>


						<div id="idArea">
							<label for="id"> 아이디</label> <input type="text"
								class="form-control" id="idInput" required name="memId"
								placeholder="공백없이 소문자,숫자로 5~12글자">
							<button type="button" id="idCheckBtn" onclick="idCheck();">중복확인</button>
						</div>


						<div id="pwdArea1">
							<label for="password"> 비밀번호</label> <input 
								type="password" class="form-control" id="pwdInput" required
								name = "memPw"
								placeholder="공백없이 소/대문자,숫자 각각 한개 이상 포함하는 6~15자 길이">
						</div>


						<div id="pwdArea2">
							<label for="password">비밀번호 확인</label> <input
								type="password" class="form-control" id="pwdInputCheck"
								placeholder="비밀번호를 다시 입력해주세요" required>
						</div>

						
						
						
						<div id="emailArea">
							<label for="email">이메일</label> <input type="email"
							name="email"
							class="form-control" id="emailInput" required> <br> <a
							href="">
							</a>
						</div>

						
						
						<div id="nameArea">
							<label for="id">이름</label>
							<input type="text" class="form-control" id="nameInput" name="memName"  required>
						</div>


						
						<div id="phoneArea">
							<label for="phone">휴대폰번호</label> <input type="phone"
								class="form-control" id="phoneInput"
								placeholder="-는 빼고 숫자만 입력해주세요" name="phone" required> 
								<!--<a href=""><button
									type="button" class="btn btn-outline-info" id="phoneButton">휴대폰
									인증하기</button></a>-->
								
						</div>

						<div id="birthDateArea">
							<label for= "birthDate">생년월일</label>
							<p><input type="text"  class="form-control" id="birthDateInput" placeholder="ex)20020604" name="memBirthDate" required></p>
						</div>
						
						
						<div id="genderArea">
							<label for= "birthDate">성별</label>
								<input type="radio" name="gender" id="male"  value=1 onchange="checkMale(this);">남
								<input type="radio" name="gender" id="female"  value=2 onchange="checkFemale(this);">여
						</div>
						
						<script>
							var gender = $('input[name=gender]:checked').val();
						</script>


						<div id="addressArea">
							<label for="address" id="addressLabel">주소</label>
		
							<div id="addressDiv2"> 
							 <input type="number" id="address1" placeholder="주소번호" name="postal" required >
							<button id="btn-address" onclick="sample6_execDaumPostcode()" type="button" >주소검색</button>  <br>
							<input type="text"  id="address2" placeholder="도로명주소" name="street" required> <br>
							<input type="text" class="form-control" id="address3" placeholder="상세주소를 입력해주세요" name="address" required> 
							
							</div>
		
						</div>

						<div id="agreeArea">

							<ul class="join_box">
								<li class="checkBox check01">
									<ul class="clearfix">
										<li>아래 약관에 모두 동의합니다.</li>
										<li class="checkAllBtn"><input type="checkbox"
											name="chkAll" id="chkAll" class="chkAll"></li>
									</ul>
								</li>
								<li class="checkBox check02">
									<ul class="clearfix">
										<li>이용약관 동의(필수)</li>
										<li class="checkBtn"><input type="checkbox" name="chk" id="check01"
											class="chk"></li>
									</ul> <textarea name="" id="">여러분을 환영합니다. 네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
               </textarea>
								</li>
								<li class="checkBox check03">
									<ul class="clearfix">
										<li>개인정보 수집 및 이용에 대한 안내(필수)</li>
										<li class="checkBtn"><input type="checkbox" name="chk" id="check02"
											class="chk"></li>
									</ul> <textarea name="" id="">여러분을 환영합니다. 네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
               </textarea>
								</li>
								<li class="checkBox check03">
									<ul class="clearfix">
										<li>위치정보 이용약관 동의(선택)</li>
										<li class="checkBtn"><input type="checkbox" name="chk"
											class="chk"></li>
									</ul> <textarea name="" id="">여러분을 환영합니다. 네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
               </textarea>
								</li>
								<li class="checkBox check04">
									<ul class="clearfix" id="lastUl">
										<li>이벤트 등 프로모션 알림 메일 수신(선택)</li>
										<li class="checkBtn"><input type="checkbox" name="chk"
											class="chk"></li>
									</ul>

								</li>
							</ul>
							<ul class="footBtwrap clearfix">
								<li><button class="fpmgBt1" type="reset">초기화</button></li>
								<li><button type="submit" class="fpmgBt2"
										id="userEnrollButton" onclick="return userEnroll();">회원가입</button></li>
							</ul>



						</div>


					</div>

					<input type="hidden" name="checked_id" value="">

				</form>
			</div>





		</div>
	</div>

	
                 <!-- 주소  -->

				 <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
						<!-- 주소 api -->
										
						<script>
							function sample6_execDaumPostcode() {
								new daum.Postcode({
									oncomplete: function(data) {
										// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
						
										// 각 주소의 노출 규칙에 따라 주소를 조합한다.
										// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
										var addr = ''; // 주소 변수
										var extraAddr = ''; // 참고항목 변수
						
										//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
										if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
											addr = data.roadAddress;
										} else { // 사용자가 지번 주소를 선택했을 경우(J)
											addr = data.jibunAddress;
										}
						
						
										// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
										//if(data.userSelectedType === 'R'){
											if( !(data.userSelectedType == 'R' )){
											/*
											// 법정동명이 있을 경우 추가한다. (법정리는 제외)
											// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
											if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
												extraAddr += data.bname;
											}
											// 건물명이 있고, 공동주택일 경우 추가한다.
											
											if(data.buildingName !== '' && data.apartment === 'Y'){
												extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
											}
											 //표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
											if(extraAddr !== ''){
												 extraAddr = ' (' + extraAddr + ')';
											}
											 //조합된 참고항목을 해당 필드에 넣는다.
											 document.getElementById("address3").value = extraAddr;
											 */
										
										//} else {
											document.getElementById("address3").value = '';
										}
						
										// 우편번호와 주소 정보를 해당 필드에 넣는다.
										document.getElementById('address1').value = data.zonecode;
										document.getElementById("address2").value = addr;
										// 커서를 상세주소 필드로 이동한다.
										document.getElementById("address3").focus();
									}
								}).open();
							}
						</script>


						<!-- 아이디 중복확인 클릭 여부 -->
						<script>
							$("#idCheckBtn").click(function(){

								$("input[name=checked_id]").val('y');

							})
							
						</script>

						<!-- 비밀번호 정규표현식  -->
						<script>
							function userEnroll() {
								
								const pwdInputf = document.getElementById("pwdInput"); //pwdInput -> 비밀번호 
								const pwdInputCheckf = document.querySelector("#pwdInputCheck"); //pwdInputCheck -> 비밀번호 확인

								//약관동의
								const check01= document.getElementById("check01");
								const check02 = document.getElementById("check02");

								const check01_checked = check01.checked;
								const check02_checked = check02.checked;

								//아이디 중복확인했나 확인
								if($("input[name='checked_id']").val()==''){
									alert('아이디중복 확인을 해주세요.');
									$("input[name='checked_id']").eq(0).focus();
									return false;
									}
						
								
						
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

								//이용약관 동의 여부 체크
								if ((check01.checked && check02.checked) != true ) {
									alert("이용약관에 동의하지 않으셧습니다.");
									return false;
								}

							}
						</script>

<script>
        
        // 생일 유효성 검사
    	var birthJ = false;
    	
    	// 생년월일	birthJ 유효성 검사
    		var dateStr = $('#birthDateInput').val();		
    	    var year = Number(dateStr.substr(0,4)); // 입력한 값의 0~4자리까지 (연)
    	    var month = Number(dateStr.substr(4,2)); // 입력한 값의 4번째 자리부터 2자리 숫자 (월)
    	    var day = Number(dateStr.substr(6,2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일)
    	    var today = new Date(); // 날짜 변수 선언
    	    var yearNow = today.getFullYear(); // 올해 연도 가져옴
    		
    	    if (dateStr.length <=8) {
    			// 1900년~올해
    		    if (1900 > year || year > yearNow){
    		    	
    		    	alert('유효하지 않은 생년월일을 입력하셨습니다');
                    birthDateInput.value="";
                    return false;
    		    	
    		    }else if (month < 1 || month > 12) {
    		    		
                    alert('유효하지 않은 생년월일을 입력하셨습니다');
                    birthDateInput.value="";
                    return false;
    		    
    		    }else if (day < 1 || day > 31) {
    		    	
    		    	alert('유효하지 않은 생년월일을 입력하셨습니다');
                    birthDateInput.value="";
                    return false;
    		    	
    		    }else if ((month==4 || month==6 || month==9 || month==11) && day==31) {
    		    	 
                    alert('유효하지 않은 생년월일을 입력하셨습니다');
                    birthDateInput.value="";
                    return false;
    		    	 
    		    }else if (month == 2) {
    		    	 
    		       	var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    		       	
    		     	if (day>29 || (day==29 && !isleap)) {
    		     		
                        alert('유효하지 않은 생년월일을 입력하셨습니다');
                        birthDateInput.value="";
                        return false;
    		    	
    				}else{
    					$('#birth_check').text('');
    					birthJ = true;
    				}//end of if (day>29 || (day==29 && !isleap))
    		     	
    		    }else{
    		    	
    		    	$('#birth_check').text(''); 
    				birthJ = true;
    			}
    			
    			}else{
    				//1.입력된 생년월일이 8자 초과할때 :  auth:false
    				alert('유효하지 않은 생년월일을 입력하셨습니다');
    			}
    	    
    
    		;
    </script>
    
    <!-- ------------------------------------------------------------------------------------------------- -->
    
    <Script>
	
		function idCheck(){
 			
 			const idInputf = document.getElementById("idInput");

			// id : 소문자,숫자로 5~12글자
			let regExp = /^(?=.*[a-z])(?=.*\d)[a-z\d]{5,12}$/;
	
			if (!regExp.test(idInputf.value)) {
				alert('유효하지 않은 id를 입력하셨습니다.');
				idInput.select();
				return false;
			}
			
			
 			const $idInput = $("#enroll-form input[name=memId]");
 			
 			$.ajax({
 				url:"idCheck.me",
 				data:{checkId:$idInput.val()},
 				success:function(result){
 					console.log(result)
 					
 					if(result == "NNNNN"){
 		 				alert("이미 사용중인 아이디입니다.")
                        $idInput.val("")
                        $idInput.focus()
 		 			}else if(result == "NNNNY"){
 		 				if($idInput.val() != null){
	 		 				if(confirm("이 아이디를 사용하시겠습니까?")){
	 		 					$idInput.attr("readonly", true)
	 		 					$("#enroll-form :submit").attr("disabled", false);
	 		 					$("#enroll-form :submit").removeAttr("disabled");
	 		 					$idInput.css("backgroundColor", "lightblue")
	 		 				}else { // 취소
	 		 					$idInput.val("")
	 	                        $idInput.focus()
	 	                        $idInput.css("backgroundColor", "")
	 	                       	$idInput.removeAttr("readonly").focus();
	 		 				}
 		 					
 		 				}
 		                
 		            }
 				},
 				
 			});
 			
 			
            
		}
	</Script>

    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
</body>


</html>