package com.example.demo.entity;

import java.sql.Timestamp;

public class Design {
	public int id;
	public int oaId;
	public String title;
	public String type;
	public String tips;
	public String unit;
	public String select;
	public Timestamp dateType;
	public Timestamp startDate;
	public Timestamp endDate;
	public int num;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOaId() {
		return oaId;
	}
	public void setOaId(int oaId) {
		this.oaId = oaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public Timestamp getDateType() {
		return dateType;
	}
	public void setDateType(Timestamp dateType) {
		this.dateType = dateType;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
