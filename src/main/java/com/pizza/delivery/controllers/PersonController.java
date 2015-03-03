package com.pizza.delivery.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pizza.delivery.domain.Person;
import com.pizza.delivery.services.PersonDAO;


@Controller
@RequestMapping(value = "/createPerson")
public class PersonController {
	
	@Autowired
	private PersonDAO<Person> personDAO;
	
	@RequestMapping( method = RequestMethod.GET )
	public String createPerson(Model model){
//	ModelAndView model = new ModelAndView("createPerson");
	Person person = new Person();
	model.addAttribute("person", person);
	return "createPerson";
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public ModelAndView saveNewPerson(@ModelAttribute("userForm") Person person, Map<String, Object> model){
		personDAO.create(person);
		String message = null;
		//return "redirect:/createPerson";
		return new ModelAndView("home", "message", message);
		
	}
}