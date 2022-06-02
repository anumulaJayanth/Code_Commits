package com.simplilearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.model.User;
import com.simplilearn.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public String Welcomepage() {
//		return "welcome";
//	}

	@RequestMapping(value = "/list-users", method = RequestMethod.GET)
	public String showUsers(ModelMap model, @Param("keyword") String keyword) {
		model.addAttribute("users", service.searchUsers(keyword));
		model.addAttribute("keyword", keyword);
		return "list-users";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String showAddUserPage(ModelMap model) {
		model.addAttribute("user", new User((String) model.get("username"),
											(String) model.get("password"),
											(String) model.get("firstname"),
											(String) model.get("lastname"),
											(String) model.get("address"),
											(String) model.get("email")));
    	System.out.println((String) model.get("username") + " " + (String) model.get("password") + " " + (String) model.get("firstname"));
    	System.out.println(model);
		return "user";
	}
	
	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteUser(@RequestParam int id) {
		System.out.println("deleting "+ id);
		service.deleteUser(id);
		return "redirect:/list-users";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.GET)
	public String showUpdateUserPage(@RequestParam int id, ModelMap model) {
		User user = service.retrieveUser(id);
		model.put("user", user);
		return "user";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public String updateUser(ModelMap model, User user, BindingResult result) {

		if (result.hasErrors()) {
			return "user";
		}

		user.setUsername((String) model.get("username"));

		service.updateUser(user);

		return "redirect:/list-users";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addUser(ModelMap model, User user, BindingResult result) {

		if (result.hasErrors()) {
			return "user";
		}

	    user = (User) model.get("user");

    	service.addUser(user.getUsername(),
    					user.getPassword(),
    					user.getFirstname(),
    					user.getLastname(),
    					user.getAddress(),
    					user.getEmail());
		return "redirect:/list-users";
	}
}
