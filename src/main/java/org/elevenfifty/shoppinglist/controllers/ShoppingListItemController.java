package org.elevenfifty.shoppinglist.controllers;

import javax.validation.Valid;

import org.elevenfifty.shoppinglist.beans.ShoppingListItem;
import org.elevenfifty.shoppinglist.beans.User;
import org.elevenfifty.shoppinglist.repositories.ShoppingListItemPriorityRepository;
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

	@Autowired
	ShoppingListItemPriorityRepository shoppingListItemPriorityRepo;

	@GetMapping("/lists/{listId}/items/add")
	public String addListItem(Model model, @PathVariable(name = "listId") long listId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		if (shoppingListRepo.findOne(listId).getUser().equals(u)) {
			model.addAttribute("user", u);
			model.addAttribute("listId", listId);
			ShoppingListItem sli = new ShoppingListItem();
			sli.setShoppingList(shoppingListRepo.findOne(listId));
			model.addAttribute("listItem", sli);
			model.addAttribute("priorities", shoppingListItemPriorityRepo.findAll());
			return "list_item_add";
		} else {
			return "redirect:/error";
		}
	}

	@PostMapping("/lists/{listId}/items/add")
	public String addListItemSave(Model model, @PathVariable(name = "listId") long listId,
			@ModelAttribute @Valid ShoppingListItem listItem, BindingResult result) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		if (shoppingListRepo.findOne(listId).getUser().equals(u)) {
			if (result.hasErrors()) {
				model.addAttribute("user", u);
				model.addAttribute("listId", listId);
				model.addAttribute("listItem", listItem);
				model.addAttribute("priorities", shoppingListItemPriorityRepo.findAll());
				return "list_item_edit";
			} else {
				shoppingListItemRepo.save(listItem);
				System.out.println("SAVED LIST ITEM ID " + listItem.getId());
				return "redirect:/lists/" + listId;
			}
		} else {
			return "redirect:/error";
		}
	}

	@GetMapping("/lists/{listId}/items/{itemId}/edit")
	public String editListItem(Model model, @PathVariable(name = "listId") long listId,
			@PathVariable(name = "itemId") long itemId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		if (shoppingListRepo.findOne(listId).getUser().equals(u)) {
			model.addAttribute("user", u);
			model.addAttribute("listId", listId);
			model.addAttribute("listItem", shoppingListItemRepo.findOne(itemId));
			model.addAttribute("priorities", shoppingListItemPriorityRepo.findAll());
			return "list_item_edit";
		} else {
			return "redirect:/error";
		}
	}

	@PostMapping("/lists/{listId}/items/{itemId}/edit")
	public String editListItemSave(Model model, @PathVariable(name = "listId") long listId,
			@PathVariable(name = "itemId") long itemId, @ModelAttribute @Valid ShoppingListItem listItem,
			BindingResult result) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		if (shoppingListRepo.findOne(listId).getUser().equals(u)) {
			if (result.hasErrors()) {
				model.addAttribute("user", u);
				model.addAttribute("listId", listId);
				model.addAttribute("listItem", listItem);
				model.addAttribute("priorities", shoppingListItemPriorityRepo.findAll());
				return "list_item_edit";
			} else {
				listItem.setShoppingList(shoppingListRepo.findOne(listId));
				shoppingListItemRepo.save(listItem);
				return "redirect:/lists/" + listId;
			}
		} else {
			return "redirect:/error";
		}
	}

	@GetMapping("/lists/{listId}/items/{listItemId}")
	public String viewListItem(Model model, @PathVariable(name = "listId") long listId,
			@PathVariable(name = "listItemId") long listItemId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		if (shoppingListRepo.findOne(listId).getUser().equals(u)) {
			model.addAttribute("user", u);
			model.addAttribute("listItem", shoppingListItemRepo.findOne(listItemId));
			return "list_item_view";
		} else {
			return "redirect:/error";
		}
	}

	@PostMapping("/lists/{listId}/items/{listItemId}/check")
	public String checkListItem(Model model, @PathVariable(name = "listId") long listId,
			@PathVariable(name = "listItemId") long listItemId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		if (shoppingListRepo.findOne(listId).getUser().equals(u)) {
			ShoppingListItem sli = shoppingListItemRepo.findOne(listItemId);
			sli.setChecked(true);
			shoppingListItemRepo.save(sli);
			return "redirect:/lists/" + listId;
		} else {
			return "redirect:/error";
		}
	}

	@PostMapping("/lists/{listId}/items/{listItemId}/uncheck")
	public String uncheckListItem(Model model, @PathVariable(name = "listId") long listId,
			@PathVariable(name = "listItemId") long listItemId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		if (shoppingListRepo.findOne(listId).getUser().equals(u)) {
			ShoppingListItem sli = shoppingListItemRepo.findOne(listItemId);
			sli.setChecked(false);
			shoppingListItemRepo.save(sli);
			return "redirect:/lists/" + listId;
		} else {
			return "redirect:/error";
		}
	}

	@PostMapping("/lists/{listId}/items/{listItemId}/delete")
	public String deleteListItem(Model model, @PathVariable(name = "listId") long listId,
			@PathVariable(name = "listItemId") long listItemId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		User u = userRepo.findOneByEmail(email);
		if (shoppingListRepo.findOne(listId).getUser().equals(u)) {
			shoppingListItemRepo.delete(listItemId);
			return "redirect:/lists/" + listId;
		} else {
			return "redirect:/error";
		}
	}

}
