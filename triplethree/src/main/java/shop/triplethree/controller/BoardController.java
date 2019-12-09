package shop.triplethree.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.triplethree.service.BoardService;
import shop.triplethree.vo.Board;

@Controller
public class BoardController {
	@Autowired private BoardService boardService;
	@Autowired
	private BoardService boardservice;
	
	/**
	  * 공지사항 작성하는 화면으로 이 
	  * @param session
	  * @return
	  */
	@GetMapping("/boardInsert")
	public String insertBoard(HttpSession session) {
		
		return "/board/boardInsert";
	}

	/**
	  * 공지사항 작성하기 
	  * @param board
	  * @param session
	  * @return
	  */
	@PostMapping("/boardInsert")
	public String insertBoard(Board board,HttpSession session){
		boardService.createBoardCode(session,board);
		System.out.println(board.toString() + "작성하기 폼에서 들어온 값들 ");
		return "redirect:/boardList";
	}
	
	
	/**
	  * 글 목록 가져오기 
	  * @param model
	  * @return
	  */
	@GetMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardservice.boardList());
		return "/board/boardList";
	}
	
	
	/**
	  * 선택된 글에 대한 수정할 데이터와 화면 보여주기
	  * @param code
	  * @param model
	  * @return
	  */
	@GetMapping("/boardUpdate")
	public String boardUpdate(@RequestParam(value="code")String code,Model model) {
//		System.out.println(code + "수정할 게시글 code");
//		model.addAttribute("board", boardservice.getBoardByCode(code));
		return "/board/boardUpdate";
	}
	
	/**
	  * 글 수정 처리 
	  * @param board
	  * @return
	  */
	//글 수정
	@PostMapping("/boardUpdate")
	public String boardUpdate(Board board) {
		boardservice.boardUpdate(board);
		return "redirect:/boardList";
	}
	
	
}
