package shop.triplethree.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		//System.out.println("시설물 관리가 클릭 되었나요?");
		model.addAttribute("AssetsList", assetsService.selectBeAssets()); 
		return "/assets/assetsBeList";
	}
	
	/**
	 * 시설물 등록 메서드
	 * */
	@PostMapping("/assetsBeInsert")
	public String insertBeAssets(Assets assets, HttpSession session) {
		//System.out.println("시설물 등록 버튼이 클릭 되었나요?");
		String sid = (String) session.getAttribute("SID");
		assets.setWriter(sid);
		assetsService.insertBeAssets(assets);
		//"redirect:/assetBeSelect";
		return "redirect:/assetBeSelect";
	}
	
	/**
	 * 시설물 수정 메서드
	 * */
	@PostMapping("/assetsBeUpdate")
	public String updateBeAssets(Assets assets, HttpSession session) {
		//System.out.println("시설물 수정 버튼이 클릭 되었나요?");
		String sid = (String) session.getAttribute("SID");
		assets.setSid(sid);
		assetsService.updateBeAssets(assets);
		return "redirect:/assetBeSelect";
	}
	
	/**
	 * 시설물 삭제 메서드
	 * */
	@GetMapping("/assetsBeDelete")
	public String deleteBeAssets(@RequestParam(value="code",required = false) String code, Assets assets, HttpSession session) {
		//System.out.println("삭제버튼이 클릭되었나요?");
		//System.out.println("코드가 잘 넘어 왔나요?" + code);
		String sid = (String) session.getAttribute("SID");
		assets.setCode(code);
		assets.setWriter(sid);
		assetsService.deleteBeAssets(assets);
		return "redirect:/assetBeSelect";
	}
	
	/**
	 * 시설물 등록/수정 유효성 검사
	 * */
	@PostMapping(value="/beNameCheck", produces = "application/json")
	public @ResponseBody int beNameChekc (String name, Assets assets) {
		//System.out.println("시설명이 제대로 들어왔나요?" + name);
		//System.out.println("시설명이 있는지 확인해 볼께요.");
		assets.setFaName(name);
		return assetsService.beNameCheck(assets);
	}
	
	/**
	 * 차량 리스트 조회 메서드
	 * */
	@GetMapping("/assetCaSelect")
	public String selectCaAssets(Model model) {
		System.out.println("차량 관리가 클릭 되었나요?");
		return "/assets/assetsCaList";
	}
}
