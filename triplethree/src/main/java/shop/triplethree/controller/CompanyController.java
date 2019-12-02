package shop.triplethree.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.triplethree.service.CompanyService;
import shop.triplethree.vo.CateNameList;
import shop.triplethree.vo.Company;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	//회사정보 입력화면
	@GetMapping("/companyInsert")
	public String insertCompany() {
		System.out.println("회사정보입력화면");
		return "company/information/companyInsert";	
	}
	//회사정보 입력처리
	@PostMapping("/companyInsert")
	public String insertCompany(Company company) {
		companyService.insertCompany(company);
		System.out.println(company.toString()+"company");
		return "redirect:/";
	}
	
	//회사정보 조회
	@GetMapping("/companyInfo")
	public String selectCompany(Model model) {
		
		model.addAttribute("companyInfo", companyService.selectCompany());
		return "company/information/companyInfo";
	}
	//회사정보 수정 클릭시 화면 보여주기
	@GetMapping("/companyUpdate")
	public String updateCompany(@RequestParam(value="Code") String Code,Model model) {
		System.out.println("Code"+Code);
		companyService.updateCompanySelect(Code);
		model.addAttribute("company", companyService.updateCompanySelect(Code));
		return "company/information/companyUpdate";	
	}
	
	//회사정보 진짜 수정클릭시 내용변경
	@PostMapping("companyUpdate")
	public String updateCompany(Company company) {
		companyService.updateCompany(company);
		return "redirect:/companyInfo";
	}
}
