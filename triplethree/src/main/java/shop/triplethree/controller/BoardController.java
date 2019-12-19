package shop.triplethree.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.triplethree.service.BoardService;
import shop.triplethree.service.ClientService;
import shop.triplethree.vo.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	/**
	 * 게시글 상세보기
	 * @param code
	 */
	@PostMapping("/board/boardDetail")
	public String goToDetail(@RequestParam(value = "code", required = false) String code, Model model) {
		// code로 선택된 글의 정보를 board 에 담아서 보내기
		System.out.println("controller - code : " + code);
		model.addAttribute("board", boardService.getBoardByCode(code));
		return "/board/boardDetail";
	}

	/**
	 * 전사게시판 글쓰기로 이동
	 * @param session
	 * @return
	 */
	@GetMapping("/admin/board/boardInsert")
	public String insertBoard(HttpSession session,Model model) {
		model.addAttribute("liCode", boardService.selectBCate());
		return "/board/boardInsert";
	}
	
	/**
	 * 부서게시판 글쓰기로 이동
	 * @param session
	 * @return
	 */
	@GetMapping("/board/departBoardInsert")
	public String insertDepartBoard(HttpSession session,Model model) {
		model.addAttribute("liCode", boardService.selectDBCate());
		return "/board/departBoardInsert";
	}

	/**
	 * 게시물 insert 처리
	 * @param board
	 * @param session
	 * @return
	 */
	@PostMapping("/admin/board/boardInsert")
	public String insertBoard(Board board, HttpSession session) {
		board = boardService.createBoardCode(session, board);
		boardService.insertBoard(board);
		System.out.println(board.toString() + "작성하기 폼에서 들어온 값들 ");
		return "redirect:/board/boardList";
	}
	
	/**
	 * 부서게시물 insert 처리
	 * @param board
	 * @param session
	 * @return
	 */
	@PostMapping("/board/boardInsert")
	public String insertDepartBoard(Board board, HttpSession session) {
		board = boardService.createBoardCode(session, board);
		boardService.insertBoard(board);
		System.out.println(board.toString() + "작성하기 폼에서 들어온 값들 ");
		return "redirect:/board/departBoardList";
	}

	/**
	 * 전사게시판 전체목록 가져오기(GET)
	 * @param model
	 * @return
	 */
	@GetMapping("/board/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardService.boardList());
		System.out.println("*****전사게시판 전체목록 SELECT*****");
		return "/board/boardList";
	}
	
	/**
	 * 전사게시판 공지사항 목록 가져오기(GET)
	 * @param model
	 * @return
	 */
	@GetMapping("/board/boardList1")
	public String boardList1(Model model) {
		model.addAttribute("boardList1", boardService.boardList1());
		System.out.println("*****전사게시판 공지사항 SELECT*****");
		return "/board/boardList";
	}
	
	/**
	 * 전사게시판 공지사항 목록 가져오기(GET)
	 * @param model
	 * @return
	 */
	@GetMapping("/board/boardList2")
	public String boardList2(Model model) {
		model.addAttribute("boardList2", boardService.boardList2());
		System.out.println("*****전사게시판 전사소식 SELECT*****");
		return "/board/boardList2";
	}

	/**
	 * 글 목록 가져오기(POST)
	 * @param model
	 * @return
	 */
	@PostMapping("/board/boardList")
	public String poBoardList(Model model) {
		  model.addAttribute("boardList", boardService.boardList());
		  return "/board/boardList";
	}
		 
	/**
	 * 부서게시판 이동
	 * @param model
	 * @return
	 */
	@GetMapping("/board/departBoardList")
	public String departBoardList(Model model) {
		model.addAttribute("departBoardList", boardService.departBoardList());
		return "/board/departBoardList";
	}

	/**
	 * 선택된 글에 대한 수정할 데이터와 화면 보여주기
	 * @param code
	 * @param model
	 * @return
	 */
	@PostMapping("/admin/board/goBoardUpdate")
	public String goBoardUpdate(@RequestParam(value = "code") String code, Model model, HttpSession session) {
		System.out.println("*************************");
		System.out.println("boardUpdate 화면 보여주기");
		System.out.println("#########################");
		model.addAttribute("board", boardService.getBoardForUpdate(code, session)); // 하나 뽑아와서 board 에 담기
		return "/board/boardUpdate";
	}

	/**
	 * 글 수정 처리
	 * @param board
	 * @return board
	 */
	@PostMapping("/admin/board/boardUpdate")
	public String boardUpdate(Board board) {
		System.out.println("*************************");
		System.out.println("******board Update 처리****");
		System.out.println("*************************");
		boardService.updateBoard(board); // 수정 처리 완료
		return "redirect:/board/boardList";
	}
	
	/**
	 * 부서게시판 글 수정 처리
	 * @param board
	 * @return board
	 */
	@PostMapping("/board/departBoardUpdate")
	public String updateDepartBoard(Board board) {
		System.out.println("*************************");
		System.out.println("***departBoard Update 처리**");
		System.out.println("*************************");
		boardService.updateDepartBoard(board); // 수정 처리 완료
		return "redirect:/board/departBoardUpdate";
	}
	
	/**
	 * 글 삭제 처리
	 * @param board board에 글의 code 를 담아서 삭제함
	 */
	@PostMapping("/admin/board/boardDelete")
	public String deleteBoard(@RequestParam(value = "code") String code) {
		System.out.println("***********************");
		System.out.println("******delete Board처리***");
		System.out.println("***********************");
		System.out.println(code + "삭제할 code가 넘어왔니???");
		boardService.deleteBoard(code);

		return "redirect:/board/boardList";
	}

}
