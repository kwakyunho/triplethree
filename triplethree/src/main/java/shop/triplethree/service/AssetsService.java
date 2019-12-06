package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.AssetsMapper;
import shop.triplethree.vo.Assets;

@Service
public class AssetsService {

	@Autowired AssetsMapper assetMapper;
	
	/**
	 * 시설물 리스트 조회 메서드
	 * */
	public List<Assets> selectAssets(){
		return assetMapper.selectAssets();
	}
}
