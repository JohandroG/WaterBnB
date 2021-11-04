package com.proyect.controllers;

import org.springframework.stereotype.Controller;

import com.proyect.service.AppService;

@Controller
public class AssociationsController {

	
private final AppService as;
    
    public AssociationsController(AppService as) {
        this.as = as;
    }
//------------------------------------------------------------
    
}
