package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Board;

@Mapper
public interface BoardMapper {
	//게시글 작성하기
	public int insertBoard(Board board);
	
	//전사게시판 게시글 목록으로 가져오기
	public List<Board> boardList();
	
	//전사게시판 공지사항 목록으로 가져오기
	public List<Board> boardList1();
	
	//전사게시판 공지사항 목록으로 가져오기
	public List<Board> boardList2();
	
	//부서게시판 전체가져오기
	public List<Board> departBoardList();
	
	//전사게시판 카테고리 가져오기
	public List<Board> selectBCate();
	
	//부서게시판 카테고리 가져오기
	public List<Board> selectDBCate();
	
	
	
	//게시글 정보 하나만 가져오기 (for detail)
	public Board getBoardByCode(String code);
	
	//게시글 수정위한 내용
	public Board getBoardForUpdate(String code);	
	
	//전게시글 수정하기
	public int updateBoard(Board board);
	
	//부게시글 수정하기
	public int updateDepartBoard(Board board);
	
	//게시글 삭제하기
	public int deleteBoard(String code);
	
	//게시글 조회수 증가하기
	public int updateCnt(String code);
	
}
