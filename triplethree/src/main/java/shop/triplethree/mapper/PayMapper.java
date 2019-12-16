package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
	
	/**급여 입력***/
	public int insertPay(Pay pay);
}
