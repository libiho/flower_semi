package com.kh.product.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.product.model.dao.ProductReviewDao;
import com.kh.product.model.vo.ProductReview;


public class ProductReviewService {
	
	public ArrayList<ProductReview> myPageReview(String memId) {
		Connection conn = getConnection();

		ArrayList<ProductReview> list = new ProductReviewDao().myPageReview(conn, memId);

		close(conn);

		return list;
	}

	public int updateReview(ProductReview productReview) {
		
		Connection conn = getConnection();
		
		int result = new ProductReviewDao().updateReview(conn, productReview);
				
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
