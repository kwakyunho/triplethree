package shop.triplethree.vo;

import java.time.LocalDateTime;


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
	private String empNum;	//사원코드	
	private String empName;	//사원이름
	private String poName;	//직책	
	private String demgName;	//부서명
	private int inseurPer; //고용보험공제비율
	private int incomePer; //소득세공제비율
	private int nationPer; //국민연금공제비율
	private int healthPer; //건보료공제비율
	private int residentTax;	//주민세공제비율
	private int longCare;	//장기요양공제비율
	private int industrialPer;	//산재보험비율
	private int securityPer;	//고용안정비율
	private LocalDateTime year;	//적용연도

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
	public int getIndustrialPer() {
		return industrialPer;
	}
	public void setIndustrialPer(int industrialPer) {
		this.industrialPer = industrialPer;
	}
	public int getSecurityPer() {
		return securityPer;
	}
	public void setSecurityPer(int securityPer) {
		this.securityPer = securityPer;
	}
	public LocalDateTime getYear() {
		return year;
	}
	public void setYear(LocalDateTime year) {
		this.year = year;
	}
	public String getCode() {		
		return code;
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
	@Override
	public String toString() {
		return "Pay [code=" + code + ", empCode=" + empCode + ", deCode=" + deCode + ", basicPay=" + basicPay
				+ ", beneFit=" + beneFit + ", holidayPay=" + holidayPay + ", overtimePay=" + overtimePay
				+ ", positionBenefit=" + positionBenefit + ", selfDriPay=" + selfDriPay + ", comPay=" + comPay
				+ ", mealCost=" + mealCost + ", childPay=" + childPay + ", deductPay=" + deductPay + ", writer="
				+ writer + ", writerDay=" + writerDay + ", paymentDate=" + paymentDate + ", empNum=" + empNum
				+ ", empName=" + empName + ", poName=" + poName + ", demgName=" + demgName + ", inseurPer=" + inseurPer
				+ ", incomePer=" + incomePer + ", nationPer=" + nationPer + ", healthPer=" + healthPer
				+ ", residentTax=" + residentTax + ", longCare=" + longCare + ", industrialPer=" + industrialPer
				+ ", securityPer=" + securityPer + ", year=" + year + "]";
	}
	
	
	
}
