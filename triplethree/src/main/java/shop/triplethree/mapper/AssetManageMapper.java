package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.AssetsManage;

@Mapper
public interface AssetManageMapper {

	// select box에 뿌려줄 데이터 조회 메서드
	public List<AssetsManage> selectBox();
	
	// 차량 예약 등록 쿼리문
	public int insertCarManageAsset(AssetsManage assetsManage);
	
	// 달력에 차량 예약 현황 보여주는 메서드
	public List<AssetsManage> selectCarManageAsset(AssetsManage assetsManage); 
	
	// 수정시 모달에 값을 뿌려줄 메서드
	public AssetsManage selectCarUpdate(String code);
	
	// 차량 예약 일정 수정 메서드
	public int updateCarManageAsset(AssetsManage assetsManage);
}
