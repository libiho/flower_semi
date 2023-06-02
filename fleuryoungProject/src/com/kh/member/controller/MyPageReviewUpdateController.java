package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.product.model.service.ProductReviewService;
import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.ProductReview;

/**
 * Servlet implementation class MyPageReviewUpdateController
 */
@WebServlet("/updateReview.my")
public class MyPageReviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageReviewUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 요청 시 전달 값 뽑아서 변수 및 객체에 담기
		String reviewDetail = request.getParameter("reviewDetail");
		int reviewId = Integer.parseInt(request.getParameter("reviewId"));
		
		ProductReview productReview = new ProductReview();
		productReview.setReviewDetail(reviewDetail);
		productReview.setReviewId(reviewId);
		
		int updateP = new ProductReviewService().updateReview(productReview);
		int pram = 100;
		
		if(updateP > 0) { // 성공
			pram = 100;
		} else { // 실패
			pram = 999;
		}
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(pram, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
