package shop.triplethree.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import shop.triplethree.vo.Employee;

@Service
public class EmployeeService {

	  public String login(Employee employee, HttpSession session) {
			
		  
			return "/index"; 
		  }
}
