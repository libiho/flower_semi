package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class UpdateWishList
 */
@WebServlet("/updateWishList.m")
public class UpdateWishList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWishList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memId = request.getParameter("memId");
		int pId = Integer.parseInt(request.getParameter("pId"));
		int check = Integer.parseInt(request.getParameter("check"));
		
		System.out.println("체크값 : "  + check);
		
		int result = 0;
		if (check > 0) {
			int chk = new MemberService().insertWishList(memId, pId);
			
			if (chk > 0) {
				result = 1;
			}
		} else {
			int chk = new MemberService().deleteWishList(memId, pId);
			if (chk > 0) {
				result = 0;
			}
		}
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
