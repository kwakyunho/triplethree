package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.AssetsMapper;
import shop.triplethree.vo.Assets;

@Service
public class AssetsService {

	@Autowired private CommonService commonService;
	@Autowired private AssetsMapper assetMapper;
	
	/**
	 * 시설물 리스트 조회 메서드
	 * */
	public List<Assets> selectBeAssets(){
		return assetMapper.selectBeAssets();
	}
	
	/**
	 * 시설물 등록 메서드
	 * */
	public int insertBeAssets(Assets assets) {
		String code = commonService.codeGeneration("FACILITY_MANAGE");
		assets.setCode(code);
		return assetMapper.insertBeAssets(assets);
	}
	
	/**
	 * 시설물 수정 메서드
	 * */
	public int updateBeAssets(Assets assets) {
		return assetMapper.updateBeAssets(assets);
	}
	
	/**
	 * 시설물 삭제 메서드
	 * */
	public int deleteBeAssets(String code) {
		return assetMapper.deleteBeAssets(code);
	}
}
