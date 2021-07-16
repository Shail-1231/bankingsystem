package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.LargeTransactionBean;
import com.dao.LargeTransactionDao;

@Controller
public class LargeTransactionController {

	@Autowired
	LargeTransactionDao largeTransactionDao;

	@GetMapping("viewlargetransaction")
	public String getLargeTransaction(Model model) {
		List<LargeTransactionBean> list = largeTransactionDao.seeLargeTransactions();
		model.addAttribute("largetransaction", list);
		return "viewlargetransaction";
	}
}
