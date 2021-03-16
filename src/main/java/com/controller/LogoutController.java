package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LogoutController {
	
	@GetMapping("logout/{userId}")
	public String logout(@PathVariable("userId") int userId, Model model, HttpSession session) {
		session.removeAttribute("user_id");
		session.invalidate();
		System.out.println("The user has logged out!!!");
		return "welcome";
	}

}
