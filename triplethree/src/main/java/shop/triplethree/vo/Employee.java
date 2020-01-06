package shop.triplethree.vo;

public class Employee {
	//사원관리와 인사이동목록을 이용하기위한 vo 
	//()는 사욜할 테이블 변수값을 쓰기위함 
	private String code; //사원관리코드
	private String moveCode; //인사이동목록코드
	private String payCode;	//급여관리코드
	private String demgCode; //부서코드(사원관리) ,변경전부서코드 (인사이동목록) 
	private String demgName; //부서명 , 
	private String afterDemgCode;	//변경 후 부서코드 (인사이동목록)
	private String afterDemgName;	//변경 후 부서명 (인사이동목록)
	private String poCode; //직급관리코드 (사원관리), 변경전직급코드 (인사이동목록)
	private String poName; //직급관리코드
	private String afterPoCode; //변경 후 직급코드 (인사이동목록)
	private String afterPoName; //변경 후 직급명 (인사이동목록)
	private String liCode; //목록관리코드로 재직상태 가지고오기 
	private String liName; //목록명 담는 변수
	private String empNum; //사원번호
	private String password; //패스워드
	private String empName; //사원명
	private String addr; //주소
	private String detailAddr; //상세주소
	private String extraAddr; //참고 주소
	private String postCode;
	private String phone; //연락처
	private String email;
	private char carPresence;
	private String joinDate;
	private String birthDate;
	private String photo;
	private String retireDate;//퇴사일
	private String signature;
	private String conType;
	private int basicPay;
	private String writer;	//작성자  (사원관리, 인사이동목록)
	private String writerName; //작성자 이름 (인사이동목록)
	private String writerDay; //작성일자 (사원관리, 인사이동목록)
	private String afterDate; //인사이동날짜 (인사이동목록 )
	private String approver; //승인자(인사이동목록)
	private String approverName; //승인자 이름 (인사이동목록)
	private String approveDay; //승인일자(인사이동목록)
	private int longevity; //근속기간
	
	public int getLongevity() {
		return longevity;
	}
	public void setLongevity(int longevity) {
		this.longevity = longevity;
	}
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
	public String getAfterDemgCode() {
		return afterDemgCode;
	}
	public void setAfterDemgCode(String afterDemgCode) {
		this.afterDemgCode = afterDemgCode;
	}
	public String getAfterDemgName() {
		return afterDemgName;
	}
	public void setAfterDemgName(String afterDemgName) {
		this.afterDemgName = afterDemgName;
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
	public String getAfterPoCode() {
		return afterPoCode;
	}
	public void setAfterPoCode(String afterPoCode) {
		this.afterPoCode = afterPoCode;
	}
	public String getAfterPoName() {
		return afterPoName;
	}
	public void setAfterPoName(String afterPoName) {
		this.afterPoName = afterPoName;
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
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public String getExtraAddr() {
		return extraAddr;
	}
	public void setExtraAddr(String extraAddr) {
		this.extraAddr = extraAddr;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	
	public int getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(int basicPay) {
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
	public String getAfterDate() {
		return afterDate;
	}
	public void setAfterDate(String afterDate) {
		this.afterDate = afterDate;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getApproveDay() {
		return approveDay;
	}
	public void setApproveDay(String approveDay) {
		this.approveDay = approveDay;
	}
	public String getMoveCode() {
		return moveCode;
	}
	public void setMoveCode(String moveCode) {
		this.moveCode = moveCode;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getApproverName() {
		return approverName;
	}
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	public String getPayCode() {
		return payCode;
	}
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	@Override
	public String toString() {
		return "Employee [code=" + code + ", moveCode=" + moveCode + ", payCode=" + payCode + ", demgCode=" + demgCode
				+ ", demgName=" + demgName + ", afterDemgCode=" + afterDemgCode + ", afterDemgName=" + afterDemgName
				+ ", poCode=" + poCode + ", poName=" + poName + ", afterPoCode=" + afterPoCode + ", afterPoName="
				+ afterPoName + ", liCode=" + liCode + ", liName=" + liName + ", empNum=" + empNum + ", password="
				+ password + ", empName=" + empName + ", addr=" + addr + ", detailAddr=" + detailAddr + ", extraAddr="
				+ extraAddr + ", postCode=" + postCode + ", phone=" + phone + ", email=" + email + ", carPresence="
				+ carPresence + ", joinDate=" + joinDate + ", birthDate=" + birthDate + ", photo=" + photo
				+ ", retireDate=" + retireDate + ", signature=" + signature + ", conType=" + conType + ", basicPay="
				+ basicPay + ", writer=" + writer + ", writerName=" + writerName + ", writerDay=" + writerDay
				+ ", afterDate=" + afterDate + ", approver=" + approver + ", approverName=" + approverName
				+ ", approveDay=" + approveDay + ", longevity=" + longevity + "]";
	}

	
	
	
}
