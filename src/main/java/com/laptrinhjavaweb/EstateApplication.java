package com.laptrinhjavaweb;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.NewService;
import com.laptrinhjavaweb.service.impl.NewServiceImpl;

public class EstateApplication {
	
	public static void main(String[] args) {
		NewService newService = new NewServiceImpl();
		NewDTO newDTO = new NewDTO();
		newDTO.setContent("content");
		newDTO.setShortdescription("shortdescription");
		newDTO.setTitle("title");
		newService.insert(newDTO);
	}
}
