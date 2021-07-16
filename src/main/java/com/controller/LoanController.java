package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AccountBean;
import com.bean.BranchBean;
import com.dao.AccountCreationDao;
import com.dao.BranchDao;
import com.dao.LoanDao;

@Controller
public class LoanController {

	@Autowired
	BranchDao branchDao;

	@Autowired
	AccountCreationDao accountCreationDao;

	@Autowired
	LoanDao loanDao;

	@GetMapping("loan")
	public String applyForLoan(HttpSession session) {
		int userId = (int) session.getAttribute("user_id");
		int branchId = 0;
		int interestRate;
		AccountBean accountBean = accountCreationDao.getSingleAccount(userId);
		BranchBean obj = branchDao.getBranchById(accountBean.getBranchId());
		interestRate = obj.getLoanIntRate();
		System.out.println("branch id is : " + obj.getBranchId());
		System.out.println("interest rate is : " + interestRate);
		return "loan";
	}

	@PostMapping("loan")
	public String loanApplied(Model model, @RequestParam("principalamount") int principalAmount,
			@RequestParam("timeperiod") int timePeriod, HttpSession session) {

		int userId = (int) session.getAttribute("user_id");
		AccountBean accountBean = accountCreationDao.getSingleAccount(userId);
		BranchBean obj = branchDao.getBranchById(accountBean.getBranchId());
		int interestRate = obj.getLoanIntRate();
		int ans = 1;

		for (int i = 0; i < timePeriod; i++) {
			ans *= (1 + interestRate);
		}
		System.out.println("emi calc " + ans);
		int interestAmount = (principalAmount * interestRate * timePeriod) / 12;
		float emiCal = principalAmount * interestRate * (ans / (ans - 1));
		System.out.println("emi cal " + emiCal);
		model.addAttribute("emiamount", emiCal);
		model.addAttribute("interestamount", interestAmount);
		String comment = "loan";
		loanDao.insert(userId, interestRate, emiCal, timePeriod, 1000, "not approved", principalAmount,
				accountBean.getBalance());
		return "loandetails";
	}

}
