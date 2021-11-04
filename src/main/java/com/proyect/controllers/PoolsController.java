package com.proyect.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyect.model.Pool;
import com.proyect.model.User;
import com.proyect.service.AppService;

@Controller
public class PoolsController {

	
	private final AppService as;
    
    public PoolsController(AppService as) {
        this.as = as;
    }
//---------------------------------------------------------------------------------	
	 
//==================================    
    @RequestMapping(value="/newpool", method=RequestMethod.POST)
	    public String registerUser(@RequestParam (value = "address") String address,
						    		@RequestParam (value = "desc") String desc,
						    		@RequestParam (value = "cost") String cost,
						    		@RequestParam (value = "size") String size,
						    		@RequestParam (value = "creator_id") Long creator_id,
						    		HttpSession session,RedirectAttributes redirectAttributes) {
    	
    	boolean isValid = true;
//<Validations>
    	if (address.isEmpty() || desc.isEmpty() || cost.isEmpty()) {
    		redirectAttributes.addFlashAttribute("derrorMessage1", "📃 You leaved an empty space");
    		isValid = false;
    	}
//<Validations>
    	
    	if (isValid) {
    		as.createnewpool(address, desc, cost, size);
    		
    		List<Pool> last = as.allPools();
    		Pool current = as.getcurrentPool(last);
    		Long pool_id = current.getPool_id();
    		
    		as.linkpooltoUser(pool_id, creator_id);
    		redirectAttributes.addFlashAttribute("dsuccess", "✔ You pool has been added");
    		return "redirect:/home";
    	}
    	else {
    		redirectAttributes.addFlashAttribute("derrorMessage2", "❌ There was an error inserting you data");
    		return "redirect:/home";
    	}
    }
	    	
    
  //==================================    
    @RequestMapping(value="/search", method=RequestMethod.POST)
	    public String registerUser(@RequestParam (value = "word") String word, HttpSession session,RedirectAttributes redirectAttributes) {
    	
    	List<Pool> results = as.searchpool(word);
    	System.out.println(results.size());
    	if (results.size() == 0 || word.isEmpty()) {
    		redirectAttributes.addFlashAttribute("Nofound", "❌ There are no results, try to search something diferent");
    		session.removeAttribute("pool_search");
    		return "redirect:/home";
    		
    	}
    	
    	session.setAttribute("pool_search", results);
    	return "redirect:/home";
    }
    
	
}
