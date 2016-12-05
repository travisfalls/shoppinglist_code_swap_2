package org.elevenfifty.shoppinglist.controllers;

import javax.validation.Valid;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.beans.User;
import org.elevenfifty.shoppinglist.repositories.ShoppingListItemRepository;
import org.elevenfifty.shoppinglist.repositories.ShoppingListRepository;
import org.elevenfifty.shoppinglist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class ShoppingListController {
	
	@Autowired
	private ShoppingListRepository shoppingListRepo;
	
	@Autowired
	private ShoppingListItemRepository shoppingListItemRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/")
	public String home(Model model) {
		return "redirect:/lists";
	}
	
	@GetMapping("/lists")
	public String lists(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		model.addAttribute("lists", shoppingListRepo.findAllByUser(u));
		model.addAttribute("user", u);
		return "lists";
	}
	
	@GetMapping("/lists/{listId}")
	public String list(Model model, @PathVariable(name = "listId") long listId) {
		model.addAttribute("listId", listId);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		ShoppingList s = shoppingListRepo.findOne(listId);
		model.addAttribute("listItems", shoppingListItemRepo.findByShoppingListId(listId));
		model.addAttribute("shoppingList", s);
		model.addAttribute("user", u);
		return "listView";
	}
	
	@GetMapping("/lists/add")
	public String listAdd(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		model.addAttribute("user", u);
		ShoppingList shopList = new ShoppingList();
		shopList.setUser(u);
		model.addAttribute("list", shopList);
		return "listAdd";
	}
	
	@PostMapping("/lists/add")
	public String listAddSave(Model model, @ModelAttribute @Valid ShoppingList list, BindingResult result) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		model.addAttribute("user", u);
//		if (result.hasErrors()) {
//			model.addAttribute("list", list);
//			return "listAdd";
//		} else {
			shoppingListRepo.save(list);
			return "redirect:/lists/" + list.getId();
//		}
	}

	
	

	
	
	
	

	
}
