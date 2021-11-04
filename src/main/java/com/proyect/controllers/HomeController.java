package com.proyect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyect.model.User;

@Controller
public class HomeController {

	@RequestMapping("/")
    public String Home(@ModelAttribute("user") User user) {
        return "search.jsp";
//        return "searchresults.jsp";
      //return "review.jsp";
//      return "dashboard.jsp";
      //return "editpool.jsp";
      //return "poolinfo.jsp";
    }
	
}
