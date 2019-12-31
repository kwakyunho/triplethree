package shop.triplethree.vo;

public class SignDocument {

	private String code; // 작성된 결재문서 관리코드
	private String empCode; // 사원코드
	private String docFormCode; // 문서양식 관리코드
	private String docTitle; // 문서명
	private String docName; // 문서제목
	private String docCon; // 사유(내용)
	private String docBego; // 비고
	private String writerDay; // 작성일자
	private String signEndDay; // 결재 완료일
	private String startDate; // 시작기간(휴가일정)
	private String endDate; // 종료기간(휴가일정)
	private String empName; // 사원이름
	private String poName; // 직급명
	private String deName; // 부서명
	private String signState; // 전자결재상태
	private String signCheck; // 접수완료체크
	private String valCheck; // 상단 메뉴 벨류값 저장
	private String accCode; // 결재라인누적관리코드
	private String docFormCdoe; // 문서양식관리코드
	private String reDocDate; // 반려일
	private String comments; // 코멘트
	private String number; // 결재 순서
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAccCode() {
		return accCode;
	}
	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}
	public String getDocFormCdoe() {
		return docFormCdoe;
	}
	public void setDocFormCdoe(String docFormCdoe) {
		this.docFormCdoe = docFormCdoe;
	}
	public String getReDocDate() {
		return reDocDate;
	}
	public void setReDocDate(String reDocDate) {
		this.reDocDate = reDocDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getValCheck() {
		return valCheck;
	}
	public void setValCheck(String valCheck) {
		this.valCheck = valCheck;
	}
	public String getSignState() {
		return signState;
	}
	public void setSignState(String signState) {
		this.signState = signState;
	}
	public String getSignCheck() {
		return signCheck;
	}
	public void setSignCheck(String signCheck) {
		this.signCheck = signCheck;
	}
	public String getSignEndDay() {
		return signEndDay;
	}
	public void setSignEndDay(String signEndDay) {
		this.signEndDay = signEndDay;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getDocFormCode() {
		return docFormCode;
	}
	public void setDocFormCode(String docFormCode) {
		this.docFormCode = docFormCode;
	}
	public String getDocTitle() {
		return docTitle;
	}
	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocCon() {
		return docCon;
	}
	public void setDocCon(String docCon) {
		this.docCon = docCon;
	}
	public String getDocBego() {
		return docBego;
	}
	public void setDocBego(String docBego) {
		this.docBego = docBego;
	}
	public String getWriterDay() {
		return writerDay;
	}
	public void setWriterDay(String writerDay) {
		this.writerDay = writerDay;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public String getDeName() {
		return deName;
	}
	public void setDeName(String deName) {
		this.deName = deName;
	}
	@Override
	public String toString() {
		return "SignDocument [code=" + code + ", empCode=" + empCode + ", docFormCode=" + docFormCode + ", docTitle="
				+ docTitle + ", docName=" + docName + ", docCon=" + docCon + ", docBego=" + docBego + ", writerDay="
				+ writerDay + ", signEndDay=" + signEndDay + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", empName=" + empName + ", poName=" + poName + ", deName=" + deName + ", signState=" + signState
				+ ", signCheck=" + signCheck + ", valCheck=" + valCheck + ", accCode=" + accCode + ", docFormCdoe="
				+ docFormCdoe + ", reDocDate=" + reDocDate + ", comments=" + comments + ", number=" + number + "]";
	}
}
