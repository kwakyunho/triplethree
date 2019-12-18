package shop.triplethree.controller;

import java.util.List;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.triplethree.service.EmployeeService;
import shop.triplethree.service.PayService;
import shop.triplethree.vo.Company;
import shop.triplethree.vo.Employee;
import shop.triplethree.vo.Pay;
@Controller
public class PayController {
	@Autowired private PayService payService;
	
	/**급여등록화면**/
	@GetMapping("/admin/pay/viewPay")
	public String viewPay() {
		
		return "pay/insertPay";	
	}
	

	/**급여 등록 검색**/
	@PostMapping("/admin/pay/insertPay")
	public String insertSearchPay(@RequestParam(value="sk") String sk
								 ,@RequestParam(value="sv") String sv
								 ,Model model) {
		List<Employee> list =payService.insertSearchPay(sk,sv);
		System.out.println(list.toString());
		model.addAttribute("insertSearchPay", list);
		model.addAttribute("payInsert", payService.payInsert());
		model.addAttribute("insertDeduct", payService.insertDeduct());
		return "pay/insertPay";	
	}
	/***급여 등록하기*****/
	@PostMapping("/admin/pay/selectPay")
	public String insertPay(Pay pay, HttpSession session) {
		return "pay/selectPay";
	}
	/** 급여대장** */
	@GetMapping("/pay/selectPay")
	public String selectPay(Model model) {
		 model.addAttribute("selectPay", payService.selectPay());
		 model.addAttribute("payInsert", payService.payInsert());
		return "pay/selectPay";	
	}
	
	/**퇴직금 등록화면**/
	@GetMapping("/pay/selectRetiring")
	public String selectRetiring() {
		System.out.println("퇴직금 등록화면");
		return "pay/selectRetiring";
		
	}
		
	/**공제액 설정화면 이동****/
	@GetMapping("/admin/pay/insertDeduct")
	public String insertDeduct(Model model) {
		model.addAttribute("insertDeduct", payService.insertDeduct());
		return "/pay/insertDeduct";
	}
	
}
