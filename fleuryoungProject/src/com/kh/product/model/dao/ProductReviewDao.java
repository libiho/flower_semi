package com.kh.product.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.product.model.vo.ProductReview;

public class ProductReviewDao {
	
	private Properties prop = new Properties();
	
	public ProductReviewDao() {
		try {
			String filePath = ProductReviewDao.class.getResource("/db/sql/productReview-mapper.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<ProductReview> myPageReview(Connection conn, String memId) {
		ArrayList<ProductReview> list = new ArrayList<ProductReview>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("myPageReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new ProductReview(rs.getString("P_NAME")
								   , rs.getInt("ORD_ID") 
								   , rs.getString("REVIEW_DETAIL")
								   , rs.getInt("REVIEW_ID")
							         ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	
	public int updateReview(Connection conn, ProductReview productReview) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMyPageReview");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, productReview.getReviewDetail());
			pstmt.setInt(2, productReview.getReviewId());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
