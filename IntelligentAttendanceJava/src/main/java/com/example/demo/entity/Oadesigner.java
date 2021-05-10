package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.List;

public class Oadesigner {
	public int id;
	public String name;
	public String image;
	public String text;
	public String range;
	public Timestamp changeTime;
	public List<Design> lists;
	public List<Design> getLists() {
		return lists;
	}
	public void setLists(List<Design> lists) {
		this.lists = lists;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public Timestamp getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(Timestamp changeTime) {
		this.changeTime = changeTime;
	}
}
