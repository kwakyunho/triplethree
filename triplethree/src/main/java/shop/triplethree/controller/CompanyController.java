package shop.triplethree.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		
		return "company/information/companyInfo";
	}
	
}
