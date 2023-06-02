package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import com.kh.member.model.dao.CouponDao;
import com.kh.member.model.vo.Coupon;
import com.kh.member.model.vo.Member;
import com.kh.product.model.dao.ProductDao;
import com.kh.product.model.vo.Product;

public class CouponService {

	public int countCoupon(String memId) {
		Connection conn = getConnection();

		int c = new CouponDao().countCoupon(conn, memId);

		close(conn);

		return c;
	}

	

}
