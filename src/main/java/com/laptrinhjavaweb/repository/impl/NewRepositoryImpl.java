package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.NewRepository;

public class NewRepositoryImpl  extends SimpleJPARepository<NewEntity> implements NewRepository {

//	@Override
//	public void insert(NewEntity entity) {
//		String sql = "insert into news (categoryid, title) values(?, ?)";
//		this.insert(sql, entity.getCategoryId(), entity.getTitle());
//	}
}
