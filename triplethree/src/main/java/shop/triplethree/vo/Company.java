package shop.triplethree.vo;

import java.sql.Date;

public class Company {
	private String Code;
	private String coName;
	private String coCeoname;
	private String coAddr;
	private String coBin;
	private String coFax;
	private String coPhone;
	private String coEmail;
	private String coLogo;
	private String writer;
	private Date writerDay;
	@Override
	public String toString() {
		return "Company [Code=" + Code + ", coName=" + coName + ", coCeoname=" + coCeoname + ", coAddr=" + coAddr
				+ ", coBin=" + coBin + ", coFax=" + coFax + ", coPhone=" + coPhone + ", coEmail=" + coEmail
				+ ", coLogo=" + coLogo + ", writer=" + writer + ", writerDay=" + writerDay + "]";
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
	public Date getWriterDay() {
		return writerDay;
	}
	public void setWriterDay(Date writerDay) {
		this.writerDay = writerDay;
	}
	
	
	
}
