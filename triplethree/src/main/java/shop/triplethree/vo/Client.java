package shop.triplethree.vo;

public class Client {
	private String code;
	private String liCode;
	private String liCode2;
	private String accCode;
	private String accCeoName;
	private String accAddr;
	private String accBln;
	private String accFax;
	private String repreNumber;
	private String accPhone;
	private String accEmail;
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
	public String getAccCode() {
		return accCode;
	}
	public void setAccCode(String accCode) {
		this.accCode = accCode;
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
	@Override
	public String toString() {
		return "Client [code=" + code + ", liCode=" + liCode + ", liCode2=" + liCode2 + ", accCode=" + accCode
				+ ", accCeoName=" + accCeoName + ", accAddr=" + accAddr + ", accBln=" + accBln + ", accFax=" + accFax
				+ ", repreNumber=" + repreNumber + ", accPhone=" + accPhone + ", accEmail=" + accEmail + "]";
	}
	
}
