package shop.triplethree.controller;

import java.util.List;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.triplethree.mapper.CompanyMapper;
import shop.triplethree.service.EmployeeService;
import shop.triplethree.service.PayService;
import shop.triplethree.vo.Company;
import shop.triplethree.vo.Employee;
import shop.triplethree.vo.Pay;
@Controller
public class PayController {
	@Autowired private PayService payService;
	@Autowired private CompanyMapper companyMapper;
		
	@Value("${file.upload.path}")
	private String uploadPath;
	/**급여 검색 및 변동시 급여조회 화면**/
	@GetMapping("/admin/pay/viewPay")
	public String viewPay() {
		//System.out.println("급여등록화면");
		return "pay/insertPay";	
	}
	

	/**급여 검색 및 변동시 급여조회 실행**/
	@PostMapping("/admin/pay/insertPay")
	public String insertSearchPay(@RequestParam(value="sk") String sk
								 ,@RequestParam(value="sv") String sv
								 ,Model model) {
		//System.out.println("급여 등록 검색");
		List<Employee> list =payService.insertSearchPay(sk,sv);
		System.out.println(list.toString());
		model.addAttribute("insertSearchPay", list);
		
		
		return "pay/insertPay";	
	}
	 
	/** 급여대장** */
	@GetMapping("/pay/selectPay")
	public String selectPay(Model model) {		
		 model.addAttribute("selectPaySum", payService.selectPaySum());
		 //System.out.println("총계에요");
		 model.addAttribute("payInsert", payService.payInsert());
		 //System.out.println("급여에유");
		return "pay/selectPay";	
	}
	
	/**퇴직금 등록화면**/
	@GetMapping("/pay/selectRetiring")
	public String selectRetiring(Model model) {
		model.addAttribute("selectRetiring", payService.selectRetiring());
		//System.out.println("퇴직금 등록화면");
		return "pay/selectRetiring";
		
	}
		
	/******급여대장에서 수정할 수 있도록 화면 이동*************/
	@GetMapping("/admin/pay/updatePay")
	public String updatePayView(@RequestParam(value="empCode") String empcode,Model model) {
		//System.out.println("empCode"+empcode);
		model.addAttribute("updatePayView", payService.updatePayView(empcode));
		System.out.println("수정화면");
		return "pay/updatePay";	
	}
	/**급여 진짜 수정하기***/
	
	  @PostMapping("/admin/pay/updatePay")  
	  public String updatePay(Pay pay,HttpSession session) {
	  String writer = (String) session.getAttribute("SID");	
	  pay.setWriter(writer);
	  System.out.println("수정처리"); 
	  payService.updatePay(pay);
	  return "redirect:/pay/selectPay"; 
	  }
	  
	  /**공제액 설정화면 이동****/
	  @GetMapping("/admin/pay/insertDeduct")
	  public String insertDeduct(Model model) {
		  //System.out.println("공제액 설정화면 이동");
		  model.addAttribute("insertDeduct", payService.insertDeduct());
		  return "/pay/insertDeduct";
	  }
	 /***공제액 모달창 설정***/
	  
	  @PostMapping("/admin/pay/insertDeduct")
	  public String deductList(Pay pay,HttpSession session, Model model) {

		String writer = (String) session.getAttribute("SID");	
		pay.setWriter(writer);
		model.addAttribute("insertDeductModal", payService.deductList(pay));
		  return "redirect:/admin/pay/insertDeduct";
	  }
	  /***공제액 수정화면가기***/
	  @GetMapping("/admin/pay/updateDeductList")
	  public String updateDeductList(@RequestParam(value="deCode") String deCode, Model model) {
		  model.addAttribute("updateDeductList", payService.updateDeductList(deCode));
		  return "/pay/updateDeduct";
	  }
	  /**공제액 수정하기****/
	  @PostMapping("/admin/pay/updateDeduct")
	  public String updateDeduct(Pay pay,HttpSession session) {
		  String writer =(String) session.getAttribute("SID");
		  pay.setWriter(writer);
		  payService.updateDeduct(pay);
		  return "redirect:/admin/pay/insertDeduct";
	  }
}
