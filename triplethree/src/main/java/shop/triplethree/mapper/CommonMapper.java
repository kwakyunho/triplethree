package shop.triplethree.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {
	
	public String codeGeneration(String tbName);
}