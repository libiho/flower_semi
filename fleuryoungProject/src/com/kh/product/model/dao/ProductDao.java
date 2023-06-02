package com.kh.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.product.model.vo.Category;
import com.kh.product.model.vo.Inquiry;
import com.kh.product.model.vo.Order;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.ProductOption;
import com.kh.product.model.vo.Review;

import static com.kh.common.JDBCTemplate.*;

public class ProductDao {

	private Properties prop = new Properties();

	public ProductDao() {
		try {

			String filePath = ProductDao.class.getResource("/db/sql/product-mapper.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Product> selectLatestProduct(Connection conn) {

		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectLatestProduct");

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"),
						rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Product> selectSaleOrderProduct(Connection conn) {
		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectSaleOrderProduct");

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"),
						rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Product> selectReviewOrderProduct(Connection conn) {
		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectReviewOrderProduct");

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"),
						rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public Product selectProductDetail(Connection conn, int pid) {

		Product p = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectProductDetail");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				p = new Product(rs.getInt("P_ID"), rs.getInt("SEL_NO"), rs.getString("STORE_NAME"),
						rs.getString("P_NAME"), rs.getInt("P_STOCK"), rs.getInt("REVIEW_RATING"), rs.getInt("COUNT"),
						rs.getString("P_NETPRICE"), rs.getString("P_Day_Delivery"), rs.getString("IMAGES"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return p;
	}

	public ArrayList<ProductOption> selectProductOption(Connection conn, int pid) {

		ArrayList<ProductOption> optList = new ArrayList<ProductOption>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectProductOption");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				optList.add(new ProductOption(rs.getInt("OPTION_1ND_NO"), rs.getInt("OPTION_2ND_NO"),
						rs.getString("OPTION_TITLE"), rs.getString("OPTION_2ND_CONTENT"), rs.getInt("OPTION_2ND_PRICE"),
						rs.getInt("OPTION_2ND_STOCK")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return optList;
	}

	public ArrayList<Review> selectProductReview(Connection conn, int pid) {

		ArrayList<Review> reviewList = new ArrayList<Review>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectProductReview");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				reviewList.add(new Review(rs.getInt("P_ID"), rs.getInt("REVIEW_ID"), rs.getInt("REVIEW_RATING"),
						rs.getString("CONTENT"), rs.getString("MEM_ID"), rs.getString("DATE"), rs.getInt("OD_ID")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return reviewList;
	}

	public ArrayList<Inquiry> selectProductInquiry(Connection conn, int pid) {

		ArrayList<Inquiry> inquiryList = new ArrayList<Inquiry>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectProductInquiry");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				inquiryList.add(new Inquiry(rs.getInt("P_ID"), rs.getString("MEM_ID"), rs.getString("MEM_NAME"),
						rs.getInt("INQUIRY_ID"), rs.getInt("INQUIRY_TYPE"), rs.getString("INQUIRY_TITLE"),
						rs.getString("INQUIRY_COMMENT")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return inquiryList;
	}

	public ArrayList<Product> selectSearchList(Connection conn, String keyword) {

		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectSearchList");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, keyword);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"),
						rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectReivewCheck(Connection conn, String memId, int pid) {

		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectReivewCheck");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);
			pstmt.setInt(2, pid);

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

	public int selectOrderCheck(Connection conn, String memId, int pid) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectOrderCheck");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);
			pstmt.setInt(2, pid);

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

	public int selectOrderId(Connection conn, String memId, int pId) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectOrderId");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);
			pstmt.setInt(2, pId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("OD_ID");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return result;
	}

	public int insertReview(Connection conn, int pId, int rating, String textBox, int odId) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pId);
			pstmt.setInt(2, rating);
			pstmt.setString(3, textBox);
			pstmt.setString(4, "none");
			pstmt.setString(5, "none");
			pstmt.setInt(6, odId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectReviewCount(Connection conn, int pid) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectReviewCount");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, pid);

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

	public ArrayList<Product> wishList(Connection conn, String mId) {
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("wishList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new Product(rs.getString("P_NAME")
								   , (rs.getInt("P_NETPRICE") + "") 
								   , rs.getString("P_IMG1")
							 	   , rs.getInt("DISCOUNT")
							       , rs.getInt("TOTAL")
							       , rs.getInt("P_ID")
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

	public ArrayList<Order> orderList(Connection conn, String memId) {
		
		ArrayList<Order> list = new ArrayList<Order>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("orderList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new Order(rs.getString("P_NAME")
						           , rs.getInt("ORD_ID")
								   , rs.getInt("OD_COUNT") 
							 	   , rs.getString("MEM_ID")
							 	   , rs.getInt("OPTION_1ND_NO")
							 	   , rs.getInt("OPTION_2ND_NO")
							 	   , rs.getInt("OD_PRICE")
							 	   , rs.getString("OPTION_2ND_TITLE")
							 	   , rs.getInt("OPTION_PRICE")
							 	   , rs.getInt("P_ID")
							 	   , rs.getString("OPTION_2ND_CONTENT")
							 	   , rs.getString("P_IMG1")
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

	public ArrayList<Product> myPageReview(Connection conn, String memId) {
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("myPageReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new Product(rs.getString("P_NAME")
								   , rs.getInt("ORD_ID") 
								   , rs.getString("REVIEW_DETAIL")
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

	public ArrayList<Review> selectSortReview(Connection conn, int pId, String sort) {
		
		ArrayList<Review> reviewList = new ArrayList<Review>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";
		
		if (sort.equals("desc")) {
			 sql = prop.getProperty("reviewSortDesc");
		} else {
			 sql = prop.getProperty("reviewSortAsc");
		}

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pId);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				reviewList.add(new Review(rs.getInt("P_ID"), rs.getInt("REVIEW_ID"), rs.getInt("REVIEW_RATING"),
						rs.getString("CONTENT"), rs.getString("MEM_ID"), rs.getString("DATE"), rs.getInt("OD_ID")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return reviewList;
	}



	// 메인 페이지
	public ArrayList<Category> selectCategory(Connection conn) {
		
		
		ArrayList<Category> categoryList = new ArrayList<Category>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("selectCategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				categoryList.add(new Category(
						
						
						rset.getInt("CATEGORY_NO")
						, rset.getString("CATEGORY_DETAIL")
						, rset.getString("CATEGORY_NAME")
						
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return categoryList;
	}

	public ArrayList<Product> selectProductType(Connection conn, int categoryNo) {
		
		
		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectProductType");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, categoryNo);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
		
		
	
	}

	public ArrayList<Product> selectProductAll(Connection conn) {

		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectProductAll");

		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
		
	}

	public ArrayList<Product> selectPriceOver(Connection conn, int amountValue) {
		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectPriceOver");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, amountValue);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Product> selectPriceLess(Connection conn, int amountValue) {
		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectPriceLess");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, amountValue);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Product> selectDeliveryAll(Connection conn) {
		
		
		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectDeliveryAll");

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Product> selectDeliveryCategory(Connection conn, String categoryName) {
	
		
		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectDeliveryCategory");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, categoryName);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Product> selectGiftAll(Connection conn, int orderSelect) {
		
		String SQL = "";

		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		if(orderSelect==2) { // 판매순
			SQL = "selectGiftAllSale";
		}else if(orderSelect==3) { //  리뷰순
			SQL = "selectGiftAllReview";
		}else { // 최신순
			SQL = "selectGiftAllEnroll";
		}

		String sql = prop.getProperty(SQL);

		try {
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
		

	}

	public ArrayList<Product> selectGiftType(Connection conn, String giftName) {


		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectGiftType");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, giftName);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
		
	}

	public ArrayList<Product> selectGiftTypeOption(Connection conn, String giftName, int orderSelect) {
		
		String SQL = "";

		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;


		if(orderSelect==2) { // 판매순
			SQL = "selectGiftSaleOption";
		}else if(orderSelect==3) { //  리뷰순
			SQL = "selectGiftReviewOption";
		}else { // 최신순
			SQL = "selectGiftEnrollOption";
		}

		String sql = prop.getProperty(SQL);

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, giftName);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Product> selectProductTypeOrderBy(Connection conn, int value, int orderSelect) {
		
		String SQL = "";

		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;


		if(orderSelect==2) { // 판매순
			SQL = "selectProductTypeSale";
		}else if(orderSelect==3) { //  리뷰순
			SQL = "selectProductTypeReview";
		}else { // 최신순
			SQL = "selectProductType";
		}

		String sql = prop.getProperty(SQL);

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, value);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	

	/**
	 * 소품 누르면 나오는 첫 상품들
	 * @param conn
	 * @return
	 */
	public ArrayList<Product> selectProductPropsAll(Connection conn) {
		
		
		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectProductPropsAll");

		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Product> selectReviewOrderProductProps(Connection conn) {
		
		

		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectReviewOrderProductProps");

		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
		
	}

	public ArrayList<Product> selectSaleOrderProductProps(Connection conn) {

		

		ArrayList<Product> list = new ArrayList<Product>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectSaleOrderProductProps");

		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("P_ID"), rs.getString("P_NAME"), rs.getInt("REVIEW_RATING"),
						rs.getInt("COUNT"), rs.getString("P_NETPRICE"), rs.getString("P_IMG1"), rs.getString("P_DAY_DELIVERY")));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
		
	}
}

















