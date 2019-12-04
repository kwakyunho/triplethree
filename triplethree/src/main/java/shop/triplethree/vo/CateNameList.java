package shop.triplethree.vo;

public class CateNameList {
	
	private int re;
	private int condition;
	private String cateCode;
	private String largeCateName;
	private String middleCateName;
	private String smallCateName;
	private String itemCode;
	private String useYn;
	private String average;
	private String writerUser;
	private String writerDay;
	private String gasoline;
	private String diesel;
	private String lpg;
	private String bus;
	private String room;
	private String roomPeriod;
	private String confUser;
	private String confDay;
	
	public int getRe() {
		return re;
	}
	public void setRe(int re) {
		this.re = re;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getLargeCateName() {
		return largeCateName;
	}
	public void setLargeCateName(String largeCateName) {
		this.largeCateName = largeCateName;
	}
	public String getMiddleCateName() {
		return middleCateName;
	}
	public void setMiddleCateName(String middleCateName) {
		this.middleCateName = middleCateName;
	}
	public String getSmallCateName() {
		return smallCateName;
	}
	public void setSmallCateName(String smallCateName) {
		this.smallCateName = smallCateName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}
	public String getWriterUser() {
		return writerUser;
	}
	public void setWriterUser(String writerUser) {
		this.writerUser = writerUser;
	}
	public String getWriterDay() {
		return writerDay;
	}
	public void setWriterDay(String writerDay) {
		this.writerDay = writerDay;
	}
	public String getGasoline() {
		return gasoline;
	}
	public void setGasoline(String gasoline) {
		this.gasoline = gasoline;
	}
	public String getDiesel() {
		return diesel;
	}
	public void setDiesel(String diesel) {
		this.diesel = diesel;
	}
	public String getLpg() {
		return lpg;
	}
	public void setLpg(String lpg) {
		this.lpg = lpg;
	}
	public String getBus() {
		return bus;
	}
	public void setBus(String bus) {
		this.bus = bus;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getRoomPeriod() {
		return roomPeriod;
	}
	public void setRoomPeriod(String roomPeriod) {
		this.roomPeriod = roomPeriod;
	}
	public String getConfUser() {
		return confUser;
	}
	public void setConfUser(String confUser) {
		this.confUser = confUser;
	}
	public String getConfDay() {
		return confDay;
	}
	public void setConfDay(String confDay) {
		this.confDay = confDay;
	}
	
	@Override
	public String toString() {
		return "CateNameList [re=" + re + ", condition=" + condition + ", cateCode=" + cateCode + ", largeCateName="
				+ largeCateName + ", middleCateName=" + middleCateName + ", smallCateName=" + smallCateName
				+ ", itemCode=" + itemCode + ", useYn=" + useYn + ", average=" + average + ", writerUser=" + writerUser
				+ ", writerDay=" + writerDay + ", gasoline=" + gasoline + ", diesel=" + diesel + ", lpg=" + lpg
				+ ", bus=" + bus + ", room=" + room + ", roomPeriod=" + roomPeriod + ", confUser=" + confUser
				+ ", confDay=" + confDay + "]";
	}
}