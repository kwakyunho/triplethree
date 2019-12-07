package shop.triplethree.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.triplethree.service.AssetsService;
import shop.triplethree.vo.Assets;

@Controller
public class AssetsController {

	@Autowired AssetsService assetsService;
	
	/**
	 * 시설물 리스트 조회 메서드
	 * */
	@GetMapping("/assetBeSelect")
	public String selectBeAssets(Model model) {
		System.out.println("시설물 예약 및 관리가 클릭 되었나요?");
		model.addAttribute("AssetsList", assetsService.selectBeAssets()); 
		return "/assets/assetsBeList";
	}
	
	/**
	 * 시설물 등록 메서드
	 * */
	@PostMapping("/assetsBeInsert")
	public String insertBeAssets(Assets assets, HttpSession session) {
		System.out.println("시설물 등록 버튼이 클릭 되었나요?");
		String sid = (String) session.getAttribute("SID");
		assets.setWriter(sid);
		assetsService.insertBeAssets(assets);
		return "redirect:/assetBeSelect";
	}
	
	/**
	 * 시설물 수정 메서드
	 * */
	@PostMapping("/assetsBeUpdate")
	public String updateBeAssets(Assets assets, HttpSession session) {
		String sid = (String) session.getAttribute("SID");
		assets.setSid(sid);
		assetsService.updateBeAssets(assets);
		return "redirect:/assetBeSelect";
	}
	
	/**
	 * 시설물 삭제 메서드
	 * */
	@GetMapping("/assetsBeDelete")
	public String deleteBeAssets(@RequestParam(value="code",required = false) String code) {
		//System.out.println("코드가 잘 넘어 왔나요?" + code);
		assetsService.deleteBeAssets(code);
		return "redirect:/assetBeSelect";
	}
}
