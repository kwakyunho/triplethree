package shop.triplethree.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.triplethree.service.WorkAttitudeService;
import shop.triplethree.vo.WorkAttitudeVo;

@Controller
public class WorkAttitudeController {
	
	
	@Autowired private WorkAttitudeService workAttService;
	@PostMapping(value = "/selectWorkAttitude", produces = "application/json")
	public @ResponseBody WorkAttitudeVo selectWorkAttitude(@RequestParam Map<String, String> json){
		
		return workAttService.selectWorkAttitude(json);
	}
	
	@PostMapping(value = "/startInsertWorkAttitude", produces = "application/json")
	public @ResponseBody WorkAttitudeVo startInsertWorkAttitude(@RequestParam Map<String, String> json){
		
		return workAttService.startInsertWorkAttitude(json);
	}
	
	@PostMapping(value = "/endUpdateWorkAttitude", produces = "application/json")
	public @ResponseBody WorkAttitudeVo endUpdateWorkAttitude(@RequestParam Map<String, String> json){
		
		return workAttService.endUpdateWorkAttitude(json);
	}
	
	@PostMapping(value = "/adminInsertWorkAttitude", produces = "application/json")
	public @ResponseBody WorkAttitudeVo adminInsertWorkAttitude(@RequestParam Map<String, String> json){
		
		return workAttService.adminInsertWorkAttitude(json);
	}
	
	// 근태목록 리스트 조회
	@GetMapping("/kuntaeList")
	public String selectWorkAttitudeList(Model model) {
		model.addAttribute("WorkAttitudeVoList", workAttService.selectWorkAttitudeList());
		return "/kuntae/kuntaeList";
	}
}