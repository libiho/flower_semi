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
 * Servlet implementation class PropsPageController
 */
@WebServlet("/props.pr")
public class PropsPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropsPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		request.setCharacterEncoding("utf-8");
		
		
		ArrayList<Product> list;
		
		ProductService pService = new ProductService();
		
		
		 String value = request.getParameter("value");
		 // 베스트, 리뷰수 버튼의 value
	
		 
		 
		 if(value == null) {
			 // 첫 화면이 로드되면 
			 
			list = pService.selectProductPropsAll();
			
		 }else {
			 
			 if(value.equals("1")) {
				 list = pService.selectReviewOrderProductProps();
				 
			 } else {
				 list = pService.selectSaleOrderProductProps();
			 }
			 
		 }
		
		
		 
		 request.setAttribute("list", list);
	
		 request.getRequestDispatcher("views/type/propsPage.jsp").forward(request, response);
			
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
