package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.AssetsManage;

@Mapper
public interface AssetManageMapper {

	// select box에 뿌려줄 데이터 조회 메서드
	public List<AssetsManage> selectBox();
}
