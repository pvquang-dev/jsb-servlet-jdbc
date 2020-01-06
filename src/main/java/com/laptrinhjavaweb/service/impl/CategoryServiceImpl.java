package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.impl.CategoryRepositoryImpl;
import com.laptrinhjavaweb.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository = new CategoryRepositoryImpl();
	private CategoryConverter converter = new CategoryConverter();
	
	@Override
	public void insert(CategoryDTO dto) {
		CategoryEntity entity = converter.convertDTOToEntity(dto);
		categoryRepository.insert(entity);
	}
}
