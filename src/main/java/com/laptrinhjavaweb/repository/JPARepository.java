package com.laptrinhjavaweb.repository;

import java.util.List;

public interface JPARepository<T> {
	List<T> findAll();
}
