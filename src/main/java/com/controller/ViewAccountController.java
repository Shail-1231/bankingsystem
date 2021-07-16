package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AccountBean;
import com.bean.BranchBean;
import com.bean.TransactionBean;
import com.bean.UserBean;
import com.dao.AccountCreationDao;
import com.dao.BranchDao;
import com.dao.MaintainTransactionDao;
import com.dao.UserInfoDao;

@Controller
public class ViewAccountController {

	@Autowired
	UserInfoDao userInfoDao;

	@Autowired
	AccountCreationDao accountCreationDao;

	@Autowired
	BranchDao branchDao;

	@Autowired
	MaintainTransactionDao transactionDao;

	@GetMapping("viewaccount")
	public String viewAccount(HttpSession session, Model model) {
		int userId = (int) session.getAttribute("user_id");
		System.out.println("user id is " + userId);
		AccountBean accountBean = accountCreationDao.getSingleAccount(userId);
		UserBean userBean = userInfoDao.getSingleRecord(userId);
		System.out.println("account id is " + accountBean.getAccountId());
		int branchId = accountBean.getBranchId();
		int accountId = accountBean.getAccountId();
		BranchBean branchBean = branchDao.getBranchById(branchId);

		System.out.println("after");
		model.addAttribute("userBean", userBean);
		model.addAttribute("accountBean", accountBean);
		model.addAttribute("branchBean", branchBean);

		return "viewaccount";
	}
}
