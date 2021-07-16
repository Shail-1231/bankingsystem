package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.RequestBean;

@Repository
public class SeeRequestDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public List<RequestBean> allRequests(int userId)
	{
		List<RequestBean> list = stmt.query("select request_id, request_type, comment, status, user_id, account_id from request where user_id=" + userId, new BeanPropertyRowMapper<RequestBean> (RequestBean.class));
		return list;
	}
}
