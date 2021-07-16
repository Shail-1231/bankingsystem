package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.bean.BranchBean;
import com.dao.BranchDao;
import com.dao.RequestDao;

@Controller
public class ChangeBranchController {

	@Autowired
	RequestDao requestDao;
	
	@Autowired
	BranchDao branchDao;
	
	
	
	@GetMapping("changebranch")
	public String changeBranch() {
		return "changebranch";
	}
	
	@PostMapping("changebranch")
	public String branchChanged(@RequestParam("changebranch") String branchName, HttpSession session)
	{
		System.out.println("branch name" + branchName );
		int userId = (int) session.getAttribute("user_id");
		int requestId = (int)session.getAttribute("request_id");
		String comment = "change branch to " + branchName;
		requestDao.update(requestId, comment);
		return "redirect:/dashboard";
	}

}
