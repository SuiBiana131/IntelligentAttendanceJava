package com.example.demo.entity;

public class Accommodation {
	int id;
	String name;
	String accommodationaddress;
	int cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccommodationaddress() {
		return accommodationaddress;
	}
	public void setAccommodationaddress(String accommodationaddress) {
		this.accommodationaddress = accommodationaddress;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Accommodation(int id, String accommodationaddress, int cost) {
		super();
		this.id = id;
		this.accommodationaddress = accommodationaddress;
		this.cost = cost;
	}
	public Accommodation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
