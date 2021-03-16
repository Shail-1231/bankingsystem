package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.UserInfoDao;

@Controller
public class ChangePasswordController {
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@GetMapping("changepassword")
	public String changePassword() {
		return "changepassword";
	}

	@PostMapping("changepassword")
	public String passwordChanged(@RequestParam("password") String password, HttpSession session) {
		int user_id = (int) session.getAttribute("user_id");
		userInfoDao.updateUserPassword(password, user_id);
		return "redirect:/dashboard";
	}
}
