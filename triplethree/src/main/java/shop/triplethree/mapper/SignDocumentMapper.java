package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.SignDocument;

@Mapper
public interface SignDocumentMapper {

	// 기안 문서함에서 기안올린 문서를 select하는 메서드
	public List<SignDocument> selectDraftDocument(String valCheck, String sid);
	
	// 기안 문서함에서 기안올린 문서중 반려된 문서를 select하는 메서드
	public List<SignDocument> selectDraftDocumentReturn(String valCheck, String sid);
}
