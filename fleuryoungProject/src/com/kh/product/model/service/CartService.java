package com.kh.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.product.model.dao.CartDao;
import com.kh.product.model.vo.Cart;

import oracle.net.aso.p;

import static com.kh.common.JDBCTemplate.*;

public class CartService {

	public int insertMemberCart(Cart c) {
		Connection conn = getConnection();
		
		int result = new CartDao().insertMemberCart(conn, c);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	public Cart selectCheckCart(Cart cart) {
		
		Connection conn = getConnection();
		
		Cart newCart = new CartDao().selectCheckCart(conn, cart);
		
		close(conn);
		
		return newCart;
	}

	
	public int updateCart(Cart origincart, Cart addCart) {
		
		Connection conn = getConnection();
		
		int result = new CartDao().updateCart(conn, origincart, addCart);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	public ArrayList<Cart> selectCart(String memId) {
		
		Connection conn = getConnection();
		
		ArrayList<Cart> list = new CartDao().selectCart(conn, memId);
		
		close(conn);
		
		return list;
	}


	public int ajaxCartUpdate(int opt1No, int opt2No, int pId, String memId, int updateCount) {
		
		Connection conn = getConnection();
		
		int result = new CartDao().ajaxCartUpdate(conn, opt1No, opt2No, pId, memId, updateCount);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	public String[] ajaxSelectCountPrice(int opt1No, int opt2No, int pId, String memId, int updateCount) {

		Connection conn = getConnection();
		
		String[] arr = new CartDao().ajaxSelectCountPrice(conn, opt1No, opt2No, pId, memId, updateCount);
		
		close(conn);
		
		return arr;
	}


	public int ajaxCartDelete(int opt1No, int opt2No, int pId, String memId) {

		Connection conn = getConnection();
		
		int result = new CartDao().ajaxCartDelete(conn, opt1No, opt2No, pId, memId);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	public int ajaxSelectDelete(Cart c) {
		
		Connection conn = getConnection();
		
		int result = new CartDao().ajaxSelectDelete(conn, c);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	public int selectCartCount(String memId) {

		Connection conn = getConnection();
		
		int result = new CartDao().selectCartCount(conn, memId);
		
		close(conn);
		
		return result;
		
	}


	public int deleteCart(String memId, int pId) {

		Connection conn = getConnection();
		
		int result = new CartDao().deleteCart(conn, memId, pId);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}




	

}


















