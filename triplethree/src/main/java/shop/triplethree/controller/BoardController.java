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
	
	/**게시글 상세보기
	 * @param code
	 * */
	@GetMapping("/boardDetail")
	public String selectDetail(@RequestParam(value="code")String code,Model model) {
		//code로 선택된 글의 정보를 board 에 담아서 보내기
		model.addAttribute("board", boardservice.getBoardByCode(code));
		return "/board/boarDetail.html";
	}
	/**
	  * 게시글 작성폼
	  * @param session
	  * @return
	  */
	@GetMapping("/boardInsert")
	public String insertBoard(HttpSession session) {
		
		return "/board/boardInsert";
	}

	/**
	  * 게시물 insert 처리
	  * @param board
	  * @param session
	  * @return
	  */
	@PostMapping("/boardInsert")
	public String insertBoard(Board board,HttpSession session){
		board = boardService.createBoardCode(session,board);
		boardService.insertBoard(board);
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
		System.out.println("*************************");
		System.out.println("boardUpdate 화면 보여주기");
		System.out.println("#########################");
		model.addAttribute("board", boardservice.getBoardByCode(code));
		return "/board/boardUpdate";
	}
	
	/**
	  * 글 수정 처리 
	  * @param board
	  * @return
	  */
	@PostMapping("/boardUpdate")
	public String boardUpdate(Board board) {
		System.out.println("*************************");
		System.out.println("******boardUpdate 처리****");
		System.out.println("*************************");
		boardservice.updateBoard(board);
		return "redirect:/boardList";
	}
	
	
}
