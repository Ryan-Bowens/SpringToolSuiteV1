package com.ryan.loginandregassignment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/welcome")
public class HomeController {
	
	public HomeController() {}
	
	@GetMapping("")
	public String index(HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
//		^ if not logged in/cant detect a user's id then can't get through to that route
		return "main/dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
