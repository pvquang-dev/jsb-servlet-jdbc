package com.laptrinhjavaweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.anotation.Column;
import com.laptrinhjavaweb.anotation.Entity;

public class ResultSetMapper<T> {
	
	public List<T> mapRow(ResultSet resultSet, Class<T> clazz) {
		List<T> results = new ArrayList<>();
		try {
			if(clazz.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData data = resultSet.getMetaData();
				Field[] fields = clazz.getDeclaredFields();
				while(resultSet.next()) {
					T obj = clazz.newInstance();
					for (int i = 0; i < data.getColumnCount(); i++) {
						String colName = data.getColumnName(i + 1);
						Object colValue = resultSet.getObject(i + 1);
						for(Field field : fields) {
							if(field.isAnnotationPresent(Column.class)) {
								Column column = field.getAnnotation(Column.class);
								if(column.name().equals(colName)) {
									BeanUtils.setProperty(obj, colName, colValue);
									break;
								}
							}
						}
					}
					results.add(obj);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return results;
	}
	
}
