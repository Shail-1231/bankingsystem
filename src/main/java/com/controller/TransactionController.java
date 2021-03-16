package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AccountBean;
import com.dao.AccountCreationDao;
import com.dao.AccountTypeDao;

@Controller
public class TransactionController {

	
	
	@Autowired
	AccountTypeDao accountDao;

	@Autowired
	AccountCreationDao accountCreationDao;

	@GetMapping("deposit")
	public String depositAmount() {
		return "deposit";
	}

	@PostMapping("deposit")
	public String amountDeposited(@RequestParam("depositAmount") int depositAmount, HttpSession session) {
		int user_id = (int) session.getAttribute("user_id");
		accountCreationDao.depositAmount(depositAmount, user_id);
		return "redirect:/dashboard";
	}

	@GetMapping("withdraw")
	public String withdrawAmount() {
		return "withdraw";
	}

	@PostMapping("withdraw")
	public String amountWithdrawn(@RequestParam("withdrawAmount") int withdrawAmount, HttpSession session) {
		int user_id = (int) session.getAttribute("user_id");
		int flag = 0;
		accountCreationDao.withdrawAmount(withdrawAmount, user_id);
		List<AccountBean> accountBean = accountCreationDao.getBalance(user_id);
		for (AccountBean bean : accountBean) {
			System.out.println("Balance is : " + bean.getBalance());
			if (bean.getBalance() <= 5000) {
				accountCreationDao.depositAmount(withdrawAmount, user_id);
				flag = 1;
			}
		}

		if (flag == 1) {
			return "errorpagewithdrawal";
		}

		else {
			return "redirect:/dashboard";
		}

	}

	@GetMapping("transfer")
	public String transferAmount() {
		return "transfer";
	}

	@PostMapping("transfer")
	public String amountTransferred(@RequestParam("accountNumber") String accountNumber,
			@RequestParam("transferAmount") int transferAmount, HttpSession session) {

		int user_id = (int) session.getAttribute("user_id");
		accountCreationDao.withdrawAmount(transferAmount, user_id);

		int flag = 0;
		List<AccountBean> accountBean = accountCreationDao.getBalance(user_id);
		for (AccountBean bean : accountBean) {
			System.out.println("Balance is : " + bean.getBalance());
			if (bean.getBalance() <= 5000) {
				accountCreationDao.depositAmount(transferAmount, user_id);
				flag = 1;
			}
		}

		if (flag == 1) {
			return "errorpagewithdrawal";
		} else {
			accountCreationDao.transferAmount(accountNumber, transferAmount);
			return "redirect:/dashboard";
		}
	}

}
