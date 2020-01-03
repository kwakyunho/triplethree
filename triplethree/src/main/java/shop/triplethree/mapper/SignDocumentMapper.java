package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.SignDocument;

@Mapper
public interface SignDocumentMapper {

	// 기안 문서함에서 기안올린 문서를 select하는 메서드
	public List<SignDocument> selectDraftDocument(String valCheck, String sid);
	
	// 결재 대기함에서 본인의 결재 건수가 있는 문서를 select하는 메서드
	public List<String> selectSignDocumentWait(String sid);
	
	// 결재 대기함에서 본인의 결재 순번을 가져오는 메서드
	/* public int selectSignNum(String sid); */
	
	// 결재 문서함에서 상단 메뉴클릭에 따라 문서를 select하는 메서드
	public List<SignDocument> selectSignDocumentEnd(String valCheck, String sid);
}