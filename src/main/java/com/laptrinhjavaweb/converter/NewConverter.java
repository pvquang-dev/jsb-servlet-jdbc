package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

public class NewConverter {
	
	private ModelMapper mapper = new ModelMapper();
	
	public NewDTO convertEntityToDTO(NewEntity entity) {
		NewDTO newdto = mapper.map(entity, NewDTO.class);
		return newdto;
	}
	
	public NewEntity convertDTOToEntity(NewDTO dto) {
		NewEntity newEntity = mapper.map(dto, NewEntity.class);
		return newEntity;
	}
}
