package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.CompanyMapper;
import shop.triplethree.vo.Company;

@Service
public class CompanyService {

	@Autowired private CompanyMapper companyMapper;
	@Autowired private CommonService commonService;

	/**
	 * 조직도 (부서) 등록 하는 메서드
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
	 * 조직도 리스트를 뽑아내는 메서드
	 * */
	public List<Company> selectOrganizationChart() {
		return companyMapper.selectOrganizationChart();
	}
}
