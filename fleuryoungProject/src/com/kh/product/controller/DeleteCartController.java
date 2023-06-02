package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.product.model.service.CartService;
import com.kh.product.model.vo.Cart;

import net.sf.json.*;

/**
 * Servlet implementation class DeleteCartController
 */
@WebServlet("/deleteCart.p")
public class DeleteCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String memberId = request.getParameter("memberId");
		String memName = request.getParameter("memName");
		String memEmail = request.getParameter("memEmail");
		String memPhone = request.getParameter("memPhone");
		int postal = Integer.parseInt(request.getParameter("postal"));
		String street = request.getParameter("street");
		String address = request.getParameter("address");
		int Mileage = Integer.parseInt(request.getParameter("Mileage"));
		
		System.out.println(memberId);
		System.out.println(memName);
		System.out.println(memEmail);
		System.out.println(postal);
		System.out.println(street);
		System.out.println(address);
		System.out.println(Mileage);
		
		int addOrder = new MemberService().addOrder(memberId, memName, memEmail, memPhone, postal, street, address);
		
		System.out.println("주문정보 성공 여부 : " + addOrder);
		
		int odId = 0;
		if (addOrder > 0) {
			odId = new MemberService().selectOdId(memberId);
		}
		
		System.out.println("odId : " + odId);
		
		System.out.println(odId);
		
		String jsonStr = request.getParameter("jsonData");
		JSONArray jsonArr = new JSONArray();
		jsonArr = JSONArray.fromObject(jsonStr);
		
		CartService cartService = new CartService();
		MemberService mService = new MemberService();
		
		int successCount = 0;
		
		for (int i = 0; i < jsonArr.size(); i++) { // 옵션 있을때
			JSONObject jsonObj = jsonArr.getJSONObject(i);
			String memId = jsonObj.getString("memId");
			int pId = jsonObj.getInt("pId");
			int opt1No = jsonObj.getInt("opt1No");
			int opt2No = jsonObj.getInt("opt2No");
			String opt2Title = jsonObj.getString("opt2Title");
			String opt2Content = jsonObj.getString("opt2Content");
			int opt2Price = jsonObj.getInt("opt2Price");
			int pNetPrice = jsonObj.getInt("pNetPrice");
			int pCount = jsonObj.getInt("pCount");
			int optCount = jsonObj.getInt("optCount");
			
			cartService.deleteCart(memId, pId);
			mService.addOrderDetail(memId, pId, opt1No, opt2No, opt2Title, opt2Content, opt2Price, pNetPrice, pCount, optCount, odId);
			System.out.println((i+1) + "번째 삭제 성공");
			successCount+=1;
		}
		
		int result = mService.updateMileage(memberId, Mileage);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
