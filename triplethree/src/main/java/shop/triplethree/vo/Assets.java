package shop.triplethree.vo;

public class Assets {

	private String sid; // 세션에서 사원id 가지고 와서 저장할 공간
	private String code; // Assets pk code
	private String faName; // Assets 시설명
	private String faLocal; // Assets 위치
	private String faSeat; // Assets 수용인원
	private String faDate; // Assets 이용기간
	private String faImage; // Assets 이미지
	private String faSt; // Assets 상태
	private String writer; // Assets 작성자
	private String writerDay; // Assets 작성일
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFaName() {
		return faName;
	}
	public void setFaName(String faName) {
		this.faName = faName;
	}
	public String getFaLocal() {
		return faLocal;
	}
	public void setFaLocal(String faLocal) {
		this.faLocal = faLocal;
	}
	public String getFaSeat() {
		return faSeat;
	}
	public void setFaSeat(String faSeat) {
		this.faSeat = faSeat;
	}
	public String getFaDate() {
		return faDate;
	}
	public void setFaDate(String faDate) {
		this.faDate = faDate;
	}
	public String getFaImage() {
		return faImage;
	}
	public void setFaImage(String faImage) {
		this.faImage = faImage;
	}
	public String getFaSt() {
		return faSt;
	}
	public void setFaSt(String faSt) {
		this.faSt = faSt;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriterDay() {
		return writerDay;
	}
	public void setWriterDay(String writerDay) {
		this.writerDay = writerDay;
	}
	@Override
	public String toString() {
		return "Assets [sid=" + sid + ", code=" + code + ", faName=" + faName + ", faLocal=" + faLocal + ", faSeat="
				+ faSeat + ", faDate=" + faDate + ", faImage=" + faImage + ", faSt=" + faSt + ", writer=" + writer
				+ ", writerDay=" + writerDay + "]";
	}
}
