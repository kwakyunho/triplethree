package shop.triplethree.vo;

public class SignDocument {

	private String code; // 작성된 결재문서 관리코드
	private String emp_code; // 사원코드
	private String doc_form_code; // 문서양식 관리코드
	private String doc_title; // 문서명
	private String doc_name; // 문서제목
	private String doc_con; // 사유(내용)
	private String doc_bego; // 비고
	private String writer_day; // 작성일자
	private String start_date; // 시작기간(휴가일정)
	private String end_date; // 종료기간(휴가일정)
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getDoc_form_code() {
		return doc_form_code;
	}
	public void setDoc_form_code(String doc_form_code) {
		this.doc_form_code = doc_form_code;
	}
	public String getDoc_title() {
		return doc_title;
	}
	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public String getDoc_con() {
		return doc_con;
	}
	public void setDoc_con(String doc_con) {
		this.doc_con = doc_con;
	}
	public String getDoc_bego() {
		return doc_bego;
	}
	public void setDoc_bego(String doc_bego) {
		this.doc_bego = doc_bego;
	}
	public String getWriter_day() {
		return writer_day;
	}
	public void setWriter_day(String writer_day) {
		this.writer_day = writer_day;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	@Override
	public String toString() {
		return "SignDocument [code=" + code + ", emp_code=" + emp_code + ", doc_form_code=" + doc_form_code
				+ ", doc_title=" + doc_title + ", doc_name=" + doc_name + ", doc_con=" + doc_con + ", doc_bego="
				+ doc_bego + ", writer_day=" + writer_day + ", start_date=" + start_date + ", end_date=" + end_date
				+ "]";
	}
}
