package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Company;
import shop.triplethree.vo.Position;

@Mapper
public interface CompanyMapper {

	// 부서 등록 메서드
	public int insertOrganizationChart(Company company);
	
	// 부서 리스트 메서드
	public List<Company> selectOrganizationChart();
	
	// 상위부서 select 박스 사용상태 'Y'인 경우 가져오기
	public List<Company> selectBox();
	
	// 부서등록시 상위부서 코드를 가져오기 ( 부서명 -> 부서코드로 변환 )
	public String selectUpCode(String upCode);
	
	// 부서 삭제 메서드 ( 사용유무 N 변경 )
	public int deleteOrganizationChart(Company company);
	
	// 부서정보 수정 메서드
	public int updateOrganizationChart(Company company);
	
	// 직급 등록 메서드
	public int insertPosition(Position position);
	
	// 직급 리스트 메서드
	public List<Position> selectPosition();
	
	// 직급 수정 메서드
	public int updatePosition(Position position);
	
	// 직급 삭제 메서드 ( 사용유무 N 변경 )
	public int deletePosition(Position position);
	
	// 부서명 유효성 검사 메서드
	public int checkDeName(Company company);
	
	// 직급명 유효성 검사 메서드
	public int checkPoName(Position position);
	
	
	//회사정보 조회
	public List<Company> selectCompany();
	
	//회사정보 수정클릭시 화면 보여주기
	public Company updateCompanySelect(String company);
	
	//수정 클릭시 내용 진짜 수정
	public int updateCompany(Company company);
	
	//회사정보 상세보기
	public Company companyDetail(String company);
	
	//회사휴업or폐업유무
	public int deleteCompany(Company company);
	
	//회사정보코드 자동생성 및 정보등록
	public int insertCompany(Company company);
	
}
