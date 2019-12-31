package shop.triplethree.vo;

import java.time.LocalDateTime;

public class Company {

	private String sid;
	private String departmentNameBe;
	private String departmentNameAf;
	private int departmentLevel;
	private String departmentUpcode;
	private String departmentSau;
	private String departmentWriter;
	private String departmentWriterDay;
	private String departmentApprover;
	private String departmentApperverSt;
	private String departmentApproDay;
	private String departmentCode;
	private String departmentYesNO;
	private String empName;
	private String deName;
	private String Code; //회사코드
	private String coName; //회사명
	private String coCeoname; //대표자명
	private String coPostCode; //우편번호
	private String coDetailAddr; //상세주소
	private String coExtraAddr; //참고주소
	private String coAddr; //회사주소
	private String coBin; //사업자등록번호
	private String coFax; //팩스번호
	private String coPhone; //회사대표번호
	private String coEmail; //회사이메일
	private String coLogo; //회사로고
	private String writer; //작성자
	private LocalDateTime writerDay; //작성일자
	private String yesOrNo; //사용유무
	private String coReason; //변경사유
	
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
	public String getDepartmentNameBe() {
		return departmentNameBe;
	}
	public void setDepartmentNameBe(String departmentNameBe) {
		this.departmentNameBe = departmentNameBe;
	}
	public String getDepartmentNameAf() {
		return departmentNameAf;
	}
	public void setDepartmentNameAf(String departmentNameAf) {
		this.departmentNameAf = departmentNameAf;
	}
	public int getDepartmentLevel() {
		return departmentLevel;
	}
	public void setDepartmentLevel(int departmentLevel) {
		this.departmentLevel = departmentLevel;
	}
	public String getDepartmentUpcode() {
		return departmentUpcode;
	}
	public void setDepartmentUpcode(String departmentUpcode) {
		this.departmentUpcode = departmentUpcode;
	}
	public String getDepartmentSau() {
		return departmentSau;
	}
	public void setDepartmentSau(String departmentSau) {
		this.departmentSau = departmentSau;
	}
	public String getDepartmentWriter() {
		return departmentWriter;
	}
	public void setDepartmentWriter(String departmentWriter) {
		this.departmentWriter = departmentWriter;
	}
	public String getDepartmentWriterDay() {
		return departmentWriterDay;
	}
	public void setDepartmentWriterDay(String departmentWriterDay) {
		this.departmentWriterDay = departmentWriterDay;
	}
	public String getDepartmentApprover() {
		return departmentApprover;
	}
	public void setDepartmentApprover(String departmentApprover) {
		this.departmentApprover = departmentApprover;
	}
	public String getDepartmentApperverSt() {
		return departmentApperverSt;
	}
	public void setDepartmentApperverSt(String departmentApperverSt) {
		this.departmentApperverSt = departmentApperverSt;
	}
	public String getDepartmentApproDay() {
		return departmentApproDay;
	}
	public void setDepartmentApproDay(String departmentApproDay) {
		this.departmentApproDay = departmentApproDay;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getDepartmentYesNO() {
		return departmentYesNO;
	}
	public void setDepartmentYesNO(String departmentYesNO) {
		this.departmentYesNO = departmentYesNO;
	}
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getCoCeoname() {
		return coCeoname;
	}
	public void setCoCeoname(String coCeoname) {
		this.coCeoname = coCeoname;
	}
	public String getCoPostCode() {
		return coPostCode;
	}
	public void setCoPostCode(String coPostCode) {
		this.coPostCode = coPostCode;
	}
	public String getCoDetailAddr() {
		return coDetailAddr;
	}
	public void setCoDetailAddr(String coDetailAddr) {
		this.coDetailAddr = coDetailAddr;
	}
	public String getCoExtraAddr() {
		return coExtraAddr;
	}
	public void setCoExtraAddr(String coExtraAddr) {
		this.coExtraAddr = coExtraAddr;
	}
	public String getCoAddr() {
		return coAddr;
	}
	public void setCoAddr(String coAddr) {
		this.coAddr = coAddr;
	}
	public String getCoBin() {
		return coBin;
	}
	public void setCoBin(String coBin) {
		this.coBin = coBin;
	}
	public String getCoFax() {
		return coFax;
	}
	public void setCoFax(String coFax) {
		this.coFax = coFax;
	}
	public String getCoPhone() {
		return coPhone;
	}
	public void setCoPhone(String coPhone) {
		this.coPhone = coPhone;
	}
	public String getCoEmail() {
		return coEmail;
	}
	public void setCoEmail(String coEmail) {
		this.coEmail = coEmail;
	}
	public String getCoLogo() {
		return coLogo;
	}
	public void setCoLogo(String coLogo) {
		this.coLogo = coLogo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public LocalDateTime getWriterDay() {
		return writerDay;
	}
	public void setWriterDay(LocalDateTime writerDay) {
		this.writerDay = writerDay;
	}
	public String getYesOrNo() {
		return yesOrNo;
	}
	public void setYesOrNo(String yesOrNo) {
		this.yesOrNo = yesOrNo;
	}
	public String getCoReason() {
		return coReason;
	}
	public void setCoReason(String coReason) {
		this.coReason = coReason;
	}
	@Override
	public String toString() {
		return "Company [sid=" + sid + ", departmentNameBe=" + departmentNameBe + ", departmentNameAf="
				+ departmentNameAf + ", departmentLevel=" + departmentLevel + ", departmentUpcode=" + departmentUpcode
				+ ", departmentSau=" + departmentSau + ", departmentWriter=" + departmentWriter
				+ ", departmentWriterDay=" + departmentWriterDay + ", departmentApprover=" + departmentApprover
				+ ", departmentApperverSt=" + departmentApperverSt + ", departmentApproDay=" + departmentApproDay
				+ ", departmentCode=" + departmentCode + ", departmentYesNO=" + departmentYesNO + ", empName=" + empName
				+ ", deName=" + deName + ", Code=" + Code + ", coName=" + coName + ", coCeoname=" + coCeoname
				+ ", coPostCode=" + coPostCode + ", coDetailAddr=" + coDetailAddr + ", coExtraAddr=" + coExtraAddr
				+ ", coAddr=" + coAddr + ", coBin=" + coBin + ", coFax=" + coFax + ", coPhone=" + coPhone + ", coEmail="
				+ coEmail + ", coLogo=" + coLogo + ", writer=" + writer + ", writerDay=" + writerDay + ", yesOrNo="
				+ yesOrNo + ", coReason=" + coReason + "]";
	}
}
