package com.example.demo.entity;

import java.sql.Time;

public class Competencegroup {
	public int id;
	public String name;
	public String type;
	public String freeWorkday;
	public String isHoilday;
	public String stytle;
	public String overWorkRule;
	public String isDelivery;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFreeWorkday() {
		return freeWorkday;
	}
	public void setFreeWorkday(String freeWorkday) {
		this.freeWorkday = freeWorkday;
	}
	public String getIsHoilday() {
		return isHoilday;
	}
	public void setIsHoilday(String isHoilday) {
		this.isHoilday = isHoilday;
	}
	public String getStytle() {
		return stytle;
	}
	public void setStytle(String stytle) {
		this.stytle = stytle;
	}
	public String getOverWorkRule() {
		return overWorkRule;
	}
	public void setOverWorkRule(String overWorkRule) {
		this.overWorkRule = overWorkRule;
	}
	public String getIsDelivery() {
		return isDelivery;
	}
	public void setIsDelivery(String isDelivery) {
		this.isDelivery = isDelivery;
	}
}
