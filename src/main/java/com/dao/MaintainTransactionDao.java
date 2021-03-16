package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;


@Repository
public class MaintainTransactionDao {

	@Autowired
	JdbcTemplate stmt;

	public void insert(AccountBean bean, String type, int depositAmount, String transactionNumber) {
		stmt.update(
				"insert into transaction (transaction_id, account_id, type, amount, updated_balance) values (?,?,?,?,?)",
				transactionNumber, bean.getAccountId(), type, depositAmount, bean.getBalance());
	}
	
	public void delete(String transactionNumber)
	{
		stmt.update("delete from transaction where transaction_id = ", transactionNumber);
	}
}
