package shop.triplethree.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping("/assetsBeDelete")
	public String deleteBeAssets(Assets assets, HttpSession session) {
		//System.out.println("삭제버튼이 클릭되었나요?");
		
		System.out.println("코드가 잘 넘어 왔나요?" + assets.getCode());
		String sid = (String) session.getAttribute("SID");
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
		//System.out.println("차량 관리가 클릭 되었나요?");
		model.addAttribute("carList", assetsService.selectCaAssets());
		return "/assets/assetsCaList";
	}
	
	/**
	 * 차량 등록 메서드
	 * */
	@PostMapping("/assetsCaInsert")
	public String insertCaAssets(Assets assets, HttpSession session) {
		String cc = assets.getVeCc();
		String sid = (String) session.getAttribute("SID");
		assets.setVeCc(cc+"CC");
		assets.setWriter(sid);
		//System.out.println("차량cc 확인" + assets.getVeCc());
		//System.out.println("차량등록 버튼이 클릭되었나요?");
		assetsService.insertCaAssets(assets);
		return "redirect:assetCaSelect";
	}
	
	/**
	 * 차량 수정 메서드
	 * */
	@PostMapping("/assetsCaUpdate")
	public String updateCaAssets(Assets assets, HttpSession session) {
		//System.out.println("차량 수정버튼이 클릭되었나요?");
		//System.out.println("무엇이 담겨있나요?" + assets);
		String sid = (String) session.getAttribute("SID");
		assets.setWriter(sid);
		String cc = assets.getVeCc();
		assets.setVeCc(cc+"CC");
		assetsService.updateCaAssets(assets);
		return "redirect:assetCaSelect";
	}
	
	/**
	 * 차랑 삭제 메서드
	 * */
	@PostMapping("/assetsCaDelete")
	public String deleteCaAssets(Assets assets, HttpSession session) {

		//System.out.println("코드가 넘어왔는지 확인해요." + assets.getCode());
		//System.out.println(assets.getCode());
		
		// 세션에서 작성자를 가지고와 셋팅
		String sid = (String) session.getAttribute("SID");
		assets.setWriter(sid);
		//System.out.println("세션값을 확인할께요." + sid);
		assetsService.deleteCaAssets(assets);
		return "redirect:assetCaSelect";
	}
	
	/**
	 * 차량 등록/수정 유효성 검사
	 * */
	@PostMapping(value="/carNameCheck", produces = "application/json")
	public @ResponseBody int carNameCheck (String veNunber, Assets assets) {
		System.out.println("차량번호가 제대로 들어왔나요?" + veNunber);
		//System.out.println("시설명이 있는지 확인해 볼께요.");
		assets.setVeNunber(veNunber);
		return assetsService.carNameCheck(assets);
	}
}
