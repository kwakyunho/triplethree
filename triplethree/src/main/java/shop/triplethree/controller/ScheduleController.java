package shop.triplethree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.triplethree.service.ScheduleService;
import shop.triplethree.vo.Schedule;

@Controller
public class ScheduleController {

	@Autowired ScheduleService scheduleService;
	
	/**
	 * 일정 조회 메서드
	 * */
	@GetMapping("/companySchedule")
	public String selectSchedule() {
		return "/calender/Calender";
	}
	
	/**
	 * 일정 등록 메서드
	 * */
	@PostMapping("/ScheduleInsert")
	public String insertSchedule(Schedule schedule) {
		System.out.println(schedule.toString());
		
		scheduleService.insertSchedule(schedule);
		return "redirect:companySchedule";
	}
}
