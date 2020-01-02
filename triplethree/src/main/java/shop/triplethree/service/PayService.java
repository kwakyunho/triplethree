package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.EmployeeMapper;
import shop.triplethree.mapper.PayMapper;
import shop.triplethree.vo.Company;
import shop.triplethree.vo.Employee;
import shop.triplethree.vo.Pay;

@Service
public class PayService {

	@Autowired
	private PayMapper payMapper;
	@Autowired 
	private CommonService commonService;
	

	/** 급여 입력  검색조건 **/
	public List<Employee> insertSearchPay(String sk, String sv) {
		List<Employee> list = payMapper.insertSearchPay(sk, sv);
		return list;
	}
	/***급여 지급액등록(사실상 수정)**/
	/*
	 * public int updatePay(Pay Pay) {
	 * 
	 * return payMapper.updatePay(Pay); }
	 */
	/** 급여 대장  selectPay,payInsert**/
	public List<Employee> selectPay() {
		return payMapper.selectPay();
	}
	public List<Pay> payInsert(){
		return payMapper.payInsert();
	}
	
	public Pay selectPaySum() {
		return payMapper.selectPaySum();
	}

	/** 퇴직금 검색 조회 **/
	public List<Employee> selectRetiring() {
		return payMapper.selectRetiring();

	}
	
	/**공제액 화면***/
	public List<Pay> insertDeduct(){
		return payMapper.insertDeduct();
	}
	
	/**급여대장에서 수정하는 화면**/
	public Pay updatePayView(String empCode) {
		
		return payMapper.updatePayView(empCode);
	}
	/**급여대장에서 진짜 수정**/
	public int updatePay(Pay pay) {
		return payMapper.updatePay(pay);
	}
	/**공제액 설정 모달창***/
	public int deductList(Pay pay) {
		String deCode = commonService.codeGeneration("DEDUCT_MANAGE");
		pay.setDeCode(deCode);
		return payMapper.deductList(pay);
	}
	/**공제액 수정***/
	public Pay updateDeductList(String deCode) {
		return payMapper.updateDeductList(deCode);
	}
	
	/**공제액 수정**/
	public int updateDeduct(Pay pay) {
		return payMapper.updateDeduct(pay);
	}
}
