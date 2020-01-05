package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

public interface NewService {
	List<NewDTO> findAll();
	NewDTO insert(NewDTO newDTO);
}
