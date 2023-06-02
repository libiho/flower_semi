package com.kh.product.model.vo;

public class Inquiry {
	
	private int pId;
	private String memId;
	private String memName;
	private int inquiryId;
	private int inquiryType;
	private String inquiryTitle;
	private String inquiryContent;
	
	public Inquiry () {}

	public Inquiry(int pId, String memId, String memName, int inquiryId, int inquiryType, String inquiryTitle,
			String inquiryContent) {
		super();
		this.pId = pId;
		this.memId = memId;
		this.memName = memName;
		this.inquiryId = inquiryId;
		this.inquiryType = inquiryType;
		this.inquiryTitle = inquiryTitle;
		this.inquiryContent = inquiryContent;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public int getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}

	public int getInquiryType() {
		return inquiryType;
	}

	public void setInquiryType(int inquiryType) {
		this.inquiryType = inquiryType;
	}

	public String getInquiryTitle() {
		return inquiryTitle;
	}

	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}

	public String getInquiryContent() {
		return inquiryContent;
	}

	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}

	@Override
	public String toString() {
		return "Inquiry [pId=" + pId + ", memId=" + memId + ", memName=" + memName + ", inquiryId=" + inquiryId
				+ ", inquiryType=" + inquiryType + ", inquiryTitle=" + inquiryTitle + ", inquiryContent="
				+ inquiryContent + "]";
	}
	
	
}
