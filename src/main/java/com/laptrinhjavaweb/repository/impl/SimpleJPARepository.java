package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.anotation.Colum;
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
		clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAll() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = EntityManagerFactory.getConnection();
		String tableName = "";
		if (connection != null) {
			try {
				if (clazz.isAnnotationPresent(Table.class)) {
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
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
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
	public void insert(String sql, Object... objects) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			int index = 1;
			for (Object object : objects) {
				statement.setObject(index, object);
				index++;
			}
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void insert(Object objects) {
		String sql = createSQLInsert();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = EntityManagerFactory.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			Class<?> zclass = objects.getClass();
			int index = 1;
			for (Field zfield : zclass.getDeclaredFields()) {
				zfield.setAccessible(true);
				statement.setObject(index, zfield.get(objects));
				index++;
			}
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	private String createSQLInsert() {
		String tableName = "";
		if (clazz.isAnnotationPresent(Table.class)) {
			Table table = clazz.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		for (Field field : clazz.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			Colum colum = field.getAnnotation(Colum.class);
			fields.append(colum.name());
			params.append("?");
		}
		String sql = "insert into " + tableName + "(" + fields.toString() + ") values(" + params.toString() + ")";;
		return sql;
	}
}
