package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.buider.BuildingSearch;
import com.laptrinhjavaweb.dto.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> findAll(BuildingSearch buildingSearch);

	void insert(BuildingDTO newdto);
	
	List<BuildingDTO> findAll();
}
