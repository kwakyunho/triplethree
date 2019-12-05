package shop.triplethree.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {
	
	// 코드 생성
	public String codeGeneration(String tbName);
}