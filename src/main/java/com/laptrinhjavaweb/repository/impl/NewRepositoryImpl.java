package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.NewRepository;

public class NewRepositoryImpl extends SimpleJPARepository<NewEntity> implements NewRepository{
	
	@Override
	public List<NewEntity> findAll() {
		return super.findAll();
	}
	
	@Override
	public NewEntity save() {
		return super.save();
	}
}
