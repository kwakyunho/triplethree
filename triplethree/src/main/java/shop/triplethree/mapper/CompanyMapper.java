package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Company;

@Mapper
public interface CompanyMapper {

	// 회사정보 등록 메서드
	public int insertOrganizationChart(Company company);
	
	// 회사정보 리스트 메서드
	public List<Company> selectOrganizationChart();
	
	// 상위부서 select 박스 사용상태 'Y'인 경우 가져오기
	public List<Company> selectBox();
	
	//회사등록시 상위부소 코드를 가져오기 ( 부서명 -> 부서코드로 변환 )
	public String selectUpCode(String upCode);
}
