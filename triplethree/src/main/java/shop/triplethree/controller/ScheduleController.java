package shop.triplethree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.triplethree.service.ScheduleService;
import shop.triplethree.vo.Schedule;

@Controller
public class ScheduleController {

	@Autowired ScheduleService scheduleService;
	
	/**
	 * 일정 조회 메서드
	 * */
	@GetMapping(value="/companySchedule")
	public String selectSchedule() {
		return "calender/Calender";
	}
	
	@PostMapping(value="/companySchedule" , produces = "application/json")
	public @ResponseBody List<Schedule> selectSchdule() {
		return scheduleService.selectSchedule();
	}
	
	/**
	 * 일정 등록 메서드
	 * */
	@GetMapping("/ScheduleInsert")
	public String insertSchedule() {
		return "calender/CalenderInsert";
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
