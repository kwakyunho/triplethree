package shop.triplethree.vo;

public class Employee {
	private String code;
	private String demgCode; //부서코드랑 부서명 받아서 가지고노는 변수 
	private String poCode;
	private String liCode;
	private String empNum;
	private String password;
	private String empName;
	private String addr;
	private String phone;
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
	private String writerDay;
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
	public String getPoCode() {
		return poCode;
	}
	public void setPoCode(String poCode) {
		this.poCode = poCode;
	}
	public String getLiCode() {
		return liCode;
	}
	public void setLiCode(String liCode) {
		this.liCode = liCode;
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
		return "Employee [code=" + code + ", demgCode=" + demgCode + ", poCode=" + poCode + ", liCode=" + liCode
				+ ", empNum=" + empNum + ", password=" + password + ", empName=" + empName + ", addr=" + addr
				+ ", phone=" + phone + ", email=" + email + ", carPresence=" + carPresence + ", joinDate=" + joinDate
				+ ", birthDate=" + birthDate + ", photo=" + photo + ", retireDate=" + retireDate + ", signature="
				+ signature + ", conType=" + conType + ", basicPay=" + basicPay + ", writer=" + writer + ", writerDay="
				+ writerDay + "]";
	}
	
	
	
}
