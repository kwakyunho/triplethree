package shop.triplethree.controller;

import java.util.List;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		System.out.println("급여등록화면");
		return "pay/insertPay";	
	}
	

	/**급여 등록 검색**/
	@PostMapping("/admin/pay/insertPay")
	public String insertSearchPay(@RequestParam(value="sk") String sk
								 ,@RequestParam(value="sv") String sv
								 ,Model model) {
		System.out.println("급여 등록 검색");
		List<Employee> list =payService.insertSearchPay(sk,sv);
		System.out.println(list.toString());
		model.addAttribute("insertSearchPay", list);
	
		return "pay/insertPay";	
	}
	/***급여 등록하기지만 수정으로 처리해줘야함*****/
	@PostMapping("/admin/pay/selectPay")
	public @ResponseBody String updatePay(@RequestParam(value="empCode") String empCode
			                              , Pay pay
			                              , Model model) {
		System.out.println("/admin/pay/selectPay 실행");
		 model.addAttribute("selectPay", payService.selectPay());
		 model.addAttribute("payInsert", payService.payInsert());
		 System.out.println(empCode+"<--급여등록코드");
		 
		 
		 payService.updatePay(pay);
		 System.out.println(pay+"<--pay");
		 
		return "/pay/selectPay";
	}
	/** 급여대장** */
	@GetMapping("/pay/selectPay")
	public String selectPay(Model model) {		
		System.out.println("급여 급여대장이다");
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
		System.out.println("공제액 설정화면 이동");
		model.addAttribute("insertDeduct", payService.insertDeduct());
		return "/pay/insertDeduct";
	}
	
}
