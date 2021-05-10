package com.example.demo.entity;

import java.sql.Time;
import java.sql.Date;

public class Overwork {
	public int id;
	public int userid;
	public Time start;
	public Time end;
	public int times;  //加班时长
	public Date date;	//日期
	public int isoverwork; //是否是一个完整加班
	public int isapply; //加班时长是否已申请
	public String type;	//加班的类型（节假日、休息日等）
	public String changetype; //加班转的类型（加班费、调休等）
}
