package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.BasicSetMapper;
import shop.triplethree.vo.CateNameList;

@Service
public class BasicSetService {
	
	@Autowired private CommonService commonService;
	@Autowired private BasicSetMapper basicSetMapper;
	
	public int insertListName(CateNameList cateNameList) {
		String code = commonService.codeGeneration("LIST_MANAGE");
		cateNameList.setCateCode(code);
		return basicSetMapper.insertListName(cateNameList);
	}
	
	public List<CateNameList> selectLargeCateNameList() {
		return basicSetMapper.selectLargeCateNameList();
	}
	
	public List<CateNameList> selectCateNameList(String largeCateName, String middleCateName){
		return basicSetMapper.selectCateNameList(largeCateName, middleCateName);
	}
	
	public CateNameList CateNameConfig(int condition, String cateCode, String largeCateName, String middleCateName, String smallCateName, String useConfig){
		CateNameList result = new CateNameList();
		System.out.println("service - largeCateName : " + largeCateName);
		if(condition == 1) {
			result = basicSetMapper.selectCateNameConfig(condition, smallCateName, useConfig);
		}else if(condition == 2) {
			int re = basicSetMapper.updateCateNameConfig(condition, cateCode, largeCateName, middleCateName, smallCateName, useConfig);
			result.setRe(re);
		}
		return result;
	}
}