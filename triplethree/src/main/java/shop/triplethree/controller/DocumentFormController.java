package shop.triplethree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentFormController {
	
	@GetMapping("/admin/documentForm/formInsert")
	public String documentFormInsert() {
		return "/documentForm/formInsert";
	}
}