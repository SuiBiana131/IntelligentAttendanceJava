package com.example.demo.entity;

public class Jur {
	int id;
	String jurname;
	String jurtext;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJurname() {
		return jurname;
	}

	public void setJurname(String jurname) {
		this.jurname = jurname;
	}

	public String getJurtext() {
		return jurtext;
	}

	public void setJurtext(String jurtext) {
		this.jurtext = jurtext;
	}

	public Jur(int id, String jurname, String jurtext) {
		super();
		this.id = id;
		this.jurname = jurname;
		this.jurtext = jurtext;
	}

	public Jur() {
		super();
		// TODO Auto-generated constructor stub
	}
}
