package shop.triplethree.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/test")
	public @ResponseBody List<CateNameList> selectCateList(@RequestBody String largeCateName, @RequestBody String middleCateName) {
		List<CateNameList> cateNameList = new ArrayList<CateNameList>();
		return cateNameList;
	}
}