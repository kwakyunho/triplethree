package shop.triplethree.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import shop.triplethree.service.BoardService;
import shop.triplethree.vo.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Value("${board.file.upload.path}")
	private String uploadPath;

	/**
	 * 게시글 상세보기
	 * 
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
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/admin/board/boardInsert")
	public String insertBoard(HttpSession session, Model model) {
		model.addAttribute("liCate", boardService.selectBCate());
		return "/board/boardInsert";
	}

	/**
	 * 부서게시판 글쓰기로 이동
	 * 
	 * @param session
	 * @return
	 */
	@GetMapping("/board/departBoardInsert")
	public String insertDepartBoard(HttpSession session, Model model) {
		model.addAttribute("liCate", boardService.selectDBCate());
		return "/board/departBoardInsert";
	}

	/**
	 * 게시물 insert 처리
	 * 
	 * @param board
	 * @param session
	 * @return
	 */
	@PostMapping("/admin/board/boardInsert")
	public String insertBoard(Board board, HttpSession session,@RequestParam("boardfile") MultipartFile file) {
		board = boardService.createBoardCode(session, board);
		 Path rootLocation = Paths.get(uploadPath);
		 String boardFilePath = null;
		
		 try {			
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				InputStream inputStream = file.getInputStream();
				System.out.println(inputStream + "<--inputStream");
				
				if(inputStream !=null && originFileName != null && !"".equals(originFileName.trim())) {
					//테이블에 파일 경로
					Files.copy(inputStream, rootLocation.resolve(originFileName), StandardCopyOption.REPLACE_EXISTING);
					boardFilePath = "/boardfiles/" + originFileName;
				}
				
				System.out.println(boardFilePath + "<- 1");
				
				
			} catch (IOException e) {
				e.printStackTrace();
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				try {
					Files.delete(rootLocation.resolve(originFileName));
				} catch (IOException e1) {
					e1.printStackTrace();
				}					
				
			}
		 
		if(boardFilePath != null) board.setBoardFilePath(boardFilePath);
		boardService.insertBoard(board);
		System.out.println(board.toString() + "작성하기 폼에서 들어온 값들 ");
		return "redirect:/board/boardList";
	}

	/**
	 * 부서게시물 insert 처리
	 * 
	 * @param board
	 * @param session
	 * @return
	 */
	@PostMapping("/board/boardInsert")
	public String insertDepartBoard(Board board, HttpSession session,@RequestParam("boardfile") MultipartFile file) {
		board = boardService.createBoardCode(session, board);
		Path rootLocation = Paths.get(uploadPath);
		 String boardFilePath = null;
		
		 try {			
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				InputStream inputStream = file.getInputStream();
				System.out.println(inputStream + "<--inputStream");
				
				if(inputStream !=null && originFileName != null && !"".equals(originFileName.trim())) {
					//테이블에 파일 경로
					Files.copy(inputStream, rootLocation.resolve(originFileName), StandardCopyOption.REPLACE_EXISTING);
					boardFilePath = "/boardfiles/" + originFileName;
				}
				
				System.out.println(boardFilePath + "<- 1");
				
				
			} catch (IOException e) {
				e.printStackTrace();
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				try {
					Files.delete(rootLocation.resolve(originFileName));
				} catch (IOException e1) {
					e1.printStackTrace();
				}					
				
			}
		 
		if(boardFilePath != null) board.setBoardFilePath(boardFilePath);
		boardService.insertBoard(board);
		System.out.println(board.toString() + "작성하기 폼에서 들어온 값들 ");
		return "redirect:/board/departBoardList";
	}

	/**
	 * 전사게시판 목록 가져오기(GET) (전사게시판 전체 / 전사공지 / 전사소식)
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/board/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardService.selectBoardList());
		model.addAttribute("noticeList", boardService.selectNoticeList());
		model.addAttribute("newsList", boardService.selectNewsList());
		System.out.println("*****전사게시판(공지+소식) 목록 SELECT*****");
		return "/board/boardList";
	}

	/**
	 * 전사게시판 공지사항 목록 가져오기(GET)
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/board/noticeList")
	public String selectNoticeList(Model model) {
		model.addAttribute("noticeList", boardService.selectNoticeList());
		System.out.println("*****전사게시판 공지사항 SELECT*****");
		return "redirect:/board/boardList";
	}

	/**
	 * 전사게시판 공지사항 목록 가져오기(GET)
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/board/newsList")
	public String selectNewsList(Model model) {
		model.addAttribute("newsList", boardService.selectNewsList());
		System.out.println("*****전사게시판 전사소식 SELECT*****");
		return "redirect:/board/boardList";
	}

	/**
	 * 글 목록 가져오기(POST)
	 * 
	 * @param model
	 * @return
	 *//*
		 * @PostMapping("/board/boardList") public String poBoardList(Model model) {
		 * model.addAttribute("boardList", boardService.boardList()); return
		 * "/board/boardList"; }
		 */

	/**
	 * 부서게시판 이동
	 * 
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
	 * 
	 * @param code
	 * @param model
	 * @return
	 */
	@PostMapping("/admin/board/goBoardUpdate")
	public String goBoardUpdate(@RequestParam(value = "code") String code, Model model, HttpSession session) {
		System.out.println("*************************");
		System.out.println("boardUpdate 화면 보여주기");
		System.out.println("#########################");
		model.addAttribute("liCate", boardService.selectBCate());
		model.addAttribute("board", boardService.getBoardForUpdate(code, session)); // 하나 뽑아와서 board 에 담기
		return "/board/boardUpdate";
	}

	/**
	 * 선택된 글에 대한 수정할 데이터와 화면 보여주기(부서게시판의 글일경우)
	 * 
	 * @param code
	 * @param model
	 * @return
	 */
	@PostMapping("/board/goBoardUpdate")
	public String goDepartBoardUpdate(@RequestParam(value = "code") String code, Model model, HttpSession session) {
		System.out.println("*************************");
		System.out.println("departBoardUpdate 화면 보여주기");
		System.out.println("#########################");
		model.addAttribute("liCate", boardService.selectDBCate());
		model.addAttribute("board", boardService.getBoardForUpdate(code, session)); // 하나 뽑아와서 board 에 담기
		return "/board/departBoardUpdate";
	}

	/**
	 * 글 수정 처리
	 * @param board
	 * @return board
	 */
	@PostMapping("/admin/board/boardUpdate")
	public String boardUpdate(Board board,@RequestParam("boardfile") MultipartFile file) {
		System.out.println("*************************");
		System.out.println("******board Update 처리****");
		System.out.println("*************************");
		
		Path rootLocation = Paths.get(uploadPath);
		String boardFilePath = null;
		
		 try {			
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				InputStream inputStream = file.getInputStream();
				System.out.println(inputStream + "<--inputStream");
				
				if(inputStream !=null && originFileName != null && !"".equals(originFileName.trim())) {
					//테이블에 파일 경로
					Files.copy(inputStream, rootLocation.resolve(originFileName), StandardCopyOption.REPLACE_EXISTING);
					boardFilePath = "/boardfiles/" + originFileName;
				}
				
				System.out.println(boardFilePath + "<- 1");
				
				
			} catch (IOException e) {
				e.printStackTrace();
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				try {
					Files.delete(rootLocation.resolve(originFileName));
				} catch (IOException e1) {
					e1.printStackTrace();
				}					
				
			}
		 
		if(boardFilePath != null) board.setBoardFilePath(boardFilePath);
		boardService.updateBoard(board); // 수정 처리 완료
		return "redirect:/board/boardList";
	}

	/**
	 * 부서게시판 글 수정 처리
	 * 
	 * @param board
	 * @return board
	 */
	@PostMapping("/board/departBoardUpdate")
	public String updateDepartBoard(Board board,@RequestParam("boardfile") MultipartFile file) {
		System.out.println("*************************");
		System.out.println("***departBoard Update 처리**");
		System.out.println("*************************");
		Path rootLocation = Paths.get(uploadPath);
		String boardFilePath = null;
		
		 try {			
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				InputStream inputStream = file.getInputStream();
				System.out.println(inputStream + "<--inputStream");
				
				if(inputStream !=null && originFileName != null && !"".equals(originFileName.trim())) {
					//테이블에 파일 경로
					Files.copy(inputStream, rootLocation.resolve(originFileName), StandardCopyOption.REPLACE_EXISTING);
					boardFilePath = "/boardfiles/" + originFileName;
				}
				
				System.out.println(boardFilePath + "<- 1");
				
				
			} catch (IOException e) {
				e.printStackTrace();
				
				String originFileName = StringUtils.cleanPath(file.getOriginalFilename());
				try {
					Files.delete(rootLocation.resolve(originFileName));
				} catch (IOException e1) {
					e1.printStackTrace();
				}					
				
			}
		 
		if(boardFilePath != null) board.setBoardFilePath(boardFilePath);
		boardService.updateDepartBoard(board); // 수정 처리 완료
		return "redirect:/board/departBoardList";
	}

	/**
	 * 글 삭제 처리
	 * 
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
	
	/**
	 * 첨부파일 다운로드
	 * 
	 * @param board의 pk코드를 받아와서 경로 가져온다
	 * */
	@GetMapping("/board/fileDownlad")
	public String downloadFiles(@RequestParam(value = "code") String code) {
		return "";
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/displayFile") public ResponseEntity<byte[]>
	 * displayFile(String fileName) throws Exception {
	 * 
	 * InputStream in = null; ResponseEntity<byte[]> entity = null;
	 * 
	 * logger.info("FILE NAME : " + fileName);
	 * 
	 * try { String formatName = fileName.substring(fileName.lastIndexOf("." ) + 1);
	 * MediaType mType = MediaUtils.getMediaType(formatName);
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * 
	 * in = new FileInputStream(uploadPath + fileName);
	 * 
	 * if (mType != null) { headers.setContentType(mType); } else { fileName =
	 * fileName.substring(fileName.indexOf("_") + 1);
	 * headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	 * headers.add("Content-Disposition", "attatchment; filename=\"" + new
	 * String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\""); }
	 * 
	 * entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers,
	 * HttpStatus.CREATED); } catch(Exception e) { e.printStackTrace(); entity = new
	 * ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST); } finally { in.close(); }
	 * 
	 * return entity; }
	 */

}
