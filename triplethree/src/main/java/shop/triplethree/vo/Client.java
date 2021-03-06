package shop.triplethree.vo;

import java.time.LocalDateTime;

public class Client {
	private String code;
	private String liCode;//거래처종류 code 담기
	private String liCodeStr; //거래처종류 text
	private String liCode2;//거래상태
	private String liCode2Str;//거래상태종류 text
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
	private String empCode;	//작성자
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
	public String getLiCodeStr() {
		return liCodeStr;
	}
	public void setLiCodeStr(String liCodeStr) {
		this.liCodeStr = liCodeStr;
	}
	public String getLiCode2() {
		return liCode2;
	}
	public void setLiCode2(String liCode2) {
		this.liCode2 = liCode2;
	}
	public String getLiCode2Str() {
		return liCode2Str;
	}
	public void setLiCode2Str(String liCode2Str) {
		this.liCode2Str = liCode2Str;
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
	public String getAccPostcode() {
		return accPostcode;
	}
	public void setAccPostcode(String accPostcode) {
		this.accPostcode = accPostcode;
	}
	public String getAccAddr() {
		return accAddr;
	}
	public void setAccAddr(String accAddr) {
		this.accAddr = accAddr;
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
	
	
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
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
	
	
	
	
}