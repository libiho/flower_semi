package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class StartPageController
 */
@WebServlet("/startPage.p")
public class StartPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memId = request.getParameter("memberId");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String title = "최신순";
		
		ArrayList<Product> list;
		ProductService pService = new ProductService();
		
		if (num == 1) {
			list = pService.selectLatestProduct();
			title = "최신순";
		} else if(num == 2) {
			list = pService.selectSaleOrderProduct();
			title = "판매순";
		} else {
			list = pService.selectReviewOrderProduct();
			title = "리뷰순";
		}

		request.setAttribute("title", title);
		request.setAttribute("optNo", num);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/main/startPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
