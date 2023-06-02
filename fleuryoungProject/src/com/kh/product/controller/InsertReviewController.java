package com.kh.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.product.model.service.ProductService;

/**
 * Servlet implementation class InsertReviewController
 */
@WebServlet("/insertReivew.p")
public class InsertReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memId = request.getParameter("memId");
		int pId = Integer.parseInt(request.getParameter("pId"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		String textBox = request.getParameter("textBox");
		
		ProductService pService = new ProductService();
		
		int odId = pService.selectOrderId(memId, pId);
		
		int result  = 0;
		
		if (odId > 0) {
			result = pService.insertReview(pId, rating, textBox, odId);
			
			response.setContentType("text/html; charset=UTF-8"); // 한글이 있다면 인코딩 처리
			response.getWriter().print(result);
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
