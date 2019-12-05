package shop.triplethree.vo;

public class Position {

	private String positionCode;
	private String positionNameBe;
	private String positionNameAf;
	private String positionLevel;
	private String positionSau;
	private String positionWriter;
	private String positionWriterDay;
	private String positionApprover;
	private String positionApperverSt;
	private String positionApproDay;
	private String positionYesNO;
	
	public String getPositionCode() {
		return positionCode;
	}
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}
	public String getPositionNameBe() {
		return positionNameBe;
	}
	public void setPositionNameBe(String positionNameBe) {
		this.positionNameBe = positionNameBe;
	}
	public String getPositionNameAf() {
		return positionNameAf;
	}
	public void setPositionNameAf(String positionNameAf) {
		this.positionNameAf = positionNameAf;
	}
	public String getPositionLevel() {
		return positionLevel;
	}
	public void setPositionLevel(String positionLevel) {
		this.positionLevel = positionLevel;
	}
	public String getPositionSau() {
		return positionSau;
	}
	public void setPositionSau(String positionSau) {
		this.positionSau = positionSau;
	}
	public String getPositionWriter() {
		return positionWriter;
	}
	public void setPositionWriter(String positionWriter) {
		this.positionWriter = positionWriter;
	}
	public String getPositionWriterDay() {
		return positionWriterDay;
	}
	public void setPositionWriterDay(String positionWriterDay) {
		this.positionWriterDay = positionWriterDay;
	}
	public String getPositionApprover() {
		return positionApprover;
	}
	public void setPositionApprover(String positionApprover) {
		this.positionApprover = positionApprover;
	}
	public String getPositionApperverSt() {
		return positionApperverSt;
	}
	public void setPositionApperverSt(String positionApperverSt) {
		this.positionApperverSt = positionApperverSt;
	}
	public String getPositionApproDay() {
		return positionApproDay;
	}
	public void setPositionApproDay(String positionApproDay) {
		this.positionApproDay = positionApproDay;
	}
	public String getPositionYesNO() {
		return positionYesNO;
	}
	public void setPositionYesNO(String positionYesNO) {
		this.positionYesNO = positionYesNO;
	}
	
	@Override
	public String toString() {
		return "Position [positionCode=" + positionCode + ", positionNameBe=" + positionNameBe + ", positionNameAf="
				+ positionNameAf + ", positionLevel=" + positionLevel + ", positionSau=" + positionSau
				+ ", positionWriter=" + positionWriter + ", positionWriterDay=" + positionWriterDay
				+ ", positionApprover=" + positionApprover + ", positionApperverSt=" + positionApperverSt
				+ ", positionApproDay=" + positionApproDay + ", positionYesNO=" + positionYesNO + "]";
	}
}
