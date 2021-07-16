package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.UserBean;
import com.dao.UserInfoDao;

@Controller
public class DashBoardController {

	
	@Autowired
	UserInfoDao userInfoDao;
	
	@GetMapping("dashboard")
	public String dashBoard(HttpSession session, Model model) {
		int user_id = (int) session.getAttribute("user_id");
		System.out.println(user_id);
		List<UserBean> user = userInfoDao.getUserById(user_id);

		model.addAttribute("user", user);
		return "dashboard";
	}

}
