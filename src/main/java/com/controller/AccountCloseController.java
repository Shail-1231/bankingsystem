package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.AccountBean;
import com.dao.AccountCreationDao;

@Controller
public class AccountCloseController {
	
	
	@Autowired
	AccountCreationDao accountCreationDao;
	
	@GetMapping("closeaccount")
	public String closeAccount(HttpSession session)
	{
		int userId = (int)session.getAttribute("user_id");
		AccountBean bean = accountCreationDao.getSingleAccount(userId);
		System.out.println("account id : " + bean.getAccountId());
		accountCreationDao.closeAccount(bean.getAccountId());
		return null;
	}
}
