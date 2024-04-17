package com.green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
	
	// /hi : http://localhost:9090/hi
	@GetMapping("/hi")
	public  String   hi(HttpServletResponse response) {
		Cookie cookie = new Cookie("usereamil","wodud6967");
		cookie.setDomain("localhost");
		cookie.setPath("/");
		//30초간 저장
		cookie.setMaxAge(30*600);
		cookie.setSecure(true);
		response.addCookie(cookie);
		return "greetings";   
		  // greetings.mustache  화면을 보여줄 template 이름
		 // resources/template package 에 생성
	}
	@PostMapping("/hi")
	public  String   posthi(HttpServletResponse response) {
		
		return "greetings";   
		  // greetings.mustache  화면을 보여줄 template 이름
		 // resources/template package 에 생성
	}
	
	@GetMapping("/hi2") 
	public  String   hi2( Model model, HttpServletRequest request ) {
		Cookie[] list = request.getCookies();
		for(Cookie cookie:list) {
			if(cookie.getName().equals("usereamil")) {
				System.out.println(cookie.getValue());
				System.out.println(cookie);
			}
			
		}
		model.addAttribute("username", "원영이" );
		return "greetings2"; // greetings2.mustache
	}
	
	@GetMapping("/hi3") 
	public  String   hi3( Model model ) {
		model.addAttribute("username", "태훈이" );
		return "greetings3"; // greetings2.mustache
	}
	
	@GetMapping("/hi4") 
	public  String   hi4( Model model ) {
		model.addAttribute("username", "태훈이" );
		return "greetings4"; // greetings2.mustache
	}
	
	
}



