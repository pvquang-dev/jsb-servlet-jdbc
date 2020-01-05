package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.repository.impl.NewRepositoryImpl;
import com.laptrinhjavaweb.service.NewService;
	
public class NewServiceImpl  implements NewService{
	
	private NewRepository newRepository = new NewRepositoryImpl();
	
	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> lstNew = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll();
		for (NewEntity newEntity : entities) {
			NewConverter convert = new NewConverter();
			convert.convertEntityToDTO(newEntity);
		}
		return lstNew;
	}

	@Override
	public NewDTO insert(NewDTO newDTO) {
		NewDTO dto = new NewDTO();
		dto.setContent(newDTO.getContent());
		dto.setShortdescription(newDTO.getShortdescription());
		NewEntity entity =  newRepository.save();
		return dto;
	}
}
