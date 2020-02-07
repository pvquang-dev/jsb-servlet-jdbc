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
		StringBuilder sql = new StringBuilder("select * from building tableName where 1=1");
		sql = this.createSQLfindAllCommon(sql, params);
		sql = createSQLspecial(sql, buildingSearch);
		return this.findAll(sql.toString());
	}

	private StringBuilder createSQLspecial(StringBuilder sql, BuildingSearch buildingSearch) {
		if(StringUtils.isNotBlank(buildingSearch.getRentAreaFrom()) || StringUtils.isNotBlank(buildingSearch.getRentAreaTo())) {
			sql.append(" and exists (select * from rentarea ra where (tableName.id = ra.buildingid");
			if(StringUtils.isNotBlank(buildingSearch.getRentAreaFrom())) {
				sql.append(" and ra.value >= "+buildingSearch.getRentAreaFrom()+" ");
			}
			if(StringUtils.isNotBlank(buildingSearch.getRentAreaTo())) {
				sql.append(" and ra.value <= "+buildingSearch.getRentAreaTo()+" ");
			}
			sql.append("))");
		}
		return null;
	}
}
