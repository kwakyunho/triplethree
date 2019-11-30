package shop.triplethree.service;

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
	
	
	public int insertCompany(Company company) {
		System.out.println(company+"<--company");
		return companyMapper.insertCompany(company);
	}
	
}
