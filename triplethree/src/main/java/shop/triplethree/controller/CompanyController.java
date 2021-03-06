package shop.triplethree.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import shop.triplethree.mapper.CompanyMapper;
import shop.triplethree.service.CompanyService;
import shop.triplethree.vo.Company;
import shop.triplethree.vo.Position;

@Controller
public class CompanyController {

	@Autowired private CompanyService companyService;
	@Autowired private CompanyMapper companyMapper;

	@Value("${file.upload.path}")
	private String uploadPath;
	
	/**
	 * 메뉴에서 부서관리탭을 누르고 들어올때 실행
	 * 리스트를 불러옴
	 * */
	@GetMapping("/admin/department/teamNameInsert")
	public String selectOrganizationChart(Model model1, Model model2)	{
		//System.out.println("리스트 뽑아요");
		
		model1.addAttribute("CompanyList", companyService.selectOrganizationChart());
		model2.addAttribute("selectBox", companyMapper.selectBox());
		//System.out.println(companyService.selectOrganizationChart());
		return "/department/department";
	}
	
	/**
	 * 부서등록화면에서 등록하기 버튼을 클릭시 실행
	 * db 에 부서를 등록함
	 * */
	@PostMapping("/admin/department/teamNameInsert")
	public String insertOrganizationChart(Company company, HttpSession session) {
		//System.out.println("부서 등록버튼 클릭이 되었나요 ?");
		String sid = (String) session.getAttribute("SID");
		//System.out.println("세션값이 들어왔나요?"+sid);
		company.setSid(sid);
		companyService.insertOrganizationChart(company);
		
		//System.out.println(company.toString());
		return "redirect:/admin/department/teamNameInsert";
	}
	
	/**
	 * 부서수정
	 * */
	@PostMapping("/admin/department/teamNameUpdate")
	public String updateOrganizationChart(Company company, HttpSession session) {
		//System.out.println("부서 수정 버튼이 클릭되었나요?");
		String sid = (String) session.getAttribute("SID");
		//System.out.println("세션값이 들어왔나요 ? " + sid);
		company.setSid(sid);
		companyService.updateOrganizationChart(company);
		return "redirect:/admin/department/teamNameInsert";
	}
	
	/**
	 * 부서 삭제
	 * */
	@PostMapping("/admin/department/teamNameDelete")
	public String deleteOrganizationChart(Company company) {
		//System.out.println("삭제버튼이 클릭되었나요?");
		//System.out.println("값이 정상적으로 넘어왔나요 ? " + departmentCode);
		//System.out.println(company.getDepartmentCode());
		companyService.deleteOrganizationChart(company);
		return "redirect:/admin/department/teamNameInsert";
	}
	
	/**
	 * 메뉴에서 직급 관리 테이블 클릭시 실행
	 * 리스트를 불러옴
	 * */
	@GetMapping("/admin/position/positionInsert")
	public String selectPosition(Model model)	{
		//System.out.println("리스트 뽑아요");
		model.addAttribute("PositionList", companyService.selectPosition());
		//System.out.println(companyService.selectOrganizationChart());
		return "/position/position";
	}
	
	/**
	 * 직급등록 화면에서 등록하기 버튼 클릭시 실행
	 * db에 직급을 등록함
	 * */
	@PostMapping("/admin/position/positionInsert")
	public String insertPosition(Position position, HttpSession session) {
		System.out.println("직급 등록 버튼이 클릭되었나요?");
		System.out.println(position.toString());
		String sid = (String) session.getAttribute("SID");
		System.out.println("세션값이 들어왔나요?" + sid);
		position.setSid(sid);
		companyService.insertPosition(position); 
		return "redirect:/admin/position/positionInsert";
	}
	
	/**
	 * 직급 수정
	 * */
	@PostMapping("/admin/position/positionUpdate")
	public String updatePosition(Position position, HttpSession session) {
		System.out.println("직급 수정 버튼이 클릭되었나요?");
		String sid = (String) session.getAttribute("SID");
		System.out.println("세션값이 들어왔나요?" + sid);
		position.setSid(sid);
		companyService.updatePosition(position); 
		return "redirect:/admin/position/positionInsert";
	}
	
	/**
	 * 직급 삭제
	 * */
	@PostMapping("/admin/position/positionListDelete")
	public String deletePosition(Position position) {
		System.out.println("삭제 버튼이 클릭되었나요?");
		System.out.println(position.getPositionCode());
		
		companyService.deletePosition(position);
		return "redirect:/admin/position/positionInsert";
	}

	/**
	 * 부서 등록/수정 유효성 검사 메서드
	 * */
	@PostMapping(value="/admin/department/deNameCheck" , produces = "application/json")
	public @ResponseBody int deNameCheck(String title, Company company) {
		System.out.println("부서명이 제대로 전달 되었나요? "+ title);
		System.out.println("부서명이 있는지 확인해볼께요.");
		company.setDepartmentNameBe(title);
		int cnt = companyService.checkDeName(company);
		System.out.println("어떤 숫자가 왔나요? " + cnt);
		return companyService.checkDeName(company);
	}
	
