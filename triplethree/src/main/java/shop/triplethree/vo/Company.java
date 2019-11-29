package shop.triplethree.vo;

public class Company {

	private String departmentName;
	private String departmentLevel;
	private String departmentUpcode;
	private String departmentSau;
	private String departmentWriter;
	private String departmentWriterDay;
	private String departmentApprover;
	private String departmentApperverSt;
	private String departmentApproDay;
	private String departmentCode;
	private String departmentYesNO;
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentLevel() {
		return departmentLevel;
	}
	public void setDepartmentLevel(String departmentLevel) {
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
	
	@Override
	public String toString() {
		return "Company [departmentName=" + departmentName + ", departmentLevel=" + departmentLevel
				+ ", departmentUpcode=" + departmentUpcode + ", departmentSau=" + departmentSau + ", departmentWriter="
				+ departmentWriter + ", departmentWriterDay=" + departmentWriterDay + ", departmentApprover="
				+ departmentApprover + ", departmentApperverSt=" + departmentApperverSt + ", departmentApproDay="
				+ departmentApproDay + ", departmentCode=" + departmentCode + ", departmentYesNO=" + departmentYesNO
				+ "]";
	}
}
