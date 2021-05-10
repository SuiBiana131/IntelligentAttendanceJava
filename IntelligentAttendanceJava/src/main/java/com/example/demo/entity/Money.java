package com.example.demo.entity;

public class Money {
	int id;
	int attendancebonus;
	int Commendation;
	int tax;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAttendancebonus() {
		return attendancebonus;
	}
	public void setAttendancebonus(int attendancebonus) {
		this.attendancebonus = attendancebonus;
	}
	public int getCommendation() {
		return Commendation;
	}
	public void setCommendation(int commendation) {
		Commendation = commendation;
	}
	public Money(int id, int attendancebonus, int commendation, int tax) {
		super();
		this.id = id;
		this.attendancebonus = attendancebonus;
		Commendation = commendation;
		this.tax = tax;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public Money() {
		super();
		// TODO Auto-generated constructor stub
	}
}
