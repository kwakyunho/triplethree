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
	
	/**
	 * 결재 문서함에서 본인이 결재자에 있는 모든 문서를 select하는 메서드
	 * @param Strig
	 * @return List<SignDocument>
	 * */
	public List<SignDocument> selectSignDocumentWait(String valCheck, String sid){
		if(valCheck != "null") {
			System.out.println("valCheck가 null이 아니에요");
			return signDocumentMapper.selectSignDocumentWait(valCheck, sid);
		}else {
			return signDocumentMapper.selectSignDocumentWait(sid);
		}
	}
}