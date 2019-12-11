package shop.triplethree.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.EmployeeMapper;
import shop.triplethree.vo.Employee;

@Service
public class EmployeeService {
		
	@Autowired private EmployeeMapper employeeMapper;  
	
	  public Employee login(Employee employee) {
				
		  return employeeMapper.login(employee);  
		
		  }
	  
	  public List<Employee> selectForDepart(){
		  
		  return employeeMapper.selectForDepart();
	  }
	  
	  public List<Employee> selectForPosition(){
		  
		  return employeeMapper.selectForPosition();
	  }
	  
	 public List<Employee> selectForStatus(){
		  
		  return employeeMapper.selectForStatus();
	  }
	 
	 public int insertEmployee(Employee employee){
		  
		  return employeeMapper.insertEmployee(employee);
	  }
	 
	  public List<Employee> selectEmployee(){
			  
			  return employeeMapper.selectEmployee();
		  }
	 
	  public Employee selectForDetail(String empNum) {
		   return employeeMapper.selectForDetail(empNum);
	  }
	  
	  public Employee selectForUpdate(String empNum) {
		   return employeeMapper.selectForUpdate(empNum);
	  }
	  
	  public int updateEmployee(Employee employee) {
		  return employeeMapper.updateEmployee(employee);
	  }
	 
}