package com.laptrinhjavaweb;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.CategoryService;
import com.laptrinhjavaweb.service.NewService;
import com.laptrinhjavaweb.service.impl.CategoryServiceImpl;
import com.laptrinhjavaweb.service.impl.NewServiceImpl;

public class EstateApplication {
	
	public static void main(String[] args) {
		CategoryService categoryService = new CategoryServiceImpl();
		CategoryDTO dto= new CategoryDTO();
		dto.setCode("code");
		dto.setName("name");
		categoryService.insert(dto);
		
		NewService newService = new NewServiceImpl();		
		NewDTO newdto = new NewDTO();
		newdto.setCategoryId(1L);
		newdto.setContent("content");
		newdto.setShortdescription("shortdecription");
		newdto.setThumbnail("thumbnail");
		newdto.setTitle("title");
		newService.insert(newdto);
	}
}
