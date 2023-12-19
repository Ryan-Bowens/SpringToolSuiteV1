package com.ryan.loginandreg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.loginandreg.models.User;
import com.ryan.loginandreg.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/home")
public class HomeController {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("")
	public String index() {
		return "main/dashboard.jsp";
	}
	
	
}
