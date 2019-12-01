package shop.triplethree.vo;

public class Schedule {

	private String code;
	private String sortation;
	private String name;
	private String content;
	private String startDay;
	private String endDay;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	
	@Override
	public String toString() {
		return "Schedule [code=" + code + ", sortation=" + sortation + ", name=" + name + ", content=" + content
				+ ", startDay=" + startDay + ", endDay=" + endDay + "]";
	}
}
