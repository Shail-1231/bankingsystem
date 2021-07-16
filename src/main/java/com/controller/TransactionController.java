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
import com.dao.MaintainTransactionDao;
import com.services.GenerateTransactionNumberService;

@Controller
public class TransactionController {

	@Autowired
	AccountTypeDao accountDao;

	@Autowired
	AccountCreationDao accountCreationDao;

	@Autowired
	GenerateTransactionNumberService transactionNumber;

	@Autowired
	MaintainTransactionDao transactionDao;

	@GetMapping("deposit")
	public String depositAmount() {
		return "deposit";
	}

	@PostMapping("deposit")
	public String amountDeposited(@RequestParam("depositAmount") int depositAmount, HttpSession session) {
		int user_id = (int) session.getAttribute("user_id");
		accountCreationDao.depositAmount(depositAmount, user_id);
		String transactionNumber1 = transactionNumber.getAlphaNumericString(10);
		String transactionNumber2 = transactionNumber.getAlphaNumericString(10);
		List<AccountBean> accountBean = accountCreationDao.getAccountId(user_id);
		String type = "deposit";
		for (AccountBean bean : accountBean) {
			transactionDao.setTransactionCount(transactionNumber2, bean.getAccountId());
			transactionDao.insert(bean, type, depositAmount, transactionNumber1);
		}

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
		List<AccountBean> accountBean1 = accountCreationDao.getAccountId(user_id);

		String transactionNumber1 = transactionNumber.getAlphaNumericString(10);
		String transactionNumber2 = transactionNumber.getAlphaNumericString(10);
		String transactionNumber3 = transactionNumber.getAlphaNumericString(10);
		String type = "withdraw";
		for (AccountBean bean : accountBean1) {
			transactionDao.insert(bean, type, withdrawAmount, transactionNumber1);
			transactionDao.setTransactionCount(transactionNumber2, bean.getAccountId());
			accountCreationDao.chargeAccount(bean.getAccountId(), transactionNumber3);
		}
		for (AccountBean bean : accountBean) {
			System.out.println("Balance is : " + bean.getBalance());
			if (bean.getBalance() <= 5000) {
				accountCreationDao.depositAmount(withdrawAmount + 35, user_id);
				// transactionDao.delete(transactionNumber1);
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
		AccountBean bean1 = accountCreationDao.getSingleAccount(user_id);
		if (bean1.getAccountNumber().equals(accountNumber)) {
			return "redirect:/depositloan";
		}

		else {
			int flag = 0, flag2 = 0;
			List<AccountBean> list = accountCreationDao.getAllAccount();
			for (AccountBean obj : list) {
				if (obj.getAccountNumber().equals(accountNumber)) {
					flag2 = 1;
					accountCreationDao.withdrawAmount(transferAmount, user_id);
					List<AccountBean> accountBean = accountCreationDao.getBalance(user_id);
					for (AccountBean bean : accountBean) {
						System.out.println("Balance is : " + bean.getBalance());
						if (bean.getBalance() <= 5000) {
							transactionDao.setTransactionCount(transactionNumber.getAlphaNumericString(10),
									bean.getAccountId());
							accountCreationDao.depositAmount(transferAmount, user_id);
							flag = 1;
						}
					}
				}
			}

			if (flag == 1) {
				return "errorpagewithdrawal";
			} else if (flag2 == 0) {
				return "errorpageaccountnumber";
			} else {
				accountCreationDao.transferAmount(accountNumber, transferAmount);
				return "redirect:/dashboard";
			}
		}

	}

}
