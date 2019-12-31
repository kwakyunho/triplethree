package shop.triplethree.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.triplethree.service.SignDocumentService;
import shop.triplethree.vo.SignDocument;

@Controller
public class SignDocumentController {

	@Autowired SignDocumentService signDocumentService;
	/**
	 * 전자결재탭에서 결재대기문서 클릭시 화면이동
	 * */
	@GetMapping("/signDocument/signStandByDocument")
	public String selectSignDocumentWait(String valCheck, String sid, Model model) {
		List<String> result = signDocumentService.selectSignDocumentWait(valCheck, sid);
		System.out.println("controller result value : " + result);
		model.addAttribute("result", result);
		return "/signDocument/signStandByDocument";
	}
	
	/**
	 * 전자결재탭에서 결재문서함 클릭시 화면이동
	 * */
	@GetMapping("/signDocument/signDocumentSearch")
	public String selectSignDocumentEnd() {
		return "/signDocument/signDocument";
	}
	
	/**
	 * 전자결대탭에서 기안문서함 클릭시 화면이동
	 * */
	@GetMapping("/signDocument/signDraftBox")
	public String selectDraftDocument(Model model) {
		//model.addAttribute("selectAll", signDocumentService.selectDraftDocument(sid));
		//model.addAttribute("starting", "<span class='btn bg-gradient-success'>진행중</span>");
		//model.addAttribute("end", "<span class='btn bg-gradient-secondary'>완료</span>");
		//model.addAttribute("return", "<span class='btn bg-gradient-danger'>반려</span>");
		return "/signDocument/signDraftDocument";
	}
	
	/**
	 * 기안문서함에서 상단 메뉴 클릭시 클릭된 값에 맞는 결재문서를 가져와 뿌려주는 메서드
	 * @param String valCheck
	 * */
	@PostMapping(value="/signDocument/selectDraftDocument",produces = "application/json")
	public @ResponseBody List<SignDocument> selectDraftDocument(String valCheck,HttpSession session) {
		//System.out.println(valCheck);

		// 리턴을 위한 변수를 선언
		List<SignDocument> selectList = null; 
		String sid = (String) session.getAttribute("SID");
		//System.out.println(signDocumentService.selectDraftDocument(valCheck,sid));
		selectList = signDocumentService.selectDraftDocument(valCheck,sid);
		//System.out.println("값확인"+selectList.toString());
		return selectList;
	}
	
	/**
	 * 결재 문서함에서 상단 메뉴 클릭시 클릭된 값에 맞는 결재문서를 가져와 뿌려주는 메서드
	 * @param String valCheck
	 * */
	@PostMapping("/signDocument/signStandByDocument")
	public @ResponseBody List<SignDocument> selectSignDocumentEnd(String valCheck, HttpSession session){
		String sid = (String) session.getAttribute("SID");
		//System.out.println(valCheck+sid);
		// 리턴을 위한 변수를 선언
		List<SignDocument> selectList = null;
		selectList = signDocumentService.selectSignDocumentEnd(valCheck, sid);
		System.out.println(selectList);
		return selectList;
	}
}