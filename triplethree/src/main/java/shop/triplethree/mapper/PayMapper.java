package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Company;
import shop.triplethree.vo.Employee;
import shop.triplethree.vo.Pay;

@Mapper
public interface PayMapper {


	/** 급여대장 **/
	public List<Employee> selectPay();
	public List<Pay> payInsert();

	/** 퇴직금 검색조회 ***/
	public List<Employee> selectRetiring();

	/** 급여 입력  검색조건 **/
	public List<Employee> insertSearchPay(String sk, String sv);
	
	/**급여  지급액입력***/
	public int updatePay(Pay pay);
	
	/***공제액화면****/
	public List<Pay> insertDeduct();
	
	/** *회사정보 수정클릭시 화면 보여주기 ***/
	public Pay updatePayView(String empCode);
	
	/**공제액 모달창 등록***/
	public int deductList(Pay pay);
	
	/**공제액 수정화면**/
	public Pay updateDeductList(String deCode);
	
	/**공제액 모달창 수정***/
	public int updateDeduct(Pay pay);
	
}
