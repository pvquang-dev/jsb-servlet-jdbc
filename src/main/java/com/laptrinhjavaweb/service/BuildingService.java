package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.buider.BuildingSearch;
import com.laptrinhjavaweb.dto.BuildingDTO;

public interface BuildingService {
  List<BuildingDTO> findAll(BuildingSearch buildingSearch);
  void save(BuildingDTO dto);
}
