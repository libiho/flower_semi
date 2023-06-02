package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
	
	private String memId;
	private String memPw;
	private String email;
	private String memName;
	private String phone;
	private int postal; // 우편번호
	private String street;
	private String address;
	private Date enrollDate;
	private int mileage;
	private String memImg;
	private String getPhone;
	private Date memBirthDate1;
	private String memBirthDate2;
	private int gender;
	private String status;
	
	public Member() {}
	
	public Member(String memId, String memPw, String email, String memName, String phone, int postal, String street,
			String address, Date enrollDate, int mileage, String memImg, String getPhone, Date memBirthDate, int gender,
			String status) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.email = email;
		this.memName = memName;
		this.phone = phone;
		this.postal = postal;
		this.street = street;
		this.address = address;
		this.enrollDate = enrollDate;
		this.mileage = mileage;
		this.memImg = memImg;
		this.getPhone = getPhone;
		this.memBirthDate1 = memBirthDate;
		this.gender = gender;
		this.status = status;
	}

	
	
	public Member(String memId, String memName, String email, String phone, int postal, String street, String address,
			int mileage) {
		super();
		this.memId = memId;
		this.email = email;
		this.memName = memName;
		this.phone = phone;
		this.postal = postal;
		this.street = street;
		this.address = address;
		this.mileage = mileage;
	}

	
	
	public Member(String memId, String email, String memName, String phone, String street, String address) {
		super();
		this.memId = memId;
		this.email = email;
		this.memName = memName;
		this.phone = phone;
		this.street = street;
		this.address = address;
	}

	
	public Member(String memId, String memPw, String email, String memName, String phone, int postal, String street,
			String address, String memBirthDate2, int gender) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.email = email;
		this.memName = memName;
		this.phone = phone;
		this.postal = postal;
		this.street = street;
		this.address = address;
		this.memBirthDate2 = memBirthDate2;
		this.gender = gender;
		
	}
	
	public Member(String email, String memName) {
		super();
		this.email = email;
		this.memName = memName;
	}
	
	



	public Member(String memId, String email, String memName) {
		super();
		this.memId = memId;
		this.email = email;
		this.memName = memName;
	}
	
	



	public Member(String memId) {
		super();
		this.memId = memId;
	}
	
	public String getMemBirthDate2() {
		return memBirthDate2;
	}

	public void setMemBirthDate2(String memBirthDate2) {
		this.memBirthDate2 = memBirthDate2;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPostal() {
		return postal;
	}

	public void setPostal(int postal) {
		this.postal = postal;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getMemImg() {
		return memImg;
	}

	public void setMemImg(String memImg) {
		this.memImg = memImg;
	}

	public String getGetPhone() {
		return getPhone;
	}

	public void setGetPhone(String getPhone) {
		this.getPhone = getPhone;
	}

	public Date getMemBirthDate() {
		return memBirthDate1;
	}

	public void setMemBirthDate(Date memBirthDate) {
		this.memBirthDate1 = memBirthDate;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [memId=" + memId + ", memPw=" + memPw + ", email=" + email + ", memName=" + memName + ", phone="
				+ phone + ", postal=" + postal + ", street=" + street + ", address=" + address + ", enrollDate="
				+ enrollDate + ", mileage=" + mileage + ", memImg=" + memImg + ", getPhone=" + getPhone
				+ ", memBirthDate=" + memBirthDate1 + ", gender=" + gender + ", status=" + status + "]";
	} 
	
	
}
