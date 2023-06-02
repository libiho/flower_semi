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
import com.kh.member.model.vo.Search;
import com.kh.product.model.vo.Product;

public class MemberDao {

	Properties prop = new Properties();

	public MemberDao() {
		try {

			String filePath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member loginMember(Connection conn, String userId, String userPwd) {

		Member member = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("loginMember");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member(rs.getString("MEM_ID"), rs.getString("MEM_PW"), rs.getString("MEM_EMAIL"),
						rs.getString("MEM_NAME"), rs.getString("MEM_PHONE"), rs.getInt("MEM_POSTAL"),
						rs.getString("MEM_STREET"), rs.getString("MEM_ADDRESS"), rs.getDate("MEM_ENROLL_DATE"),
						rs.getInt("MEM_MILEAGE"), rs.getString("MEM_IMG"), rs.getString("MEM_GET_PHONE"),
						rs.getDate("MEM_BIRTHDATE"), rs.getInt("MEM_GENDER"), rs.getString("MEM_STATUS"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return member;
	}

	public String checkMember(Connection conn, String memId) {

		String result = "";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("checkMember");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getString("MEM_ID");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public Member selectMemberOrderInfo(Connection conn, String memId) {

		Member m = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectMemberOrderInfo");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				m = new Member(rs.getString("MEM_ID"), rs.getString("MEM_NAME"), rs.getString("MEM_EMAIL"),
						rs.getString("MEM_PHONE"), rs.getInt("MEM_POSTAL"), rs.getString("MEM_STREET"),
						rs.getString("MEM_ADDRESS"), rs.getInt("MEM_MILEAGE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return m;
	}

	public ArrayList<Coupon> selectMemberCoupon(Connection conn, String memId) {

		ArrayList<Coupon> couponList = new ArrayList<Coupon>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectMemberCoupon");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				couponList.add(new Coupon(rs.getInt("COU_ID"), rs.getString("COU_NAME"), rs.getString("COU_DETAIL"),
						rs.getDate("COU_REGDATE"), rs.getDate("COU_EXPIRE"), rs.getFloat("COU_DISCOUNT")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return couponList;

	}

	public int addOrder(Connection conn, String memberId, String memName, String memEmail, String memPhone, int postal,
			String street, String address) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("addOrder");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberId);
			pstmt.setInt(2, postal);
			pstmt.setString(3, street);
			pstmt.setString(4, address);
			pstmt.setString(5, memName);
			pstmt.setString(6, memPhone);
			pstmt.setString(7, "");

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int addOrderDetail(Connection conn, String memId, int pId, int opt1No, int opt2No, String opt2Title,
			String opt2Content, int opt2Price, int pNetPrice, int pCount, int optCount, int odId) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("addOrderDetail");

		try {
			pstmt = conn.prepareStatement(sql);

			if (opt1No != 0) {
				pstmt.setInt(1, optCount);
				pstmt.setInt(2, 1);
				pstmt.setInt(3, odId);
				pstmt.setString(4, memId);
				pstmt.setInt(5, opt1No);
				pstmt.setInt(6, opt2No);
				pstmt.setInt(7, pNetPrice);
				pstmt.setString(8, opt2Title);
				pstmt.setInt(9, opt2Price);
				pstmt.setInt(10, pId);
				pstmt.setString(11, opt2Content);
			} else {
				pstmt.setInt(1, pCount);
				pstmt.setInt(2, 1);
				pstmt.setInt(3, odId);
				pstmt.setString(4, memId);
				pstmt.setInt(5, 0);
				pstmt.setInt(6, 0);
				pstmt.setInt(7, pNetPrice);
				pstmt.setString(8, "none");
				pstmt.setInt(9, 0);
				pstmt.setInt(10, pId);
				pstmt.setString(11, "none");
			}

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	public int selectOdId(Connection conn, String memberId) {

		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectOdId");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("ORD_ID");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public int updateMileage(Connection conn, String memberId, int mileage) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateMileage");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, mileage);
			pstmt.setString(2, memberId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertWishList(Connection conn, String memId, int pId) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertWishList");

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

	public int deleteWishList(Connection conn, String memId, int pId) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteWishList");

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

	public int insertkeyword(Connection conn, String memId, String keyWord) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertkeyword");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);
			pstmt.setString(2, keyWord);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Search> selectRealTimeSearch(Connection conn) {

		ArrayList<Search> list = new ArrayList<Search>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectRealTimeSearch");

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Search(rs.getString("SEARCH_KEYWORD")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

	public int updateMember(Connection conn, Member m) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateMember");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getMemName());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getStreet());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getMemId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Member selectMember(Connection conn, String userId) {
		Member m = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		String sql = prop.getProperty("selectMember");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				m = new Member(rs.getString("MEM_ID"), rs.getString("MEM_PW"), rs.getString("MEM_EMAIL"),
						rs.getString("MEM_NAME"), rs.getString("MEM_PHONE"), rs.getInt("MEM_POSTAL"),
						rs.getString("MEM_STREET"), rs.getString("MEM_ADDRESS"), rs.getDate("MEM_ENROLL_DATE"),
						rs.getInt("MEM_MILEAGE"), rs.getString("MEM_IMG"), rs.getString("MEM_GET_PHONE"),
						rs.getDate("MEM_BIRTHDATE"), rs.getInt("MEM_GENDER"), rs.getString("MEM_STATUS"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}

	public int updatePwd(Connection conn, String userId, String userPwd, String updatePwd) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updatePwd");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, updatePwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteMember(Connection conn, String userId, String userPwd) {
		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteMember");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Product> selectLikeArr(Connection conn, String memId) {

		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectLikeArr");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

	public int selectLikeCount(Connection conn, String memId) {

		int size = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectLikeCount");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				size = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return size;
	}

	// 회원가입 찾기 등등
	public int insertMember(Connection conn, Member m) {

		int result = 0;

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMember");

		try {
			pstmt = conn.prepareStatement(sql);

			System.out.println();

			pstmt.setString(1, m.getMemId());
			pstmt.setString(2, m.getMemPw());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getMemName());
			pstmt.setString(5, m.getPhone());
			pstmt.setInt(6, m.getPostal());
			pstmt.setString(7, m.getStreet());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getMemBirthDate2());
			pstmt.setInt(10, m.getGender());

			result = pstmt.executeUpdate();

			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(pstmt);
		}
		return result;

	}

	public Member findId(Connection conn, String userName, String userEmail) {

		Member member = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("findId");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);

			rs = pstmt.executeQuery();
			System.out.println(rs);

			if (rs.next()) {

				member = new Member(rs.getString("MEM_ID"));
				System.out.println(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return member;

	}

	public Member findPw(Connection conn, String member_id, String member_email) {
		Member member = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("findPw");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			pstmt.setString(2, member_email);

			System.out.println(sql);

			rs = pstmt.executeQuery();
			if (rs.next()) {

				member = new Member(rs.getString("MEM_PW"));
//				System.out.println(member);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	public int idCheck(Connection conn, String checkId) {
		// select문 => rset필요, int리턴
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("idCheck");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, checkId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				count = rset.getInt("count");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return count;

	}
}
