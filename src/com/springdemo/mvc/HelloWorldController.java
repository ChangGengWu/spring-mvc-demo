package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//controller method to show init form  
	@RequestMapping ("/showForm")
	public String showForm() {
		return "helloworld-form";
		
	}
	
	//controller method to process form
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloworld";
	}
	
	
	//controller method to read form data
	//add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "YO! " + theName;
		
		//add message to model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, Model model) {
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "hi~ " + theName;
		
		//add message to model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	

}
