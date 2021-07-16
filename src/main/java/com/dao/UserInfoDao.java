package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserInfoDao {

	@Autowired
	JdbcTemplate stmt;

	public int insertQuery(UserBean bean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String insertQ = "insert into user_info (first_name, last_name, email, password, address, role_id, wrong_attempt, is_lock) values(?,?,?,?,?,?,?,?)";
		try {
			stmt.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(insertQ, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, bean.getFirstName());
					ps.setString(2, bean.getLastName());
					ps.setString(3, bean.getEmail());
					ps.setString(4, bean.getPassword());
					ps.setString(5, bean.getAddress());
					ps.setInt(6, bean.getRoleId());
					ps.setInt(7, bean.getWrongAttempt());
					ps.setInt(8, bean.getIsLock());
					return ps;

				}
			}, keyHolder);

			return (Integer) keyHolder.getKeys().get("user_id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public List<UserBean> getUserById(int user_id) {
		// TODO Auto-generated method stub
		List<UserBean> user = stmt.query("select * from user_info where user_id=" + user_id, new UserRowMapper());
		return user;
	}

	class UserRowMapper implements RowMapper<UserBean> {

		@Override
		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBean user = new UserBean();
			user.setUserId(rs.getInt("user_id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setAddress(rs.getString("address"));
			user.setRoleId(rs.getInt("role_id"));
			user.setIsLock(rs.getInt("is_lock"));
			user.setWrongAttempt(rs.getInt("wrong_attempt"));
			return user;
		}

	}

	public void updateUserPassword(String password, int user_id) {
		stmt.update("update user_info set password='" + password + "'" + " where user_id=" + user_id);

	}

	public List<UserBean> getAllUsers() {
		List<UserBean> users = stmt.query("select *from user_info",
				new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;
	}

	public UserBean getSingleRecord(int userId) {
		UserBean bean = stmt.queryForObject("select *from user_info where user_id=" + userId,
				new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return bean;
	}

	public void authenticateUser(String email, String password) {
		SimpleJdbcCall call = new SimpleJdbcCall(stmt).withProcedureName("update_wrongattempt");
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("email_input", email);
		inParamMap.put("password_input", password);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		call.execute(in);
	}

	public UserBean getSingleRecordWithEmail(String email) {
		UserBean bean = stmt.queryForObject("select *from user_info where email = '" + email + "'",
				new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return bean;

	}

	public void lockAccount(String email, String password) {
		SimpleJdbcCall call = new SimpleJdbcCall(stmt).withProcedureName("lock_account");
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("email_input", email);
		inParamMap.put("password_input", password);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		call.execute(in);

	}

}
