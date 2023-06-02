package com.kh.board.model.vo;

import java.util.Date;

public class Notice {
	private int noticeId;
	private String noticeTitle;
	private String noticeComment;
	private Date noticeRegDate;
	
	public Notice() {}

	public Notice(int noticeId, String noticeTitle, String noticeComment, Date noticeRegDate) {
		super();
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeComment = noticeComment;
		this.noticeRegDate = noticeRegDate;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeComment() {
		return noticeComment;
	}

	public void setNoticeComment(String noticeComment) {
		this.noticeComment = noticeComment;
	}

	public Date getNoticeRegDate() {
		return noticeRegDate;
	}

	public void setNoticeRegDate(Date noticeRegDate) {
		this.noticeRegDate = noticeRegDate;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeComment=" + noticeComment
				+ ", noticeRegDate=" + noticeRegDate + "]";
	}
	
	
	
}
