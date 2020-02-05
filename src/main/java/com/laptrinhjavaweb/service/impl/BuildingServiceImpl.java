package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.buider.BuildingSearch;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepositoryImpl;
import com.laptrinhjavaweb.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {

	private BuildingRepository newRepository = new BuildingRepositoryImpl();
	private BuildingConverter convert = new BuildingConverter();

	@Override
	public void insert(BuildingDTO newdto) {
		newRepository.insert(convert.convertDTOToEntity(newdto));
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearch buildingSearch) {
		List<BuildingDTO> results = new ArrayList<>(); 
		Map<String, Object> params = new HashMap<>();
		params.put("name", buildingSearch.getName());
		params.put("dictrict", buildingSearch.getDictrict());
		params.put("floorarea", (StringUtils.isNotBlank(buildingSearch.getFloorArea())) ? Integer.parseInt(buildingSearch.getFloorArea())
				: null);
		params.put("numberofbasement",
				(StringUtils.isNotBlank(buildingSearch.getNumberofbasement())) ? Integer.parseInt(buildingSearch.getNumberofbasement())
						: null);
		List<BuildingEntity> entities =  newRepository.findAll(params, buildingSearch);
		for (BuildingEntity item : entities) {
			BuildingDTO dto = convert.convertEntityToDTO(item);
			results.add(dto);
		}
		return results;
	}
}
