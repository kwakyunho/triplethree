package shop.triplethree.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.triplethree.vo.Board;

@Mapper
public interface BoardMapper {
	//게시글 작성하기
	public int boardInsert(Board board);
	
	//게시글정보 목록으로 가져오기
	public List<Board> boardList();
	
	//게시글 정보 하나만 가져오기 (for update&delete)
	public Board getBoardByCode(String code);
	
	//게시글 수정하기
	public Board boardUpdate(Board board);
}
