package com.ryan.loginandregassignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ryan.loginandregassignment.models.LoginUser;
import com.ryan.loginandregassignment.models.User;
import com.ryan.loginandregassignment.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("")
public class UserController {

	public UserController() {}
	
	@Autowired
	private UserService userServ;

	@GetMapping("")
	public String loginRegUser(@ModelAttribute("user")User user, @ModelAttribute("loginUser")
		LoginUser loginUser) {
		return "user/loginReg.jsp";
	}
	
	@PostMapping("/process/register")
	public String processRegister(@Valid @ModelAttribute("user")User user,
			BindingResult result, Model model, HttpSession session) {
		if(userServ.getUser(user.getEmail())!= null) {
			result.rejectValue("email", "Unique", "Email is already in use");
		}
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("password", "Match", "Passwords don't match");
		}
		
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "user/loginReg.jsp";
		}
		User newUser = userServ.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		session.setAttribute("userName", newUser.getUserName());
		return "redirect:/welcome";
	}
		
	@PostMapping("/process/login")
	public String processLoginUser(@Valid @ModelAttribute("loginUser")LoginUser loginUser,
			BindingResult result, Model model, HttpSession session) {
		User loggingUser = userServ.login(loginUser, result);
		if(result.hasErrors()) {
			model.addAttribute("user", new User());
			return "user/loginReg.jsp";
		}
		session.setAttribute("user_id", loggingUser.getId());
		session.setAttribute("userName", loggingUser.getUserName());
		return "redirect:/welcome";
	}
}
