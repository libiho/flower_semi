package com.kh.member.model.vo;

import java.sql.Date;

public class Coupon {

	private int couId;
	private String couName;
	private String couDetail;
	private Date couRegDate;
	private Date couExpire;
	private float couDiscount;
	
	private String couImg;		
	private String couCondition1;		
	private String couCondition2;		
	private String couCondition3;		
	private Date couEditDate;		
	private String memId;
	
	public Coupon() {}
	
	public Coupon(int couId, String couName, String couDetail, Date couRegDate, Date couExpire, float couDiscount) {
		super();
		this.couId = couId;
		this.couName = couName;
		this.couDetail = couDetail;
		this.couRegDate = couRegDate;
		this.couExpire = couExpire;
		this.couDiscount = couDiscount;
	}

	public Coupon(int couId, String couName, String couDetail, String couImg, Date couExpire, String couCondition1,
			String couCondition2, String couCondition3, Date couRegDate, Date couEditDate, float couDiscount) {
		super();
		this.couId = couId;
		this.couName = couName;
		this.couDetail = couDetail;
		this.couImg = couImg;
		this.couExpire = couExpire;
		this.couCondition1 = couCondition1;
		this.couCondition2 = couCondition2;
		this.couCondition3 = couCondition3;
		this.couRegDate = couRegDate;
		this.couEditDate = couEditDate;
		this.couDiscount = couDiscount;
	}
	
	public Coupon(int couId, String memId) {
		super();
		this.couId = couId;
		this.memId = memId;
	}
	
	public String getCouImg() {
		return couImg;
	}

	public void setCouImg(String couImg) {
		this.couImg = couImg;
	}

	public String getCouCondition1() {
		return couCondition1;
	}

	public void setCouCondition1(String couCondition1) {
		this.couCondition1 = couCondition1;
	}

	public String getCouCondition2() {
		return couCondition2;
	}

	public void setCouCondition2(String couCondition2) {
		this.couCondition2 = couCondition2;
	}

	public String getCouCondition3() {
		return couCondition3;
	}

	public void setCouCondition3(String couCondition3) {
		this.couCondition3 = couCondition3;
	}

	public Date getCouEditDate() {
		return couEditDate;
	}

	public void setCouEditDate(Date couEditDate) {
		this.couEditDate = couEditDate;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getCouId() {
		return couId;
	}

	public void setCouId(int couId) {
		this.couId = couId;
	}

	public String getCouName() {
		return couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public String getCouDetail() {
		return couDetail;
	}

	public void setCouDetail(String couDetail) {
		this.couDetail = couDetail;
	}

	public Date getCouRegDate() {
		return couRegDate;
	}

	public void setCouRegDate(Date couRegDate) {
		this.couRegDate = couRegDate;
	}

	public Date getCouExpire() {
		return couExpire;
	}

	public void setCouExpire(Date couExpire) {
		this.couExpire = couExpire;
	}

	public float getCouDiscount() {
		return couDiscount;
	}

	public void setCouDiscount(float couDiscount) {
		this.couDiscount = couDiscount;
	}

	@Override
	public String toString() {
		return "Coupon [couId=" + couId + ", couName=" + couName + ", couDetail=" + couDetail + ", couRegDate="
				+ couRegDate + ", couExpire=" + couExpire + ", couDiscount=" + couDiscount + "]";
	}
	
	
	
}
