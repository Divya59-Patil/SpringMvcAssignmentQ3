package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;

@Controller
public class UserController {
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String demo() {
		return "login";
	}
	
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("user") User user) {
        // check user authentication here
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin123")) {
            return new ModelAndView("success", "message", "Login successful!");
        } else {
            return new ModelAndView("error", "message", "Invalid username or password.");
        }
    }
}


