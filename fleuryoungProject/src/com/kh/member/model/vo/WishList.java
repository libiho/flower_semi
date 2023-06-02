package com.kh.member.model.vo;

import java.sql.Date;

public class WishList {
	private String memId;
	private int pId;
	private Date wishListDate;
	
	public WishList() {}

	public WishList(String memId, int pId, Date wishListDate) {
		super();
		this.memId = memId;
		this.pId = pId;
		this.wishListDate = wishListDate;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public Date getWishListDate() {
		return wishListDate;
	}

	public void setWishListDate(Date wishListDate) {
		this.wishListDate = wishListDate;
	}

	@Override
	public String toString() {
		return "WishList [memId=" + memId + ", pId=" + pId + ", wishListDate=" + wishListDate + "]";
	}
	
	
}
