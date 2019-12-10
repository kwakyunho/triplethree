package shop.triplethree.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	
	/**
	 * 일정 조회 메서드
	 * */
	@PostMapping(value="/companySchedule" , produces = "application/json")
	public @ResponseBody List<Schedule> selectSchdule(HttpSession session, Schedule schedule) {
		String scode = (String) session.getAttribute("SCODE");
		String sdecode = (String) session.getAttribute("SDECODE");
		System.out.println("세션에서 사원코드가 넘어왔나요?" + scode);
		System.out.println("세션에서 부서코드가 넘어왔나요 ?" + sdecode);
		session.setAttribute("sid", scode);
		
		schedule.setSid(scode);
		schedule.setDemgcode(sdecode);
		List<Schedule> sc = scheduleService.selectSchedule(schedule);
		System.out.println(sc.toString());
		return scheduleService.selectSchedule(schedule);
	}
	
	/**
	 * 일정 등록 메서드
	 * */
	/*
	 * @GetMapping("/companyScheduleInsert") public String insertSchedule() { return
	 * "calender/CalenderInsert"; }
	 */
	
	/**
	 * 일정 등록 메서드
	 * */
	@PostMapping("/companyScheduleInsert")
	public String insertSchedule(Schedule schedule, HttpSession session) {
		
		System.out.println(schedule.toString());
		
		String scode = (String) session.getAttribute("SCODE");
		String sdecode = (String) session.getAttribute("SDECODE");
		System.out.println("세션에서 사원코드가 넘어왔나요?" + scode);
		System.out.println("세션에서 부서코드가 넘어왔나요 ?" + sdecode);
		
		schedule.setSid(scode);
		schedule.setDemgcode(sdecode);
		
		scheduleService.insertSchedule(schedule); 
		return "redirect:companySchedule";
	}
	
	/**
	 * 일정 수정 메서드
	 * */
	@PostMapping("/companyScheduleUpdate")
	public String Schedule(Schedule schedule) {
		System.out.println(schedule.toString());
		System.out.println("수정 버튼이 눌렸어요.");
		
		scheduleService.updateSchedule(schedule);
		return "redirect:companySchedule";
	}
	
	/**
	 * 일정 수정시 화면에 값을 뿌려주기 위한 메서드
	 * */
	@PostMapping(value="/selectUpdate" , produces = "application/json")
	public @ResponseBody Schedule selectUpdate(String code, HttpSession session){
		System.out.println("일정이 클릭되었나요?");
		System.out.println("값을 확인해봐요" + code);
		Schedule sc = scheduleService.selectUpdate(code);
		System.out.println(sc);

		return scheduleService.selectUpdate(code);
	}
	
	/**
	 * 일정 삭제 메서드
	 * */
	@PostMapping("/companyScheduleDelet")
	public String deleteSchedule(Schedule schedule) {
		System.out.println("삭제버튼이 클릭되었나요?");
		System.out.println(schedule.toString());
		
		scheduleService.deleteSchedule(schedule);
		return "redirect:companySchedule";
	}
	
	@PostMapping(value="/checkSID",produces = "application/json")
	public @ResponseBody String checkSID(HttpSession session) {
		String sid = (String) session.getAttribute("SID");
		System.out.println("세션값 확인" + sid);
		return sid;
	}
}
