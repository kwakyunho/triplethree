package shop.triplethree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignDocumentController {

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
}
