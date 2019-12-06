package shop.triplethree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.triplethree.service.EmployeeService;
import shop.triplethree.service.PayService;

@Controller
public class PayController {
	@Autowired private PayService payService;
	//급여등록화면
	@GetMapping("/insertPay")
	public String insertPay() {
		System.out.println("급여지급등록화면");
		return "pay/insertPay";		
	}
	
	//사원 급여 조회
	@GetMapping("/payList")
	public String payList(Model model) {
		 model.addAttribute("payList", payService.payList());
		return "pay/payList";	
	}
	
}
