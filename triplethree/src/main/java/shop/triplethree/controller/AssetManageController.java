package shop.triplethree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AssetManageController {

	/**
	 * 메뉴에서 차량 예약 눌렸을때 실행
	 * 예약 리스트를 보여줌
	 * 모달에 사용 가능한 차량만 셀렉트 박스로 뿌려줌.
	 * */
	@GetMapping("/assetsManageCaSelect")
	public String selectCarManageAsset(Model model) {
		System.out.println("차량 예약 신청이 클릭되었나요?");
		
		return "/assets/assetsCarManage";
	}
}
