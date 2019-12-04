package shop.triplethree.vo;

import java.time.LocalDateTime;

public class Employee {
	private String code; //사원관리코드
	private String demgCode; //부서코드
	private String demgName; //부서명
	private String poCode; //직급관리코드
	private String poName; //직급관리코드
	private String liCode; //목록관리코드로 재직상태 가지고오기 
	private String liName; //목록명 담는 변수
	private String empNum; //사원번호
	private String password; //패스워드
	private String empName; //사원명
	private String addr; //주소
	private String phone; //연락처
	private String email;
	private char carPresence;
	private String joinDate;
	private String birthDate;
	private String photo;
	private String retireDate;
	private String signature;
	private String conType;
	private String basicPay;
	private String writer;
	private String writerDay; // 부를때 포맷형식 바꿔야함
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDemgCode() {
		return demgCode;
	}
	public void setDemgCode(String demgCode) {
		this.demgCode = demgCode;
	}
	public String getDemgName() {
		return demgName;
	}
	public void setDemgName(String demgName) {
		this.demgName = demgName;
	}
	public String getPoCode() {
		return poCode;
	}
	public void setPoCode(String poCode) {
		this.poCode = poCode;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public String getLiCode() {
		return liCode;
	}
	public void setLiCode(String liCode) {
		this.liCode = liCode;
	}
	public String getLiName() {
		return liName;
	}
	public void setLiName(String liName) {
		this.liName = liName;
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getCarPresence() {
		return carPresence;
	}
	public void setCarPresence(char carPresence) {
		this.carPresence = carPresence;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRetireDate() {
		return retireDate;
	}
	public void setRetireDate(String retireDate) {
		this.retireDate = retireDate;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getConType() {
		return conType;
	}
	public void setConType(String conType) {
		this.conType = conType;
	}
	public String getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(String basicPay) {
		this.basicPay = basicPay;
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
		return "Employee [code=" + code + ", demgCode=" + demgCode + ", demgName=" + demgName + ", poCode=" + poCode
				+ ", poName=" + poName + ", liCode=" + liCode + ", liName=" + liName + ", empNum=" + empNum
				+ ", password=" + password + ", empName=" + empName + ", addr=" + addr + ", phone=" + phone + ", email="
				+ email + ", carPresence=" + carPresence + ", joinDate=" + joinDate + ", birthDate=" + birthDate
				+ ", photo=" + photo + ", retireDate=" + retireDate + ", signature=" + signature + ", conType="
				+ conType + ", basicPay=" + basicPay + ", writer=" + writer + ", writerDay=" + writerDay + "]";
	}
	
	
	
	
	
	
}