	/**
	 * 직급 등록/수정 유효성 검사 메서드
	 * */
	@PostMapping(value = "/admin/position/poNameCheck", produces = "application/json")
	public @ResponseBody int poNameCheck(String name, Position position) {
		System.out.println("직급명이 제대로 전달 되었나요 ? " + name);
		System.out.println("직급명이 있는지 확인해볼께요.");
		position.setPositionNameBe(name);
		int cnt = companyService.checkPoName(position);
		System.out.println("어떤 숫자가 왔나요? " + cnt);
		return companyService.checkPoName(position);
	}
	
	/**회사정보 입력화면**/
	@GetMapping("/admin/company/companyInsert")
	public String insertCompany() {
		//System.out.println("회사정보입력화면");
		return "company/information/companyInsert";	
	}
	/**회사정보 입력처리 및 코드생성**/

	@PostMapping("/company/companyInsert")
	public String insertCompany(@RequestParam("coLogofile") MultipartFile file,Company company, HttpSession session) {

		String sid = (String) session.getAttribute("SID");
		
		 company.setSid(sid);
		 Path rootLocation = Paths.get(uploadPath);
		 String filePath = null;
		 			
		
		 try {			
				
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				InputStream inputStream = file.getInputStream();
				System.out.println(inputStream + "<--inputStream");
				
			
				
				if(inputStream !=null && originFileName != null && !"".equals(originFileName.trim())) {
					//테이블에 사진주소
					Files.copy(inputStream, rootLocation.resolve(originFileName), StandardCopyOption.REPLACE_EXISTING);
					filePath = "/img/" + originFileName;
				}
				
			
				System.out.println(filePath + "<- 1");
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				
				try {
					Files.delete(rootLocation.resolve(originFileName));
				
				} catch (IOException e1) {
					e1.printStackTrace();
				}					
				
			}
					
		if(filePath != null) company.setCoLogo(filePath);
	 	
		companyService.insertCompany(company);
		
		
		return "redirect:/company/companyInfo";
	}
	
	/**회사정보 조회**/
	@GetMapping("/company/companyInfo")
	public String selectCompany(Model model) {
		model.addAttribute("companyInfo", companyService.selectCompany());
		//System.out.println(model+"<--model");
		return "company/information/companyInfo";
	}
	/**회사정보 수정 클릭시 화면 보여주기**/
	@GetMapping("/company/companyUpdate")
	public String updateCompanySelect(@RequestParam(value="Code") String code,Model model) {
		//System.out.println("Code"+code);
		//companyService.updateCompanySelect(code);
		model.addAttribute("company", companyService.updateCompanySelect(code));
		//System.out.println(model+"<--model수정");
		return "company/information/companyUpdate";	
	}
	
	/**회사정보 진짜 수정클릭시 내용변경**/
	@PostMapping("/company/companyUpdate")
	public String updateCompany(Company company, @RequestParam("coLogofile") MultipartFile file, HttpSession session) {
		//System.out.println("여기오냐?");
		String sid = (String) session.getAttribute("SID");
		
		 company.setSid(sid);
		 Path rootLocation = Paths.get(uploadPath);
		 String filePath = null;
		 			
		
		 try {			
				
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				InputStream inputStream = file.getInputStream();
				System.out.println(inputStream + "<--inputStream");
				
			
				
				if(inputStream !=null && originFileName != null && !"".equals(originFileName.trim())) {
					//테이블에 사진주소
					Files.copy(inputStream, rootLocation.resolve(originFileName), StandardCopyOption.REPLACE_EXISTING);
					filePath = "/img/" + originFileName;
				}
				
			
				System.out.println(filePath + "<- 1");
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				
				try {
					Files.delete(rootLocation.resolve(originFileName));
				
				} catch (IOException e1) {
					e1.printStackTrace();
				}					
				
			}
					
		if(filePath != null) company.setCoLogo(filePath);
		companyService.updateCompany(company);
		return "redirect:/company/companyInfo";
	}
	/**회사정보 상세보기***/
	@GetMapping("/company/companyDetail")
	public String companyDetail(@RequestParam(value="coName") String coname,Model model) {
		//System.out.println("coName"+coname);
		model.addAttribute("companyDetail", companyService.companyDetail(coname));
		//System.out.println("상세보기");
		return "company/information/companyDetail";
	}
	
	/**회사휴업 또는 폐업****/
	@PostMapping("/company/deleteCompany")
	public String deleteCompany(Company company) {
		//System.out.println("상태를 변경할꺼야?");
		//System.out.println(company.getCode());
		
		companyService.deleteCompany(company);
		return "redirect:/company/companyInfo";
	}
}
