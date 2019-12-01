package shop.triplethree.mapper;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Schedule;

@Mapper
public interface ScheduleMapper {

	// 일정 등록
	public int insertSchedule(Schedule schedule);
	
	// 일정 수정
	public int updateSchedule();
	
	// 일정 삭제
	public int deleteSchedule();
	
	// 일정 조회
	public int selectSchedule();
	
}
