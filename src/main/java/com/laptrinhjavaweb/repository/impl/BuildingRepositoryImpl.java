package com.laptrinhjavaweb.repository.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.buider.BuildingSearch;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;

public class BuildingRepositoryImpl extends SimpleJPARepository<BuildingEntity> implements BuildingRepository {

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, BuildingSearch buildingSearch) {
		StringBuilder result = new StringBuilder("select * from building tableName where 1=1");
		result = this.createSQLfindAllCommon(result, params);
		return this.findAll(result.toString());
	}
}
