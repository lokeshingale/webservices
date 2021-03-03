package com.dev.dto;

import java.io.Serializable;
import java.util.Date;

public class StudentDTO implements Serializable {
	private int SerialNo;
	private int Student_No;
	private String name;
	private Date dob;
	private Date doj;
	public int getStudent_No() {
		return Student_No;
	}
	public void setStudent_No(int student_No) {
		Student_No = student_No;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public int getSerialNo() {
		return SerialNo;
	}
	public void setSerialNo(int serialNo) {
		SerialNo = serialNo;
	}
	
	
}
