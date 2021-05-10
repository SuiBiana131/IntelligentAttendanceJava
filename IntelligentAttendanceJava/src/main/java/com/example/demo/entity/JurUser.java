package com.example.demo.entity;

public class JurUser {
	int id;
	int jurid;
	int userid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJurid() {
		return jurid;
	}
	public void setJurid(int jurid) {
		this.jurid = jurid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public JurUser(int id, int jurid, int userid) {
		super();
		this.id = id;
		this.jurid = jurid;
		this.userid = userid;
	}
	public JurUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
