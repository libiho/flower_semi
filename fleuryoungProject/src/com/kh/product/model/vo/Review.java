package com.kh.product.model.vo;

public class Review {
	private int pId;
	private int reviewId;
	private int reviewRating;
	private String content;
	private String memId;
	private String date;
	private int odId;
	
	public Review () {}

	public Review(int pId, int reviewId, int reviewRating, String content, String memId, String date, int odId) {
		super();
		this.pId = pId;
		this.reviewId = reviewId;
		this.reviewRating = reviewRating;
		this.content = content;
		this.memId = memId;
		this.date = date;
		this.odId = odId;
	}
	
	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Review [pId=" + pId + ", reviewId=" + reviewId + ", reviewRating=" + reviewRating + ", content="
				+ content + ", memId=" + memId + ", date=" + date + ", odId=" + odId + "]";
	}


	
	
}
