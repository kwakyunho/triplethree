package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.CateNameList;

@Mapper
public interface BasicSetMapper {
	// 카테고리명 등록
	public int insertListName(CateNameList cateNameList);
	
	// 대분류 리스트 가져오기
	public List<CateNameList> selectLargeCateNameList(); 
	
	// 중분류 리스트 가져오기
	public List<CateNameList> selectCateNameList(String largeCateName, String middleCateName);
}
