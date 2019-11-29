package shop.triplethree.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.triplethree.service.EmployeeService;
import shop.triplethree.vo.Employee;

@Controller
public class EmployeeController {
		
	  @Autowired private EmployeeService employeeService;
	  
	  /**
	   * 로그인 입력값을 받아서 Db와 조회해서 입력값있으면 로그인 그렇지 않으면 다시 로그인페이지 
	   * @param employee
	   * @param session
	   * @return index
	   */
	  @PostMapping("/login")
	  public String login(Employee employee, HttpSession session) {
		System.out.println(employee.getEmpNum()+ "<- 로그인 아이디 입력값 ");  
		System.out.println(employee.getPassword()+ "<- 로그인 패스워드 입력값 ");  
		 //아직 로그인 처리과정 완성못함 
		 //사원관리 등록먼저하고 다시 할 예정 
		return "/index"; 
	  }
	 
	  /**
	   * 사원등록을 누르면 employee로 이동하는 메서드 
	   * @return employee/employeeInsert
	   */
	 @GetMapping("/employeeInsert")
	 public String insertEmployee() {
		
		 return "employee/employeeInsert";
	 }
	
}
