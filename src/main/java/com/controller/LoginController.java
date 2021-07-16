package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.UserBean;
import com.bean.UserProfileBean;
import com.dao.AccountCreationDao;
import com.dao.AccountTypeDao;
import com.dao.BranchDao;
import com.dao.ProofTypeDao;
import com.dao.UserInfoDao;
import com.dao.UserProfileDao;
import com.services.GenerateAccountNumberService;
import com.services.ImageService;

@Controller
public class LoginController {

	@Autowired
	GenerateAccountNumberService accountNumberService;

	@Autowired
	ImageService imageService;

	@Autowired
	UserProfileDao userProfileDao;

	@Autowired
	ProofTypeDao proofTypeDao;

	@Autowired
	UserInfoDao userInfoDao;

	@Autowired
	BranchDao branchDao;

	@Autowired
	AccountTypeDao accountDao;

	@Autowired
	AccountCreationDao accountCreationDao;

	int id;

	@GetMapping("/")
	public String welcome() { // welcome screen for signup and sign in
		return "welcome";
	}

	@GetMapping("loginpage")
	public String loginpage() { // login page
		return "loginpage";
	}

	@PostMapping("loginpage")
	public String loggedIn(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		if (email.equals("admin@admin.com") && password.equals("admin")) {
			return "redirect:/allusers";
		}

		UserBean userBean = userInfoDao.getSingleRecordWithEmail(email);
		System.out.println("S LCOK : " + userBean.getIsLock());
		if (userBean.getIsLock() == 0) {
			return "accountlock";
		}
		int flag = 0;

		System.out.println("Email : " + email);
		System.out.println("Password : " + password);

		List<UserBean> list = userInfoDao.getAllUsers();

		userInfoDao.authenticateUser(email, password);
		userInfoDao.lockAccount(email, password);
		for (UserBean bean : list) {
			System.out.println(bean.getEmail());
			System.out.println(bean.getPassword());
			if (bean.getEmail().equals(email) && bean.getPassword().equals(password)) {
				System.out.println("I am inside");
				session.setAttribute("user_id", bean.getUserId());
				flag = 1;
				break;
			}
		}

		if (flag == 1) {
			return "redirect:/dashboard";
		}

		else {
			return "wrongcredentials";
		}

	}

	@GetMapping("allusers")
	public String listUsers(Model model) {
		List<UserBean> users = userInfoDao.getAllUsers();
		model.addAttribute("users", users);
		return "allusers";
	}

	@GetMapping("signuppage") // sign up page for the customer
	public String signUp(Model model) {

		model.addAttribute("userInfo", new UserBean());
		return "signuppage";
	}

	@PostMapping("signuppage")
	public String signUpDone(@ModelAttribute("userInfo") UserBean bean, Model model, HttpSession session) {
		System.out.println(bean.getRoleId());
		bean.setWrongAttempt(3);
		bean.setIsLock(1);
		model.addAttribute("userInfo", bean);
		int id = userInfoDao.insertQuery(bean);
		if (id == -1) {
			model.addAttribute("message", "duplicate email ");
			return "signuppage";
		}
		System.out.println("s 127 ");
		session.setAttribute("user_id", id);
		System.out.println(bean.getEmail());
		System.out.println(id);
		return "redirect:/userprofile";
	}

	@GetMapping("userprofile")
	public String userProfile(Model model) {

		model.addAttribute("proofType", proofTypeDao.getAllProofType());

		return "userprofile";
	}

	@PostMapping("userprofile")
	public String profileCreated(@ModelAttribute("userProfile") UserProfileBean bean,
			@RequestParam("addressProofI") MultipartFile proofFile,
			@RequestParam("profilePictureI") MultipartFile profileFile,
			@RequestParam("panPictureI") MultipartFile panFile, Model model, HttpSession session) {
		System.out.println(bean.getPanNumber());
		int id = (Integer) session.getAttribute("user_id");
		bean.setUserId(id);
		bean.setUserProfileId(id);
		imageService.uploadImage(proofFile, "user/" + id + "/", "proof.jpg");
		imageService.uploadImage(profileFile, "user/" + id + "/", "profile.jpg");
		imageService.uploadImage(panFile, "user/" + id + "/", "pan.jpg");
		bean.setAddressProof("/resources/images/user/" + id + "/" + proofFile.getOriginalFilename());
		bean.setProfilePicture("/resources/images/user/" + id + "/" + profileFile.getOriginalFilename());
		bean.setPanPicture("/resources/images/user/" + id + "/" + panFile.getOriginalFilename());
		model.addAttribute("userProfile", bean);
		userProfileDao.insert(bean);

		return "redirect:/branchaccountselect";
	}

