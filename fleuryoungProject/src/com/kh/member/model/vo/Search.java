package com.kh.member.model.vo;

public class Search {
	
	private String keyWord;
	
	public Search() {}

	public Search(String keyWord) {
		super();
		this.keyWord = keyWord;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Override
	public String toString() {
		return "Search [keyWord=" + keyWord + "]";
	}
	
	
	
}
