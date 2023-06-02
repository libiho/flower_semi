package com.kh.member.controller;

import java.io.IOException;

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
 * Servlet implementation class MyPageInfoUpdateController
 */
@WebServlet("/myPageInfoUpdate.my")
public class MyPageInfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageInfoUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 요청 시 전달 값 뽑아서 변수 및 객체에 담기
		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String street = request.getParameter("street");
		String address = request.getParameter("address");
		
		Member m = new Member(userId, email, userName, phone, street, address);
		
		Member updateMem = new MemberService().updateMember(m);
		
		if(updateMem == null) { // 실패
			// 에러문구 담아서 에러페이지 포워딩
			request.setAttribute("errorMsg", "회원정보 수정에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("/views/common/error.jsp");
			view.forward(request, response);
		} else { // 성공
			// 성공했다는 alert => 마이페이지 url 재요청
			// session에 담겨있는 loginUser 바꾸는 작업
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMem);
			
			session.setAttribute("alertMsg", "성공적으로 회원정보를 수정했습니다.");
			
			// 마이페이지 => /jsp/myPage.me로 url 재요청
			response.sendRedirect(request.getContextPath() + "/myPageInfo.my");
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
