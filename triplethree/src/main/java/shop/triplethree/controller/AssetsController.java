package shop.triplethree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shop.triplethree.service.AssetsService;
import shop.triplethree.vo.Assets;

@Controller
public class AssetsController {

	@Autowired AssetsService assetsService;
	
	/**
	 * 시설물 리스트 조회 메서드
	 * */
	@GetMapping("/assetSelect")
	public String selectAssets(Model model) {
		System.out.println("시설물 예약 및 관리가 클릭 되었나요?");
		model.addAttribute("AssetsList", assetsService.selectAssets()); 
		List<Assets> assets = assetsService.selectAssets();
		System.out.println(assets.toString());
		return "/assets/assetsList";
	}
	
	/**
	 * 시설물 & 차량 예약 메서드
	 * */
	@GetMapping("/assetsInsert")
	public String reserve() {
		System.out.println("시설물 예약 OR 차량 예약이 클릭 되었나요?");
		return "/assets/assetsList";
	}
}
