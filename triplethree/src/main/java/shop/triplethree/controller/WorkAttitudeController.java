package shop.triplethree.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.triplethree.service.WorkAttitudeService;
import shop.triplethree.vo.WorkAttitudeVo;

@Controller
public class WorkAttitudeController {
	
	
	@Autowired private WorkAttitudeService workAttService;
	@PostMapping(value = "/WorkAttitude", produces = "application/json")
	public @ResponseBody WorkAttitudeVo WorkAttitude(@RequestParam Map<String, String> json){
		
		return workAttService.WorkAttitude(json);
	}
}