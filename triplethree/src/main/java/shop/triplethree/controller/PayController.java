package shop.triplethree.controller;

import java.util.List;

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

@Controller
public class PayController {
	@Autowired private PayService payService;
	
	/**급여등록화면**/
	@GetMapping("/viewPay")
	public String viewPay() {
		
		return "pay/insertPay";	
	}
	
	
	
	
	/**급여 등록 검색**/
	@PostMapping("/insertPay")
	public String insertSearchPay(@RequestParam(value="sk") String sk
								 ,@RequestParam(value="sv") String sv
								 ,Model model) {
		List<Employee> list =payService.insertSearchPay(sk,sv);
		System.out.println(list.toString());
		model.addAttribute("insertSearchPay", list);
		
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
		System.out.println("퇴직금 등록화면");
		return "pay/selectRetiring";
	}
	
}
