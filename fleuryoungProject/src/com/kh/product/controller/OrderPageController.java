package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Coupon;
import com.kh.member.model.vo.Member;
import com.kh.product.model.service.CartService;
import com.kh.product.model.vo.Cart;

/**
 * Servlet implementation class OrderPageController
 */
@WebServlet("/orderPage.p")
public class OrderPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memId = request.getParameter("memId");
		int delivery = Integer.parseInt(request.getParameter("delivery"));
		
		System.out.println(delivery);
		
		Member m = new MemberService().selectMemberOrderInfo(memId);
		ArrayList<Cart> cartList = new CartService().selectCart(memId);
		
		System.out.println("회원 아이디 : " + memId);
		
		ArrayList<Coupon> couponList = new MemberService().selectMemberCoupon(memId);
		
		
		request.setAttribute("member", m);
		request.setAttribute("delivery", delivery);
		request.setAttribute("cartList", cartList);
		request.setAttribute("couponList", couponList);
		request.getRequestDispatcher("views/main/orderPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
