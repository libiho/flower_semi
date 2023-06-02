package com.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class FindIdController
 */
@WebServlet("/findId.me")
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			
			String userName = request.getParameter("member_name");
			String userEmail = request.getParameter("member_email");
			System.out.println(userName);
			System.out.println(userEmail);
			Member idFind = new MemberService().findId(userName, userEmail);
			
			
			if (idFind == null) {
				
				if (userName != null && userEmail != null) {
				  response.setContentType("text/html; charset=UTF-8");

		            PrintWriter out = response.getWriter();

		            out.println("<script>alert('존재하지 않는 회원정보입니다. 다시 입력해 주세요.'); history.go(-1); </script>"); 

		            out.flush(); 
				}
				
			} else {
				//HttpSession session = request.getSession();
				//response.sendRedirect(request.getContextPath() + "/views/main/FindIdResult.jsp");
				
				request.setAttribute("idFind", idFind);
				RequestDispatcher view = request.getRequestDispatcher("/views/main/FindIdResult.jsp");
				view.forward(request, response);
			}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
