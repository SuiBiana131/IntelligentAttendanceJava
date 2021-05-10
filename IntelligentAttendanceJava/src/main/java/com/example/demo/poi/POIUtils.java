package com.example.demo.poi;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class POIUtils {
	//月度汇总
	public static ResponseEntity<byte[]> mouthExcel(List<Map<String,Object>> list,String start,String end) {
        //1. 创建一个 Excel 文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2. 创建文档摘要
        workbook.createInformationProperties();
        //3. 获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("员工信息");
        //文档管理员
        docInfo.setManager("javaboy");
        //设置公司信息
        docInfo.setCompany("www.javaboy.org");
        //4. 获取文档摘要信息
        SummaryInformation summInfo = workbook.getSummaryInformation();
        //文档标题
        summInfo.setTitle("月度汇总表");
        //文档作者
        summInfo.setAuthor("刘泽榕");
        // 文档备注
        summInfo.setComments("本文档由 刘泽榕 提供");
        //5. 创建样式
        //创建标题行的样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFSheet sheet = workbook.createSheet("月度汇总表");
        //6. 创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("id");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("name");
        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("groupname");
        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("出勤天数");
        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("休息天数");
        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("工作时长/分");
        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("迟到天数");
        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("迟到时长/分");
        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("早退天数");
        HSSFCell c9 = r0.createCell(9);
        c9.setCellStyle(headerStyle);
        c9.setCellValue("早退时长/分");
        HSSFCell c10 = r0.createCell(10);
        c10.setCellStyle(headerStyle);
        c10.setCellValue("上班缺卡次数");
        HSSFCell c11 = r0.createCell(11);
        c11.setCellStyle(headerStyle);
        c11.setCellValue("下班缺卡次数");
        HSSFCell c12 = r0.createCell(12);
        c12.setCellStyle(headerStyle);
        c12.setCellValue("缺勤天数");
        HSSFCell c13 = r0.createCell(13);
        c13.setCellStyle(headerStyle);
        c13.setCellValue("加班时长(全部)/分");
        HSSFCell c14 = r0.createCell(14);
        c14.setCellStyle(headerStyle);
        c14.setCellValue("加班时长(转加班费)/分");
        HSSFCell c15 = r0.createCell(15);
        c15.setCellStyle(headerStyle);
        c15.setCellValue("加班时长(转调休)/分");
        HSSFCell c16 = r0.createCell(16);
        c16.setCellStyle(headerStyle);
        c16.setCellValue("加班时长(工作日)/分");
        HSSFCell c17 = r0.createCell(17);
        c17.setCellStyle(headerStyle);
        c17.setCellValue("加班时长(休息日)/分");
        HSSFCell c18 = r0.createCell(18);
        c18.setCellStyle(headerStyle);
        c18.setCellValue("加班时长(节假日)/分");
        //7.循环你的集合进行存储数据
        for (int i = 0; i < list.size(); i++) {
        	Map<String, Object> emp = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue((Integer)emp.get("id"));
            row.createCell(1).setCellValue((String)emp.get("name"));
            row.createCell(2).setCellValue((String)emp.get("groupname"));
            row.createCell(3).setCellValue((Integer)emp.get("出勤天数"));
            // 时间类型参数设置
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellValue((Integer)emp.get("休息天数"));
            row.createCell(5).setCellValue((Integer)emp.get("工作时长/分"));
            row.createCell(6).setCellValue((Integer)emp.get("迟到天数"));
            row.createCell(7).setCellValue((Integer)emp.get("迟到时长/分"));
            row.createCell(8).setCellValue((Integer)emp.get("早退天数"));
            row.createCell(9).setCellValue((Integer)emp.get("早退时长/分"));
            row.createCell(10).setCellValue((Integer)emp.get("上班缺卡次数"));
            row.createCell(11).setCellValue((Integer)emp.get("下班缺卡次数"));
            row.createCell(12).setCellValue((Integer)emp.get("缺勤天数"));
            row.createCell(13).setCellValue((Integer)emp.get("加班时长(全部)/分"));
            row.createCell(14).setCellValue((Integer)emp.get("加班时长(转加班费)/分"));
            row.createCell(15).setCellValue((Integer)emp.get("加班时长(转调休)/分"));
            row.createCell(16).setCellValue((Integer)emp.get("加班时长(工作日)/分"));
            row.createCell(17).setCellValue((Integer)emp.get("加班时长(休息日)/分"));
            row.createCell(18).setCellValue((Integer)emp.get("加班时长(节假日)/分"));
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
        	String name="员工表("+start+"-"+end+").xls";
            headers.setContentDispositionFormData("attachment", new String(name.getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }
	//每日信息
	public static ResponseEntity<byte[]> DateExcel(List<Map<String,Object>> list,String date){
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.createInformationProperties();
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        docInfo.setCategory("员工信息");
        docInfo.setManager("刘泽榕");
        docInfo.setCompany("www.lzr.org");
        SummaryInformation summInfo = workbook.getSummaryInformation();
        summInfo.setTitle("每日信息表");
        summInfo.setAuthor("刘泽榕");
        summInfo.setComments("本文档由 刘泽榕 提供");
        
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFCellStyle timeCellStyle = workbook.createCellStyle();
        timeCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("HH:mm:ss"));
        SimpleDateFormat f = new  SimpleDateFormat("HH:mm:ss");
        HSSFSheet sheet = workbook.createSheet("每日信息表");
        //6. 创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("userid");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("name");
        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("groupname");
        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("start");
        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("end");
        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("state");
        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("date");
        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("加班时长");
        for (int i = 0; i < list.size(); i++) {
        	Map<String, Object> emp = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue((Integer)emp.get("id"));
            row.createCell(1).setCellValue((String)emp.get("name"));
            row.createCell(2).setCellValue((String)emp.get("groupname"));
            row.createCell(3).setCellValue(f.format((Time)emp.get("start")));
            row.createCell(4).setCellValue(f.format((Time)emp.get("end")));
            row.createCell(5).setCellValue((String)emp.get("state"));
            HSSFCell cell6 = row.createCell(6);
            cell6.setCellStyle(dateCellStyle);
            cell6.setCellValue((Date) emp.get("date"));
            row.createCell(7).setCellValue((Integer)emp.get("加班时长"));
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
        	String name="每日信息表("+date+").xls";
            headers.setContentDispositionFormData("attachment", new String(name.getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
	}
	//考勤时间
	public static ResponseEntity<byte[]> EveryDateExcel(List<Map<String,Object>> list,String start,String end){
		HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.createInformationProperties();
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        docInfo.setCategory("员工信息");
        docInfo.setManager("刘泽榕");
        docInfo.setCompany("www.lzr.org");
        SummaryInformation summInfo = workbook.getSummaryInformation();
        summInfo.setTitle("考勤时间表");
        summInfo.setAuthor("刘泽榕");
        summInfo.setComments("本文档由 刘泽榕 提供");
        
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        SimpleDateFormat df = new  SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat f = new  SimpleDateFormat("HH:mm:ss");
        HSSFSheet sheet = workbook.createSheet("考勤时间表");
        //6. 创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("uid");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("name");
        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("groupname");
        HSSFCell cx;
        if(list.size()>0) {
        	List<Map<String, Object>> lmap = (List<Map<String, Object>>) list.get(0).get("list");
        	for (int i = 0; i < lmap.size(); i++) {
        		cx = r0.createCell(i+3);
                cx.setCellStyle(headerStyle);
                cx.setCellValue(df.format((Date)lmap.get(i).get("date")));
        	}
        	for (int i = 0; i < list.size(); i++) {
            	Map<String, Object> emp = list.get(i);
                HSSFRow row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue((Integer)emp.get("uid"));
                row.createCell(1).setCellValue((String)emp.get("name"));
                row.createCell(2).setCellValue((String)emp.get("groupname"));
                lmap = (List<Map<String, Object>>) emp.get("list");
                for (int j = 0; j < lmap.size(); j++) {
                	String str="无";
                	if(lmap.get(j).get("start")!=null)
                		str = f.format((Time)lmap.get(j).get("start"))+"到"+f.format((Time)lmap.get(j).get("end"));
                	row.createCell(j+3).setCellValue(str);
                }
        	}
        }
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
        	String name="考勤时间表("+start+"-"+end+").xls";
            headers.setContentDispositionFormData("attachment", new String(name.getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
	}
}

