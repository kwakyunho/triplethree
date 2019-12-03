package shop.triplethree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.triplethree.service.BasicSetService;
import shop.triplethree.vo.CateNameList;

@Controller
public class BasicSetController {
	
	@Autowired private BasicSetService basicSetService;
	
	@GetMapping("/documentFormCateInsert")
	public String insertListName(Model model) {
		model.addAttribute("largeCateNameList", basicSetService.selectLargeCateNameList());
		return "/documentFormCate/cateInsert";
	}
	
	@PostMapping("/documentFormCateInsert")
	public String insertListName(CateNameList cateNameList) {
		basicSetService.insertListName(cateNameList);
		return "redirect:/documentFormCateInsert";
	}
	
	@PostMapping(value="/selectCateNameList", produces="application/json")
	public @ResponseBody List<CateNameList> selectCateNameList(@RequestParam(value="largeCateName", required=false) String largeCateName,
			@RequestParam(value="middleCateName", required=false) String middleCateName) {
		return basicSetService.selectCateNameList(largeCateName, middleCateName);
	}
	
	@PostMapping(value="/updateCateNameConfig", produces="application/json")
	public @ResponseBody CateNameList updateCateNameConfig(@RequestParam(value="condition", required=false) int condition,
			@RequestParam(value="smallCateName", required=false) String smallCateName,
			@RequestParam(value="useConfig", required=false) String useConfig){
		return basicSetService.CateNameConfig(condition, smallCateName, useConfig);
	}
}