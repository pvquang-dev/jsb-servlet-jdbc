package com.laptrinhjavaweb;

import java.util.Date;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.service.impl.BuildingServiceImpl;

public class EstateApplication {

  public static void main(String[] args) {
    BuildingDTO dto = new BuildingDTO();
    dto.setName("landmark72");
    dto.setCreatedBy("quangrio");
    dto.setCreatedDate(new Date());
    BuildingService service = new BuildingServiceImpl();
    service.save(dto);
  }
}
