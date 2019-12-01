package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.CateNameList;
import shop.triplethree.vo.Company;

@Mapper
public interface CompanyMapper {
	//회사정보 등록
	public int insertCompany(Company company);
	
	//회사정보 조회
	public List<Company> selectCompany();
}
