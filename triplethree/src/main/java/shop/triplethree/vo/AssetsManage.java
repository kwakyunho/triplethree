package shop.triplethree.vo;

public class AssetsManage {

	private String code; // 예약관리코드
	private String division; // 시설,차량구분
	private String empCode; //사원관리코드(예약자)
	private String coName; // 시설,차량 관리코드
	private String reReq; // 신청일자(작성일)
	private String reStart; // 사용시작일
	private String reEnd; // 반납예정일(사용종료일)
	private String reCom; // 반납완료일
	private String reComCheck; // 반납유무
	private String reCheckName; // 반납 확인자
	private String veCode; // 차량관리코드
	private String veName; // 차량명
	private String veNumber; // 차량번호
	private String beCode; // 시설관리코드
	private String beName; // 시설명
	private String beLocal; // 시설위치
	private String beSeat; // 수용인원
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getReReq() {
		return reReq;
	}
	public void setReReq(String reReq) {
		this.reReq = reReq;
	}
	public String getReStart() {
		return reStart;
	}
	public void setReStart(String reStart) {
		this.reStart = reStart;
	}
	public String getReEnd() {
		return reEnd;
	}
	public void setReEnd(String reEnd) {
		this.reEnd = reEnd;
	}
	public String getReCom() {
		return reCom;
	}
	public void setReCom(String reCom) {
		this.reCom = reCom;
	}
	public String getReComCheck() {
		return reComCheck;
	}
	public void setReComCheck(String reComCheck) {
		this.reComCheck = reComCheck;
	}
	public String getReCheckName() {
		return reCheckName;
	}
	public void setReCheckName(String reCheckName) {
		this.reCheckName = reCheckName;
	}
	public String getVeCode() {
		return veCode;
	}
	public void setVeCode(String veCode) {
		this.veCode = veCode;
	}
	public String getVeName() {
		return veName;
	}
	public void setVeName(String veName) {
		this.veName = veName;
	}
	public String getVeNumber() {
		return veNumber;
	}
	public void setVeNumber(String veNumber) {
		this.veNumber = veNumber;
	}
	public String getBeCode() {
		return beCode;
	}
	public void setBeCode(String beCode) {
		this.beCode = beCode;
	}
	public String getBeName() {
		return beName;
	}
	public void setBeName(String beName) {
		this.beName = beName;
	}
	public String getBeLocal() {
		return beLocal;
	}
	public void setBeLocal(String beLocal) {
		this.beLocal = beLocal;
	}
	public String getBeSeat() {
		return beSeat;
	}
	public void setBeSeat(String beSeat) {
		this.beSeat = beSeat;
	}
	
	@Override
	public String toString() {
		return "AssetsManage [code=" + code + ", division=" + division + ", empCode=" + empCode + ", coName=" + coName
				+ ", reReq=" + reReq + ", reStart=" + reStart + ", reEnd=" + reEnd + ", reCom=" + reCom
				+ ", reComCheck=" + reComCheck + ", reCheckName=" + reCheckName + ", veCode=" + veCode + ", veName="
				+ veName + ", veNumber=" + veNumber + ", beCode=" + beCode + ", beName=" + beName + ", beLocal="
				+ beLocal + ", beSeat=" + beSeat + "]";
	}
}
