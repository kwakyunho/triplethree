package shop.triplethree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayController {
	@GetMapping("/insertPay")
	public String insertPay() {
		System.out.println("급여지급등록화면");
		return "pay/insertPay";		
	}
}
