package shop.triplethree.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.triplethree.service.AssetManageService;
import shop.triplethree.service.CommonService;
import shop.triplethree.vo.AssetsManage;

@Controller
public class AssetManageController {

	@Autowired AssetManageService assetManageService;
	@Autowired CommonService commonService;
	/**
	 * 메뉴에서 차량 예약 눌렸을때 실행
	 * 예약 리스트를 보여줌
	 * 모달에 사용 가능한 차량만 셀렉트 박스로 뿌려줌.
	 * */
	@GetMapping("/assetsManageCaSelect")
	public String selectCarManageAsset(Model model) {
		//System.out.println("차량 예약 신청이 클릭되었나요?");
		//System.out.println(assetManageService.selectBox());
		model.addAttribute("selectCarBox", assetManageService.selectCarBox());
		return "/assets/assetsCarManage";
	}
	
	/**
	 * 달력에 예약 일정 뿌려주는 메서드
	 * */
	@PostMapping(value="/assetsManageCaSelect", produces = "application/json")
	public @ResponseBody List<AssetsManage> selectCarManageAsset(AssetsManage assetsManage){
		//List<AssetsManage> list = assetManageService.selectCarManageAsset(assetsManage);
		//System.out.println("달력에 뿌려줄 값이에요"+list.toString());
		return assetManageService.selectCarManageAsset(assetsManage);
	}
	
	/**
	 * 차량 예약 신청 메서드
	 * */
	@PostMapping("/assetsManageCaInsert")
	public String insertCarManageAsset (AssetsManage assetsManage, HttpSession session) {
		//System.out.println("값을 확인해 볼께요." + assetsManage);
		// 예약 관리 코드를 생성하는 메서드
		String code = commonService.codeGeneration("RESER_MANAGE");
		assetsManage.setCode(code);
		// 세션의 사원번호를 가져오는 메서드
		String sid = (String) session.getAttribute("SID");
		assetsManage.setEmpCode(sid);
		// 차량 예약 등록 메서드
		assetManageService.insertCarManageAsset(assetsManage);
		return "redirect:/assetsManageCaSelect";
	}
	
	/**
	 * 차량 예약 수정시 화면에 뿌려줄 값을 찾는 메서드
	 * */
	@PostMapping(value="/selectCarUpdate", produces = "application/json")
	public @ResponseBody AssetsManage selectCarUpdate(String code) {
		//System.out.println("값이 넘어왔나요?" + code);
		return assetManageService.selectCarUpdate(code);
	}
	
	/**
	 * 차량 예약 수정 메서드
	 * */
	@PostMapping("/assetsManageCaUpdate")
	public String updateCarManageAsset(AssetsManage assetsManage) {
		//System.out.println("어떤 값이 들어 있나요?" + assetsManage);
		assetManageService.updateCarManageAsset(assetsManage);
		return "redirect:/assetsManageCaSelect";
	}
	
	/**
	 * 차량 예약 삭제 메서드
	 * */
	@PostMapping("/assetsManageCaDelete")
	public String deleteCarManageAsset(String code) {
		//System.out.println("삭제 버튼이 클릭되었어요.");
		//System.out.println("삭제하는 값을 확인해 볼께요" + code);
		assetManageService.deleteCarManageAsset(code);
		return "redirect:/assetsManageCaSelect";
	}
	
	/**
	 * 메뉴에서 시설물 예약 눌렸을때 실행
	 * 예약 리스트를 보여줌
	 * 모달에 사용 가능한 시설만 셀렉트 박스로 뿌려줌.
	 * */
	@GetMapping("/assetsManageBeSelect")
	public String electBeManageAsset (Model model) {
		System.out.println("시설물예약이 클릭되었어요.");
		model.addAttribute("selectBeBox", assetManageService.selectBeBox());
		return "/assets/assetsBeManage";
	}
}
