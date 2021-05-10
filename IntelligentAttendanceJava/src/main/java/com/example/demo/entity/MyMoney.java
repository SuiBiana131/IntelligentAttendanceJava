package com.example.demo.entity;

import java.sql.Date;

public class MyMoney {
	int id;  
	int userid;
	int commendation;  //
	int attendancebonus; //考勤
	int basic; //基本工资
	int accommodation; //住宿
	int commission; //
	int tax; //税费
	int state;
	Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCommendation() {
		return commendation;
	}
	public void setCommendation(int commendation) {
		this.commendation = commendation;
	}
	public int getAttendancebonus() {
		return attendancebonus;
	}
	public void setAttendancebonus(int attendancebonus) {
		this.attendancebonus = attendancebonus;
	}
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic = basic;
	}
	public int getAccommodation() {
		return accommodation;
	}
	public void setAccommodation(int accommodation) {
		this.accommodation = accommodation;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public MyMoney(int id, int userid, int commendation, int attendancebonus, int basic, int accommodation,
			int commission, int tax, int state, Date date) {
		super();
		this.id = id;
		this.userid = userid;
		this.commendation = commendation;
		this.attendancebonus = attendancebonus;
		this.basic = basic;
		this.accommodation = accommodation;
		this.commission = commission;
		this.tax = tax;
		this.state = state;
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public MyMoney() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
