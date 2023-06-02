package com.kh.product.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.kh.product.model.dao.ProductDao;
import com.kh.product.model.vo.Category;
import com.kh.product.model.vo.Inquiry;
import com.kh.product.model.vo.Order;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.ProductOption;
import com.kh.product.model.vo.Review;

public class ProductService {

	public ArrayList<Product> selectLatestProduct() {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectLatestProduct(conn);

		close(conn);

		return list;

	}

	public ArrayList<Product> selectSaleOrderProduct() {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectSaleOrderProduct(conn);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectReviewOrderProduct() {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectReviewOrderProduct(conn);

		close(conn);

		return list;
	}

	public Product selectProductDetail(int pid) {

		Connection conn = getConnection();

		Product p = new ProductDao().selectProductDetail(conn, pid);

		close(conn);

		return p;
	}

	public ArrayList<ProductOption> selectProductOption(int pid) {

		Connection conn = getConnection();

		ArrayList<ProductOption> optList = new ProductDao().selectProductOption(conn, pid);

		close(conn);

		return optList;
	}

	public ArrayList<Review> selectProductReview(int pid) {

		Connection conn = getConnection();

		ArrayList<Review> reviewList = new ProductDao().selectProductReview(conn, pid);

		close(conn);

		return reviewList;
	}

	public ArrayList<Inquiry> selectProductInquiry(int pid) {

		Connection conn = getConnection();

		ArrayList<Inquiry> inquiryList = new ProductDao().selectProductInquiry(conn, pid);

		close(conn);

		return inquiryList;

	}

	public ArrayList<Product> selectSearchList(String keyword) {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectSearchList(conn, keyword);

		close(conn);

		return list;
	}

	public int selectReivewCheck(String memId, int pid) {

		Connection conn = getConnection();

		int result = new ProductDao().selectReivewCheck(conn, memId, pid);

		close(conn);

		return result;
	}

	public int selectOrderCheck(String memId, int pid) {
		Connection conn = getConnection();

		int result = new ProductDao().selectOrderCheck(conn, memId, pid);

		close(conn);

		return result;
	}

	public int selectOrderId(String memId, int pId) {

		Connection conn = getConnection();

		int result = new ProductDao().selectOrderId(conn, memId, pId);

		close(conn);

		return result;
	}

	public int insertReview(int pId, int rating, String textBox, int odId) {

		Connection conn = getConnection();

		int result = new ProductDao().insertReview(conn, pId, rating, textBox, odId);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	public int selectReviewCount(int pid) {

		Connection conn = getConnection();

		int result = new ProductDao().selectReviewCount(conn, pid);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

	// 마이 페이지
	public ArrayList<Product> wishList(String mId) {
		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().wishList(conn, mId);

		close(conn);

		return list;
	}

	public ArrayList<Order> orderList(String memId) {
		Connection conn = getConnection();

		ArrayList<Order> list = new ProductDao().orderList(conn, memId);

		close(conn);

		return list;
	}

	public ArrayList<Product> myPageReview(String memId) {
		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().myPageReview(conn, memId);

		close(conn);

		return list;
	}

	public ArrayList<Review> selectSortReview(int pId, String sort) {

		Connection conn = getConnection();

		ArrayList<Review> list = new ProductDao().selectSortReview(conn, pId, sort);

		close(conn);

		return list;
	}

	// 메인 페이지관련
	public ArrayList<Category> selectCategory() {

		Connection conn = getConnection();

		ArrayList<Category> categoryList = new ProductDao().selectCategory(conn);

		close(conn);

		return categoryList;
	}

	public ArrayList<Product> selectProductType(int categoryNo) {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectProductType(conn, categoryNo);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectProductAll() {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectProductAll(conn);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectPriceOver(int amountValue) {
		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectPriceOver(conn, amountValue);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectPriceLess(int amountValue) {
		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectPriceLess(conn, amountValue);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectDeliveryAll() {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectDeliveryAll(conn);

		close(conn);

		return list;

	}

	public ArrayList<Product> selectDeliveryCategory(String categoryName) {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectDeliveryCategory(conn, categoryName);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectGiftAll(int orderSelect) {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectGiftAll(conn, orderSelect);

		close(conn);

		return list;

	}

	public ArrayList<Product> selectGiftType(String giftName) {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectGiftType(conn, giftName);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectGiftTypeOption(String giftName, int orderSelect) {
		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectGiftTypeOption(conn, giftName, orderSelect);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectProductTypeOrderBy(int value, int orderSelect) {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectProductTypeOrderBy(conn, value, orderSelect);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectProductPropsAll() {
		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectProductPropsAll(conn);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectReviewOrderProductProps() {
		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectReviewOrderProductProps(conn);

		close(conn);

		return list;
	}

	public ArrayList<Product> selectSaleOrderProductProps() {

		Connection conn = getConnection();

		ArrayList<Product> list = new ProductDao().selectSaleOrderProductProps(conn);

		close(conn);

		return list;
	}

}
