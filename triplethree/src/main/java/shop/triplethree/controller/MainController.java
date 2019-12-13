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
}