package shop.triplethree.vo;

public class Assets {

	private String sid; // 세션에서 사원id 가지고 와서 저장할 공간
	private String code; // Assets pk code + Car pk code
	private String faName; // Assets 시설명
	private String faLocal; // Assets 위치
	private String faSeat; // Assets 수용인원
	private String faDate; // Assets 이용기간
	private String faImage; // Assets 이미지
	private String faSt; // Assets 상태 + Car 상태
	private String writer; // Assets + Car 작성자
	private String writerDay; // Assets + Car 작성일
	private String veMake; // Car 제조사
	private String veName; // Car 이름
	private String veNunber; // Car 차량번호
	private String veCc; // Car 배기량
	private String veUse; // Car 사용 용도
	private String veBuy; // Car 구입연도
	private String veModelYear; // Car 차량연식
	private String empName;
	private String deName;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeName() {
		return deName;
	}
	public void setDeName(String deName) {
		this.deName = deName;
	}
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
	public String getVeMake() {
		return veMake;
	}
	public void setVeMake(String veMake) {
		this.veMake = veMake;
	}
	public String getVeName() {
		return veName;
	}
	public void setVeName(String veName) {
		this.veName = veName;
	}
	public String getVeNunber() {
		return veNunber;
	}
	public void setVeNunber(String veNunber) {
		this.veNunber = veNunber;
	}
	public String getVeCc() {
		return veCc;
	}
	public void setVeCc(String veCc) {
		this.veCc = veCc;
	}
	public String getVeUse() {
		return veUse;
	}
	public void setVeUse(String veUse) {
		this.veUse = veUse;
	}
	public String getVeBuy() {
		return veBuy;
	}
	public void setVeBuy(String veBuy) {
		this.veBuy = veBuy;
	}
	public String getVeModelYear() {
		return veModelYear;
	}
	public void setVeModelYear(String veModelYear) {
		this.veModelYear = veModelYear;
	}
	@Override
	public String toString() {
		return "Assets [sid=" + sid + ", code=" + code + ", faName=" + faName + ", faLocal=" + faLocal + ", faSeat="
				+ faSeat + ", faDate=" + faDate + ", faImage=" + faImage + ", faSt=" + faSt + ", writer=" + writer
				+ ", writerDay=" + writerDay + ", veMake=" + veMake + ", veName=" + veName + ", veNunber=" + veNunber
				+ ", veCc=" + veCc + ", veUse=" + veUse + ", veBuy=" + veBuy + ", veModelYear=" + veModelYear
				+ ", empName=" + empName + ", deName=" + deName + "]";
	}
}
