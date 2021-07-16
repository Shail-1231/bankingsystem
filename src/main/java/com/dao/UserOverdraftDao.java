package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserOverdraftBean;

@Repository
public class UserOverdraftDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public List<UserOverdraftBean> getUserOverdraft()
	{
		List<UserOverdraftBean> list = stmt.query("select *from user_overdraft", new BeanPropertyRowMapper<UserOverdraftBean>(UserOverdraftBean.class));
		return list;
	}
}
