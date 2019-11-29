package shop.triplethree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.triplethree.mapper.CompanyMapper;
import shop.triplethree.service.CommonService;
import shop.triplethree.service.CompanyService;
import shop.triplethree.vo.Company;

@Controller
public class CompanyController {
	
	@Autowired private CommonService commonService;
	@Autowired private CompanyService companyService;
	@Autowired private CompanyMapper companyMapper;

	/**
	 * 메뉴에서 부서관리탭을 누르고 들어올때 실행
	 * 리스트를 불러옴
	 * */
	@GetMapping("/teamNameInsert")
	public String selectOrganizationChart(Model model1, Model model2)	{
		System.out.println("리스트 뽑아요");
		model1.addAttribute("CompanyList", companyService.selectOrganizationChart());
		model2.addAttribute("selectBox", companyMapper.selectBox());
		/* System.out.println(companyService.selectOrganizationChart()); */
		return "/department/d_Insert";
	}
	
	/**
	 * 부서등록화면에서 등록하기 버튼을 클릭시 실행
	 * db 에 부서를 등록함
	 * */
	@PostMapping("/teamNameInsert")
	public String insertOrganizationChart(Company company) {
		System.out.println("부서 등록버튼 클릭이 되었나요 ?");
		String code = commonService.codeGeneration("DEMG");
			
		companyService.insertOrganizationChart(company);
		
		System.out.println(company.toString());
		System.out.println(code);
		return "redirect:/teamNameInsert";
	}
	
}
