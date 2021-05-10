package com.example.demo.entity;

import java.sql.Date;
import java.sql.Time;

public class StaffAttend {
	int id;
	int userid;
	Time start;
	Time end;
	String state;
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
	public Time getStart() {
		return start;
	}
	public void setStart(Time start) {
		this.start = start;
	}
	public Time getEnd() {
		return end;
	}
	public void setEnd(Time end) {
		this.end = end;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public StaffAttend(int id, int userid, Time start, Time end, String state, Date date) {
		super();
		this.id = id;
		this.userid = userid;
		this.start = start;
		this.end = end;
		this.state = state;
		this.date = date;
	}
	public StaffAttend() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StaffAttend [id=" + id + ", userid=" + userid + ", start=" + start + ", end=" + end + ", state=" + state
				+ ", date=" + date + "]";
	}
	
}
