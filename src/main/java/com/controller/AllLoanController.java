package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.LoanBean;
import com.dao.LoanDao;

@Controller
public class AllLoanController {

	@Autowired
	LoanDao loanDao;

	@GetMapping("viewallloans")
	public String viewAllLoans(Model model) {
		List<LoanBean> list = loanDao.getAllLoans();
		model.addAttribute("loans", list);
		return "viewallloans";
	}
}
