package com.laptrinhjavaweb.repository.impl;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.buider.BuildingSearch;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;

public class BuildingRepositoryImpl extends SimpleJPARepository<BuildingEntity> implements BuildingRepository {

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, BuildingSearch buildingSearch) {
		StringBuilder result = new StringBuilder("select * from building where 1=1");
		result = createSQLfindAllCommon(params, result);
		return this.findAll(result.toString());
	}

	private StringBuilder createSQLfindAllCommon(Map<String, Object> params, StringBuilder sql) {
		if(params != null && params.size() > 0) {
			String[] keys = new String[params.size()];
			Object[] values = new Object[]{};
			int i = 0;
			for(Map.Entry<String, Object> item : params.entrySet()) {
				keys[i] = item.getKey();
				values[i] = item.getValue();
				i++;
			}
			for(int index = 0; index < keys.length; index++) {
				if(values[index] instanceof String) {
					sql.append(" and b."+keys[index]+" like '%"+ values[index]+"%'");
				} else {
					sql.append(" and b."+keys[index]+" = "+values[index]+"");
				}
			}
		}
		return sql;
	}
}
