<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.nonMember.model.vo.NonMemberOrder"%>
<%
	//String contextPath = request.getContextPath(); 
	
NonMemberOrder orderNoFind = (NonMemberOrder)session.getAttribute("findOrderNo");	
%>
<%
	String alertMsg = (String)request.getAttribute("alertMsg");	
	// 서비스 요청 전 menubar.jsp 로딩시 : null
	// 서비스 성공 후 menubar.jsp 로싱시 : alert로 띄어줄 메세지 문구
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 아이디 찾기 해서 아이디 보여주는 페이지 -->
<head>
    <meta charset="utf-8">
    <title>Fleuryoung</title>
    <link rel="stylesheet" href="../../resources/css/header.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>




<!-- ------------------------------------------------------------------------ -->
    <style>
        #body{
            width: 100%;
            height: 800px;
            margin-top: 120px;
           
            
        }
        body {
  padding: 40px;
}

.separator {
  margin-top: 25px;
  margin-bottom: 50px;
  border: 0;
}

.separator--line {
  border: 0;
  border-bottom: 5px solid green;
  width: 0;
  animation: separator-width 1s ease-out forwards;
}

@keyframes separator-width {
  0% {
    width: 0;
  }
  100% {
    width: 100%;
    
  }
}
#header{
    
    width: 40%;
    margin: auto;

}

a{
    text-decoration: none;
    text-align: center;
    color: rgb(99, 97, 97);
}

#contentBody{
    width: 50%;
    margin: auto;
    height: 500px;
}
#links{
    margin: auto;
    text-align: center;
    margin-top: 120px;
}
#message{
    text-align: center;
}
/* ----------------------------------------------------------------------------------------------------- */



    </style>
</head>

<body class style="padding-right: 0px;">

    <div class="wrap">
        
        <%@ include file="../common/header.jsp"%>
        
        	
        <!-- 철현이형 여기서부터 하시면 되요~ -->

        <div id="body">
            <div id="header" >
                <h1 align="center"><b>주문번호 조회 결과</b>  </h1>
                <hr class="separator separator--line"  align="center">
            </div>
           

            <div id="contentBody" >
                <br>
                <div id="message">
                    <h4 align="center" style="display: inline-block;"><b>고객님의 주문번호는</b></h4>
                    <label for="idResult" align="center" style="display: inline-block; color: blue; font-size: 30px;"><b><%= orderNoFind.getOrd_id() %></b></label><!-- --------------------------------------------------- -->
                 <h4 align="center" style="display: inline-block;"><b>입니다</b></h4> <br><br><br>
                    <a  align="center" href="<%= contextPath %>/loginpage.me" style="text-decoration-line: none; color: rgb(32, 152, 118)">주문조회하기</a>
                </div>
               
    
               
                 
                </div>
                
            </div>
           
        </div>


        
           








         
    </div>

    <script src="../../resources/js/jquery-3.1.1.min.js"></script>
    <script src="../../resources/js/scripts.js"></script>

    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>

</html>