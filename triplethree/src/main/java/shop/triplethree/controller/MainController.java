package shop.triplethree.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/project")
	public String mainpage(HttpSession session) {
		if(session.getAttribute("SID") != null) {
			return "index";
		}else {
			return "employee/login";
		}
	}
	
	@GetMapping("/")
	public String portfolio() {
		return "portfolio";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/notLogin")
	public String notLogin() {
		return "notLogin";
	}
	
	@GetMapping("/notPermission")
	public String notPermission() {
		return "notPermission";
	}
}