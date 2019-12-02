package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Employee;

@Mapper
public interface EmployeeMapper {

	public Employee login(Employee employee);
	
	public List<Employee> selectForDepart();
	
	public List<Employee> selectForPosition();
	
	public List<Employee> selectForDepart();
	
	public String emCodeGeneration();
}
