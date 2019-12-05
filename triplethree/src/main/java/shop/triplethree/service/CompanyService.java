package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.CommonMapper;
import shop.triplethree.mapper.CompanyMapper;
import shop.triplethree.vo.CateNameList;
import shop.triplethree.vo.Company;


@Service
public class CompanyService {
	
	@Autowired
	
	private CompanyMapper companyMapper;
	
	//회사정보 등록
	public int insertCompany(Company company) {
		System.out.println(company+"<--company");
		return companyMapper.insertCompany(company);
	}
	
	//회사 정보 조회
	public List<Company> selectCompany(){
		List<Company> list=companyMapper.selectCompany();
		System.out.println(list.toString());
	
		return companyMapper.selectCompany();
	}
	
	//회사 정보 수정
	public Company updateCompanySelect(String code) {
		
		return companyMapper.updateCompanySelect(code);
	}
	//회사 정보 진짜 수정하여 변경
	public int updateCompany(Company company) {
		return companyMapper.updateCompany(company);
	}
}
