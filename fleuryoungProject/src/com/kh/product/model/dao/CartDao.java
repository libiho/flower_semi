package com.kh.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.member.model.dao.MemberDao;
import com.kh.product.model.vo.Cart;

import static com.kh.common.JDBCTemplate.*;

public class CartDao {

	Properties prop = new Properties();

	public CartDao() {
		try {

			String filePath = MemberDao.class.getResource("/db/sql/product-mapper.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMemberCart(Connection conn, Cart cart) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertMemberCart");
		System.out.println("dao :" + cart);
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cart.getOpt1stNo());
			pstmt.setInt(2, cart.getOpt2ndNo());
			pstmt.setString(3, cart.getOpt2Title());
			pstmt.setInt(4, cart.getOptCount());
			pstmt.setInt(5, cart.getOptPrice());
			pstmt.setInt(6, cart.getNoneOptCount());
			pstmt.setInt(7, cart.getpId());
			pstmt.setString(8, cart.getMemId());
			pstmt.setString(9, "NONE");

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Cart selectCheckCart(Connection conn, Cart cart) {

		Cart newCart = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		if (cart.getOpt1stNo() != 0) {
			sql = prop.getProperty("selectOptCart");
		} else {
			sql = prop.getProperty("selectDefaultCart");
		}

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cart.getMemId());
			pstmt.setInt(2, cart.getpId());
			if (cart.getOpt1stNo() != 0) {
				pstmt.setInt(3, cart.getOpt2ndNo());
			}

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (cart.getOpt1stNo() != 0) {
					newCart = new Cart(rs.getInt("OPTION_2ND_NO"), rs.getInt("OPTION_STOCK"), rs.getInt("P_ID"));
				} else {
					newCart = new Cart(rs.getInt("NON_OPTION_STOCK"), rs.getInt("P_ID"));
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return newCart;
	}

	public int updateCart(Connection conn, Cart origincart, Cart addCart) {

		int result = 0;
		int newOptStock = origincart.getOptCount() + addCart.getOptCount();
		int newDefaultStock = origincart.getNoneOptCount() + addCart.getNoneOptCount();

		PreparedStatement pstmt = null;

		String sql = "";

		if (origincart.getOpt1stNo() != 0) {
			sql = prop.getProperty("updateOptCart");
		} else {
			sql = prop.getProperty("updateDefaultCart");
		}

		try {
			pstmt = conn.prepareStatement(sql);

			if (origincart.getOpt1stNo() != 0) {
				pstmt.setInt(1, newOptStock);
				pstmt.setString(2, origincart.getMemId());
				pstmt.setInt(3, addCart.getOpt2ndNo());
				pstmt.setInt(4, addCart.getpId());
			} else {
				pstmt.setInt(1, newDefaultStock);
				pstmt.setString(2, origincart.getMemId());
				pstmt.setInt(3, addCart.getpId());
			}

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Cart> selectCart(Connection conn, String memId) {

		ArrayList<Cart> list = new ArrayList<Cart>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectCart");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Cart(rs.getInt("SEL_NO"), rs.getInt("P_ID"), rs.getString("MEM_ID"),
						rs.getString("P_NAME"), rs.getString("SEL_STORE_NAME"), rs.getInt("OPTION_1ND_NO"),
						rs.getString("OPTION_TITLE"), rs.getString("OPTION_CONTENT"), rs.getInt("OPTION_2ND_NO"),
						rs.getInt("OPTION_PRICE"), rs.getInt("OPTION_STOCK"), rs.getInt("NON_OPTION_STOCK"),
						rs.getInt("P_NETPRICE"), rs.getString("IMG")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

	public int ajaxCartUpdate(Connection conn, int opt1No, int opt2No, int pId, String memId, int updateCount) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "";

		if (opt1No != 0) {
			sql = prop.getProperty("updateOptCart");
		} else {
			sql = prop.getProperty("updateDefaultCart");
		}

		try {
			pstmt = conn.prepareStatement(sql);

			if (opt1No != 0) {
				pstmt.setInt(1, updateCount);
				pstmt.setString(2, memId);
				pstmt.setInt(3, opt2No);
				pstmt.setInt(4, pId);
			} else {
				pstmt.setInt(1, updateCount);
				pstmt.setString(2, memId);
				pstmt.setInt(3, pId);
			}

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public String[] ajaxSelectCountPrice(Connection conn, int opt1No, int opt2No, int pId, String memId,
			int updateCount) {

		String[] arr = new String[3];

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		if (opt1No != 0) {
			sql = prop.getProperty("ajaxSelectOptionPrice");
		} else {
			sql = prop.getProperty("ajaxSelectPrice");
		}

		try {
			pstmt = conn.prepareStatement(sql);

			if (opt1No != 0) {
				pstmt.setString(1, memId);
				pstmt.setInt(2, opt2No);
				pstmt.setInt(3, pId);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					arr[0] = rs.getString("OPTION_PRICE" + "");
					arr[1] = rs.getString("OPTION_STOCK" + "");
					arr[2] = rs.getString("P_NETPRICE" + "");
				}
			} else {
				pstmt.setString(1, memId);
				pstmt.setInt(2, pId);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					arr[0] = rs.getString("NON_OPTION_STOCK" + "");
					arr[1] = rs.getString("P_NETPRICE" + "");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return arr;
	}

	public int ajaxCartDelete(Connection conn, int opt1No, int opt2No, int pId, String memId) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = "";

		if (opt1No != 0) {
			sql = prop.getProperty("ajaxOptDelete");
		} else {
			sql = prop.getProperty("ajaxDelete");
		}

		try {
			pstmt = conn.prepareStatement(sql);

			if (opt1No != 0) {
				pstmt.setInt(1, opt2No);
				pstmt.setInt(2, pId);
				pstmt.setString(3, memId);
			} else {
				pstmt.setInt(1, pId);
				pstmt.setString(2, memId);
			}

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int ajaxSelectDelete(Connection conn, Cart c) {

		int result = 0;
		int opt1No = c.getOpt1stNo();
		int opt2No = c.getOpt2ndNo();
		int pId = c.getpId();
		String memId = c.getMemId();

		PreparedStatement pstmt = null;

		String sql = "";

		if (opt1No != 0) {
			sql = prop.getProperty("ajaxOptDelete");
		} else {
			sql = prop.getProperty("ajaxDelete");
		}

		try {
			pstmt = conn.prepareStatement(sql);

			if (opt1No != 0) {
				pstmt.setInt(1, opt2No);
				pstmt.setInt(2, pId);
				pstmt.setString(3, memId);
			} else {
				pstmt.setInt(1, pId);
				pstmt.setString(2, memId);
			}

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int selectCartCount(Connection conn, String memId) {

		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectCartCount");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("COUNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public int deleteCart(Connection conn, String memId, int pId) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteCart");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);
			pstmt.setInt(2, pId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	

}























