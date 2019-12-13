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
		
		if(json.get("conditionValue").equals("1")) {
			return workAttMapper.selectWorkAttitude(json);
			
		}else if(json.get("conditionValue").equals("2")) {
			result = workAttMapper.selectWorkAttitude(json);
			
			if(result == null) {
				json.put("workAttCode", commonService.codeGeneration("ABS_MANAGE"));	// 코드 생성
				workAttMapper.startInsertWorkAttitude(json);	// 출근정보 등록
				result = workAttMapper.selectWorkAttitude(json);
			}
			return result;	// 근태현황 조회하여 리턴
			
		}else if(json.get("conditionValue").equals("3")) {
			workAttMapper.endUpdateWorkAttitude(json);	// 퇴근정보 등록
			return workAttMapper.selectWorkAttitude(json);	// 근태현황 조회하여 리턴
			
		}else {
			return null;
		}
	}
	
	// 근태목록 리스트 조회
	public List<WorkAttitudeVo> selectWorkAttitudeList() {
		return workAttMapper.selectWorkAttitudeList();
	}
}