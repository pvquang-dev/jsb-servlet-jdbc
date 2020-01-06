package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;

public class CategoryRepositoryImpl extends SimpleJPARepository<CategoryDTO> implements CategoryRepository {

	@Override
	public void insert(CategoryEntity entity) {
		String sql = "insert into category (name, code) values(?, ?)";
		this.insert(sql, entity.getName(), entity.getCode());
	}
}
