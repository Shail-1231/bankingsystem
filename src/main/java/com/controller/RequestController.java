package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AccountBean;
import com.bean.RequestBean;
import com.dao.AccountCreationDao;
import com.dao.RequestDao;

@Controller
public class RequestController {

	@Autowired
	AccountCreationDao accountCreationDao;

	@Autowired
	RequestDao requestDao;

	@GetMapping("request")
	public String request() {
		return "request";
	}

	@PostMapping("request")
	public String requestGiven(@RequestParam("request") String request, HttpSession session) {
		int userId = (int) session.getAttribute("user_id");
		int accountId = 0;
		List<AccountBean> list = accountCreationDao.getAccountId(userId);
		for (AccountBean obj : list) {
			accountId = obj.getAccountId();
		}
		session.setAttribute("account_id", accountId);
		requestDao.insert(request, userId, accountId);
		String loanComment = "take a loan";
		String overDraftComment = "increase overdraft ";
		RequestBean requestBean = requestDao.getRequestId();
		System.out.println("request Id : " + requestBean.getRequestId());
		session.setAttribute("request_id", requestBean.getRequestId());
		if (request.equals("loan")) {
			requestDao.update(requestBean.getRequestId(), loanComment);
			return "redirect:/loan";
		}

		else if (request.equals("changebranch")) {
			return "redirect:/changebranch";
		}

		else if (request.equals("overdraft")) {
			session.setAttribute("overdraft_req", requestBean.getRequestId());
			return "redirect:/increaseoverdraft";
		}

		else {
			return "redirect:/dashboard";
		}
	}
}
