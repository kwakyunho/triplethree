package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.EmployeeMapper;
import shop.triplethree.mapper.PayMapper;
import shop.triplethree.vo.Employee;
import shop.triplethree.vo.Pay;

@Service
public class PayService {

	@Autowired
	private PayMapper payMapper;
	

	/** 급여 입력  검색조건 **/
	public List<Employee> insertSearchPay(String sk, String sv) {
		List<Employee> list = payMapper.insertSearchPay(sk, sv);
		return list;
	}
	
	/** 급여 대장 **/
	public List<Employee> selectPay() {
		return payMapper.selectPay();
	}
	public List<Pay> payInsert(){
		return payMapper.payInsert();
	}

	/** 퇴직금 검색 조회 **/
	public List<Employee> selectRetiring() {
		return payMapper.selectRetiring();

	}
}
