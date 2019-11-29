package shop.triplethree.mapper;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Employee;

@Mapper
public interface EmployeeMapper {

	public Employee login(Employee employee);
}
