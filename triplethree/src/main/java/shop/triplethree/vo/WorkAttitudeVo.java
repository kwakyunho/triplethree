package shop.triplethree.vo;

public class WorkAttitudeVo {
	
	private String workAttCode;	// 근태관리코드
	private String userNum;	// 사원관리코드
	private String day;	// 일자
	private String startWorkTime;	// 출근시간
	private String endWorkTime;	// 퇴근시간
	private String startOutSideTime;	// 외근출발시간
	private String endOutSideTime;	// 외근복귀시간
	private String userId;	// 작성자
	private String insertDt;	// 작성일자
	private String adminUpdateYn;	// 관리자수정여부
	private String adminId;	// 관리자아이디
	private String adminInsertDt;	// 수정일자
	private String coment;	// 사유
	
	public String getWorkAttCode() {
		return workAttCode;
	}
	public void setWorkAttCode(String workAttCode) {
		this.workAttCode = workAttCode;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStartWorkTime() {
		return startWorkTime;
	}
	public void setStartWorkTime(String startWorkTime) {
		this.startWorkTime = startWorkTime;
	}
	public String getEndWorkTime() {
		return endWorkTime;
	}
	public void setEndWorkTime(String endWorkTime) {
		this.endWorkTime = endWorkTime;
	}
	public String getStartOutSideTime() {
		return startOutSideTime;
	}
	public void setStartOutSideTime(String startOutSideTime) {
		this.startOutSideTime = startOutSideTime;
	}
	public String getEndOutSideTime() {
		return endOutSideTime;
	}
	public void setEndOutSideTime(String endOutSideTime) {
		this.endOutSideTime = endOutSideTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInsertDt() {
		return insertDt;
	}
	public void setInsertDt(String insertDt) {
		this.insertDt = insertDt;
	}
	public String getAdminUpdateYn() {
		return adminUpdateYn;
	}
	public void setAdminUpdateYn(String adminUpdateYn) {
		this.adminUpdateYn = adminUpdateYn;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminInsertDt() {
		return adminInsertDt;
	}
	public void setAdminInsertDt(String adminInsertDt) {
		this.adminInsertDt = adminInsertDt;
	}
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	
	@Override
	public String toString() {
		return "WorkAttitudeVo [workAttCode=" + workAttCode + ", userNum=" + userNum + ", day=" + day
				+ ", startWorkTime=" + startWorkTime + ", endWorkTime=" + endWorkTime + ", startOutSideTime="
				+ startOutSideTime + ", endOutSideTime=" + endOutSideTime + ", userId=" + userId + ", insertDt="
				+ insertDt + ", adminUpdateYn=" + adminUpdateYn + ", adminId=" + adminId + ", adminInsertDt="
				+ adminInsertDt + ", coment=" + coment + "]";
	}
}