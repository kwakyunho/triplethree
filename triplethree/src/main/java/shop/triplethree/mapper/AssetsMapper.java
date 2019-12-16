package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Assets;

@Mapper
public interface AssetsMapper {

	// 시설물 조회 메서드
	public List<Assets> selectBeAssets();
	
	// 시설물 등록 메서드
	public int insertBeAssets(Assets assets);
	
	// 시설물 수정 메서드
	public int updateBeAssets(Assets assets);
	
	// 시설물 삭제 메서드
	public int deleteBeAssets(Assets assets);
	
	// 시설물 등록/수정 유효성 검사 메서드
	public int beNameCheck(Assets assets);
	
	// 차량 등록 메서드
	public int insertCaAssets(Assets assets);
	
	// 차량 조회 메서드
	public List<Assets> selectCaAssets();
	
	// 차량 수정 메서드
	public int updateCaAssets(Assets assets);
	
	// 차량 삭제 메서드
	public int deleteCaAssets(Assets assets);
	
	// 차량 등록/수정 유효성 검사 메서드
	public int carNameCheck(Assets assets);
}
