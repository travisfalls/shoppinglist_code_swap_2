package org.elevenfifty.shoppinglist.controllers;

import javax.validation.Valid;

import org.elevenfifty.shoppinglist.beans.ShoppingListItem;
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
public class ShoppingListItemController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	ShoppingListRepository shoppingListRepo;

	@Autowired
	ShoppingListItemRepository shoppingListItemRepo;

	@GetMapping("/lists/{listId}/items/add")
	public String addListItem(Model model, @PathVariable(name = "listId") long listId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		model.addAttribute("user", u);
		model.addAttribute("listId", listId);
		model.addAttribute("listItem", new ShoppingListItem());
		return "list_item_add";
	}

	@PostMapping("/lists/{listId}/items/add")
	public String addListItemSave(Model model, @PathVariable(name = "listId") long listId,
			@ModelAttribute @Valid ShoppingListItem listItem, BindingResult result) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		model.addAttribute("user", u);
		model.addAttribute("listId", listId);
		if (result.hasErrors()) {
			model.addAttribute("listItem", listItem);
			return "list_item_add";
		} else {
			listItem.setShoppingList(shoppingListRepo.findOne(listId));
			shoppingListItemRepo.save(listItem);
			return "redirect:/lists/" + listId;
		}
	}

	@GetMapping("/lists/{listId}/items/{listItemId}")
	public String viewListItem(Model model, @PathVariable(name = "listId") long listId,
			@PathVariable(name = "listItemId") long listItemId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		model.addAttribute("user", u);
		model.addAttribute("listItem", shoppingListItemRepo.findOne(listItemId));
		return "list_item_view";
	}

	// @PostMapping("/lists/{listId}/items/{listItemId}/check")
	// public String checkListItem(Model model) {
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// String email = auth.getName();
	// User u = userRepo.findOneByEmail(email);
	// model.addAttribute("user", u);
	// }
	//
	// @PostMapping("/lists/{listId}/items/{listItemId}/uncheck")
	// public String uncheckListItem(Model model) {
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// String email = auth.getName();
	// User u = userRepo.findOneByEmail(email);
	// model.addAttribute("user", u);
	// }

}
