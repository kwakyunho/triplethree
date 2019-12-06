package shop.triplethree.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;

import shop.triplethree.service.CommonService;
import shop.triplethree.service.EmployeeService;
import shop.triplethree.vo.Employee;

@Controller
public class EmployeeController {
		
	@Autowired private CommonService commonService; 
	@Autowired private EmployeeService employeeService;
	  
	  /**
	   * 로그인 입력값을 받아서 Db와 조회해서 입력값있으면 로그인 그렇지 않으면 다시 로그인페이지 
	   * @param employee
	   * @param session
	   * @return index
	 * @throws IOException 
	   */
	  @PostMapping(value="login", produces ="text/html")
	  public @ResponseBody String login(Employee employee, HttpSession session, HttpServletResponse response) throws IOException {
		//System.out.println(employee.getEmpNum()+ "<- 로그인 아이디 입력값 ");  
		//System.out.println(employee.getPassword()+ "<- 로그인 패스워드 입력값 ");  		
		
		String scriptStr = "<script>alert('아이디와 패스워드를 입력해주세요'); location.href='/';</script>";
		String scriptStr2 = "<script>alert('로그인 성공~!'); location.href='/';</script>";
		String scriptStr3 = "<script>alert('등록된 비밀번호와 일치하지 않습니다.'); location.href='/';</script>";
		String scriptStr4 = "<script>alert('등록된 정보가 없습니다.'); location.href='/';</script>";
		String html = "text/html; charset=UTF-8";
		
		if(employee.getEmpNum() != null && !"".equals(employee.getEmpNum())) {
			
			Employee em2 = employeeService.login(employee); //로그인받은 값을 조회하고 결과값을 가지고온 객체 
			
				if(em2 != null) {
					//디비 조회 값이 있을 경우
					if(em2.getPassword() != null && em2.getPassword().equals(employee.getPassword())) {
						session.setAttribute("SID", em2.getEmpNum());
						session.setAttribute("SNAME", em2.getEmpName());
						session.setAttribute("SDEPART", em2.getDemgCode());
						session.setAttribute("SPOSI", em2.getPoCode());
						session.setAttribute("SADDR", em2.getAddr());
						session.setAttribute("SPHONE", em2.getPhone());
						session.setAttribute("SEMAIL", em2.getEmail());
						return scriptStr2;
					}else {
						
						return scriptStr3;
					}
					
				}else {
					//디비 조회 값이 없을 경우
					return scriptStr4;
				}
			}else {
				//아이디랑 패스워드값 누락
			}
					
		
		return scriptStr;
		
		
	  }
	  
	  /**
	   * 로그아웃 세션 초기화하는 메서드
	   * @param session
	   * @return
	   */
	  @GetMapping("/logout")
	  public String logout(HttpSession session) {
		  session.invalidate();
		  return "redirect:/";
	  }
	 
	  /**
	   * 사원등록을 누르면 employee로 이동하는 메서드 
	   * @return employee/employeeInsert
	   */
	 @GetMapping("/employeeInsert")
	 public String insertEmployee(Model model1, Model model2,Model model3) {
		 model1.addAttribute("depart", employeeService.selectForDepart());
		 model2.addAttribute("position", employeeService.selectForPosition());
		 model3.addAttribute("status", employeeService.selectForStatus());
		 return "/employee/employeeInsert";
	 }
	 
	 /**
	  * 사원관리코드와 사원번호(아이디) 자동생성하거 사원 내용을 등록하는 매서드
	  * @param employee
	  * @return /employee/employeeList
	  */
	 @PostMapping("/employeeInsert")
	 public String insertEmployee(Employee employee) {
		 String code = commonService.codeGeneration("EMP_MANAGE");
		 employee.setCode(code);
		 System.out.println(employee.getCode() + "<-생성된 코드");
		 
		 employeeService.insertEmployee(employee);
		 return "redirect:/employeeList";
	 }
	 
	/**
	 * 사원 조회를 누르면 사원조회하는 화면으로 이동
	 * @return employee/employeeList
	 */
	 @GetMapping("/employeeList")
	 public String selectEmployee(Model model) {
		 model.addAttribute("emList", employeeService.selectEmployee());
		 return "/employee/employeeList";
	 }
	 
	 /**
	  * 사원목록에서 사원의 상세데이터 보여주기
	  * @param model
	  * @return
	  */
	 @GetMapping("/employeeDetail")
	 public String detailEmployee(@RequestParam(value="empNum")String empNum, Model model) {
		 model.addAttribute("detail",employeeService.selectForDetail(empNum));
		 return "/employee/employeeDetail";
	 }
	 /**
	  * 선택된 사원정보의 수정할 데이터와 화면 보여주기
	  * @param empNum
	  * @param model
	  * @return
	  */
	 @GetMapping("/employeeUpdate")
	 public String updateEmployee(@RequestParam(value="empNum")String empNum, Model model,Model model1, Model model2,Model model3) {
		 model.addAttribute("update", employeeService.selectForUpdate(empNum));
		 model1.addAttribute("depart", employeeService.selectForDepart());
		 model2.addAttribute("position", employeeService.selectForPosition());
		 model3.addAttribute("status", employeeService.selectForStatus());
		 return "/employee/employeeUpdate";
	 }
	
	 /**
	  * 수정된 회원정보를 처리하기
	  * @param employee
	  * @return
	  */
	 @PostMapping("/employeeUpdate")
	 public String updateEmployee(Employee employee) {
		 String code = commonService.codeGeneration("EMP_MANAGE");
		 employee.setCode(code);
		 employeeService.updateEmployee(employee);
		 return "redirect:/employeeList";
	 }
	
}
