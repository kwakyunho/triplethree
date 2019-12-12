package shop.triplethree.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.triplethree.mapper.AssetManageMapper;
import shop.triplethree.vo.AssetsManage;

@Service
public class AssetManageService {

	@Autowired private AssetManageMapper assetManageMapper;
	
	// select Box 값 뿌리기위한 메서드
	public List<AssetsManage> selectBox(){
		return assetManageMapper.selectBox();
	}
	
	// 차량 예약 등록 메서드
	public int insertCarManageAsset(AssetsManage assetsManage) {
		return assetManageMapper.insertCarManageAsset(assetsManage);
	}
	
	// 달력에 차량 예약 현황 보여주는 메서드
	public List<AssetsManage> selectCarManageAsset(AssetsManage assetsManage){
		return assetManageMapper.selectCarManageAsset(assetsManage);
	}
	
	// 수정시 모달 화면에 값을 뿌려주는 메서드
	public AssetsManage selectCarUpdate(String code) {
		return assetManageMapper.selectCarUpdate(code);
	}
	
	// 차량 예약 수정 메서드
	public int updateCarManageAsset(AssetsManage assetsManage) {
		return assetManageMapper.updateCarManageAsset(assetsManage);
	}
}
