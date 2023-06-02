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
 * Servlet implementation class DeliveryPageController
 */
@WebServlet("/delivery.de")
public class DeliveryPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryPageController() {
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
		
		String categoryName = request.getParameter("categoryName");
		

		
		if(categoryName == null || categoryName.equals("전체")) {
			list = pService.selectDeliveryAll();
		}else{
			list = pService.selectDeliveryCategory(categoryName);
			
		}
		
		
		 
		 request.setAttribute("list", list);
	
		 request.getRequestDispatcher("views/type/deliveryPage.jsp").forward(request, response);
			
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
