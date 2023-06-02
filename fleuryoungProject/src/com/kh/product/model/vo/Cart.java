package com.kh.product.model.vo;

public class Cart {
	
	private String memId;
	private int selNo;
	private int pId;
	private int opt1stNo;
	private int opt2ndNo;
	private int optCount;
	private int noneOptCount;
	
	private String pName;
	private String storeName;
	private String opt1Title;
	private String opt2Title;
	private int pNetPrice;
	private String img;
	private int optPrice;
	
	public Cart() {}
	

	public Cart(int selNo, int pId, String memId, String pName, String storeName, int opt1stNo
			, String opt1Title, String opt2Title, int opt2ndNo, int optPrice, int optCount, int noneOptCount, int pNetPrice, String img) {
		super();
		this.memId = memId;
		this.selNo = selNo;
		this.pId = pId;
		this.opt1stNo = opt1stNo;
		this.opt2ndNo = opt2ndNo;
		this.optCount = optCount;
		this.noneOptCount = noneOptCount;
		this.pName = pName;
		this.storeName = storeName;
		this.opt1Title = opt1Title;
		this.opt2Title = opt2Title; 
		this.pNetPrice = pNetPrice;
		this.img = img;
		this.optPrice = optPrice;
	}


	public Cart(String memId, int selNo, int pId, int opt1stNo, int opt2ndNo, int optCount, int noneOptCount, String opt2Title, int optPrice) {
		super();
		this.memId = memId;
		this.selNo = selNo;
		this.pId = pId;
		this.opt1stNo = opt1stNo;
		this.opt2ndNo = opt2ndNo;
		this.opt2Title = opt2Title;
		this.optCount = optCount;
		this.noneOptCount = noneOptCount;
		this.optPrice = optPrice;
	}

	
	public Cart(String memId, int pId, int opt1stNo, int opt2ndNo) {
		super();
		this.memId = memId;
		this.pId = pId;
		this.opt1stNo = opt1stNo;
		this.opt2ndNo = opt2ndNo;
	}


	public Cart(int opt2ndNo, int optCount, int pId) { // 옵션 있는 생성자
		super();
		this.pId = pId;
		this.opt2ndNo = opt2ndNo;
		this.optCount = optCount;
	}
	
	
	public Cart(int noneOptCount, int pId) { // 옵션 없는 생성자
		super();
		this.pId = pId;
		this.noneOptCount = noneOptCount;
	}
	
	
	public int getOptPrice() {
		return optPrice;
	}


	public void setOptPrice(int optPrice) {
		this.optPrice = optPrice;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getOpt1Title() {
		return opt1Title;
	}

	public void setOpt1Title(String opt1Title) {
		this.opt1Title = opt1Title;
	}

	public String getOpt2Title() {
		return opt2Title;
	}

	public void setOpt2Title(String opt2Title) {
		this.opt2Title = opt2Title;
	}

	public int getpNetPrice() {
		return pNetPrice;
	}

	public void setpNetPrice(int pNetPrice) {
		this.pNetPrice = pNetPrice;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getSelNo() {
		return selNo;
	}

	public void setSelNo(int selNo) {
		this.selNo = selNo;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getOpt1stNo() {
		return opt1stNo;
	}

	public void setOpt1stNo(int opt1stNo) {
		this.opt1stNo = opt1stNo;
	}

	public int getOpt2ndNo() {
		return opt2ndNo;
	}

	public void setOpt2ndNo(int opt2ndNo) {
		this.opt2ndNo = opt2ndNo;
	}

	public int getOptCount() {
		return optCount;
	}

	public void setOptCount(int optCount) {
		this.optCount = optCount;
	}

	public int getNoneOptCount() {
		return noneOptCount;
	}

	public void setNoneOptCount(int noneOptCount) {
		this.noneOptCount = noneOptCount;
	}

	@Override
	public String toString() {
		return "Cart [memId=" + memId + ", selNo=" + selNo + ", pId=" + pId + ", opt1stNo=" + opt1stNo + ", opt2ndNo="
				+ opt2ndNo + ", optCount=" + optCount + ", noneOptCount=" + noneOptCount + "]";
	};
	
	
}
