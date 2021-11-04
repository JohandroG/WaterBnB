package com.proyect.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyect.model.Pool;
import com.proyect.model.User;
import com.proyect.service.AppService;

@Controller
public class UsersController {

	   private final AppService as;
	    
	    public UsersController(AppService as) {
	        this.as = as;
	    }
//---------------------------------------------------------------------------------	


	    
//================================
	@RequestMapping("/user")
    public String registerForm(@ModelAttribute("user") User user) {
        return "LoginandReg.jsp";
    }

//=================================
	 @RequestMapping(value="/register", method=RequestMethod.POST)
	    public String registerUser(@RequestParam (value = "first_name") String firstname,
						    		@RequestParam (value = "last_name") String lastname,
						    		@RequestParam (value = "email") String email,
						    		@RequestParam (value = "password") String password,
						    		@RequestParam (value = "passwordReview") String conf,
						    		@RequestParam (value = "admin") String admin,
						    		HttpSession session,RedirectAttributes redirectAttributes) {
	    	
	    	List<User> match = as.getlistofUsersByEmail(email);
	    	boolean isValid = true;
//<Validations>
	    	if( match.size() > 0 ) {
	    		redirectAttributes.addFlashAttribute("rerrorMessage1", "📧 That email is already in use!");
	    		isValid = false;
	    	}
	    	if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty()) {
	    		redirectAttributes.addFlashAttribute("rerrorMessage2", "📃 You leaved an empty space");
	    		isValid = false;
	    	}
	    	if (firstname.length() < 3) {
	    		redirectAttributes.addFlashAttribute("rerrorMessage3", "⚠ The firstname must be at least 3 characters long");
	    		isValid = false;
	    	}
	    	if (lastname.length() < 3) {
	    		redirectAttributes.addFlashAttribute("rerrorMessage4", "⚠ The lastname must be at least 3 characters long");
	    		isValid = false;
	    	}
	    	if (password.length() < 8 ) {
	    		redirectAttributes.addFlashAttribute("rerrorMessage5", "⚠ The password must be at least 8 characters long");
	    		isValid = false;
	    	}
		    if (!password.equals( conf )) {
		    	redirectAttributes.addFlashAttribute("rerrorMessage6","🔑 The password doesn't match");
		    	isValid = false;
		    }
//<Validations>
//<Insert>		    
		    if (isValid) {
		    	as.registerUser(firstname,lastname,email,password,admin);
		    	
		    	User unew = as.getUserByEmail(email);
		    	session.setAttribute("user_id", unew.getUser_id());
		    	
		    	return "redirect:/home";
		    }
		    else {
		    	return "redirect:/user";
		    }
//<Insert>
		} 


//===============================
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String lemail, 
	    		@RequestParam("user_password") String lpassword, 
	    		HttpSession session, RedirectAttributes redirectAttributes) {
	        	    	
	    	User current = as.getUserByEmail(lemail);
	    	boolean isValid = true;
	    	
//<Validations>
	    	if (lemail.isEmpty() || lpassword.isEmpty()) {
	    		redirectAttributes.addFlashAttribute("lerrorMessage1", "📃 You leaved an empty space");
	    		isValid = false;
	    	}
	    	
	    	if( current == null && isValid) {
	    		redirectAttributes.addFlashAttribute("lerrorMessage2", "📧 There is no user with this email!");
	    		isValid = false;
	    	}
	    	
//<Validations>
	    	
//<Insert>
	    	if(isValid) {
	    		if( as.validateUser(current, lpassword) ) {
	    			User u = as.getUserByEmail(lemail);
			    	session.setAttribute("user_id", u.getUser_id());
			    	return "redirect:/home";
				}
				else {
					
			    	redirectAttributes.addFlashAttribute("lerrorMessage3", "🔑 The password for this email is incorrect");
			    	return "redirect:/user";
	    	}
	    	}
	    	else {
	    		return "redirect:/user";
	    	}
//<Insert>
	    }	
	
	    @RequestMapping("/home")
	    public String home(HttpSession session, Model model) {
	    	
	    	Long user_id =  (Long) session.getAttribute("user_id");
	    	User current = as.findUsingID(user_id);
	    	List<Pool> results = (List<Pool>) session.getAttribute("pool_search");
	    	
	    	
	    	if(current == null) {
	    		return "redirect:/user";
	    	}
	    	if (current.getAdmin().equals("Host")) {
	    		
	    		model.addAttribute("userInfo", current );
		    	return "dashboard.jsp";
	    	}
	    	else {
	    		model.addAttribute("poolInfo", results );
	    		model.addAttribute("userInfo", current );
	    		return "searchresults.jsp";
	    	}
	    	
	    	
	    }
	
//===============================	    
	    @RequestMapping("/logout")
	    public String logout( HttpSession session ) {
			session.removeAttribute("user_id");
			return "redirect:/user";
		}
	
	
	
	
	
	
	
	
	
	
}//Controller end
