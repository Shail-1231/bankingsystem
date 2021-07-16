package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LargeTransactionBean;

@Repository
public class LargeTransactionDao {

	@Autowired
	JdbcTemplate template;

	public List<LargeTransactionBean> seeLargeTransactions() {
		return template.query("select *from large_transaction",
				new BeanPropertyRowMapper<LargeTransactionBean>(LargeTransactionBean.class));
	}
}
