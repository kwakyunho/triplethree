package shop.triplethree.vo;

import java.time.LocalDateTime;

public class Deduct {
	private String deCode;
	private int inseurPer;
	private int incomePer;
	private int nationPer;
	private int healthPer;
	private int residentTax;
	private int longCare;
	private LocalDateTime year;
	private String writer;
	private LocalDateTime writerDay;
	public String getDeCode() {
		return deCode;
	}
	public void setDeCode(String deCode) {
		this.deCode = deCode;
	}
	public int getInseurPer() {
		return inseurPer;
	}
	public void setInseurPer(int inseurPer) {
		this.inseurPer = inseurPer;
	}
	public int getIncomePer() {
		return incomePer;
	}
	public void setIncomePer(int incomePer) {
		this.incomePer = incomePer;
	}
	public int getNationPer() {
		return nationPer;
	}
	public void setNationPer(int nationPer) {
		this.nationPer = nationPer;
	}
	public int getHealthPer() {
		return healthPer;
	}
	public void setHealthPer(int healthPer) {
		this.healthPer = healthPer;
	}
	public int getResidentTax() {
		return residentTax;
	}
	public void setResidentTax(int residentTax) {
		this.residentTax = residentTax;
	}
	public int getLongCare() {
		return longCare;
	}
	public void setLongCare(int longCare) {
		this.longCare = longCare;
	}
	public LocalDateTime getYear() {
		return year;
	}
	public void setYear(LocalDateTime year) {
		this.year = year;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public LocalDateTime getWriterDay() {
		return writerDay;
	}
	public void setWriterDay(LocalDateTime writerDay) {
		this.writerDay = writerDay;
	}
	@Override
	public String toString() {
		return "Deduct [deCode=" + deCode + ", inseurPer=" + inseurPer + ", incomePer=" + incomePer + ", nationPer="
				+ nationPer + ", healthPer=" + healthPer + ", residentTax=" + residentTax + ", longCare=" + longCare
				+ ", year=" + year + ", writer=" + writer + ", writerDay=" + writerDay + "]";
	}

	
}
