package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Employee;

@Mapper
public interface PayMapper {

	public List<Employee> selectPay();
}
