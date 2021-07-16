package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.AccountBean;
import com.bean.BranchBean;
import com.dao.AccountCreationDao;
import com.dao.BranchDao;

@Controller
public class ViewBranchController {
	
	@Autowired
	AccountCreationDao accountDao;
	
	@Autowired
	BranchDao branchDao;
	
	@GetMapping("branch")
	public String viewBranchDetails(HttpSession session, Model model)
	{
		int user_id = (int)session.getAttribute("user_id");
		AccountBean bean = accountDao.getSingleAccount(user_id);
		BranchBean branchBean = branchDao.getBranchById(bean.getBranchId());
		model.addAttribute("branch", branchBean);
		return "branchdetails";
		
	}
}
