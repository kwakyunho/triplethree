package shop.triplethree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.triplethree.service.BasicSetService;
import shop.triplethree.vo.CateNameList;

@Controller
public class BasicSetController {
	
	@Autowired private BasicSetService basicSetService;
	
	@GetMapping("/documentFormCateInsert")
	public String insertListName() {
		return "/documentFormCate/cateInsert";
	}
	
	@PostMapping("/documentFormCateInsert")
	public String insertListName(CateNameList cateNameList) {
		basicSetService.insertListName(cateNameList);
		return "redirect:/documentFormCateInsert";
	}
}