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
	
	  public String login(Employee employee, HttpSession session) {
			
		  
		return "/index"; 
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
}
