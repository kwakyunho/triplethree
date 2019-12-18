package shop.triplethree.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.WorkAttitudeMapper;
import shop.triplethree.vo.WorkAttitudeVo;

@Service
public class WorkAttitudeService {
	
	@Autowired private CommonService commonService;
	@Autowired private WorkAttitudeMapper workAttMapper;
	public WorkAttitudeVo WorkAttitude(Map<String, String> json) {
		WorkAttitudeVo result = new WorkAttitudeVo();
		
		// day, id에 따라 검색(개인 근태 정보 조회)
		if(json.get("conditionValue").equals("1")) {
			return workAttMapper.selectWorkAttitude(json);
			
		// 개인 출근 등록 기능
		}else if(json.get("conditionValue").equals("2")) {
			result = workAttMapper.selectWorkAttitude(json);
			
			if(result == null) {
				json.put("workAttCode", commonService.codeGeneration("ABS_MANAGE"));	// 코드 생성
				workAttMapper.startInsertWorkAttitude(json);	// 출근정보 등록
				result = workAttMapper.selectWorkAttitude(json);
			}
			return result;	// 근태현황 조회하여 리턴
			
		// 개인 퇴근 등록 기능
		}else if(json.get("conditionValue").equals("3")) {
			workAttMapper.endUpdateWorkAttitude(json);	// 퇴근정보 등록
			return workAttMapper.selectWorkAttitude(json);	// 근태현황 조회하여 리턴
			
		// 관리자 기능 : 사원 근태정보 컨트롤 (수정, 삭제)
		}else if(json.get("conditionValue").equals("4")) {
			workAttMapper.adminUpdateWorkAttitude(json);
			return workAttMapper.selectWorkAttitude(json);
				
		// 관리자 기능 : 사원 근태정보 컨트롤 (등록)
		}else if(json.get("conditionValue").equals("5")) {
			// 입력하는 일자가 수정하는것인지 새로등록하는것인지 확인
			result = workAttMapper.selectWorkAttitude(json);
			if(result == null) {	// 새롭게 등록
				json.put("workAttCode", commonService.codeGeneration("ABS_MANAGE"));	// 코드 생성
				workAttMapper.startInsertWorkAttitude(json);	// 출근정보 등록
				result = workAttMapper.selectWorkAttitude(json);
				result.setStartWorkTime(null);
			}
			return result;
		}
		return null;
	}
	
	// 근태목록 리스트 조회
	public List<WorkAttitudeVo> selectWorkAttitudeList() {
		return workAttMapper.selectWorkAttitudeList();
	}
}