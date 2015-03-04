package com.pizza.delivery.controllers;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(ModelAndView model) {
		String message = "Hello World, Spring 3.0!";
		model.addObject("message", message);
		return "home";

	}
//	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
//	public ModelAndView welcomePage() {
// 
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Custom Login Form");
//		model.addObject("message", "This is welcome page!");
//		model.setViewName("hello");
//		return model;
// 
//	}
 
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() { 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin"); 
		return model; 
	}
 
//	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
 
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		model.setViewName("login");
 		return model;
	}
	
	@RequestMapping("403page")  
	 public String ge403denied() {  
	  return "redirect:login?denied";  
	 }  
		
		
//	@RequestMapping("/home")
//	public
//	ModelAndView handleRequest(HttpServletRequest request,	HttpServletResponse response)throws	Exception {
//	ModelAndView modelAndView = new	ModelAndView("home");
//	modelAndView.addObject("login","Example login");
//	return	modelAndView;
//	}
}