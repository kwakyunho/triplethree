package shop.triplethree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.triplethree.mapper.CompanyMapper;
import shop.triplethree.service.CompanyService;
import shop.triplethree.vo.Company;
import shop.triplethree.vo.Position;

@Controller
public class CompanyController {

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
		//System.out.println(companyService.selectOrganizationChart());
		return "/department/department";
	}
	
	/**
	 * 부서등록화면에서 등록하기 버튼을 클릭시 실행
	 * db 에 부서를 등록함
	 * */
	@PostMapping("/teamNameInsert")
	public String insertOrganizationChart(Company company) {
		System.out.println("부서 등록버튼 클릭이 되었나요 ?");
			
		companyService.insertOrganizationChart(company);
		
		//System.out.println(company.toString());
		return "redirect:/teamNameInsert";
	}
	
	/**
	 * 부서수정
	 * */
	@PostMapping("/teamNameUpdate")
	public String updateOrganizationChart(Company company) {
		System.out.println("부서 수정 버튼이 클릭되었나요?");
		
		companyService.updateOrganizationChart(company);
		return "redirect:/teamNameInsert";
	}
	
	/**
	 * 부서 삭제
	 * */
	@GetMapping("/teamNameDelete")
	public String deleteOrganizationChart(@RequestParam(value = "departmentCode" ,required = false) String departmentCode) {
		System.out.println("삭제버튼이 클릭되었나요?");
		//System.out.println("값이 정상적으로 넘어왔나요 ? " + departmentCode);
		
		companyService.deleteOrganizationChart(departmentCode);
		return "redirect:/teamNameInsert";
	}
	
	/**
	 * 메뉴에서 직급 관리 테이블 클릭시 실행
	 * 리스트를 불러옴
	 * */
	@GetMapping("/positionInsert")
	public String selectPosition(Model model)	{
		System.out.println("리스트 뽑아요");
		model.addAttribute("PositionList", companyService.selectPosition());
		//System.out.println(companyService.selectOrganizationChart());
		return "/position/position";
	}
	
	/**
	 * 직급등록 화면에서 등록하기 버튼 클릭시 실행
	 * db에 직급을 등록함
	 * */
	@PostMapping("/positionInsert")
	public String insertPosition(Position position) {
		System.out.println("직급 등록 버튼이 클릭되었나요?");
		System.out.println(position.toString());
		companyService.insertPosition(position);
		return "redirect:/positionInsert";
	}
	
	/**
	 * 직급 수정
	 * */
	@PostMapping("/positionUpdate")
	public String updatePosition(Position position) {
		System.out.println("직급 수정 버튼이 클릭되었나요?");
		companyService.updatePosition(position);
		return "redirect:/positionInsert";
	}
	
	/**
	 * 직급 삭제
	 * */
	@GetMapping("/positionListDelete")
	public String deletePosition(@RequestParam(value = "positionCode", required = false) String positionCode) {
		System.out.println("삭제 버튼이 클릭되었나요?");
		
		companyService.deletePosition(positionCode);
		return "redirect:/positionInsert";
	}

}
