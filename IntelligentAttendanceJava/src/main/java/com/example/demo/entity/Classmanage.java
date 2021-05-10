package com.example.demo.entity;

import java.sql.Time;

public class Classmanage {
	public int id;
	public String name;
	public Time start;
	public Time end;
	public String isRest;
	public Time restStart;
	public Time restEnd;
	public String clock;
	public int compute;
	public String seriouslylate;
	public String neglectWork;
	public String isSerious;
	public String isNeglect;
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
	public String getIsRest() {
		return isRest;
	}
	public void setIsRest(String isRest) {
		this.isRest = isRest;
	}
	public Time getRestStart() {
		return restStart;
	}
	public void setRestStart(Time restStart) {
		this.restStart = restStart;
	}
	public Time getRestEnd() {
		return restEnd;
	}
	public void setRestEnd(Time restEnd) {
		this.restEnd = restEnd;
	}
	public String getClock() {
		return clock;
	}
	public void setClock(String clock) {
		this.clock = clock;
	}
	public int getCompute() {
		return compute;
	}
	public void setCompute(int compute) {
		this.compute = compute;
	}
	public String getSeriouslylate() {
		return seriouslylate;
	}
	public void setSeriouslylate(String seriouslylate) {
		this.seriouslylate = seriouslylate;
	}
	public String getNeglectWork() {
		return neglectWork;
	}
	public void setNeglectWork(String neglectWork) {
		this.neglectWork = neglectWork;
	}
	public String getIsSerious() {
		return isSerious;
	}
	public void setIsSerious(String isSerious) {
		this.isSerious = isSerious;
	}
	public String getIsNeglect() {
		return isNeglect;
	}
	public void setIsNeglect(String isNeglect) {
		this.isNeglect = isNeglect;
	}
}
