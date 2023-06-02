package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.member.model.vo.Coupon;
import com.kh.member.model.vo.Member;
import com.kh.product.model.vo.Product;

public class CouponDao {
	
	Properties prop = new Properties();

	public CouponDao() {
		try {
			
			String filePath = MemberDao.class.getResource("/db/sql/coupon-mapper.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int countCoupon(Connection conn, String memId) {
		int c = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("countCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				c = rs.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return c;
	}
	
	

}
