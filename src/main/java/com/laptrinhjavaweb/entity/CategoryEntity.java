package com.laptrinhjavaweb.entity;

import com.laptrinhjavaweb.anotation.Colum;
import com.laptrinhjavaweb.anotation.Entity;
import com.laptrinhjavaweb.anotation.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {
	
	@Colum(name = "name")
	private String name;
	
	@Colum(name = "code")
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
