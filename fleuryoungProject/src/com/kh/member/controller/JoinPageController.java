package com.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class JoinPageController
 */
@WebServlet("/insert.me")
public class JoinPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
				

			
				
				
				//RequestDispatcher view = request.getRequestDispatcher("views/main/joinPage.jsp");
				//view.forward(request, response);

				
				String memId = request.getParameter("memId"); 
				String memPw = request.getParameter("memPw"); 
				String memName = request.getParameter("memName"); 
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				int postal = Integer.parseInt(request.getParameter("postal"));
				String street = request.getParameter("street");
				String address = request.getParameter("address");
				int gender = Integer.parseInt(request.getParameter("gender"));
				System.out.println(gender);
				String memBirthDate = request.getParameter("memBirthDate");
				System.out.println(memBirthDate);

				Member m = new 	Member(memId, memPw, email , memName,  phone, postal, 
										street, address, memBirthDate, gender  );

				
				
				
				int result = new MemberService().insertMember(m);
				
				if(result>0) {
					
					/*
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('회원가입에 성공하였습니다. 로그인하고 많은 혜택 누리세요!');  </script>"); 
					out.flush();
					*/
					//
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter writer = response.getWriter();
					writer.println("<script>alert('회원가입에 성공하였습니다, 로그인하고 많은 혜택 누리세요!'); location.href='"+"/fleuryoungProject/startPage.p?num=1"+"';</script>"); 
					writer.close();
					
					
					//HttpSession session = request.getSession();
					//session.setAttribute("alertMsg", "성공적으로 회원가입이 되었습니다");
					//response.sendRedirect(request.getContextPath() );
					
					
				}else {
					  //response.setContentType("text/html; charset=UTF-8");

			            PrintWriter out = response.getWriter();

			            out.println("<script>alert('회원가입에 실패하였습니다. 다시 시도해 주세요.'); history.go(-1); </script>"); 
			            

			            out.flush(); 
					RequestDispatcher view = request.getRequestDispatcher("/views/main/joinPage.jsp");
					view.forward(request, response);
				}
				
				
				//RequestDispatcher view = request.getRequestDispatcher("views/main/joinPage.jsp");
				//view.forward(request, response);
				
				

			}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}