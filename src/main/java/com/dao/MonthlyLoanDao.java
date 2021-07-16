package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.bean.MonthlyLoanBean;

@Repository
public class MonthlyLoanDao {
	
	
	@Autowired
	JdbcTemplate template;
	
	public void monthlyLoanGeneration()
	{
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template).withProcedureName("loan_monthly");

		Map<String, Integer> inParamMap = new HashMap<String, Integer>();
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);

		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		System.out.println(simpleJdbcCallResult);
	}
	
	
	public List<MonthlyLoanBean> getMonthlyLoan()
	{
		List<MonthlyLoanBean> list = template.query("select *from monthly_loan", new BeanPropertyRowMapper<MonthlyLoanBean>(MonthlyLoanBean.class));
		return list;
	}
}