	@GetMapping("branchaccountselect")
	public String selectBranchAccount(Model model) {
		model.addAttribute("branchSelect", branchDao.getAllBranch());
		model.addAttribute("accountType", accountDao.getAllAccountType());
		return "branchaccountselect";
	}

	@PostMapping("branchaccountselect")
	public String accountCreation(@RequestParam("accountTypeId") int accountTypeId,
			@RequestParam("branchId") int branchId, HttpSession session) {
		System.out.println("account id : " + accountTypeId);
		System.out.println("branch id : " + branchId);
		System.out.println("user id : " + session.getAttribute("user_id"));
		int user_id = (int) session.getAttribute("user_id");
		String accountNumber = accountNumberService.getAlphaNumericString(10);
		session.setAttribute("account_number", accountNumber);
		System.out.println("account number : " + accountNumber);
		accountCreationDao.insert(branchId, user_id, accountTypeId, accountNumber);

		return "redirect:/dashboard";
	}

//	@GetMapping("dashboard")
//	public String dashBoard(HttpSession session, Model model) {
//		int user_id = (int) session.getAttribute("user_id");
//		List<UserBean> user = userInfoDao.getUserById(user_id);
//
//		model.addAttribute("user", user);
//		return "dashboard";
//	}

//	@GetMapping("logout/{userId}")
//	public String logout(@PathVariable("userId") int userId, Model model, HttpSession session) {
//		session.removeAttribute("user_id");
//		session.invalidate();
//		System.out.println("The user has logged out!!!");
//		return "welcome";
//	}

//	@GetMapping("changepassword")
//	public String changePassword() {
//		return "changepassword";
//	}
//
//	@PostMapping("changepassword")
//	public String passwordChanged(@RequestParam("password") String password, HttpSession session) {
//		int user_id = (int) session.getAttribute("user_id");
//		userInfoDao.updateUserPassword(password, user_id);
//		return "redirect:/dashboard";
//	}

//	@GetMapping("deposit")
//	public String depositAmount() {
//		return "deposit";
//	}
//
//	@PostMapping("deposit")
//	public String amountDeposited(@RequestParam("depositAmount") int depositAmount, HttpSession session) {
//		int user_id = (int) session.getAttribute("user_id");
//		accountCreationDao.depositAmount(depositAmount, user_id);
//		return "redirect:/dashboard";
//	}
//
//	@GetMapping("withdraw")
//	public String withdrawAmount() {
//		return "withdraw";
//	}
//
//	@PostMapping("withdraw")
//	public String amountWithdrawn(@RequestParam("withdrawAmount") int withdrawAmount, HttpSession session) {
//		int user_id = (int) session.getAttribute("user_id");
//		int flag = 0;
//		accountCreationDao.withdrawAmount(withdrawAmount, user_id);
//		List<AccountBean> accountBean = accountCreationDao.getBalance(user_id);
//		for (AccountBean bean : accountBean) {
//			System.out.println("Balance is : " + bean.getBalance());
//			if (bean.getBalance() <= 5000) {
//				accountCreationDao.depositAmount(withdrawAmount, user_id);
//				flag = 1;
//			}
//		}
//
//		if (flag == 1) {
//			return "errorpagewithdrawal";
//		}
//
//		else {
//			return "redirect:/dashboard";
//		}
//
//	}
//
//	@GetMapping("transfer")
//	public String transferAmount() {
//		return "transfer";
//	}
//
//	@PostMapping("transfer")
//	public String amountTransferred(@RequestParam("accountNumber") String accountNumber,
//			@RequestParam("transferAmount") int transferAmount, HttpSession session) {
//
//		int user_id = (int) session.getAttribute("user_id");
//		accountCreationDao.withdrawAmount(transferAmount, user_id);
//
//		int flag = 0;
//		List<AccountBean> accountBean = accountCreationDao.getBalance(user_id);
//		for (AccountBean bean : accountBean) {
//			System.out.println("Balance is : " + bean.getBalance());
//			if (bean.getBalance() <= 5000) {
//				accountCreationDao.depositAmount(transferAmount, user_id);
//				flag = 1;
//			}
//		}
//
//		if (flag == 1) {
//			return "errorpagewithdrawal";
//		} else {
//			accountCreationDao.transferAmount(accountNumber, transferAmount);
//			return "redirect:/dashboard";
//		}
//	}

}
