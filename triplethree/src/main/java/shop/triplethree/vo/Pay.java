package shop.triplethree.vo;

import java.time.LocalDateTime;


public class Pay {
	private String code; //급여지급명세서코드
	private String empCode; //사원관리코드
	private String deCode; //공제액코드
	private int basicPay; //기본급
	private int benefit;	//야간근무수당
	private int holidayPay; //휴일근무수당
	private int overtimePay;//연장근무수당
	private int qualiPay;	//자격수당
	private int specialPay;//특수근무지수당
	private int positionBenefit;//직책수당
	private int selfDriPay;//자가운전보조금
	private int comPay;		//통신수당
	private int mealCost;	//식대보조금
	private int childPay;	//육아수당
	private int deductPay;	//공제후급여
	private String writer;	//작성자
	private LocalDateTime writerDay;	//작성일자
	private LocalDateTime paymentDate;	//지급일자
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
