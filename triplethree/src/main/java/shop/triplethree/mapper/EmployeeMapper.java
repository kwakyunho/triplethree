package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Employee;

@Mapper
public interface EmployeeMapper {

	public Employee login(Employee employee);
	
	//부서코드와 부서명 가지고오는 메서드
	public List<Employee> selectForDepart();
	
	//직급코드와 직급명 가지고오는 메서드
	public List<Employee> selectForPosition();
	
	//재직상태코드와 재직상태 가지고 오는 메서드
	public List<Employee> selectForStatus();
	
	public int insertEmployee(Employee employee);
}
