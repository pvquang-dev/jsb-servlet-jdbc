package com.laptrinhjavaweb.entity;

import com.laptrinhjavaweb.anotation.Colum;
import com.laptrinhjavaweb.anotation.Entity;
import com.laptrinhjavaweb.anotation.Table;

@Entity 
@Table(name = "news")
public class NewEntity {
	
	@Colum(name ="title")
	private String title;
	
	@Colum(name ="thumbnail")
	private String thumbnail;
	
	@Colum(name ="shortDesciption")
	private String shortDesciption;
	
	@Colum(name ="content")
	private String content;
	
	@Colum(name = "categoryId")
	private Long categoryId;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDesciption() {
		return shortDesciption;
	}

	public void setShortDesciption(String shortDesciption) {
		this.shortDesciption = shortDesciption;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
