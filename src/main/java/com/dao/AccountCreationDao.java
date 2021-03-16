package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;



@Repository
public class AccountCreationDao {

	@Autowired
	JdbcTemplate template;

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
		List<AccountBean> list = template.query("select *from account where user_id=" + user_id, new BeanPropertyRowMapper<AccountBean>(AccountBean.class));
		return list;
	}

	public List<AccountBean> getBalanceByAccountnumber(String accountNumber) {
		List<AccountBean> list = template.query("select *from account where account_number='" + accountNumber + "'", new BeanPropertyRowMapper<AccountBean>(AccountBean.class));
		return list;
	}

}
