package com.kh.product.model.vo;

public class Order {
	private String pName;
	private int ordId;
	private int count;
	private String memId;
	private int opt1No;
	private int opt2No;
	private int price;
	private String optTitle;
	private int optPrice;
	private int pId;
	private String optContent;
	private String img;
	
	public Order() {}
	
	public Order(String pName, int ordId, int count, String memId, int opt1No, int opt2No, int price, String optTitle,
			int optPrice, int pId, String optContent, String img) {
		super();
		this.pName = pName;
		this.ordId = ordId;
		this.count = count;
		this.memId = memId;
		this.opt1No = opt1No;
		this.opt2No = opt2No;
		this.price = price;
		this.optTitle = optTitle;
		this.optPrice = optPrice;
		this.pId = pId;
		this.optContent = optContent;
		this.img = img;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public String getOptTitle() {
		return optTitle;
	}

	public void setOptTitle(String optTitle) {
		this.optTitle = optTitle;
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

	public String getOptContent() {
		return optContent;
	}

	public void setOptContent(String optContent) {
		this.optContent = optContent;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Order [pName=" + pName + ", ordId=" + ordId + ", count=" + count + ", memId=" + memId + ", opt1No="
				+ opt1No + ", opt2No=" + opt2No + ", price=" + price + ", optTitle=" + optTitle + ", optPrice="
				+ optPrice + ", pId=" + pId + ", optContent=" + optContent + ", img=" + img + "]";
	}
	
	
	
}
