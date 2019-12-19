package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.triplethree.mapper.SignDocumentMapper;
import shop.triplethree.vo.SignDocument;

@Service
public class SignDocumentService {

	@Autowired SignDocumentMapper signDocumentMapper;
	
	/**
	 * 기안 문서함에서 기안올린 문서를 select하는 메서드
	 * @param String
	 * @return List<SignDocument>
	 * */
	public List<SignDocument> selectDraftDocument(String valCheck,String sid){
		return signDocumentMapper.selectDraftDocument(valCheck,sid);
	}
}
