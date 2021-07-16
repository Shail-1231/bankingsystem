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

import com.bean.AccountBean;
import com.bean.LargeTransactionBean;
import com.bean.TransactionBean;

@Repository
public class MaintainTransactionDao {

	@Autowired
	JdbcTemplate stmt;

	public void insert(AccountBean bean, String type, int depositAmount, String transactionNumber) {
		stmt.update(
				"insert into transaction (transaction_id, account_id, transaction_type, amount, updated_balance) values (?,?,?,?,?)",
				transactionNumber, bean.getAccountId(), type, depositAmount, bean.getBalance());
	}

	public void delete(String transactionNumber) {
		System.out.println(transactionNumber);
		stmt.update("delete from transaction where transaction_id = '", transactionNumber +"'");
	}

	public List<TransactionBean> getTransactions(int accountId) {
		System.out.println("account id in method is : "  +accountId);
		List<TransactionBean> list = stmt.query(
				"select transaction_id, account_id, transaction_type, amount,updated_balance from transaction where account_id = "
						+ accountId,
				new BeanPropertyRowMapper<TransactionBean>(TransactionBean.class));
		System.out.println("select transaction_id, account_id, transaction_type, amount,updated_balance from transaction where account_id = "
						+ accountId);
		return list;
	}
	
	public void setTransactionCount(String transactionId, int accountId)
	{
		SimpleJdbcCall call = new SimpleJdbcCall(stmt).withProcedureName("transaction_count");
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("id_account", accountId);
		inParamMap.put("id_transaction", transactionId);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		Map<String, Object> simpleJdbcCallResult = call.execute(in);
		System.out.println(simpleJdbcCallResult);
	}
	
	public List<LargeTransactionBean> viewLargeTransactions()
	{
		List<LargeTransactionBean> list = stmt.query("select *from large_transaction", new BeanPropertyRowMapper<LargeTransactionBean>(LargeTransactionBean.class));
		return list;
	}
}
