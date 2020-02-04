package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<BuildingDTO> findAll() {
		List<BuildingDTO> lstNew = new ArrayList<>();
		List<BuildingEntity> entities = newRepository.findAll();
		for (BuildingEntity newEntity : entities) {
			BuildingDTO newdto = convert.convertEntityToDTO(newEntity);
			lstNew.add(newdto);
		}
		return lstNew;
	}

	@Override
	public void insert(BuildingDTO newdto) {
		newRepository.insert(convert.convertDTOToEntity(newdto));
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearch buildingSearch) {
		Map<String, Object> params = new HashMap<>();
		params.put("name", buildingSearch.getName());
		params.put("dictrict", buildingSearch.getDictrict());
		params.put("floorarea", buildingSearch.getFloorArea() != null ? Integer.parseInt(buildingSearch.getFloorArea())
				: buildingSearch.getFloorArea());
		params.put("numberofbasement",
				buildingSearch.getNumberofbasement() != null ? Integer.parseInt(buildingSearch.getNumberofbasement())
						: buildingSearch.getNumberofbasement());
		return null;
	}
}
