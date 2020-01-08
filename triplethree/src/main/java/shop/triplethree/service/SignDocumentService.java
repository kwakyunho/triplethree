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
	 * 결재 대기 문서에서 본인이 결재자에 있는 모든 문서를 select하는 메서드
	 * @param Strig
	 * @return List<SignDocument>
	 * */
	public List<String> selectSignDocumentWait(String sid){
			List<String> result = signDocumentMapper.selectSignDocumentWait(sid);
			//System.out.println("service result value : " + result);
		/*
		 * int num = signDocumentMapper.selectSignNum(sid); System.out.println("순차확인 : "
		 * + num);
		 */
			return result;
	}
	
	/**
	 * 결재 문서함에서 본인의 결재가 있는 모든 문서를 select하는 메서드
	 * @param String
	 * @return List<SignDocument>
	 * */
	public List<SignDocument> selectSignDocumentEnd (String valCheck, String sid){
		return signDocumentMapper.selectSignDocumentEnd(valCheck, sid);
	}
}