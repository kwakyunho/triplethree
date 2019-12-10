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
		//board vo안에 code,writer(작성자 이) 세팅이 되어서 온 상태
		System.out.println(board.toString() + "insertBoard에 두 개가 잘 도착했니?");
		return boardMapper.insertBoard(board);
	}
	
	/* 게시물인서트 pk 코드 생성 메서드
	 * pk 코드 생성 후 board 에  담아서 session에서 사원 아이디 가져와서 board 에 담아서 insertBoard 메서드로 리턴  */
	public Board createBoardCode(HttpSession session,Board board) {
		System.out.println("createBoardCode 메서드가 실행 되었니");
		board.setCode(commonService.codeGeneration("BOARD"));
		board.setWriter((String)session.getAttribute("SNAME"));
		board.setEmpCode((String)session.getAttribute("SID"));
		System.out.println("createBoardCode 실행 후" + board.toString());
		
		return board;
	}
	
	//게시물 목록 가져오기
	public List<Board> boardList() {
		List<Board> list = boardMapper.boardList();
		return boardMapper.boardList();
	}
	
	//게시물  가져오기
	public Board getBoardByCode(String code) {
		Board board = boardMapper.getBoardByCode(code);
		System.out.println("board 안이다"+board.toString());
		return	board;
	}
	
	//게시물 수정하기
	public int updateBoard(Board board) {
		return boardMapper.updateBoard(board);
	}
	
}
