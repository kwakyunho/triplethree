package shop.triplethree.mapper;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.CateNameList;
import shop.triplethree.vo.Company;

@Mapper
public interface CompanyMapper {
	//회사정보 등록
	public int insertCompany(Company company);
	
}
