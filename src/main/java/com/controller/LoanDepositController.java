package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AccountBean;
import com.dao.AccountCreationDao;
import com.dao.LoanDao;

@Controller
public class LoanDepositController {
	
	
	@Autowired
	AccountCreationDao accountCreationDao;
	
	@Autowired
	LoanDao loanDao;
	
	@GetMapping("depositloan")
	public String loanDeposit()
	{
		return "depositloan";
	}
	
	@PostMapping("depositloan")
	public String loanDeposited(@RequestParam("depositamount")int depositAmount, @RequestParam("loanid")int loanId, HttpSession session, @RequestParam("accountnumber") String accountNumber)
	{
		int userId = (int)session.getAttribute("user_id");
		 
		accountCreationDao.withdrawAmount(depositAmount, userId);
		AccountBean bean = accountCreationDao.getSingleAccount(userId);
		String accountNumber1 = bean.getAccountNumber();
		if(accountNumber1.equals(accountNumber))
		{
			if((bean.getBalance() - depositAmount) < 5000)
			{
				return "errorpageloan";
			}
			else
			{
				loanDao.setLoanClosureStatus(accountNumber1, loanId, depositAmount);
			}
			return "redirect:/dashboard";
		}
		
		else
		{
			return "errorpageloan";
		}
		
	}
}
