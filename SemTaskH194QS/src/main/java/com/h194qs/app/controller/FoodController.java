package com.h194qs.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.h194qs.app.model.Foods;
import com.h194qs.app.service.FoodService;

@Controller
public class FoodController {

	@Autowired
	private FoodService service; 
	
	@RequestMapping("/allfoods")
	public String viewHomePage(Model model) {
		List<Foods> listFoods = service.listAll();
		model.addAttribute("listFoods", listFoods);
		
		return "admin/foodList";
	}

	@RequestMapping(value ="/allfoods/new")
	public String showNewFoodPage(Model model) {
		Foods foods= new Foods();
		model.addAttribute("foods", foods);
		
		return "admin/foodNew";
	}
	
	@RequestMapping(value ="/allfoods/save", method = RequestMethod.POST)
	public String saveFood(@ModelAttribute("Foods")Foods foods) {
		service.save(foods);
		
		return "redirect:/allfoods";
	}
	
	@RequestMapping("/allfoods/edit/{id}")
	public ModelAndView showEditFoodPage(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("admin/foodEdit");
		Foods foods = service.get(id);
		mav.addObject("foods", foods);
		
		return mav;
	}
	
	
	@RequestMapping("/allfoods/delete/{id}")
	public String deleteFood(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/allfoods";		
	}
	
	@RequestMapping("/allfoods/select/{id}")
	public ModelAndView showAllData(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("admin/foodSelect");
		Foods foods = service.get(id);
		mav.addObject("foods", foods);
		return mav;
	}
	

}
