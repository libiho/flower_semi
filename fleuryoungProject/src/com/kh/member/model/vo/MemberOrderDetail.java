package com.kh.member.model.vo;

public class MemberOrderDetail {
	private int odId;
	private int odCount;
	private int odStatus;
	private int ordId;
	private String memId;
	private int opt1No;
	private int opt2No;
	private int price;
	private int opt2Title;
	private int optPrice;
	private int pId;
	private String opt2Content;
	
	public MemberOrderDetail() {}

	public MemberOrderDetail(int odId, int odCount, int odStatus, int ordId, String memId, int opt1No, int opt2No,
			int price, int opt2Title, int optPrice, int pId, String opt2Content) {
		super();
		this.odId = odId;
		this.odCount = odCount;
		this.odStatus = odStatus;
		this.ordId = ordId;
		this.memId = memId;
		this.opt1No = opt1No;
		this.opt2No = opt2No;
		this.price = price;
		this.opt2Title = opt2Title;
		this.optPrice = optPrice;
		this.pId = pId;
		this.opt2Content = opt2Content;
	}

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public int getOdCount() {
		return odCount;
	}

	public void setOdCount(int odCount) {
		this.odCount = odCount;
	}

	public int getOdStatus() {
		return odStatus;
	}

	public void setOdStatus(int odStatus) {
		this.odStatus = odStatus;
	}

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

	public int getOpt1No() {
		return opt1No;
	}

	public void setOpt1No(int opt1No) {
		this.opt1No = opt1No;
	}

	public int getOpt2No() {
		return opt2No;
	}

	public void setOpt2No(int opt2No) {
		this.opt2No = opt2No;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOpt2Title() {
		return opt2Title;
	}

	public void setOpt2Title(int opt2Title) {
		this.opt2Title = opt2Title;
	}

	public int getOptPrice() {
		return optPrice;
	}

	public void setOptPrice(int optPrice) {
		this.optPrice = optPrice;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getOpt2Content() {
		return opt2Content;
	}

	public void setOpt2Content(String opt2Content) {
		this.opt2Content = opt2Content;
	}

	@Override
	public String toString() {
		return "MemberOrderDetail [odId=" + odId + ", odCount=" + odCount + ", odStatus=" + odStatus + ", ordId="
				+ ordId + ", memId=" + memId + ", opt1No=" + opt1No + ", opt2No=" + opt2No + ", price=" + price
				+ ", opt2Title=" + opt2Title + ", optPrice=" + optPrice + ", pId=" + pId + ", opt2Content="
				+ opt2Content + "]";
	}
	
	
}
