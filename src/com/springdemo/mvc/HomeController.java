package com.springdemo.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showPage(Model model, HttpSession session) {
		model.addAttribute("user", new User());
		try {
			User user = (User) session.getAttribute("user");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("get /");
		
		return "main-menu";
	}

	@RequestMapping("/login")
	public String userLogin(HttpSession session, @ModelAttribute("user") User user, Model model) {
		System.out.println(user.getId());
		if (user.getId().equals("123")) {
			System.out.println("true");
			user.setStatus("login");
			session.setAttribute("user", user);
			User tuser = (User) session.getAttribute("user");
			System.out.println(tuser.getStatus());
		} else {
			model.addAttribute("message", "Login failed. Try again.");
			return "redirect:/";
		}
		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("µn¥X");
		User tuser = (User) session.getAttribute("user");
		System.out.println(tuser.getStatus());
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/redirectTest")
	public String logout(HttpSession session,RedirectAttributes reA) {
		System.out.println("redirectTest...");
		reA.addFlashAttribute("theReturn","2");
		return "redirect:/";
	}


}
