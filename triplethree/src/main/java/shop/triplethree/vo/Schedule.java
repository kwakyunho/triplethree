package shop.triplethree.vo;

public class Schedule {

	private String sid;
	private String code;
	private String demgcode;
	private String sortation;
	private String title;
	private String start;
	private String end;
	private String color;
	private String backgroundColor;
	
	public String getDemgcode() {
		return demgcode;
	}
	public void setDemgcode(String demgcode) {
		this.demgcode = demgcode;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSortation() {
		return sortation;
	}
	public void setSortation(String sortation) {
		this.sortation = sortation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	@Override
	public String toString() {
		return "Schedule [sid=" + sid + ", code=" + code + ", demgcode=" + demgcode + ", sortation=" + sortation
				+ ", title=" + title + ", start=" + start + ", end=" + end + ", color=" + color + ", backgroundColor="
				+ backgroundColor + "]";
	}
}
