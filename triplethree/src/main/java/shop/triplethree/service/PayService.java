package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.EmployeeMapper;
import shop.triplethree.mapper.PayMapper;
import shop.triplethree.vo.Employee;

@Service
public class PayService {
	
	@Autowired private PayMapper payMapper;  
	
	public List<Employee> selectPay(){		  
		  return payMapper.selectPay();
	  }
}
