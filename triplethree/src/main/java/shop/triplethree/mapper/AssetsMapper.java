package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Assets;

@Mapper
public interface AssetsMapper {

	// 시설물 조회 메서드
	public List<Assets> selectAssets();
}
