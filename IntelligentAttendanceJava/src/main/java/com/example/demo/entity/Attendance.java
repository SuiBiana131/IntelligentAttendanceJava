package com.example.demo.entity;

import java.sql.Time;

public class Attendance {
	int id;
	Time start;
	Time end;
	String marks;
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Attendance(int id, Time start, Time end) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
	}
	public Attendance(int id, Time start, Time end, String marks) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.marks = marks;
	}
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
