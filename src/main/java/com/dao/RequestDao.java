package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.bean.RequestBean;

@Repository
public class RequestDao {

	@Autowired
	JdbcTemplate stmt;

	public void insert(String request, int user_id, int account_id) {
		stmt.update("insert into request (request_type, comment, user_id, account_id) values (?,?,?,?)", request, "",
				user_id, account_id);
	}

	public void update(int requestId, String comment) {
		// TODO Auto-generated method stub
		stmt.update("update request set comment='" + comment + "' " + "where request_id=" + requestId);
	}

//	public String changeBranchFunction(int userId, int branchId) {
//		SimpleJdbcCall call = new SimpleJdbcCall(stmt).withFunctionName("branch_change");
//		SqlParameterSource paramap = new MapSqlParameterSource().addValue("id_user", userId);
//		SqlParameterSource paramap1 = new MapSqlParameterSource().addValue("id_branch", branchId);
//		  call.executeFunction(String.class, paramap, paramap1);
//		System.out.println("call 1 "+call.getCallString());
//		return "";
//	}

	public RequestBean getRequestId() {
		RequestBean bean = stmt.queryForObject("select *from request order by date_of_request desc limit 1",
				new BeanPropertyRowMapper<RequestBean>(RequestBean.class));
		return bean;
	}

	public void changeBranchFunction(int userId, int branchId) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(stmt)

				.withProcedureName("branch_change");

		Map<String, Integer> inParamMap = new HashMap<String, Integer>();
		inParamMap.put("id_user", userId);
		inParamMap.put("id_branch", branchId);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);

		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		System.out.println(simpleJdbcCallResult);
	}
	
	public void increaseOverDraft(int userId, int amount)
	{
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(stmt)

				.withProcedureName("over_draft_increase");

		Map<String, Integer> inParamMap = new HashMap<String, Integer>();
		inParamMap.put("id_user", userId);
		inParamMap.put("increase_amount", amount);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);

		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		System.out.println(simpleJdbcCallResult);
	}

	public void approve(int requestId) {
		stmt.update("update request set status = 'approved' where request_id = " + requestId);

	}

	public RequestBean getRequestById(int requestId) {
		RequestBean bean = stmt.queryForObject("select *from request where request_id = " + requestId,
				new BeanPropertyRowMapper<RequestBean>(RequestBean.class));
		return bean;
	}

}
