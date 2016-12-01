package org.elevenfifty.shoppinglist.controllers;

import javax.validation.Valid;

import org.elevenfifty.shoppinglist.beans.User;
import org.elevenfifty.shoppinglist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;

	@GetMapping("/login")
	public String login(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		model.addAttribute("user", u);
		return "login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/signup")
	public String signupSave(Model model, //
			@ModelAttribute @Valid User user, //
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "signup";
		} else {
			userRepo.save(user);
			return "redirect:/login?signedup";
		}
	}

	@GetMapping("/user/edit")
	public String userEdit(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		model.addAttribute("user", u);
		return "user_edit";
	}

	@PostMapping("/user/edit")
	public String userEditSave(Model model, //
			@ModelAttribute @Valid User user, //
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "signup";
		} else {
			user.setShoppingLists(userRepo.findOne(user.getId()).getShoppingLists());
			userRepo.save(user);
			return "redirect:/lists";
		}
	}

}
