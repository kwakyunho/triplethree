package shop.triplethree.vo;

import java.time.LocalDateTime;


public class Company {
	private String Code;
	private String coName;
	private String coCeoname;
	private String coPostCode;
	private String coDetailAddr;
	private String coExtraAddr;
	private String coAddr;
	private String coBin;
	private String coFax;
	private String coPhone;
	private String coEmail;
	private String coLogo;
	private String writer;
	private LocalDateTime writerDay;
	private String yesOrNo;
	private String coReason;
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
		return "Company [Code=" + Code + ", coName=" + coName + ", coCeoname=" + coCeoname + ", coPostCode="
				+ coPostCode + ", coDetailAddr=" + coDetailAddr + ", coExtraAddr=" + coExtraAddr + ", coAddr=" + coAddr
				+ ", coBin=" + coBin + ", coFax=" + coFax + ", coPhone=" + coPhone + ", coEmail=" + coEmail
				+ ", coLogo=" + coLogo + ", writer=" + writer + ", writerDay=" + writerDay + ", yesOrNo=" + yesOrNo
				+ ", coReason=" + coReason + "]";
	}
	
	
	
}
