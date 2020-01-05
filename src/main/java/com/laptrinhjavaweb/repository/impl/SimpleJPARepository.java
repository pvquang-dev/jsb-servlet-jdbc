package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.anotation.Table;
import com.laptrinhjavaweb.mapper.ResultSetMapper;
import com.laptrinhjavaweb.repository.EntityManagerFactory;
import com.laptrinhjavaweb.repository.JPARepository;

public class SimpleJPARepository<T> implements JPARepository<T> {
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public SimpleJPARepository() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		clazz = (Class<T>)parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAll() {
		PreparedStatement  statement = null;
		ResultSet resultSet = null;
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = EntityManagerFactory.getConnection();
		String tableName = "";
		if(connection != null) {
			try {
				if(clazz.isAnnotationPresent(Table.class)) {
					Table table = clazz.getAnnotation(Table.class);
					tableName = table.name();
				}
				String sql = "select * from " + tableName;
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				return resultSetMapper.mapRow(resultSet, this.clazz);
			} catch (SQLException e) {
				return null;
			} finally {
				try {
					if(connection != null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(resultSet != null) {
						resultSet.close();
					}
				} catch (Exception e2) {
					return null;
				}
			}
		}
		return new ArrayList<>();
	}

	@Override
	public T save() {
		PreparedStatement  statement = null;
		ResultSet resultSet = null;
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = EntityManagerFactory.getConnection();
		String tableName = "";
		if(connection != null) {
			try {
				if(clazz.isAnnotationPresent(Table.class)) {
					Table table = clazz.getAnnotation(Table.class);
					tableName = table.name();
				}
				String sql = "INSERT INTO Registration " + "VALUES (100, 'Zara', 'Ali', 18)";
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				return null;
			} catch (SQLException e) {
				return null;
			} finally {
				try {
					if(connection != null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(resultSet != null) {
						resultSet.close();
					}
				} catch (Exception e2) {
					return null;
				}
			}
		}
		return null;
	}

//	@Override
//	public T insert() {
//		PreparedStatement  statement = null;
//		ResultSet resultSet = null;
//		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
//		Connection connection = EntityManagerFactory.getConnection();
//		String tableName = "";
//		if(connection != null) {
//			try {
//				if(clazz.isAnnotationPresent(Table.class)) {
//					Table table = clazz.getAnnotation(Table.class);
//					tableName = table.name();
//				}
//				String sql = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
//				sql = "insert into " + tableName + "()"
//				statement = connection.prepareStatement(sql);
//				resultSet = statement.executeQuery();
//				return resultSetMapper.mapRow(resultSet, this.clazz);
//			} catch (SQLException e) {
//				return null;
//			} finally {
//				try {
//					if(connection != null) {
//						connection.close();
//					}
//					if(statement != null) {
//						statement.close();
//					}
//					if(resultSet != null) {
//						resultSet.close();
//					}
//				} catch (Exception e2) {
//					return null;
//				}
//			}
//		}
//		return new ArrayList<>();
//	}

	
}
