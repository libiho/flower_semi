package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.product.model.service.CartService;
import com.kh.product.model.vo.Cart;

import net.sf.json.*;

/**
 * Servlet implementation class AjaxUpdateCartController
 */
@WebServlet("/updateCart.p")
public class AjaxUpdateCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxUpdateCartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int opt1No = Integer.parseInt(request.getParameter("opt1No"));
		int opt2No = Integer.parseInt(request.getParameter("opt2No"));
		int pId = Integer.parseInt(request.getParameter("pId"));
		int count = Integer.parseInt(request.getParameter("count"));
		String memId = request.getParameter("memId");
		String active = request.getParameter("active");
		System.out.println(active);
		int updateCount = 0;

		if (active.equals("delete")) { // 삭제
			int result = new CartService().ajaxCartDelete(opt1No, opt2No, pId, memId);

			if (result > 0) {
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(result, response.getWriter());
			} else {
				System.out.println("삭제 실패");
			}

		} else if (active.equals("selectDel")) { // 선택 삭제
			String jsonStr = request.getParameter("jsonData");
			JSONArray jsonArr = new JSONArray();
			jsonArr = JSONArray.fromObject(jsonStr);

			ArrayList<Cart> deleteList = new ArrayList<Cart>();

			for (int i = 0; i < jsonArr.size(); i++) { // 옵션 있을때
				if(!jsonArr.getJSONObject(i).isNullObject()) {
					JSONObject jsonObj = jsonArr.getJSONObject(i);
					int opt1Num = jsonObj.getInt("opt1No");
					int opt2Num = jsonObj.getInt("opt2No");
					int productId = jsonObj.getInt("pId");
					
					deleteList.add(new Cart(memId, productId, opt1Num, opt2Num));
				}
			}

			int deleteSucces = 0;
			int pram = 100;

			for (Cart c : deleteList) {
				int result = new CartService().ajaxSelectDelete(c);

				if (result > 0) {
					System.out.println((deleteSucces + 1) + "번째 삭제 성공");
				} else {
					System.out.println((deleteSucces + 1) + "번째 삭제 실패");
					break;
				}
				deleteSucces += 1;

			}

			if (deleteList.size() == deleteSucces) {
				System.out.println("선택 삭제 성공");

			} else {
				System.out.println("선택 삭제 실패");
			}

			response.setContentType("application/json; charset=utf-8");
			new Gson().toJson(pram, response.getWriter());

		} else {
			if (active.equals("plus")) {
				updateCount = count + 1;
			} else {
				if (count > 1) {
					updateCount = count - 1;
				} else {
					updateCount = 1;
				}
			}

			int result = new CartService().ajaxCartUpdate(opt1No, opt2No, pId, memId, updateCount);

			String[] arr = null;

			if (result > 0) {
				arr = new CartService().ajaxSelectCountPrice(opt1No, opt2No, pId, memId, updateCount);
				System.out.println(Arrays.toString(arr));
			} else {
				System.out.println("장바구니 수정 실패!!");
			}

			response.setContentType("application/json; charset=utf-8");
			new Gson().toJson(arr, response.getWriter());

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
