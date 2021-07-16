package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

import com.bean.LoanBean;

import javassist.bytecode.StackMapTable;

@Repository
public class LoanDao {

	@Autowired
	JdbcTemplate template;

	public void insert(int userId, int rateOfInterest, float approxEmi, int duration, int processingFee, String status,
			int principalAmount, int balanceAmount) {
		template.update(
				"insert into loan (user_id, rate_of_interest, approx_emi, duration, processing_fee, status, principal_amount, balance_amount) values(?,?,?,?,?,?,?,?)",
				userId, rateOfInterest, approxEmi, duration, processingFee, status, principalAmount, balanceAmount);
	}

	public void updateStatus(String string) {
		// TODO Auto-generated method stub
		template.update("update loan set status ='" + string + "'");

	}

	public LoanBean getLoanDetails(int loanId) {
		return template.queryForObject("select *from loan where loan_id = " + loanId,
				new BeanPropertyRowMapper<LoanBean>(LoanBean.class));
	}

	public void setLoanClosureStatus(String accountNumber, int loanId, int amount) {

		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template).withProcedureName("check_loan");
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("id_loan", loanId);
		inParamMap.put("deposit_amount", amount);
		inParamMap.put("id_account", accountNumber);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
	}

	public List<LoanBean> getAllLoans() {
		return template.query("select *from loan", new BeanPropertyRowMapper<LoanBean>(LoanBean.class));
	}
}
