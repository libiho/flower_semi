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
import com.kh.member.model.vo.Member;
import com.kh.product.model.dao.CartDao;
import com.kh.product.model.service.CartService;
import com.kh.product.model.vo.Cart;

import net.sf.json.*;

/**
 * Servlet implementation class ProductAddCartController
 */
@WebServlet("/addCart.p")
public class ProductAddCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductAddCartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String memId = request.getParameter("memId");
		int pId = Integer.parseInt(request.getParameter("pId"));
		int selNo = Integer.parseInt(request.getParameter("selNo"));
		int opt1stNo = Integer.parseInt(request.getParameter("opt1stNo"));
		int noneOptCount = Integer.parseInt(request.getParameter("count"));

		String jsonStr = request.getParameter("jsonData");
		JSONArray jsonArr = new JSONArray();
		// 문자열 형식의 데이터를 JSONArray로 가공
		jsonArr = JSONArray.fromObject(jsonStr);

		ArrayList<Cart> cartList = new ArrayList<Cart>();

		System.out.println("1번옵션 : " + opt1stNo);

		if (opt1stNo == 0) {
			cartList.add(new Cart(memId, selNo, pId, 0, 0, 0, noneOptCount, "NONE", 0));
		} else {
			for (int i = 0; i < jsonArr.size(); i++) { // 옵션 있을때
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				int opt2ndNo = jsonObj.getInt("opt2ndNo");
				int optCount = jsonObj.getInt("optCount");
				String opt2Title = jsonObj.getString("optTitle");
				int optPrice = jsonObj.getInt("optPrice");
				
				cartList.add(new Cart(memId, selNo, pId, opt1stNo, opt2ndNo, optCount, 0, opt2Title, optPrice));
				
			}
		}
		// 데이터의 길이만큼 반복 및 JSONObject로 변환하며 확인

		if (!memId.equals("")) { // 회원일때
			String getMemId = new MemberService().checkMember(memId);
			if (memId.equals(getMemId)) { // 한번더 체크

				int successUpdate = 0;
				int successInsert = 0;

				for (Cart cart : cartList) { // 장바구니에 해당 상품이 있는지 확인

					Cart newCart = new CartService().selectCheckCart(cart);

					if (newCart != null) { // 상품이 존재할때
						int result = new CartService().updateCart(cart, newCart);

						if (result > 0) {
							System.out.println((successUpdate + 1) + "번째 수정 성공");
						} else {
							System.out.println((successUpdate + 1) + "번째 수정 실패");
							break;
						}
						successUpdate++;

					} else { // 상품 존재하지 않을때 새로 삽입
						int result = new CartService().insertMemberCart(cart);

						if (result > 0) {
							System.out.println((successInsert + 1) + "번째 삽입 성공");
						} else {
							System.out.println((successInsert + 1) + "번째 삽입 실패");
							break;
						}
						successInsert++;
					}
				}

				if (cartList.size() == successUpdate) {
					System.out.println("수정성공");
				} else {
					System.out.println("수정실패");
				}

				if (cartList.size() == successInsert) {
					System.out.println("삽입성공");
				} else {
					System.out.println("삽입실패");
				}
			}
		} else { // 비회원일때

		}

		for (Cart c : cartList) {
			System.out.println(c);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
