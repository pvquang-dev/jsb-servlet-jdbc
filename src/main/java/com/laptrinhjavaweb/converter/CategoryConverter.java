package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

public class CategoryConverter {
	private ModelMapper mapper = new ModelMapper();

	public CategoryDTO convertEntityToDTO(CategoryEntity entity) {
		CategoryDTO dto = mapper.map(entity, CategoryDTO.class);
		return dto;
	}

	public CategoryEntity convertDTOToEntity(CategoryDTO dto) {
		CategoryEntity entity = mapper.map(dto, CategoryEntity.class);
		return entity;
	}
}
