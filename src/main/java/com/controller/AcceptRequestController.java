package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AccountBean;
import com.bean.BranchBean;
import com.bean.RequestBean;
import com.dao.AccountCreationDao;
import com.dao.BranchDao;
import com.dao.LoanDao;
import com.dao.RequestDao;

@Controller
public class AcceptRequestController {
	
	
	@Autowired
	RequestDao requestDao;
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	LoanDao loanDao;
	
	@Autowired
	AccountCreationDao accountCreationDao;
	
	@GetMapping("/acceptrequest/{requestid}/{userid}/{comment}")
	public String acceptRequest(@PathVariable("requestid") int requestId, @PathVariable("userid")int userId, @PathVariable("comment")String comment)
	{
		System.out.println("The request id is " + requestId);
		//RequestBean requestBean = requestDao.getRequestById(requestId);
		requestDao.approve(requestId);
		
		String branch;
		if(comment.contains("loan"))
		{
			loanDao.updateStatus("approved");
		}
		//System.out.println("get branch id " + accou);
		if(comment.contains("branch"))
		{
			System.out.println("comment is " + comment);
			if(comment.contains("Paldi"))
			{
				branch = "Paldi";
			}
			else if(comment.contains("Kathwada"))
			{
				branch = "Kathwada";
			}
			else if(comment.contains("Bopal"))
			{
				branch = "Bopal";
			}
			
			else
			{
				branch = "Prahladnagar";
			}
			
			BranchBean bean = branchDao.getBranchByName(branch);
			//AccountBean accountBean = accountCreationDao.getSingleAccount(userId);
			requestDao.changeBranchFunction(userId, bean.getBranchId());
		}
		
		if(comment.contains("overdraft"))
		{
			//call function here increase overdraft by 1000
			String test =  comment;
			int amount = (Integer.parseInt(test.substring(test.lastIndexOf(" ")+1)));
			AccountBean bean = accountCreationDao.getSingleAccount(userId);
			System.out.println("Amount is : " + amount);
			requestDao.increaseOverDraft(userId, amount);
		}
		return null;
	}
	
}
