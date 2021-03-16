package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.bean.AccountTypeBean;


@Repository
public class AccountTypeDao {

	@Autowired
	JdbcTemplate stmt;

	public List<AccountTypeBean> getAllAccountType() {

		List<AccountTypeBean> account = stmt.query("select * from account_type",
				new BeanPropertyRowMapper<AccountTypeBean>(AccountTypeBean.class));
		
		return account;
	}

}
