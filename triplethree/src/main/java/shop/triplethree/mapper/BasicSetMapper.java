package shop.triplethree.mapper;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.CateNameList;

@Mapper
public interface BasicSetMapper {

	public int insertListName(CateNameList cateNameList);

}
