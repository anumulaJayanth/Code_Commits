package com.simplilearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.model.SportShoes;
import com.simplilearn.service.ShoesService;

@Controller
public class ShoesController {

	@Autowired
	ShoesService service;

	@RequestMapping(value = "/list-shoes", method = RequestMethod.GET)
	public String showShoes(ModelMap model, @Param("keyword") String keyword) {
		model.addAttribute("shoeslist", service.searchShoes(keyword));
		model.addAttribute("keyword", keyword);
		return "list-shoes";
	}
	
	@RequestMapping(value = "/list-shoes/{keyword}", method = RequestMethod.GET)
	public String categorizeShoes(ModelMap model, @PathVariable("keyword") String keyword) {
		
		model.addAttribute("shoeslist", service.searchShoes(keyword));
		model.addAttribute("keyword", keyword);
		System.out.println("I am here");
		return "list-shoes";
	}

	@RequestMapping(value = "/add-shoes", method = RequestMethod.GET)
	public String showAddShoesPage(ModelMap model) {
		model.addAttribute("shoes", new SportShoes((String) model.get("shoetype"),
													(String) model.get("gender"),
													8.5,//Double.parseDouble((String) model.get("size")),
													(String) model.get("color"),
													55.99));//Double.parseDouble((String) model.get("price"))));
    	System.out.println(model);
		return "shoes";
	}


	@RequestMapping(value = "/update-shoes", method = RequestMethod.GET)
	public String showUpdateShoesPage(@RequestParam int id, ModelMap model) {
		SportShoes shoes = service.retrieveSportShoes(id);
		model.put("shoes", shoes);
		return "shoes";
	}

	@RequestMapping(value = "/update-shoes", method = RequestMethod.POST)
	public String updateShoes(ModelMap model, SportShoes shoes, BindingResult result) {

		if (result.hasErrors()) {
			return "shoes";
		}

		shoes = (SportShoes) model.get("sportShoes");
		service.updateSportShoes(shoes);

		return "redirect:/list-shoes";
	}

	@RequestMapping(value = "/add-shoes", method = RequestMethod.POST)
	public String addShoes(ModelMap model, SportShoes shoes, BindingResult result) {

		if (result.hasErrors()) {
			return "shoes";
		}

		shoes = (SportShoes) model.get("sportShoes");
    	System.out.println("Model: "+model);

    	service.addSportShoes(shoes.getShoetype(),
	    					  shoes.getGender(),
	    					  shoes.getSize(),
	    					  shoes.getColor(),
	    					  shoes.getPrice());
		return "redirect:/list-shoes";
	}

}
