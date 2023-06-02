package com.kh.board.model.vo;

import java.util.Date;

public class FAQ {
	private int faqId;
	private String faqCategory;
	private String faqTitle;
	private String faqComment;
	private Date faqRegDate;
	private Date faqUpDate;
	
	public FAQ() {}
	
	public FAQ(int faqId, String faqCategory, String faqTitle, String faqComment, Date faqRegDate, Date faqUpDate) {
		super();
		this.faqId = faqId;
		this.faqCategory = faqCategory;
		this.faqTitle = faqTitle;
		this.faqComment = faqComment;
		this.faqRegDate = faqRegDate;
		this.faqUpDate = faqUpDate;
	}

	public int getFaqId() {
		return faqId;
	}

	public void setFaqId(int faqId) {
		this.faqId = faqId;
	}

	public String getFaqCategory() {
		return faqCategory;
	}

	public void setFaqCategory(String faqCategory) {
		this.faqCategory = faqCategory;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqComment() {
		return faqComment;
	}

	public void setFaqComment(String faqComment) {
		this.faqComment = faqComment;
	}

	public Date getFaqRegDate() {
		return faqRegDate;
	}

	public void setFaqRegDate(Date faqRegDate) {
		this.faqRegDate = faqRegDate;
	}

	public Date getFaqUpDate() {
		return faqUpDate;
	}

	public void setFaqUpDate(Date faqUpDate) {
		this.faqUpDate = faqUpDate;
	}

	@Override
	public String toString() {
		return "FAQ [faqId=" + faqId + ", faqCategory=" + faqCategory + ", faqTitle=" + faqTitle + ", faqComment="
				+ faqComment + ", faqRegDate=" + faqRegDate + ", faqUpDate=" + faqUpDate + "]";
	}
	
	
	
}
