package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.repository.impl.NewRepositoryImpl;
import com.laptrinhjavaweb.service.NewService;
	
public class NewServiceImpl  implements NewService {
	
	private NewRepository newRepository = new NewRepositoryImpl();
	private NewConverter convert = new NewConverter();
	
	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> lstNew = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll();
		for (NewEntity newEntity : entities) {
			NewDTO newdto = convert.convertEntityToDTO(newEntity);
			lstNew.add(newdto);
		}
		return lstNew;
	}
}
