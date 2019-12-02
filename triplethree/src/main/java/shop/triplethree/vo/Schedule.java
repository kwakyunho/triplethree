package shop.triplethree.vo;

public class Schedule {

	private String code;
	private String sortation;
	private String title;
	private String content;
	private String start;
	private String end;
	private String backgroundColor;
	private String borderColor;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	
	@Override
	public String toString() {
		return "Schedule [code=" + code + ", sortation=" + sortation + ", title=" + title + ", content=" + content
				+ ", start=" + start + ", end=" + end + ", backgroundColor=" + backgroundColor + ", borderColor="
				+ borderColor + "]";
	}
}
