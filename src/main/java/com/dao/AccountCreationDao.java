package com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;
import com.bean.TransactionBean;

@Repository
public class AccountCreationDao {

	@Autowired
	JdbcTemplate template;

	@Autowired
	MaintainTransactionDao maintainTransactionDao;

	public void insert(int branchId, int userId, int accountTypeId, String accountNumber) {
		template.update(
				"insert into account (user_id, branch_id, account_number, account_type_id, balance, over_draft, over_draft_limit) values (?,?,?,?,?,?,?)	",
				userId, branchId, accountNumber, accountTypeId, 5000, 0, 0);
	}

//	public List<AccountBean> getAccountById(int user_id)
//	{
//		
//	}

	public void depositAmount(int depositAmount, int user_id) {

		template.update("update account set balance=balance+" + depositAmount + " where user_id=" + user_id);

	}

	public void withdrawAmount(int withdrawAmount, int user_id) {
		// TODO Auto-generated method stub
		template.update("update account set balance=balance-" + withdrawAmount + " where user_id=" + user_id);

	}

	public void transferAmount(String accountNumber, int transferAmount) {
		// TODO Auto-generated method stub
		template.update("update account set balance=balance+" + transferAmount + " where account_number='"
				+ accountNumber + "'");

	}

	public List<AccountBean> getBalance(int user_id) {
		List<AccountBean> list = template.query("select *from account where user_id=" + user_id,
				new BeanPropertyRowMapper<AccountBean>(AccountBean.class));
		return list;
	}

	public List<AccountBean> getBalanceByAccountnumber(String accountNumber) {
		List<AccountBean> list = template.query("select *from account where account_number='" + accountNumber + "'",
				new BeanPropertyRowMapper<AccountBean>(AccountBean.class));
		return list;
	}

	public List<AccountBean> getAccountId(int user_id) {
		List<AccountBean> list = template.query("select *from account where user_id=" + user_id,
				new BeanPropertyRowMapper<AccountBean>(AccountBean.class));
		return list;
	}

	public List<AccountBean> getAllAccount() {
		List<AccountBean> list = template.query("select *from account",
				new BeanPropertyRowMapper<AccountBean>(AccountBean.class));
		return list;
	}

	public AccountBean getSingleAccount(int userId) {
		System.out.println("select *from account where user_id=" + userId);
		return template.queryForObject("select *from account where user_id=" + userId,
				new BeanPropertyRowMapper<AccountBean>(AccountBean.class));

	}

	public void chargeAccount(int idAccount, String idTransaction) {
		SimpleJdbcCall call = new SimpleJdbcCall(template).withProcedureName("charge_account");
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("id_account", idAccount);
		inParamMap.put("id_transaction", idTransaction);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		Map<String, Object> simpleJdbcCallResult = call.execute(in);
		System.out.println(simpleJdbcCallResult);
		// call.execute("procedure name");
	}

	public void closeAccount(int idAccount) {

		SimpleJdbcCall call = new SimpleJdbcCall(template).withProcedureName("close_account");
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("id_account", idAccount);
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		call.execute(in);
		Map<String, Object> simpleJdbcCallResult = call.execute(in);
		System.out.println(simpleJdbcCallResult);
		// call.execute("procedure name");
	}

}
