package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.ScheduleMapper;
import shop.triplethree.vo.Schedule;

@Service
public class ScheduleService {
	
	@Autowired private ScheduleMapper schedulemapper;
	@Autowired private CommonService commonService;

	/**
	 * 일정 등록 메서드
	 * */
	public int insertSchedule(Schedule schedule) {
		
		String code = commonService.codeGeneration("CALENDAR");
		schedule.setCode(code);
		
		return schedulemapper.insertSchedule(schedule);
	}
	
	/**
	 * 일정 조회 메서드
	 * */
	public List<Schedule> selectSchedule() {
		return schedulemapper.selectSchedule();
	}
	
	
}
