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
	
	/**급여등록화면**/
	@GetMapping("/insertPay")
	public String insertPay() {
		System.out.println("급여지급등록화면");
		return "pay/insertPay";		
	}
	
	/** 급여대장** */
	@GetMapping("/selectPay")
	public String selectPay(Model model) {
		 model.addAttribute("selectPay", payService.selectPay());
		return "pay/selectPay";	
	}
	
	/**퇴직금 등록화면**/
	@GetMapping("/selectRetiring")
	public String selectRetiring() {
		System.out.println("공제액등록화면");
		return "pay/selectRetiring";
	}
	
}
