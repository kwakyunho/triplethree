package shop.triplethree.vo;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;


public class Pay {
	private String code; //급여지급명세서코드
	private String empCode; //사원관리코드
	private String deCode; //공제액코드
	private int basicPay; //기본급
	private int beneFit;	//야간근무수당
	private int holidayPay; //휴일근무수당
	private int overtimePay;//연장근무수당
	private int positionBenefit;//직책수당
	private int selfDriPay;//자가운전보조금
	private int comPay;		//통신수당
	private int mealCost;	//식대보조금
	private int childPay;	//육아수당
	private int deductPay;	//공제후급여
	private String writer;	//작성자
	private LocalDateTime writerDay;	//작성일자
	private LocalDateTime paymentDate;	//지급일자
	private String empNum;	//사원번호	
	private String empName;	//사원이름
	private String poName;	//직책	
	private String demgName;	//부서명
	private Double inseurPer; //고용보험공제비율
	private int inCode; //소득세
	private int one; //소득세
	private int residentTax;
	private Double nationPer; //국민연금공제비율
	private Double healthPer; //건보료공제비율
	private Double longCare;	//장기요양공제비율
	private Double industrialPer;	//산재보험비율	
	private Year year;	//적용연도
	public String getCode() {
		return code;
	}
	public int getOne() {
		return one;
	}
	public void setOne(int one) {
		this.one = one;
	}
	public int getResidentTax() {
		return residentTax;
	}
	public void setResidentTax(int residentTax) {
		this.residentTax = residentTax;
	}
	public void setInCode(int inCode) {
		this.inCode = inCode;
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
	public int getInCode() {
		return inCode;
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
	public int getBeneFit() {
		return beneFit;
	}
	public void setBeneFit(int beneFit) {
		this.beneFit = beneFit;
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
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public String getDemgName() {
		return demgName;
	}
	public void setDemgName(String demgName) {
		this.demgName = demgName;
	}
	public Double getInseurPer() {
		return inseurPer;
	}
	public void setInseurPer(Double inseurPer) {
		this.inseurPer = inseurPer;
	}
	public Double getNationPer() {
		return nationPer;
	}
	public void setNationPer(Double nationPer) {
		this.nationPer = nationPer;
	}
	public Double getHealthPer() {
		return healthPer;
	}
	public void setHealthPer(Double healthPer) {
		this.healthPer = healthPer;
	}

	public Double getLongCare() {
		return longCare;
	}
	public void setLongCare(Double longCare) {
		this.longCare = longCare;
	}
	public Double getIndustrialPer() {
		return industrialPer;
	}
	public void setIndustrialPer(Double industrialPer) {
		this.industrialPer = industrialPer;
	}
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Pay [code=" + code + ", empCode=" + empCode + ", deCode=" + deCode + ", basicPay=" + basicPay
				+ ", beneFit=" + beneFit + ", holidayPay=" + holidayPay + ", overtimePay=" + overtimePay
				+ ", positionBenefit=" + positionBenefit + ", selfDriPay=" + selfDriPay + ", comPay=" + comPay
				+ ", mealCost=" + mealCost + ", childPay=" + childPay + ", deductPay=" + deductPay + ", writer="
				+ writer + ", writerDay=" + writerDay + ", paymentDate=" + paymentDate + ", empNum=" + empNum
				+ ", empName=" + empName + ", poName=" + poName + ", demgName=" + demgName + ", inseurPer=" + inseurPer
				+ ", inCode=" + inCode + ", residentTax=" + residentTax + ", nationPer=" + nationPer + ", healthPer="
				+ healthPer + ", longCare=" + longCare + ", industrialPer=" + industrialPer + ", year=" + year + "]";
	}

	
	
}
