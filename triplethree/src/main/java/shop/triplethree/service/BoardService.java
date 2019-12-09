package shop.triplethree.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.triplethree.mapper.BoardMapper;
import shop.triplethree.vo.Board;
@Service
public class BoardService {
	@Autowired private CommonService commonService;
	@Autowired private BoardMapper boardMapper;
	
	//공지사항 작성
	public int insertBoard(Board board) {
		//board vo안에 code,empCode(작성자) 세팅이 되어서 온 상태
		System.out.println(board.toString() + "insertBoard에 두 개가 잘 도착했니?");
		return boardMapper.insertBoard(board);
	}
	
	/* 게시물인서트 pk 코드 생성 메서드
	 * pk 코드 생성 후 board 에  담아서 session에서 사원 아이디 가져와서 board 에 담아서 insertBoard 메서드로 리턴  */
	public int createBoardCode(HttpSession session,Board board) {
		System.out.println("createBoardCode 메서드가 실행 되었니");
		String code = commonService.codeGeneration("BOARD");
		board.setCode(code);
		System.out.println(code+" : 생성된 공지게시물 PK코드");
		String empCode = (String)session.getAttribute("SID");
		board.setEmpCode(empCode);
		return insertBoard(board);
	}
	
	//사원아이디 가지고 이름 가져오기
	public String getNameByEmpCode(String empCode) {
		
		return boardMapper.getNameByEmpCode(empCode);
	}
	
	//게시물 목록 가져오기
	public List<Board> boardList() {
		List<Board> list = boardMapper.boardList();
		return boardMapper.boardList();
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
