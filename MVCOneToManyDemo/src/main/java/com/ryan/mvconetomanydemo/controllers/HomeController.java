package com.ryan.mvconetomanydemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.mvconetomanydemo.models.Donation;
import com.ryan.mvconetomanydemo.models.User;
import com.ryan.mvconetomanydemo.services.DonationService;
import com.ryan.mvconetomanydemo.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private final UserService userServ;
	private final DonationService donationServ;

	public HomeController(UserService userServ, DonationService donationServ) {
		this.userServ = userServ;
		this.donationServ = donationServ;
	}

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("allDonations", donationServ.getAll());
		model.addAttribute("allUsers", userServ.getAll());
		return "main/dashboard.jsp";
	}
	
	@GetMapping("/user/create")
	public String createUser(@ModelAttribute("user") User user) {
		return "user/create.jsp";
	}
	
	@PostMapping("user/process/create")
	public String processCreateUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if(result.hasErrors()) {
			return "user/create.jsp";
		}
		userServ.create(user);
		return "redirect:/home";
	}
	
	@GetMapping("/donation/create")
	public String createDonation(@ModelAttribute("donation") Donation donation,
			Model model) {
		model.addAttribute("allUsers", userServ.getAll());
		return "donation/create.jsp";
	}
	
	@PostMapping("/donation/process/create")
	public String processCreateDonation(@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result) {
		if(result.hasErrors()) {
			return "donation/create.jsp";
		}
		donationServ.create(donation);
		return "redirect:/home";
	}
	
	@GetMapping("/user/display/{id}")
	public String displayOneUser(Model model, @PathVariable("id") Long id) {
		model.addAttribute("user", userServ.getOne(id));
		return "user/showOne.jsp";
	}
	
	@GetMapping("/donation/edit/{id}")
	public String editDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationServ.getOne(id));
		return "donation/edit.jsp";
	}
	
	@PatchMapping("/donation/process/edit/{id}")
	public String processEditDonation(@Valid @ModelAttribute("donation")
		Donation donation, BindingResult result) {
		if(result.hasErrors()) {
			return "donation/edit.jsp";
		}
//		can use update OR edit, just be consistent 
		donationServ.update(donation);
		return "redirect:/home";
	}
	
	@DeleteMapping("/donation/delete/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		donationServ.delete(id);
		return "redirect:/home";
	}
	
}
