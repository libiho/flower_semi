package com.kh.product.model.vo;

public class ProductReview {
	
	private String pName;
	private int ordId;
	private String reviewDetail;
	private int reviewId;
	
	public ProductReview() {}
	
	public ProductReview(int reviewId, String reviewDeatil) {
		this.reviewId = reviewId;
		this.reviewDetail = reviewDeatil;
	}
	
	public ProductReview(String pName, int ordId, String reviewDeatil, int reviewId) {
		super();
		this.reviewId = reviewId;
		this.reviewDetail = reviewDeatil;
		this.pName = pName;
		this.ordId = ordId;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getOrdId() {
		return ordId;
	}
	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}
	public String getReviewDetail() {
		return reviewDetail;
	}
	public void setReviewDetail(String reviewDetail) {
		this.reviewDetail = reviewDetail;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	@Override
	public String toString() {
		return "ProductReview [pName=" + pName + ", ordId=" + ordId + ", reviewDetail=" + reviewDetail + ", reviewId="
				+ reviewId + "]";
	}
	
}
