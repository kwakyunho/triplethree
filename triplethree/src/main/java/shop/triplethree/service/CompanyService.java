package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.CompanyMapper;
import shop.triplethree.vo.Company;
import shop.triplethree.vo.Position;

@Service
public class CompanyService {

	@Autowired private CompanyMapper companyMapper;
	@Autowired private CommonService commonService;

	/**
	 * 부서정보 등록 메서드
	 * */
	public int insertOrganizationChart (Company company) {
		
		String code = commonService.codeGeneration("DEMG");
		company.setDepartmentCode(code);
		
		String upCode = company.getDepartmentUpcode();
		company.setDepartmentUpcode(companyMapper.selectUpCode(upCode));
		System.out.println("상위부서 코드 잘오나요 ? "+ company.getDepartmentUpcode());
		
		return companyMapper.insertOrganizationChart(company);
	}
	
	/**
	 * 부서정보 리스트를 뽑아내는 메서드
	 * */
	public List<Company> selectOrganizationChart() {
		return companyMapper.selectOrganizationChart();
	}
	
	/**
	 * 부서정보 삭제 ( 사용 상태만 N 으로 변경 )
	 * */
	public int deleteOrganizationChart(Company company) {
		return companyMapper.deleteOrganizationChart(company);
	}
	
	/**
	 * 부서정보 수정
	 * */
	public int updateOrganizationChart(Company company) {
		System.out.println(company.toString());
		String upCode = company.getDepartmentUpcode();
		company.setDepartmentUpcode(companyMapper.selectUpCode(upCode));
		System.out.println("상위부서 코드 잘오나요 ? "+ company.getDepartmentUpcode());
		return companyMapper.updateOrganizationChart(company);
	}
	
	/**
	 * 직급정보 등록 메서드
	 * */
	public int insertPosition(Position position) {
		String code = commonService.codeGeneration("POSISYS");
		position.setPositionCode(code);
		System.out.println(position.getPositionCode());
		
		return companyMapper.insertPosition(position);
	}
	
	/**
	 * 직급정보 수정 메서드
	 * */
	public int updatePosition(Position position) {
		return companyMapper.updatePosition(position);
	}
	
	/**
	 * 직급정보 리스트 메서드
	 * */
	public List<Position> selectPosition(){
		return companyMapper.selectPosition();
	}
	
	/**
	 * 직급정보 삭제 메서드 ( 사용상태만 N 으로 변경 )
	 * */
	public int deletePosition(Position position) {
		return companyMapper.deletePosition(position);
	}

	/**
	 * 부서명 유효성 검사 메서드
	 * */
	public int checkDeName(Company company) {		
		return companyMapper.checkDeName(company);
	}
	
	/**
	 * 직급명 유효성 검사 메서드
	 * */
	public int checkPoName(Position position) {
		return companyMapper.checkPoName(position);
	}
	

	/**
	 * 회사 정보 조회
	 * */
	public List<Company> selectCompany(){
		List<Company> list=companyMapper.selectCompany();
		System.out.println(list.toString());
	
		return companyMapper.selectCompany();
	}
	
	/**
	 * 회사 정보 수정
	 * */
	public Company updateCompanySelect(String code) {
		
		return companyMapper.updateCompanySelect(code);
	}
	/**
	 * 회사 정보 진짜 수정하여 변경
	 * */
	public int updateCompany(Company company) {
		return companyMapper.updateCompany(company);
	}
	
	/**회사정보 상세보기****/
	public Company companyDetail(String coname) {
		
		return companyMapper.companyDetail(coname);
	}
	/**회사정보 휴업또는 폐업****/
	public int deleteCompany(Company company) {
		return companyMapper.deleteCompany(company);
	}
	
	/**회사 코드 자동 생성 및 정보등록**/
	public int insertCompany (Company company) {
	
	String code = commonService.codeGeneration("EM_INFO");
	company.setCode(code);
	
	System.out.println("회사코드는 ? "+ company.getCode());
	
	return companyMapper.insertCompany(company);
}
}
