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
	 * */
	@GetMapping("/assetsManageCaSelect")
	public String selectCarManageAsset() {
		return "/assets/assetsCarManage";
	}
	
	/**
	 * 차량 예약시 일정 선택하면 셀렉트 박스에 사용 가능한 차량 뿌려주는 메서드
	 * */
	@PostMapping(value="/selectCarBox", produces = "application/json")
	public @ResponseBody List<AssetsManage> selectCarBox(String star, String end) {
		String time = ":00";
		String startday = star.replace("T", " ");
		String endday = end.replace("T", " ");
		String startDay = startday.concat(time);
		String endDay = endday.concat(time);
		System.out.println(startDay +"\n"+ endDay);
		return assetManageService.selectCarBox(startDay, endDay);
	}
	
	/**
	 * 차량 예약시 일정 선택하면 셀렉트 박스에 사용 가능한 차량 뿌려주는 메서드
	 * */
	@PostMapping(value="/selectCarBox2", produces = "application/json")
	public @ResponseBody List<AssetsManage> selectCarBox2(String star, String end) {
		String time = ":00";
		String startday = star.replace("T", " ");
		String endday = end.replace("T", " ");
		String startDay = startday.concat(time);
		String endDay = endday.concat(time);
		System.out.println(startDay +"\n"+ endDay);
		return assetManageService.selectCarBox2(startDay, endDay);
	}
	
	/**
	 * 달력에 차량 예약 일정 뿌려주는 메서드
	 * */
	@PostMapping(value="/assetsManageCaSelect", produces = "application/json")
	public @ResponseBody List<AssetsManage> selectCarManageAsset(AssetsManage assetsManage){
		//System.out.println(assetsManage);
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
	 * */
	@GetMapping("/assetsManageBeSelect")
	public String selectBeManageAsset () {
		return "/assets/assetsBeManage";
	}
	
	/**
	 * 시설물 예약시 일정 선택하면 셀렉트 박스에 사용 가능한 시설물 뿌려주는 메서드
	 * */
	@PostMapping(value="/selectBeBox", produces = "application/json")
	public @ResponseBody List<AssetsManage> selectBeBox(String star, String end) {
		String time = ":00";
		String startday = star.replace("T", " ");
		String endday = end.replace("T", " ");
		String startDay = startday.concat(time);
		String endDay = endday.concat(time);
		System.out.println(startDay +"\n"+ endDay);
		return assetManageService.selectBeBox(startDay, endDay);
	}
	
	/**
	 * 시설물 예약시 일정 선택하면 셀렉트 박스에 사용 가능한 시설물 뿌려주는 메서드
	 * */
	@PostMapping(value="/selectBeBox2", produces = "application/json")
	public @ResponseBody List<AssetsManage> selectBeBox2(String star, String end) {
		String time = ":00";
		String startday = star.replace("T", " ");
		String endday = end.replace("T", " ");
		String startDay = startday.concat(time);
		String endDay = endday.concat(time);
		System.out.println(startDay +"\n"+ endDay);
		return assetManageService.selectBeBox2(startDay, endDay);
	}
	
	/**
	 * 달력에 시설물 예약 일정 뿌려주는 메서드
	 * */
	@PostMapping(value="/assetsManageBeSelect", produces = "application/json")
	public @ResponseBody List<AssetsManage> selectBeManageAsset(AssetsManage assetsManage){
		//System.out.println("일정을 찾아주세요.");
		return assetManageService.selectBeManageAsset(assetsManage);
	}
	
	/**
	 * 시설물 예약 신청 메서드
	 * */
	@PostMapping("/assetsManageBeInsert")
	public String insertBeManageAsset(AssetsManage assetsManage, HttpSession session) {
		System.out.println("등록버튼이 눌렸어요.");
		// 예약 관리 코드를 생성하는 메서드
		String code = commonService.codeGeneration("RESER_MANAGE");
		assetsManage.setCode(code);
		// 세션의 사원번호를 가져오는 메서드
		String sid = (String) session.getAttribute("SID");
		assetsManage.setEmpCode(sid);
		assetManageService.insertBeManageAsset(assetsManage);
		return "redirect:assetsManageBeSelect";
	}
	
	/**
	 * 시설물 예약 수정 메서드
	 * */
	@PostMapping("/assetsManageBeUpdate")
	public String updateBeManageAsset(AssetsManage assetsManage) {
		System.out.println("시설물 수정 버튼이 클릭되었어요.");
		assetManageService.updateBeManageAsset(assetsManage);
		return "redirect:assetsManageBeSelect";
	}
	
	/**
	 * 시설물 예약 삭제 메서드
	 * */
	@PostMapping("/assetsManageBeDelete")
	public String deleteBeManageAsset(String code) {
		//System.out.println("삭제버튼이 클릭되었어요.");
		//System.out.println("코드값을 확인해 볼께요." + code);
		assetManageService.deleteBeManageAsset(code);
		return "redirect:assetsManageBeSelect";
	}
	
	/**
	 * 이용 내역 조회 버튼 클릭시 실행
	 * 이용 내역 조회
	 * */
	@GetMapping("/assetsManageList")
	public String assetsManageListSelect(HttpSession session, Model model, Model model2) {
		String sid = (String) session.getAttribute("SID");
		//System.out.println("세션값이 넘어왔나요?" + sid);
		List<AssetsManage> List = assetManageService.assetsManageListSelect(sid);
		System.out.println("값 확인" + List);
		model.addAttribute("List", List);
		model2.addAttribute("input", "<input type='button' value='반납' class='btn btn-block btn-primary btn-mg'>");
		return "/assets/assetsManageList";
	}
	
	/**
	 * 이용 내역 조회에서 반납 버튼 클릭시 실행되는 메서드
	 * */
	@PostMapping("/assetsManageCaReturn")
	public String ReturnCarManageAsset(String code, HttpSession session) {
		//System.out.println("반납 할래요.");
		//System.out.println("반납 하려는 예약코드를 확인 할께요" + code);
		String sid = (String) session.getAttribute("SID");
		assetManageService.ReturnCarManageAsset(code, sid);
		return "redirect:assetsManageList";
	}
}
