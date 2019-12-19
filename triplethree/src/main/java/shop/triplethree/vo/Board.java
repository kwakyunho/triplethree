package shop.triplethree.vo;

public class Board {
	private String code;
	private String empCode; //사원코드
	private String poname; //직급명
	private String writer;
	private String boardTitle;
	private String boardCon;
	private String boardCount;
	private String writerDay;
	private String boardPw;
	private String liCode; //카테고리코드
	private String liCodeStr; //코드이름

	
	public String getLiCode() {
		return liCode;
	}
	public void setLiCode(String liCode) {
		this.liCode = liCode;
	}
	public String getLiCodeStr() {
		return liCodeStr;
	}
	public void setLiCodeStr(String liCodeStr) {
		this.liCodeStr = liCodeStr;
	}
	public String getPoname() {
		return poname;
	}
	public void setPoname(String poname) {
		this.poname = poname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getBoardPw() {
		return boardPw;
	}
	public void setBoardPw(String boardPw) {
		this.boardPw = boardPw;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardCon() {
		return boardCon;
	}
	public void setBoardCon(String boardCon) {
		this.boardCon = boardCon;
	}
	public String getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(String boardCount) {
		this.boardCount = boardCount;
	}
	public String getWriterDay() {
		return writerDay;
	}
	public void setWriterDay(String writerDay) {
		this.writerDay = writerDay;
	}
	@Override
	public String toString() {
		return "Board [code=" + code + ", boardTitle=" + boardTitle + ", boardCon=" + boardCon + ", boardCount="
				+ boardCount + ", writerDay=" + writerDay + "]";
	}
	
	
}
