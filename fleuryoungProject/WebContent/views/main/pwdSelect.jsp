<%@page import="com.kh.seller.model.vo.Seller" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String contextPath=request.getContextPath(); Seller loginSeller=(Seller)session.getAttribute("loginSeller");
String alertMsg=(String)session.getAttribute("alertMsg"); %>
<!DOCTYPE html>
<html lang="en">
<!-- session 필요 -->

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
<title></title>
<link rel="shortcut icon" href="resources/img/logo.png">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/plugins/fontawesome/css/fontawesome.min.css">
<link rel="stylesheet" href="resources/plugins/fontawesome/css/all.min.css">
<link rel="stylesheet" href="resources/css/style.css">

</head>

<body class="nk-body bg-lighter npc-default has-sidebar no-touch nk-nio-theme">
<div class="main-wrapper login-body">
    <div class="login-wrapper">
        <div class="container">
            <a href="<%= contextPath%>"><img class="img-fluid logo-dark mb-2"
                    src="resources/img/Fleuryoung.png" alt="Logo"></a>
            <div class="loginbox" style="width: 450px">
                <div class="login-right" style="width: 450px">
                    <div class="login-right-wrap" style="width: 450px">
                        <br>
                        <p class="account-subtitle">Fleuryoung에 오신것을 환영합니다!</p>
                        <div class="form-group">
                            <label class="form-control-label">아이디</label>
                            <div class="pass-group">
                                <input type="text" id="selId" class="form-control pass-input"
                                    name="selId" required>

                            </div>
                        </div>
                        <div class="form-group">
                            <label class="form-control-label">이메일</label>
                            <div class="pass-group">
                                <input type="email" id="email" class="form-control pass-input"
                                    name="email" required>

                            </div>
                        </div>
                        <div class="form-group" id="sendNum_Wrapper" style="display: none;">
                            <label class="form-control-label">인증번호</label>

                            <div class="pass-group">
                                <input type="text" id="num" class="form-control-sm" name="certified"
                                    required>
                                <button type="button" class="btn btn-primary btn-sm"
                                    id="btnSubmit">인증확인</button>
                                <input type="hidden" id="modals" data-bs-toggle="modal"
                                    data-bs-target="#signup-modal">
                            </div>
                        </div>

                        <button class="btn btn-lg btn-block btn-primary w-100" type="button"
                            id="btnSendEmail">이메일 인증</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="signup-modal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="text-center mt-2 mb-4">
                    <div class="auth-logo">
                        <a href="<%=contextPath%>" class="logo logo-dark">
                            <span class="logo-lg">
                                <img src="resources/img/logo.png" alt="" height="42">
                            </span>
                        </a>
                    </div>
                </div>
                <form class="px-3" action="#">

                    <div class="mb-3">
                        <label for="emailaddress" class="form-label">새 비밀번호</label>
                        <input class="form-control" type="password" id="password" required
                            placeholder="john@deo.com">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">새 비밀번호 확인</label>
                        <input class="form-control" type="password" required id="checkpwd"
                            placeholder="Enter your password">
                    </div>

                    <div class="mb-3 text-center">
                        <button class="btn btn-primary" id="checked" type="button" >확인</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- js 호출 -->
<script src="resources/js/jquery-3.6.0.min.js"></script>
<script src="resources/js/bootstrap.bundle.min.js"></script>
<script src="resources/js/feather.min.js"></script>
<script src="resources/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="resources/plugins/apexchart/apexcharts.min.js"></script>
<script src="resources/plugins/apexchart/chart-data.js"></script>
<script src="resources/js/script.js"></script>

<script>
    $(function () {
        // 인증번호 받기 버튼  (아이디 찾기 - 이메일 인증)
        let user_id = "";
        let ranNum = "";
        document.getElementById("btnSendEmail").addEventListener("click", function () {
            $.ajax({
                type: "post",
                url: "idSelect.eml",
                data: {
                    email: document.getElementById("email").value,
                    selId: document.getElementById("selId").value,
                    chack: "pwdSelect"
                }
            }).done(function (data) {
                if (data.email == "false") {
                    alert("존재하지 않는 이메일입니다.");
                } else {
                    user_id = data.userId;
                    ranNum = data.ranNum;
                    alert("인증번호를 입력해주세요");
                    document.getElementById("sendNum_Wrapper").style.display = "block";
                    document.getElementById("btnSendEmail").disabled = "disabled";
                }
            }).fail(function (e) {
                console.log(e);
            });


            document.getElementById("btnSubmit").addEventListener("click", function () {
                let verification_number = $("#num").val()
                console.log(verification_number)
                console.log(ranNum)
                if (ranNum == verification_number) {
                    alert("새 비밀번호를 입력하세요.");
                    $("#modals").trigger('click');
                } else {
                    alert("인증번호를 잘못 입력하셨습니다.");
                }
            })
        })
        document.getElementById("checked").addEventListener("click", function () {
            $.ajax({
                type: "post",
                url: "newPwd.eml",
                data: {
                    selId: $("#selId").val(),
                    pass: $("#password").val()
                }
            }).done(function (result) {
                if (result > 0) {

                    alert("비밀번호가 수정되었습니다.");
                    location.href = "<%=contextPath%>/login.se";
                } else {
                    alert("수정 실패");
                    console.log($("#selId").val());
                    console.log($("#password").val());


                }
            })
        })
    })


</script>

</body>

</html>