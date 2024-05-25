package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDto;

@Repository
public class UserDAOJDBCImp implements UserDAOInt {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long add(UserDto dto) {

		String sql = "INSERT INTO USER VALUES(?,?,?,?,?)";

		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());
		return pk;
	}

	public void update(UserDto dto) {
		String sql = "UPDATE USER SET FIRST=?,LAST_NAME = ?,LOGIN = ?, PASSWORD = ? WHERE ID = ?";

		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());
	}

	public void delete(long id) {
		String sql = "DELETE FROM USER WHERE ID = ?";
		Object[] params = { id };
		int i = jdbcTemplate.update(sql, params);
	}

	public UserDto findByLogin(String login) {
		String sql = "SELECT ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM USER WHERE LOGIN = ?";
		Object[] params = { login };
		UserDto user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
		return user;
	}

	public UserDto authenticate(String login, String password) {
		try {
			String sql = "SELECT ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM USER WHERE LOGIN = ? AND PASSWORD = ?";
			Object[] params = { login, password };
			UserDto user = jdbcTemplate.queryForObject(sql, params, new UserMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public UserDto findByPK(long pk) {
		String sql = "SELECT ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM USER WHERE ID = ?";

		Object[] params = { pk };
		List list = jdbcTemplate.query(sql, params, new UserMapper());

		UserDto dto = null;

		if (list.size() > 0) {
			dto = (UserDto) list.get(0);
		}
		return dto;
	}

	public List search(UserDto dto) {
		String sql = "SELECT ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM USER";
		List list = jdbcTemplate.query(sql, new UserMapper());
		return list;
	}

	public List seach(UserDto dto, int pageNo, int pagesize) {
		String sql = "SELECT ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD FROM USER";
		List list = jdbcTemplate.query(sql, new UserMapper());
		return list;
	}

}
