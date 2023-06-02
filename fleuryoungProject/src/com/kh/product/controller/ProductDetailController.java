package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Inquiry;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.ProductOption;
import com.kh.product.model.vo.Review;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet("/pdetail.p")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memId = request.getParameter("memId");
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		ProductService pService = new ProductService();
		
		// 상품(가게이름, 상품이름, 별점, 리뷰수, 가격, 옵션 ,상세이미지들)
		Product p = pService.selectProductDetail(pid);
		
		//옵션
		ArrayList<ProductOption> optList = pService.selectProductOption(pid);
		
		// 리뷰
		ArrayList<Review> reviewList = pService.selectProductReview(pid); 
		
		int check = 0;
		
		// 주문 체크
		int reviewChk = pService.selectReivewCheck(memId, pid);
		
		// 리뷰 체크
		int orderChk = pService.selectOrderCheck(memId, pid);
		
		// 리뷰 카운트
		int reviewCount = pService.selectReviewCount(pid);
		
		check = reviewChk * orderChk;
		
		if (reviewChk == 0 && orderChk == 0) {
			check = 0;
 		} else if (reviewChk == 0 && orderChk > 0) {
 			check = 1;
 		} else if (reviewChk > 0 && orderChk > 0) {
 			check = 0;
 		}
		
		
		
		// 문의
		ArrayList<Inquiry> inquiryList = pService.selectProductInquiry(pid);
		
		if (optList.isEmpty()) {
			System.out.println("null");
		}
		//System.out.println(p);
		//System.out.println(optList);
		//System.out.println(reviewList);
		
		request.setAttribute("product", p);
		request.setAttribute("optList", optList);
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("reviewCount", reviewCount);
		request.setAttribute("check", check);
		request.setAttribute("inquiryList", inquiryList);
		request.getRequestDispatcher("views/main/productDetailPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
