package com.laptrinhjavaweb;

import java.util.List;

import com.laptrinhjavaweb.buider.BuildingSearch;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.service.impl.BuildingServiceImpl;

public class EstateApplication {
	
	public static void main(String[] args) {
		String name = "Tower";
		String dictrict = "QUAN_1";
		String ward = "Phường 6";
		String[] types = new String[] {"TANG_TRET", "NGUYEN_CAN"};
		String rentAreaFrom = "300";
		String rentAreaTo = "500";
		String rentCostFrom = "1";
		String rentCostTo = "2";
		String numberofbasement = "2";
		String floorArea = "500";
		
		BuildingSearch search = new BuildingSearch.Buider()
				.setDictrict(dictrict)
				.setFloorArea(floorArea)
				.setName(name)
				.setNumberofbasement(numberofbasement)
				.build();
		
		BuildingService buildingService = new BuildingServiceImpl();
		buildingService.findAll(search);
		List<BuildingDTO> result = buildingService.findAll(search);
		System.out.println(result);
	}
}
