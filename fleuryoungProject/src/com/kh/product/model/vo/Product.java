package com.kh.product.model.vo;

import java.sql.Date;

public class Product {

	private int pId; // 상품번호
	private String pName; // 상품명
	private String pNetPrice; // 가격
	private int pDetail; // 상세설명
	private int pStock; // 총수량
	private Date enrollDate; // 등록일 
	private String returnYN; // 환불여부
	private String pTagYN; // 카드여부
	private int saleCount; // 판매량
	private String pDayDelivery; // 당일배송여부
	private String pGift; // 선물여부
	private int selNo; // 판매자 번호 
	private String categoryNO; // 카테고리 번호
	private int reviewRating; // 별점 1 ~ 5
	private String mainImg; // 메인 이미지
	private int reviewCount; // 조회수
	private String images;
	private String storeName;
	
	private int discountRate; // 할인율
	private int total; // 정가 - (정가*할인율)
	private int ordId; // 주문번호
	private String memOrderDetail; // 리뷰내용 
	private String optTitle;

	public Product() {}


	public Product(int pId, String pName, int reviewRating, int reviewCount,  String pNetPrice,  String mainImg, String pDayDelivery
			) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pNetPrice = pNetPrice;
		this.pDayDelivery = pDayDelivery;
		this.reviewRating = reviewRating;
		this.mainImg = mainImg;
		this.reviewCount = reviewCount;
	}

	public Product(int pId, String pName, String pNetPrice, int pDetail, int pStock, Date enrollDate, String returnYN,
			String pTagYN, int saleCount, String pDayDelivery, String pGift, int selNo, String categoryNO) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pNetPrice = pNetPrice;
		this.pDetail = pDetail;
		this.pStock = pStock;
		this.enrollDate = enrollDate;
		this.returnYN = returnYN;
		this.pTagYN = pTagYN;
		this.saleCount = saleCount;
		this.pDayDelivery = pDayDelivery;
		this.pGift = pGift;
		this.selNo = selNo;
		this.categoryNO = categoryNO;
	}
	
	
	public Product(int pId, int selNo, String storeName, String pName, int pStock, int reviewRating, int reviewCount, String pNetPrice, String pDayDelivery,
			  String images) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pNetPrice = pNetPrice;
		this.pStock = pStock;
		this.pDayDelivery = pDayDelivery;
		this.selNo = selNo;
		this.reviewRating = reviewRating;
		this.reviewCount = reviewCount;
		this.images = images;
		this.storeName = storeName;
	}
	
	
	public Product(String pName, String pNetPrice, String mainImg, int discountRate, int total, int pId) {
		super();
		this.pName = pName;
		this.pNetPrice = pNetPrice;
		this.mainImg = mainImg;
		this.discountRate = discountRate;
		this.total = total;
		this.pId= pId;
	}
	

	public Product(String pName, String mainImg, int total, int ordId, String optTitle) {
		super();
		this.pName = pName;
		this.mainImg = mainImg;
		this.total = total;
		this.ordId = ordId;
		this.optTitle = optTitle;
	}

	

	public Product(String pName, int ordId, String memOrderDetail) {
		super();
		this.pName = pName;
		this.ordId = ordId;
		this.memOrderDetail = memOrderDetail;
	}


	public Product(int pId) {
		super();
		this.pId = pId;
	}


	public Product(String memOrderDetail) {
		super();
		this.memOrderDetail = memOrderDetail;
	}


	public String getOptTitle() {
		return optTitle;
	}


	public void setOptTitle(String optTitle) {
		this.optTitle = optTitle;
	}


	public int getDiscountRate() {
		return discountRate;
	}


	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getOrdId() {
		return ordId;
	}


	public void setOrdId(int ordId) {
		this.ordId = ordId;
	}


	public String getMemOrderDetail() {
		return memOrderDetail;
	}


	public void setMemOrderDetail(String memOrderDetail) {
		this.memOrderDetail = memOrderDetail;
	}


	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public String getImages() {
		return images;
	}


	public void setImages(String images) {
		this.images = images;
	}
	
	public int getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpNetPrice() {
		return pNetPrice;
	}

	public void setpNetPrice(String pNetPrice) {
		this.pNetPrice = pNetPrice;
	}

	public int getpDetail() {
		return pDetail;
	}

	public void setpDetail(int pDetail) {
		this.pDetail = pDetail;
	}

	public int getpStock() {
		return pStock;
	}

	public void setpStock(int pStock) {
		this.pStock = pStock;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getReturnYN() {
		return returnYN;
	}

	public void setReturnYN(String returnYN) {
		this.returnYN = returnYN;
	}

	public String getpTagYN() {
		return pTagYN;
	}

	public void setpTagYN(String pTagYN) {
		this.pTagYN = pTagYN;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public String getpDayDelivery() {
		return pDayDelivery;
	}

	public void setpDayDelivery(String pDayDelivery) {
		this.pDayDelivery = pDayDelivery;
	}

	public String getpGift() {
		return pGift;
	}

	public void setpGift(String pGift) {
		this.pGift = pGift;
	}

	public int getSelNo() {
		return selNo;
	}

	public void setSelNo(int selNo) {
		this.selNo = selNo;
	}

	public String getCategoryNO() {
		return categoryNO;
	}

	public void setCategoryNO(String categoryNO) {
		this.categoryNO = categoryNO;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pNetPrice=" + pNetPrice + ", pDetail=" + pDetail
				+ ", pStock=" + pStock + ", enrollDate=" + enrollDate + ", returnYN=" + returnYN + ", pTagYN=" + pTagYN
				+ ", saleCount=" + saleCount + ", pDayDelivery=" + pDayDelivery + ", pGift=" + pGift + ", selNo="
				+ selNo + ", categoryNO=" + categoryNO + "]";
	}
	
	
}
