package com.kh.product.model.vo;

public class ProductOption {
	
	private int opt1ndNo;
	private int opt2ndNo;
	private String optTitle;
	private String optContent;
	private int optPrice;
	private int optStock;
	
	public ProductOption() {}

	public ProductOption(int opt1ndNo, int opt2ndNo, String optTitle, String optContent, int optPrice, int optStock) {
		super();
		this.opt1ndNo = opt1ndNo;
		this.opt2ndNo = opt2ndNo;
		this.optTitle = optTitle;
		this.optContent = optContent;
		this.optPrice = optPrice;
		this.optStock = optStock;
	}

	public int getOpt1ndNo() {
		return opt1ndNo;
	}

	public void setOpt1ndNo(int opt1ndNo) {
		this.opt1ndNo = opt1ndNo;
	}

	public int getOpt2ndNo() {
		return opt2ndNo;
	}

	public void setOpt2ndNo(int opt2ndNo) {
		this.opt2ndNo = opt2ndNo;
	}

	public String getOptTitle() {
		return optTitle;
	}

	public void setOptTitle(String optTitle) {
		this.optTitle = optTitle;
	}

	public String getOptContent() {
		return optContent;
	}

	public void setOptContent(String optContent) {
		this.optContent = optContent;
	}

	public int getOptPrice() {
		return optPrice;
	}

	public void setOptPrice(int optPrice) {
		this.optPrice = optPrice;
	}

	public int getOptStock() {
		return optStock;
	}

	public void setOptStock(int optStock) {
		this.optStock = optStock;
	}
	
	
	
}
