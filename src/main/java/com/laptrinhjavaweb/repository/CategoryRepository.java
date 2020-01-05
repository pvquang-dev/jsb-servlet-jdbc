package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

public interface CategoryRepository extends JPARepository<CategoryDTO>{
	void save(CategoryEntity entity);
}
