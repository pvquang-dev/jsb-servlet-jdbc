package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;

public class CategoryRepositoryImpl extends SimpleJPARepository<CategoryDTO> implements CategoryRepository {

	@Override
	public List<CategoryDTO> findAll() {
		return super.findAll();
	}

	@Override
	public void save(CategoryEntity entity) {
		
	}

}
