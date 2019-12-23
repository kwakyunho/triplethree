package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.SignDocument;

@Mapper
public interface SignDocumentMapper {

	// 기안 문서함에서 기안올린 문서를 select하는 메서드
	public List<SignDocument> selectDraftDocument(String valCheck, String sid);
	
	// 결재 문서함에서 본인의 결재 건수가 있는 문서를 select하는 메서드
	public List<SignDocument> selectSignDocumentWait(String sid);
	public List<SignDocument> selectSignDocumentWait(String valCheck, String sid);
}