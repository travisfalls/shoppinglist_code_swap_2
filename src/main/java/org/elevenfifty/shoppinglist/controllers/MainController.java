package org.elevenfifty.shoppinglist.controllers;

import org.elevenfifty.shoppinglist.beans.User;
import org.elevenfifty.shoppinglist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	UserRepository userRepo;

	@GetMapping("/error")
	public String error(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		model.addAttribute("user", u);
		return "error";
	}

}
