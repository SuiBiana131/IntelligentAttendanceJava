package com.example.demo.entity;

public class UserAccommodation {
	int id;
	int userid;
	int accommodationid;
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
	public int getAccommodationid() {
		return accommodationid;
	}
	public void setAccommodationid(int accommodationid) {
		this.accommodationid = accommodationid;
	}
	public UserAccommodation(int id, int userid, int accommodationid) {
		super();
		this.id = id;
		this.userid = userid;
		this.accommodationid = accommodationid;
	}
	public UserAccommodation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
