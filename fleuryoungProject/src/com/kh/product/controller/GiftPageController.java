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
 * Servlet implementation class GiftPageController
 */
@WebServlet("/gift.gi")
public class GiftPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiftPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
request.setCharacterEncoding("utf-8");
		
		
		ArrayList<Product> list;
		String title = "최신순";
		int titleValue = 1;
		
		ProductService pService = new ProductService();
		
		String giftName = request.getParameter("giftName");
		int orderSelect  = 1;
	
				
		
		 if((giftName == null || giftName.equals("전체")) && request.getParameter("orderSelect") == null) {
			 // 버튼 선택x, 전체 선택했을 경우 &&  최신순인 경우
			
			
			list = pService.selectGiftAll(orderSelect);
			 
			System.out.println("버튼x  최신순 -------- 최초 로드");
			
			
				
		 }else if(giftName == null && request.getParameter("orderSelect") != null){
			 // 버튼 선택x && 최신순,판매순,리뷰순 선택한 경우
			
			 System.out.println("버튼선택 xx " + giftName + " select는 oo   " + orderSelect);

			
			 
			 orderSelect  = Integer.parseInt(request.getParameter("orderSelect"));
			 
			 list = pService.selectGiftAll(orderSelect);
			 
			 if (orderSelect == 1) {
					title = "최신순";
					
				} else if(orderSelect == 2) {
					title = "판매순";
					titleValue = 2;
				} else {
					title = "리뷰순";
					titleValue = 3;
				}
			 
			 
			 
			 
		 } else if(!(giftName.equals("전체")) && request.getParameter("orderSelect") == null){
			 // 버튼 선택 && 최신순,판매순,리뷰순은 선택x
			 
			 
			 System.out.println("버튼선택 oo " + giftName + " select는 xx   " + orderSelect);
			 
			
			 list = pService.selectGiftType(giftName);
			
		 }else{
			 // 버튼 + 옵션 선택o
			 
			 
			 orderSelect  = Integer.parseInt(request.getParameter("orderSelect"));
			 System.out.println("버튼선택 oo " + giftName + " select는 oo   " + orderSelect);
			 
			 if(giftName.equals("전체")) {
				 list = pService.selectGiftAll(orderSelect);
				 
				 
			 }else {
				 list = pService.selectGiftTypeOption(giftName,orderSelect);
				
				 if (orderSelect == 1) {
						title = "최신순";
						
					} else if(orderSelect == 2) {
						title = "판매순";
						titleValue = 2;
					} else {
						title = "리뷰순";
						titleValue = 3;
					}
				 
			 }
			 
			
			 
			 
		 }
		 
		 
		 request.setAttribute("giftName", giftName);
		 request.setAttribute("orderSelect", orderSelect);
		 	request.setAttribute("title", title);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/type/giftPage.jsp").forward(request, response);
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
