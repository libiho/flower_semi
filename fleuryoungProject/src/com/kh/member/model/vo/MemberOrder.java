package com.kh.member.model.vo;

import java.util.Date;

public class MemberOrder {
	
	private int ordId;
	private String memId;
	private Date ordDate;
	private int ordPostal;
	private String ordStreet;
	private String ordAddress;
	private String ordName;
	private String ordPhone;
	private String ordRequest;
	
	public MemberOrder() {}

	public int getOrdId() {
		return ordId;
	}

	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public Date getOrdDate() {
		return ordDate;
	}

	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}

	public int getOrdPostal() {
		return ordPostal;
	}

	public void setOrdPostal(int ordPostal) {
		this.ordPostal = ordPostal;
	}

	public String getOrdStreet() {
		return ordStreet;
	}

	public void setOrdStreet(String ordStreet) {
		this.ordStreet = ordStreet;
	}

	public String getOrdAddress() {
		return ordAddress;
	}

	public void setOrdAddress(String ordAddress) {
		this.ordAddress = ordAddress;
	}

	public String getOrdName() {
		return ordName;
	}

	public void setOrdName(String ordName) {
		this.ordName = ordName;
	}

	public String getOrdPhone() {
		return ordPhone;
	}

	public void setOrdPhone(String ordPhone) {
		this.ordPhone = ordPhone;
	}

	public String getOrdRequest() {
		return ordRequest;
	}

	public void setOrdRequest(String ordRequest) {
		this.ordRequest = ordRequest;
	}

	@Override
	public String toString() {
		return "MemberOrder [ordId=" + ordId + ", memId=" + memId + ", ordDate=" + ordDate + ", ordPostal=" + ordPostal
				+ ", ordStreet=" + ordStreet + ", ordAddress=" + ordAddress + ", ordName=" + ordName + ", ordPhone="
				+ ordPhone + ", ordRequest=" + ordRequest + "]";
	};
	
	
	
}
