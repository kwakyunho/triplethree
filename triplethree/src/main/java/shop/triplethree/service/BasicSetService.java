package shop.triplethree.service;

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
		System.out.println(code);
		cateNameList.setCode(code);
		return basicSetMapper.insertListName(cateNameList);
	}

}
