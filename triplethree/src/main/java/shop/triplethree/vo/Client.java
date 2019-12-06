package shop.triplethree.vo;

import java.time.LocalDateTime;

public class Client {
	private String code;
	private String liCode;
	private String liCode2;
	private String accName;
	private String accCeoName;
	private String accPostcode; //우편번호
	private String accAddr; //도로명주소
	private String accDetailAddr; //상세주소
	private String accExtraAddr; // 참고주소
	private String accBln;
	private String accFax;
	private String repreNumber;
	private String accPhone;
	private String accEmail;
	private String writer;
	
	
	public String getAccPostcode() {
		return accPostcode;
	}
	public void setAccPostcode(String accPostcode) {
		this.accPostcode = accPostcode;
	}
	public String getAccDetailAddr() {
		return accDetailAddr;
	}
	public void setAccDetailAddr(String accDetailAddr) {
		this.accDetailAddr = accDetailAddr;
	}
	public String getAccExtraAddr() {
		return accExtraAddr;
	}
	public void setAccExtraAddr(String accExtraAddr) {
		this.accExtraAddr = accExtraAddr;
	}
	private LocalDateTime writerDay;
	private String approver;
	private String approDay;
	private String approverSt;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLiCode() {
		return liCode;
	}
	public void setLiCode(String liCode) {
		this.liCode = liCode;
	}
	public String getLiCode2() {
		return liCode2;
	}
	public void setLiCode2(String liCode2) {
		this.liCode2 = liCode2;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getAccCeoName() {
		return accCeoName;
	}
	public void setAccCeoName(String accCeoName) {
		this.accCeoName = accCeoName;
	}
	public String getAccAddr() {
		return accAddr;
	}
	public void setAccAddr(String accAddr) {
		this.accAddr = accAddr;
	}
	public String getAccBln() {
		return accBln;
	}
	public void setAccBln(String accBln) {
		this.accBln = accBln;
	}
	public String getAccFax() {
		return accFax;
	}
	public void setAccFax(String accFax) {
		this.accFax = accFax;
	}
	public String getRepreNumber() {
		return repreNumber;
	}
	public void setRepreNumber(String repreNumber) {
		this.repreNumber = repreNumber;
	}
	public String getAccPhone() {
		return accPhone;
	}
	public void setAccPhone(String accPhone) {
		this.accPhone = accPhone;
	}
	public String getAccEmail() {
		return accEmail;
	}
	public void setAccEmail(String accEmail) {
		this.accEmail = accEmail;
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
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getApproDay() {
		return approDay;
	}
	public void setApproDay(String approDay) {
		this.approDay = approDay;
	}
	public String getApproverSt() {
		return approverSt;
	}
	public void setApproverSt(String approverSt) {
		this.approverSt = approverSt;
	}
	@Override
	public String toString() {
		return "Client [code=" + code + ", liCode=" + liCode + ", liCode2=" + liCode2 + ", accName=" + accName
				+ ", accCeoName=" + accCeoName + ", accAddr=" + accAddr + ", accBln=" + accBln + ", accFax=" + accFax
				+ ", repreNumber=" + repreNumber + ", accPhone=" + accPhone + ", accEmail=" + accEmail + ", writer="
				+ writer + ", writerDay=" + writerDay + ", approver=" + approver + ", approDay=" + approDay
				+ ", approverSt=" + approverSt + "]";
	}
	
	
	
	
}