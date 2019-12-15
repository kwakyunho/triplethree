package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.AssetsManage;

@Mapper
public interface AssetManageMapper {

	// 차량 관련 select box에 뿌려줄 데이터 조회 메서드
	public List<AssetsManage> selectCarBox(String startDay, String endDay);
	public List<AssetsManage> selectCarBox2(String startDay, String endDay);
	
	// 차량 예약 등록 쿼리문
	public int insertCarManageAsset(AssetsManage assetsManage);
	
	// 달력에 차량 예약 현황 보여주는 메서드
	public List<AssetsManage> selectCarManageAsset(AssetsManage assetsManage); 
	
	// 차량 예약 수정시 모달에 값을 뿌려줄 메서드
	public AssetsManage selectCarUpdate(String code);
	
	// 차량 예약 일정 수정 메서드
	public int updateCarManageAsset(AssetsManage assetsManage);
	
	// 차량 예약 일정 삭제 메서드
	public int deleteCarManageAsset(String code);
	
	// 시설물 관련 select box에 뿌려줄 데이터 조회 메서드
	public List<AssetsManage> selectBeBox(String startDay, String endDay);
	public List<AssetsManage> selectBeBox2(String startDay, String endDay);
	
	// 달력에 시설물예약 현황 보여주는 메서드
	public List<AssetsManage> selectBeManageAsset(AssetsManage assetsManage);
	
	// 시설물 예약 등록 메서드
	public int insertBeManageAsset(AssetsManage assetsManage);
	
	// 시설물 예약 수정 메서드
	public int updateBeManageAsset(AssetsManage assetsManage);
	
	// 시설물 예약 삭제 메서드
	public int deleteBeManageAsset(String code);
}
