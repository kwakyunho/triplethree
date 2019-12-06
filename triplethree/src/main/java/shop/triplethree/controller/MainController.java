package shop.triplethree.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("/")
	public String mainpage(HttpSession session) {
		if(session.getAttribute("SID") != null) {
			return "index";
		}else {
			return "employee/login";
		}
	}
	
	@GetMapping("/index")
	public String index() {
		
		return "/index";
	}
	
	@GetMapping("/Dashboard_v1")
	public String Dashboard_v1() {
		return "/index1";
	}
	
	@GetMapping("/Dashboard_v2")
	public String Dashboard_v2() {
		return "/index2";
	}
	
	@GetMapping("/Dashboard_v3")
	public String Dashboard_v3() {
		return "/index3";
	}
	
	@GetMapping("/Widgets")
	public String widgets() {
		return "/pages/widgets";
	}
	
	@GetMapping("/top_nav")
	public String top_nav() {
		return "/pages/layout/top-nav";
	}
}
