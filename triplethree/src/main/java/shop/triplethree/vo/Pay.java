package shop.triplethree.vo;

import java.time.LocalDateTime;


public class Pay {
	private String Code;
	private String EmpCode;
	private String DeCode;
	private int BasicPay;
	private int Benefit;
	private int HolidayPay;
	private int OvertimePay;
	private int QualiPay;
	private int SpecialPay;
	private int PositionBenefit;
	private int SelfDriPay;
	private int ComPay;
	private int MealCost;
	private int ChildPay;
	private int DeductPay;
	private String Writer;
	private LocalDateTime WriterDay;
	public String getCode() {
		return Code;
	}
	@Override
	public String toString() {
		return "Pay [Code=" + Code + ", EmpCode=" + EmpCode + ", DeCode=" + DeCode + ", BasicPay=" + BasicPay
				+ ", Benefit=" + Benefit + ", HolidayPay=" + HolidayPay + ", OvertimePay=" + OvertimePay + ", QualiPay="
				+ QualiPay + ", SpecialPay=" + SpecialPay + ", PositionBenefit=" + PositionBenefit + ", SelfDriPay="
				+ SelfDriPay + ", ComPay=" + ComPay + ", MealCost=" + MealCost + ", ChildPay=" + ChildPay
				+ ", DeductPay=" + DeductPay + ", Writer=" + Writer + ", WriterDay=" + WriterDay + "]";
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getEmpCode() {
		return EmpCode;
	}
	public void setEmpCode(String empCode) {
		EmpCode = empCode;
	}
	public String getDeCode() {
		return DeCode;
	}
	public void setDeCode(String deCode) {
		DeCode = deCode;
	}
	public int getBasicPay() {
		return BasicPay;
	}
	public void setBasicPay(int basicPay) {
		BasicPay = basicPay;
	}
	public int getBenefit() {
		return Benefit;
	}
	public void setBenefit(int benefit) {
		Benefit = benefit;
	}
	public int getHolidayPay() {
		return HolidayPay;
	}
	public void setHolidayPay(int holidayPay) {
		HolidayPay = holidayPay;
	}
	public int getOvertimePay() {
		return OvertimePay;
	}
	public void setOvertimePay(int overtimePay) {
		OvertimePay = overtimePay;
	}
	public int getQualiPay() {
		return QualiPay;
	}
	public void setQualiPay(int qualiPay) {
		QualiPay = qualiPay;
	}
	public int getSpecialPay() {
		return SpecialPay;
	}
	public void setSpecialPay(int specialPay) {
		SpecialPay = specialPay;
	}
	public int getPositionBenefit() {
		return PositionBenefit;
	}
	public void setPositionBenefit(int positionBenefit) {
		PositionBenefit = positionBenefit;
	}
	public int getSelfDriPay() {
		return SelfDriPay;
	}
	public void setSelfDriPay(int selfDriPay) {
		SelfDriPay = selfDriPay;
	}
	public int getComPay() {
		return ComPay;
	}
	public void setComPay(int comPay) {
		ComPay = comPay;
	}
	public int getMealCost() {
		return MealCost;
	}
	public void setMealCost(int mealCost) {
		MealCost = mealCost;
	}
	public int getChildPay() {
		return ChildPay;
	}
	public void setChildPay(int childPay) {
		ChildPay = childPay;
	}
	public int getDeductPay() {
		return DeductPay;
	}
	public void setDeductPay(int deductPay) {
		DeductPay = deductPay;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public LocalDateTime getWriterDay() {
		return WriterDay;
	}
	public void setWriterDay(LocalDateTime writerDay) {
		WriterDay = writerDay;
	}
	
}
