package shop.triplethree.controller;

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
	
	@Autowired
	private BoardService boardservice;
	//공지사항  작성하기
	@GetMapping("/boardInsert")
	public String boardInsert() {
		
		return "/board/boardInsert";
	}
	//글목록 가져오기
	@GetMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardservice.boardList());
		return "/board/boardList";
	}
	
	//글 수정하기 창으로 정보가지고 이동
	@GetMapping("/boardUpdate")
	public String boardUpdate(@RequestParam(value="code")String code,Model model) {
		System.out.println(code + "수정할 게시글 code");
		model.addAttribute("board", boardservice.getBoardByCode(code));
		return "/board/boardUpdate";
	}
	
	//글 수정
	@PostMapping("/boardUpdate")
	public String boardUpdate(Board board) {
		boardservice.boardUpdate(board);
		return "redirect:/boardList";
	}
	
	
}
