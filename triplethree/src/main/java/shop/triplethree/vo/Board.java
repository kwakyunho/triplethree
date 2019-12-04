package shop.triplethree.vo;

public class Board {
	private String code;
	private String empCode;
	private String boardTitle;
	private String boardCon;
	private String boardCount;
	private String writerDay;
	
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
