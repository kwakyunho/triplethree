package shop.triplethree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PayController {
	
	//급여등록화면
	@GetMapping("/insertPay")
	public String insertPay() {
		System.out.println("급여지급등록화면");
		return "pay/insertPay";		
	}
	
	//사원 급여 조회
	@PostMapping("/payList")
	public String payList() {
		return "/pay/payList";
	}
	
}
