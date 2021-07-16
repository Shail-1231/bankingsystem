package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.MonthlyLoanBean;
import com.dao.MonthlyLoanDao;

@Controller
public class MonthlyLoanController {

	@Autowired
	MonthlyLoanDao monthlyLoanDao;

	@GetMapping("loanmonthly")
	public String monthlyLoan(Model model) {
		monthlyLoanDao.monthlyLoanGeneration();
		List<MonthlyLoanBean> list = monthlyLoanDao.getMonthlyLoan();
		model.addAttribute("monthlyloan", list);
		return "loanmonthly";
	}
}
