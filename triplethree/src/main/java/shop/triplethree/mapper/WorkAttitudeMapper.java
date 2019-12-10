package shop.triplethree.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.WorkAttitudeVo;

@Mapper
public interface WorkAttitudeMapper {
	// 오늘 날짜 기준 근무현황 조회
	public WorkAttitudeVo selectWorkAttitude(Map<String, String> json);
	
	// 출근시간 입력
	public int startInsertWorkAttitude(Map<String, String> json);
	
}