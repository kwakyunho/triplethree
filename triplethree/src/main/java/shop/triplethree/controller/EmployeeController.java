package shop.triplethree.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import shop.triplethree.service.CommonService;
import shop.triplethree.service.EmployeeService;
import shop.triplethree.vo.Employee;

@Controller
public class EmployeeController {
		
	@Autowired private CommonService commonService; 
	@Autowired private EmployeeService employeeService;
	
	@Value("${file.upload.path}")
	private String uploadPath;
	  
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
						session.setAttribute("SCODE", em2.getCode());	//사원코드
						session.setAttribute("SID", em2.getEmpNum());	//사원번호(아이디)
						session.setAttribute("SNAME", em2.getEmpName());	//사원명
						session.setAttribute("SDEMGCODE", em2.getDemgCode());	//부서코드
						session.setAttribute("SDEMGNAME", em2.getDemgName());	//부서명
						session.setAttribute("SPOCODE", em2.getPoCode());	//직급코드
						session.setAttribute("SPONAME", em2.getPoName());	//직급명
						session.setAttribute("SEMAIL", em2.getEmail());	//사원 이메일
						session.setAttribute("SPHONE", em2.getPhone());	//사원 연락처
						session.setAttribute("SPHOTO", em2.getPhoto());	//사원 사진
						session.setAttribute("SPOSTCODE", em2.getPostCode());	//사원 우편번호
						session.setAttribute("SADDR", em2.getAddr());	//사원 주소
						session.setAttribute("SDTAILADDR", em2.getDetailAddr());	//사원 상세주소
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
	 @GetMapping("/employee/employeeInsert")
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
	 @PostMapping("/employee/employeeInsert")
	 public String insertEmployee(@RequestParam("image") MultipartFile[] file,Employee employee) {
		 String code = commonService.codeGeneration("EMP_MANAGE");
		 employee.setCode(code);
		 System.out.println(employee.getCode() + "<-생성된 코드");
		 
		 Path rootLocation = Paths.get(uploadPath);
		 try {			
				
				String filePath = null;
				String filePath2 = null;			
				
				for(int i =0; i < file.length; i++) {
					
					String originFileName = StringUtils.cleanPath(file[i].getOriginalFilename());
					InputStream inputStream = file[i].getInputStream();
					System.out.println(inputStream + "<--inputStream");
					
					if(inputStream !=null && originFileName != null && !"".equals(originFileName.trim())) {
						
							//테이블에 사진주소
							Files.copy(inputStream, rootLocation.resolve(originFileName), StandardCopyOption.REPLACE_EXISTING);
						
							if(i == 0) {
								filePath = "/img/" + originFileName;
							}else {
								filePath2 = "/img/" + originFileName;
							}
							
						}
						
				}
					System.out.println(filePath + "<- 1");
					System.out.println(filePath2 + "<- 2");
					
					employee.setPhoto(filePath);
					employee.setSignature(filePath2);
					 employeeService.insertEmployee(employee);
				} catch (IOException e) {
					e.printStackTrace();
					
					for(int i =0; i < file.length; i++) {
						String originFileName = StringUtils.cleanPath(file[i].getOriginalFilename());
						try {
							Files.delete(rootLocation.resolve(originFileName));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
				}
					
					
		 
		
		 return "redirect:/employee/employeeList";
	 }
	 
	/**
	 * 사원 조회를 누르면 사원조회하는 화면으로 이동
	 * @return employee/employeeList
	 */
	 @GetMapping("/employee/employeeList")
	 public String selectEmployee(Model model) {
		 model.addAttribute("emList", employeeService.selectEmployee());
		 return "/employee/employeeList";
	 }
	 
	 /**
	  * 사원목록에서 사원의 상세데이터 보여주기
	  * @param model
	  * @return
	  */
	 @GetMapping("/employee/employeeDetail")
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
	 @GetMapping("/employee/employeeUpdate")
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
	 @PostMapping("/employee/employeeUpdate")
	 public String updateEmployee(@RequestParam("image") MultipartFile[] file,Employee employee) {
		 	//System.out.println("DemgCode : " + employee.getDemgCode());
		 	//System.out.println("AfterDemgCode : " + employee.getAfterDemgCode());
		    Path rootLocation = Paths.get(uploadPath);
		 if(employee.getAfterDemgCode() != null || employee.getAfterPoCode() != null) {
			 if(!employee.getDemgCode().equals(employee.getAfterDemgCode()) || !employee.getPoCode().equals(employee.getAfterPoCode())) {
				 System.out.println("변경하기거든?");
				 String moveCode = commonService.codeGeneration("PECHANGE");
				 employee.setMoveCode(moveCode);
				 employeeService.insertMoveEmployee(employee);
			 }
		 }else {
			 System.out.println("수정하기거든?");
			 try {			
					
					String filePath = null;
					String filePath2 = null;			
					
					for(int i =0; i < file.length; i++) {
						
						String originFileName = StringUtils.cleanPath(file[i].getOriginalFilename());
						InputStream inputStream = file[i].getInputStream();
						System.out.println(inputStream + "<--inputStream");
						
						if(inputStream !=null && originFileName != null && !"".equals(originFileName.trim())) {
							
								//테이블에 사진주소
								Files.copy(inputStream, rootLocation.resolve(originFileName), StandardCopyOption.REPLACE_EXISTING);
							
								if(i == 0) {
									filePath = "/img/" + originFileName;
								}else {
									filePath2 = "/img/" + originFileName;
								}
								
							}
							
					}
						System.out.println(filePath + "<- 1");
						System.out.println(filePath2 + "<- 2");
						
						employee.setPhoto(filePath);
						employee.setSignature(filePath2);
						employeeService.updateEmployee(employee);	
					} catch (IOException e) {
						e.printStackTrace();
						
						for(int i =0; i < file.length; i++) {
							String originFileName = StringUtils.cleanPath(file[i].getOriginalFilename());
							try {
								Files.delete(rootLocation.resolve(originFileName));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						
					}
		 }
		
		 return "redirect:/employee/employeeList";	
	 }
	 
	 /**
	  * 로그인한 회원의 기본정보를 보여주는 화면
	  * @return
	  */
	 @GetMapping("/employee/employeeMyPage")
	 public String employeeMyPage(Model model, HttpSession session) {
		
		 String SID = (String)session.getAttribute("SID");
		 if(SID != null) {
			 model.addAttribute("mypage", employeeService.employeeMyPage(SID));
		 }else {
			 
		 }
		 return "/employee/employeeMyPage";
	 }
	 
	 /**
	  * 로그인한 회원의 기본정보를 수정하는 화면
	  * @return
	  */
	 @GetMapping("/employee/employeeMyUpdate")
	 public String employeeMyUpdate(Model model,HttpSession session) {
		 String SID = (String)session.getAttribute("SID");
		 if(SID != null) {
			 model.addAttribute("mypage", employeeService.employeeMyPage(SID));
			 
		 }else {
			 
		 }
		
		 
		 return "/employee/employeeMyUpdate";
	 }
	 /**
	  * 나의 기본정보를 수정처리하는 메서드
	  * @param employee
	  * @return
	  */
	 @PostMapping("/employee/employeeMyUpdate")
	 public String employeeMyUpdate(@RequestParam("image") MultipartFile[] file,Employee employee) {
		 Path rootLocation = Paths.get(uploadPath);
		 try {			
				
				String filePath = null;
				String filePath2 = null;			
				
				for(int i =0; i < file.length; i++) {
					
					String originFileName = StringUtils.cleanPath(file[i].getOriginalFilename());
					InputStream inputStream = file[i].getInputStream();
					System.out.println(inputStream + "<--inputStream");
					
					if(inputStream !=null && originFileName != null && !"".equals(originFileName.trim())) {
						
							//테이블에 사진주소
							Files.copy(inputStream, rootLocation.resolve(originFileName), StandardCopyOption.REPLACE_EXISTING);
						
							if(i == 0) {
								filePath = "/img/" + originFileName;
							}else {
								filePath2 = "/img/" + originFileName;
							}
							
						}
						
				}
					System.out.println(filePath + "<- 1");
					System.out.println(filePath2 + "<- 2");
					
					employee.setPhoto(filePath);
					employee.setSignature(filePath2);
					employeeService.updateEmployee(employee);	
				} catch (IOException e) {
					e.printStackTrace();
					
					for(int i =0; i < file.length; i++) {
						String originFileName = StringUtils.cleanPath(file[i].getOriginalFilename());
						try {
							Files.delete(rootLocation.resolve(originFileName));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
				}
		 
		 employeeService.updateEmployee(employee);
		 return "redirect:/employee/employeeMyPage";
	 }
	 
	 /**
	  * 로그인한 회원의 인사이동목록을 보여주는 화면
	  * @return
	  */
	 @GetMapping("/employee/employeeMyMoveList")
	 public String employeeMyMoveList(HttpSession session,Model model) {
		 String SCODE=(String)session.getAttribute("SCODE");
		 model.addAttribute("MyMove", employeeService.employeeMyMoveList(SCODE));
		 return "/employee/employeeMyMoveList";
	 }
	 
	 /**
	  * 모든 회원의 인사이동 목록을 보여주고 승인처리하는 화면 
	  * @return
	  */
	 @GetMapping("/admin/employee/employeeAllMoveList")
	 public String employeeAllMoveList(Model model,Model model2) {
		 model.addAttribute("AllMove", employeeService.employeeAllMoveList());
		 model2.addAttribute("AllMoveOk", employeeService.employeeAllMoveListOk());
		 return "/employee/employeeAllMoveList";
	 }
	 
	 /**
	  * 승인하기 받은 승인자 번호로 인사이동목록에 업데이트 하고 
	  * 승인받은 정보가 사원정보에 같이 업데이트 되는 메서드	  
	  * @param employee, session
	  * @return
	  */
	 @PostMapping("/admin/employee/employeeAllMoveList")
	 public String employeeAllMoveList(Employee employee, HttpSession session) {
		 String SID = (String)session.getAttribute("SID");
		 employee.setApprover(SID);
		 System.out.println(employee.getMoveCode() + " :이동코드");
		 System.out.println(employee.getCode() + " :사원코드확인");
		 employeeService.updateMoveList(employee);
		 employeeService.updateDepNPoEmployee(employee);
		 return "redirect:/admin/employee/employeeAllMoveList";
	 }
	 
}