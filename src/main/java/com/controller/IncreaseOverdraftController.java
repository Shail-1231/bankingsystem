package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserOverdraftBean;
import com.dao.RequestDao;
import com.dao.UserOverdraftDao;

@Controller
public class IncreaseOverdraftController {
	
	@Autowired
	RequestDao requestDao;
	
	@Autowired
	UserOverdraftDao userOverdraftDao;
	
	@GetMapping("increaseoverdraft")
	public String increaseOverdraft()
	{
		return "increaseoverdraft";
	}
	
	@PostMapping("increaseoverdraft")
	public String overdraftIncrease(@RequestParam("overdraftincrease") int amount, HttpSession session)
	{
		String comment = "increase overdraft by " + amount;
		int requestId = (int)session.getAttribute("overdraft_req");
		int userId = (int) session.getAttribute("user_id");
		requestDao.update(requestId, comment);
		return "redirect:/dashboard";
	}
	
	@GetMapping("viewuseroverdraft")
	public String viewUserOverdraft(Model model)
	{
		List<UserOverdraftBean> list = userOverdraftDao.getUserOverdraft();
		model.addAttribute("over", list);
		return "viewuseroverdraft";
	}
}
