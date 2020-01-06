package com.laptrinhjavaweb;

import com.laptrinhjavaweb.service.NewService;
import com.laptrinhjavaweb.service.impl.NewServiceImpl;

public class EstateApplication {
	
	public static void main(String[] args) {
		NewService newService = new NewServiceImpl();
		newService.findAll();
	}
}
