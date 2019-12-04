package shop.triplethree.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.triplethree.mapper.BoardMapper;
import shop.triplethree.vo.Board;

@Service
public class BoardService {
	@Autowired private CommonService commonService;
	@Autowired private BoardMapper boardMapper;
	
	//게시물인서트 pk 코드 생성 메서드
	public int createBoardCode(Board board) {
		String code = commonService.codeGeneration("BOARD");
		board.setCode(code);
		System.out.println(code+" : 생성된 공지게시물 PK코드");
		board.setEmpCode("EMP-20191202000003");//세션에서 값 가져와서 작성자 넣기
		return boardMapper.boardInsert(board);
	}
	
	//게시물 목록 가져오기
	public List<Board> boardList() {
		List<Board> list = boardMapper.boardList();
		return	list;
	}
	
	//게시물  가져오기
	public Board getBoardByCode(String code) {
		return	boardMapper.getBoardByCode(code);
	}
	
	//게시물 수정하기
	public Board boardUpdate(Board board) {
		return boardMapper.boardUpdate(board);
	}
	
		
	
}
