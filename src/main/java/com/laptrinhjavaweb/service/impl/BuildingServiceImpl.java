package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		Map<String, Object> params = convertToMapProperties(buildingSearch);
//		params.put("name", buildingSearch.getName());
//		params.put("dictrict", buildingSearch.getDictrict());
//		params.put("floorarea", (StringUtils.isNotBlank(buildingSearch.getFloorArea())) ? Integer.parseInt(buildingSearch.getFloorArea())
//				: null);
//		params.put("numberofbasement",
//				(StringUtils.isNotBlank(buildingSearch.getNumberofbasement())) ? Integer.parseInt(buildingSearch.getNumberofbasement())
//						: null);
		
		
		List<BuildingEntity> entities =  newRepository.findAll(params, buildingSearch);
		List<BuildingDTO> results = entities.stream().map(item -> convert.convertEntityToDTO(item)).collect(Collectors.toList());
//		for (BuildingEntity item : entities) {
//			BuildingDTO dto = convert.convertEntityToDTO(item);
//			results.add(dto);
//		}
		return results;
	}

	private Map<String, Object> convertToMapProperties(BuildingSearch buildingSearch) {
		Map<String, Object> properties = new HashMap<>();
		try {
			Field[] fields = BuildingSearch.class.getDeclaredFields();
			for (Field field : fields) {
				if(!field.getName().startsWith("rentarea")) {
					field.setAccessible(true);
					if(field.get(buildingSearch) instanceof String) {
						properties.put(field.getName().toLowerCase(), field.get(buildingSearch));
					} else {
						if(field.get(buildingSearch) != null && StringUtils.isEmpty((String) field.get(buildingSearch))) {
							properties.put(field.getName().toLowerCase(), Integer.parseInt((String) field.get(buildingSearch)));
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return null;
	}
}
