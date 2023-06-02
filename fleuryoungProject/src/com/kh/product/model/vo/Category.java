package com.kh.product.model.vo;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	
	 private int categoryNo;
	 private String categoryDetail;
	 private String categoryName;
	 private List<String> categoryDetails;
	 
	
	 public Category() {
		 
	 }

	public Category(int categoryNo, String categoryDetail, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryDetail = categoryDetail;
		this.categoryName = categoryName;
	}

	
	
	public Category(int categoryNo, String categoryDetail, String categoryName, List<String> categoryDetails) {
		super();
		this.categoryNo = categoryNo;
		this.categoryDetail = categoryDetail;
		this.categoryName = categoryName;
		this.categoryDetails = categoryDetails;
	}

	public List<String> getCategoryDetails() {
		return categoryDetails;
	}

	public void setCategoryDetails(List<String> categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryDetail() {
		return categoryDetail;
	}

	public void setCategoryDetail(String categoryDetail) {
		this.categoryDetail = categoryDetail;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryDetail=" + categoryDetail + ", categoryName="
				+ categoryName + "]";
	}
	 
	 
	  public boolean hasDetails() {
	        return categoryDetails != null && !categoryDetails.isEmpty();
	    }
	
	  public void addCategoryDetail(String categoryDetail) { // 세부 정보가 있는 경우 리스트에 추가하는 메서드
	        if (categoryDetails == null) {
	            categoryDetails = new ArrayList<>();
	        }
	        categoryDetails.add(categoryDetail);
	    }

}
