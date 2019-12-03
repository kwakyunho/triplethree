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
}
