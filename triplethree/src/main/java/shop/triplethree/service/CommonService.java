package shop.triplethree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.CommonMapper;

@Service
public class CommonService {
	
	@Autowired private CommonMapper commonMapper;
	
	/**
	 * 각 테이블별 등록될 코드 값 추출하는 공통메서드 (매개변수 '테이블명' 입력)
	 * @param String tbName
	 * @return String 코드값
	 */
	public String codeGeneration(String tbName) {
		return commonMapper.codeGeneration(tbName);
	}
}