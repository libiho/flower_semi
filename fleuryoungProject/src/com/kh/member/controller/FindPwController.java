package com.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class FindPwController
 */
@WebServlet("/FindPwController")
public class FindPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String member_id = request.getParameter("member_id");
		String member_email = request.getParameter("member_email");
		
		Member findPw  = new MemberService().findPw(member_id, member_email);
		System.out.println(member_id);
		System.out.println(member_email);
		//System.out.println(findPw.getMemPw());
		
		
		if(findPw == null ) {
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('존재하지 않는 회원정보입니다. 다시 입력해 주세요.'); history.go(-1); </script>"); 
            out.flush(); 
		}else {
//			HttpSession session = request.getSession();
//			session.setAttribute("findPw", findPw);
//			response.sendRedirect(request.getContextPath() + "/views/main/FindPwResult.jsp");
			
			request.setAttribute("findPw", findPw);
			RequestDispatcher view = request.getRequestDispatcher("/views/main/FindPwResult.jsp");
			view.forward(request, response);
			
		}
		
		/*
		else {
		String host = "smtp.naver.com";
		String user = "lch759"; //자신의 네이버 계정
        String password = "gkdlqmflemdhalfl";
        
        String to_email = member_email;
        
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.trust", host);
        
        StringBuffer temp =new StringBuffer();
        Random rnd = new Random();
        for(int i=0;i<10;i++)
        {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
            case 0:
                // a-z
                temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                break;
            case 1:
                // A-Z
                temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                break;
            case 2:
                // 0-9
                temp.append((rnd.nextInt(10)));
                break;
            }
        }
        String AuthenticationKey = temp.toString();
        System.out.println(AuthenticationKey);
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(user, "Flieuryoung"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
            
            //메일 제목
            msg.setSubject("안녕하세요 KH BOOKS 인증 메일입니다.");
            //메일 내용
            msg.setText("인증 번호는 :"+temp);
            
            Transport.send(msg);
            System.out.println("이메일 전송");
            
        }catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
        HttpSession saveKey = request.getSession();
        saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
        //패스워드 바꿀때 뭘 바꿀지 조건에 들어가는 id
        request.setAttribute("id", member_id);
        request.getRequestDispatcher("views/main/joinPage.jsp").forward(request, response);
}
*/
		
	}

        
        
        
        
        
        
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
