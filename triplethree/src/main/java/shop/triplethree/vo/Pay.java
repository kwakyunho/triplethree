package shop.triplethree.vo;

import java.time.LocalDateTime;


public class Pay {
	private String code;
	private String empCode;
	private String deCode;
	private int basicPay;
	private int benefit;
	private int holidayPay;
	private int overtimePay;
	private int qualiPay;
	private int specialPay;
	private int positionBenefit;
	private int selfDriPay;
	private int comPay;
	private int mealCost;
	private int childPay;
	private int deductPay;
	private String writer;
	private LocalDateTime writerDay;
	private LocalDateTime paymentDate;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getDeCode() {
		return deCode;
	}
	public void setDeCode(String deCode) {
		this.deCode = deCode;
	}
	public int getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(int basicPay) {
		this.basicPay = basicPay;
	}
	public int getBenefit() {
		return benefit;
	}
	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}
	public int getHolidayPay() {
		return holidayPay;
	}
	public void setHolidayPay(int holidayPay) {
		this.holidayPay = holidayPay;
	}
	public int getOvertimePay() {
		return overtimePay;
	}
	public void setOvertimePay(int overtimePay) {
		this.overtimePay = overtimePay;
	}
	public int getQualiPay() {
		return qualiPay;
	}
	public void setQualiPay(int qualiPay) {
		this.qualiPay = qualiPay;
	}
	public int getSpecialPay() {
		return specialPay;
	}
	public void setSpecialPay(int specialPay) {
		this.specialPay = specialPay;
	}
	public int getPositionBenefit() {
		return positionBenefit;
	}
	public void setPositionBenefit(int positionBenefit) {
		this.positionBenefit = positionBenefit;
	}
	public int getSelfDriPay() {
		return selfDriPay;
	}
	public void setSelfDriPay(int selfDriPay) {
		this.selfDriPay = selfDriPay;
	}
	public int getComPay() {
		return comPay;
	}
	public void setComPay(int comPay) {
		this.comPay = comPay;
	}
	public int getMealCost() {
		return mealCost;
	}
	public void setMealCost(int mealCost) {
		this.mealCost = mealCost;
	}
	public int getChildPay() {
		return childPay;
	}
	public void setChildPay(int childPay) {
		this.childPay = childPay;
	}
	public int getDeductPay() {
		return deductPay;
	}
	public void setDeductPay(int deductPay) {
		this.deductPay = deductPay;
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
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "Pay [code=" + code + ", empCode=" + empCode + ", deCode=" + deCode + ", basicPay=" + basicPay
				+ ", benefit=" + benefit + ", holidayPay=" + holidayPay + ", overtimePay=" + overtimePay + ", qualiPay="
				+ qualiPay + ", specialPay=" + specialPay + ", positionBenefit=" + positionBenefit + ", selfDriPay="
				+ selfDriPay + ", comPay=" + comPay + ", mealCost=" + mealCost + ", childPay=" + childPay
				+ ", deductPay=" + deductPay + ", writer=" + writer + ", writerDay=" + writerDay + ", paymentDate="
				+ paymentDate + "]";
	}
	
	
	
}
