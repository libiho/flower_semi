package com.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.common.RanNumUtils;
import com.kh.member.model.service.EmailService;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.member.model.service.MemberService;


/**
 * Servlet implementation class CheckEmailController
 */
@WebServlet("/idSelect.eml")
public class CheckEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PrintWriter = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 클래스 이름은 EmailController지만 SellerController 같은곳에 메서드 안에 넣어서 사용 하세요
			
				/*
		        String member_id = request.getParameter("member_id");
				String member_email = request.getParameter("member_email");
		       
		        Member mem = new MemberService().findPw(member_id, member_email);//이메일로 사용자아디 찾아서 객체로 반환 (이메일 확인)
		        
		        if( mem == null ) {
		        	  response.setContentType("text/html; charset=UTF-8");

			            PrintWriter out1 = response.getWriter();

			            out1.println("<script>alert('존재하지 않는 회원정보입니다. 다시 입력해 주세요.'); history.go(-1); </script>"); 

			            out1.flush(); 
				}
				*/
		        
		        request.setCharacterEncoding("UTF-8");
		        response.setContentType("text/html;charset=UTF-8");
		        response.setCharacterEncoding("UTF-8");
		        
		        String uri = request.getRequestURI(); 			// requestURL : @Webservlet("매핑 URL") 
				String ctxPath = request.getContextPath();		// 절대경로 : 디버깅 하거나 System.out.println 으로 찍어보세용
				String cmd = request.getParameter("check");	 //아이디 찾기 비번 찾기 해주는 식별자
				PrintWriter out = response.getWriter();
				
				String user_email = request.getParameter("email");
		        Member mem = new MemberService().findPw(member_id, member_email);
		        
		        // 이메일 인증 매핑
				if(cmd.equals("idSelect")) {
					// 수신 확인
					System.out.println("user_email : " + );
					try {
						if(mem == null) {
							out.write("false");
						} else {
							//인증 번호 생성기
							String title = "비밀번호 찾기";
							String email = mem.getEmail(); 
							
							//랜덤값
					        String AuthenticationKey = new RanNumUtils().ranNum().toString(); //랜덤값 String 형으로 변환
					        System.out.println(AuthenticationKey);
					        
					        //이메일 인증로직. 건들 ㄴㄴ
							String ranNum =  new EmailService().sendEmail(request, response, title, member_email, AuthenticationKey); // 이메일을 조회 하는 로직 후에 MemberDTO형 dto 변수에 담는 객체
						    
							JSONObject jObj = new JSONObject();
						    jObj.put("email", email);
						    jObj.put("ranNum", ranNum);
						    jObj.put("userId", mem.getMemId());
						    response.setContentType("application/json; charset=utf-8");
						    response.getWriter().print(jObj);
						    
						}
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				//이메일로 패스워드 찾기
				else if(cmd.equals("pwdSelect")) {
					// 수신 확인
					System.out.println("user_email : " + member_email);
					try {
						
						if(mem == null) {
							out.write("false");
						}else if(!(mem.getMemPw().equals(new MemberService().findPw(member_id, member_email)))) {
							out.write("false");					
						}else {
							//인증 번호 생성기
							String title = "비밀번호 찾기";
							String email = member_email; 
							System.out.println();
							
							StringBuffer temp =new RanNumUtils().ranNum();
					        String AuthenticationKey = temp.toString();
					        System.out.println(AuthenticationKey);
							String ranNum =  new EmailService().sendEmail(request, response, title, member_email, AuthenticationKey); // 이메일을 조회 하는 로직 후에 MemberDTO형 dto 변수에 담는 객체
						    
							JSONObject jObj = new JSONObject();
						    jObj.put("email", email);
						    jObj.put("ranNum", ranNum);
						    jObj.put("userId", mem.getMemId());
						    response.setContentType("application/json; charset=utf-8");
						    response.getWriter().print(jObj);
						    
						}
					} catch(Exception e) {
						e.printStackTrace();
					}
				
				} else if (cmd.equals("sendEmailProc.mem")) {
					System.out.println("test");
				}
			}

			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
			}
		}
