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
	public String selectSignDocumentWait() {
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
		String sid = (String) session.getAttribute("SID");
		//System.out.println(signDocumentService.selectDraftDocument(valCheck,sid));
		List<SignDocument> selectList = signDocumentService.selectDraftDocument(valCheck,sid);
		return selectList;
	}
}
