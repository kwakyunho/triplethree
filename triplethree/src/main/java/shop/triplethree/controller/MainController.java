package shop.triplethree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import shop.triplethree.service.CommonService;

@Controller
public class MainController {
	
	@Autowired private CommonService commonService;
	@GetMapping("/")
	public String mainpage() {
		String code = commonService.codeGeneration("TRAVEL_HISTORY");
		System.out.println("생성된 코드명 : " + code);
		return "employee/login";
	}
	
	@GetMapping("/Dashboard_v1")
	public String Dashboard_v1() {
		return "/index1";
	}
	
	@GetMapping("/Dashboard_v2")
	public String Dashboard_v2() {
		return "/index2";
	}
	
	@GetMapping("/Dashboard_v3")
	public String Dashboard_v3() {
		return "/index3";
	}
	
	@GetMapping("/Widgets")
	public String widgets() {
		return "/pages/widgets";
	}
	
	@GetMapping("/top_nav")
	public String top_nav() {
		return "/pages/layout/top-nav";
	}
}
