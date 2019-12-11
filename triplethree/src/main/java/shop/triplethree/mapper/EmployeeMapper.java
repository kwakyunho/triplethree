package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Employee;

@Mapper
public interface EmployeeMapper {
	
	//로그인 처리를 위해 아이디/비번 조회하는 메서드
	public Employee login(Employee employee);
	
	//부서코드와 부서명 가지고오는 메서드
	public List<Employee> selectForDepart();
	
	//직급코드와 직급명 가지고오는 메서드
	public List<Employee> selectForPosition();
	
	//재직상태코드와 재직상태 가지고 오는 메서드
	public List<Employee> selectForStatus();
	
	//사원등록처리하는 메서드
	public int insertEmployee(Employee employee);
	
	//사원목록 조회하는 메서드
	public List<Employee> selectEmployee();
	
	//상세정보에서 뿌려줄 데이터 찾는 메서드
	public Employee selectForDetail(String empNum);
	
	//수정할 정보를 뿌려줄 테이터를 찾는 메서드
	public Employee selectForUpdate(String empNum);
	
	//인사이동변경사항을 인사이동목록테이블에 insert하는 메서드
	public int insertMoveEmployee(Employee employee);
	
	//수정할 정보를 업데이트하는 메서드
	public int updateEmployee(Employee employee);
	
	//인사이동이랑 같이 사원정보가 변경되면 업데이트하는 메서드
	public int updateDepNPoEmployee(Employee employee);
	
	//마이페이지의 정보를 뿌려줄 메서드
	public Employee employeeMyPage(String SID);
	
	
}
