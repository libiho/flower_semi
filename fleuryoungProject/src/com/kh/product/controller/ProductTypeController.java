package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Category;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class ProductTypeController
 */
@WebServlet("/typePage.mi")
public class ProductTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductTypeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	
	
	// String pCategory = request.getParameter("category");
	
		
		ArrayList<Product> list;
		
		ProductService pService = new ProductService();
		
		
		String title = "최신순";
		
	
		int value = Integer.parseInt(request.getParameter("value"));
		String categoryName = request.getParameter("categoryName");
		
		int orderSelect  = 1;
		
		
		// 아직 최신순등 선택안했을때
	    if (request.getParameter("orderSelect") == null) {
	   
	    
	  
	    	list = pService.selectProductType(value);
	    
	    	 
	    	 
	    	 
	    } else  {
	      
	    	
	    	 orderSelect  = Integer.parseInt(request.getParameter("orderSelect"));
	 	    
	    	
	    		
	    	 list = pService.selectProductTypeOrderBy(value,orderSelect);
			 
			 if (orderSelect == 1) {
					title = "최신순";
				} else if(orderSelect == 2) {
					title = "판매순";
				} else {
					title = "리뷰순";
				}
	    	
		
	    	
	    }
		
	    
	    
	    
	    
	    request.setAttribute("categoryName", categoryName);
	    request.setAttribute("orderSelect", orderSelect);
	 	request.setAttribute("title", title);
	 	 request.setAttribute("value", value);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/type/productType.jsp").forward(request, response);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
