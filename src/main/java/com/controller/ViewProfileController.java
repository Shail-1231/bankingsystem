package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.RequestBean;
import com.dao.RequestDao;
import com.dao.SeeRequestDao;

@Controller
public class ViewProfileController {
	
	
	@Autowired
	SeeRequestDao seeDao;
	
	@GetMapping("viewprofile/{userId}")
	public String viewProfile(@PathVariable("userId") int userId, HttpSession session, Model model)
	{
		session.setAttribute("user_id", userId);
		List<RequestBean> list = seeDao.allRequests(userId);
		model.addAttribute("requests", list);
		return "viewprofile";
	}
}
