package com.cg.expense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class WebController {
	
    @GetMapping(value="/")
    public String homepage(){
    	return "index";
    }
}