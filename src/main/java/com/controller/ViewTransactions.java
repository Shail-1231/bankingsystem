package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.AccountBean;
import com.bean.LargeTransactionBean;
import com.bean.TransactionBean;
import com.dao.AccountCreationDao;
import com.dao.MaintainTransactionDao;

@Controller
public class ViewTransactions {
	
	@Autowired
	MaintainTransactionDao maintaintransactionDao;
	
	@Autowired
	AccountCreationDao accountDao;
	
	@GetMapping("viewtransaction")
	public String viewTransaction(HttpSession session, Model model)
	{
		int userId = (int)session.getAttribute("user_id");
		System.out.println("user id in view transaction is : " + userId);
		AccountBean bean = accountDao.getSingleAccount(userId);
		List<TransactionBean> list = maintaintransactionDao.getTransactions(bean.getAccountId());
		model.addAttribute("transactions", list);
		return "viewtransaction";
	}
	
	
}
