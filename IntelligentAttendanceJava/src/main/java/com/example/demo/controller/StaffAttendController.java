package com.example.demo.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.ai.GsonUtils;
import com.example.demo.entity.*;

import com.example.demo.poi.POIUtils;
import com.example.demo.service.AttendanceMapperService;
import com.example.demo.service.CompetencegroupMapperService;
import com.example.demo.service.FixedworkdayMapperService;
import com.example.demo.service.GroupMapperService;
import com.example.demo.service.MustworkdayMapperService;
import com.example.demo.service.NotworkdayMapperService;
import com.example.demo.service.OverWorkMapperService;
import com.example.demo.service.StaffAttendMapperService;
import com.example.demo.service.UserMapperService;
import com.example.demo.service.UsergroupMapperService;

@Controller
@CrossOrigin
@RequestMapping("/StaffAttend")
public class StaffAttendController {
	@Autowired
    private StaffAttendMapperService service;
	@Autowired
    private UserMapperService service1;
	@Autowired
    private AttendanceMapperService attendanceservice;
	@Autowired
    private UsergroupMapperService Usergroupservice;
	@Autowired
    private OverWorkMapperService overWorkservice;
	@Autowired
    private UsergroupMapperService usergroup;
	@Autowired
    private GroupMapperService group;
	@Autowired
	private CompetencegroupMapperService competencegroupservice;
	@Autowired
	private FixedworkdayMapperService Fixedworkday;
	@Autowired
	private MustworkdayMapperService Mustworkday;
	@Autowired
	private NotworkdayMapperService Notworkday;
	
	@RequestMapping("/show")
    public String getIndex() {
        return "Accommodation";
    }
	
	/**@RequestMapping("/select")
	@ResponseBody
	public String selectOne() {
		Department de= service.selectOne(2);
		System.out.print(de.getDepartmentName());
        return "hello";
    }**/
	@GetMapping("/export")
    public ResponseEntity<byte[]> exportData(String start,String end) {
    	System.out.print(start+" "+end);
    	// 1.这一步就是查询你要导出的数据
    	List<Map<String, Object>> employeeList = this.getStatistics(start, end);
        // 2.创建一个 POIUtils 工具类进行导出操作
        return POIUtils.mouthExcel(employeeList,start,end);
    }
    @GetMapping("/DateExcel")
    public ResponseEntity<byte[]> DateExcel(String date) {
    	System.out.print(date);
    	// 1.这一步就是查询你要导出的数据
    	List<Map<String, Object>> employeeList = this.selectBydate(date);
        // 2.创建一个 POIUtils 工具类进行导出操作
        return POIUtils.DateExcel(employeeList, date);
    }
    @GetMapping("/EveryDateExcel")
    public ResponseEntity<byte[]> EveryDateExcel(String start,String end) {
    	System.out.print(start+" "+end);
    	// 1.这一步就是查询你要导出的数据
    	List<Map<String, Object>> employeeList = this.selectByEveryday(start, end);
        // 2.创建一个 POIUtils 工具类进行导出操作
        return POIUtils.EveryDateExcel(employeeList, start, end);
    }
	@RequestMapping("/getStatistics")
	@ResponseBody
	public List<Map<String, Object>> getStatistics(String start,String end) {
		//System.out.print(start+" "+end);
		List<Map<String, Object>> reslist=new java.util.ArrayList<>();
		List<User> list= service1.selectAll();
		Map<String, Object> map;
		Map<String, Object> res;
		for(int i=0;i<3;i++) {
			res= new java.util.HashMap<>();
			res.put("id", list.get(i).getId());res.put("name", list.get(i).getName());res.put("groupname",Usergroupservice.selectById(list.get(i).getId()).getGroupname());
			map= new java.util.HashMap<>();//"2021-03-14""2021-03-20"
			map.put("uid", list.get(i).getId());map.put("start",start);map.put("end",end);map.put("str", "休息");
			res.put("出勤天数", service.selectAttnum(map));map.put("str", "休息");
			res.put("休息天数", service.selectNum(map));map.put("str", "缺勤");
			res.put("缺勤天数", service.selectNum(map));map.put("str", "迟到");
			res.put("迟到天数", service.selectNum(map));map.put("str", "早退");
			res.put("早退天数", service.selectNum(map));map.put("str", "上班缺卡");
			res.put("上班缺卡次数", service.selectNum(map));map.put("str", "下班缺卡");
			res.put("下班缺卡次数", service.selectNum(map));
			res.put("工作时长/分", service.selectWorkTime(map));map.put("str", "早退");
			Calendar c = Calendar.getInstance();map.put("latetime",c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DATE) + " " +"10:10:11");
			res.put("早退时长/分", service.selectLateTime(map));map.put("str", "迟到");
			map.put("latetime",c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DATE) + " " +"18:10:11");
			res.put("迟到时长/分", service.selectLeaveTime(map));
			map.put("userid", list.get(i).getId());map.put("str", "工作日");res.put("加班时长(全部)/分", overWorkservice.selectOverworkAll(map));
			res.put("加班时长(工作日)/分",overWorkservice.selectOverworkType(map));map.put("str", "休息日");
			res.put("加班时长(休息日)/分",overWorkservice.selectOverworkType(map));map.put("str", "节假日");
			res.put("加班时长(节假日)/分",overWorkservice.selectOverworkType(map));map.put("str", "转调休");
			res.put("加班时长(转调休)/分",overWorkservice.selectOverworkResType(map));map.put("str", "转加班费");
			res.put("加班时长(转加班费)/分",overWorkservice.selectOverworkResType(map));
			reslist.add(res);
		}
		//System.out.print(de.getAddress());
        return reslist;
    }
	@RequestMapping("/select")
	@ResponseBody
	public StaffAttend selectOne() {
		StaffAttend de= service.selectById(1);
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<StaffAttend> selectAll() {
		 List<StaffAttend> de= service.selectAll();
		//System.out.print(de.getAddress());
        return de;
    }
	@RequestMapping("/selectByEveryday")
	@ResponseBody
	public List<Map<String,Object>> selectByEveryday(String start,String end) {
		List<User> list= service1.selectAll();
		List<Map<String,Object>> lists=new java.util.ArrayList<>();
		Map<String,Object> map = new java.util.HashMap<>();
		for(int i=0;i<3;i++) {
			Map<String,Object> listmap=new java.util.HashMap<>();
			listmap.put("uid", list.get(i).getId());
			listmap.put("name", list.get(i).getName());listmap.put("groupname",Usergroupservice.selectById(list.get(i).getId()).getGroupname());
			map.put("uid", list.get(i).getId());map.put("start",start);map.put("end",end);
			listmap.put("list", service.selectByEveryday(map));
			lists.add(listmap);
		}
        return lists;
    }
	@RequestMapping("/selectBydate")
	@ResponseBody
	public List<Map<String,Object>> selectBydate(String str) {
		//System.out.print(de.getAddress());
		List<Map<String,Object>> lists = service.selectBydate(str);
		Map<String,Object> map = new java.util.HashMap<>();
		map.put("start", str);map.put("end", str);
		for(int i=0;i<lists.size();i++) {
			//System.out.print(lists.get(i).get("userid"));
			map.put("userid", lists.get(i).get("userid"));
			Usergroup ug=Usergroupservice.selectById((int)lists.get(i).get("userid"));
			lists.get(i).put("加班时长", overWorkservice.selectOverworkAll(map));
			lists.get(i).put("name",ug.getUsername());
			lists.get(i).put("groupname", ug.getGroupname());
		}
        return lists;
    }
	@RequestMapping("/selectAttnum")
	@ResponseBody
	public int selectAttnum() {
		Map<String, Object> map= new java.util.HashMap<>();
		map.put("uid", 1);map.put("start", "2020-11-07");map.put("end", "2020-11-08");map.put("str", "休息");
		
		//System.out.print(de.getAddress());
        return service.selectAttnum(map);
    }
	@RequestMapping("/selectNum")
	@ResponseBody
	public int selectNum() {
		Map<String, Object> map= new java.util.HashMap<>();
		map.put("uid", 1);map.put("start", "2020-11-07");map.put("end", "2020-11-08");map.put("str", "早退");
		//System.out.print(de.getAddress());
        return service.selectNum(map);
    }
	@RequestMapping("/selectWorkTime")
	@ResponseBody
	public int selectWorkTime() {
		Map<String, Object> map= new java.util.HashMap<>();
		map.put("uid", 1);map.put("start", "2021-03-14");map.put("end", "2021-03-20");map.put("str", "早退");
		//System.out.print(de.getAddress());
        return service.selectWorkTime(map);
    }
	@RequestMapping("/selectLateTime")
	@ResponseBody
	public int selectLateTime() throws ParseException {
		Map<String, Object> map= new java.util.HashMap<>();
		Calendar c = Calendar.getInstance();
		map.put("uid", 1);map.put("start", "2020-11-07");map.put("end", "2020-11-08");map.put("str", "早退");
		map.put("latetime",c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DATE) + " " +"10:10:11");
        return service.selectLateTime(map);
    }
	@RequestMapping("/selectLeaveTime")
	@ResponseBody
	public int selectLeaveTime() {
		Map<String, Object> map= new java.util.HashMap<>();
		Calendar c = Calendar.getInstance();
		map.put("uid", 1);map.put("start", "2020-11-07");map.put("end", "2020-11-08");map.put("str", "迟到");
		map.put("latetime",c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DATE) + " " +"18:10:11");
        return service.selectLeaveTime(map);
    }
	@RequestMapping("/selectCondition")
	@ResponseBody
	public List<StaffAttend> selectCondition(@RequestParam Map<String,Object> map) {
		System.out.println(map.get("userid"));
		System.out.println(map.get("state"));
		//String date= (String) map.get("date");
		//map.put("date", date.subSequence(0, 10));
		System.out.println(map.get("date"));
		System.out.print("dads");
		
		List<StaffAttend> de= service.selectCondition(map);
		
        return de;
    }
	@RequestMapping("/insert")
	@ResponseBody
	public void insert(StaffAttend information) {
		service.insert(information);
		System.out.print("insert");
    }
	@RequestMapping("/insertStaff")
	@ResponseBody
	public void insertStaff(@RequestParam Map<String,Object> map) {
		//System.out.println(map.get("date"));
		Date date=Date.valueOf((String) map.get("date"));
		//System.out.println(date);
		List<User> users=service1.selectAll();
		Usergroup Usergroup;//查询员工考勤组
		Group Group ;//查询员工考勤组
		Competencegroup competencegroup ;  //查询员工考勤组;
		String freeWorkday[] ; //自由考勤的日期规定
		List<Fixedworkday> fixedworkday ; //固定考勤的日期规定
		List<Mustworkday> mustworkday ;//必须考勤的时间
		List<Notworkday> notworkday;//无需考勤的时间
		Calendar cal = Calendar.getInstance();cal.setTime(date);
		int week = cal.get(Calendar.DAY_OF_WEEK);//获得该日期是一周中的第几天（周日是第一天）
		for(int i=0;i<users.size();i++)
		{
			StaffAttend sa= new StaffAttend();
			sa.setUserid(users.get(i).getId());sa.setState("缺席");sa.setDate(date);
			Usergroup=usergroup.selectByusername(users.get(i).getName());//查询员工考勤组
			Group = group.selectById(Usergroup.getGroupname());//查询员工考勤组
			competencegroup = competencegroupservice.selectByname(Group.getClassname());  //查询员工考勤组
			freeWorkday = competencegroup.getFreeWorkday().split(""); //自由考勤的日期规定
			fixedworkday = Fixedworkday.selectBygid(competencegroup.getId()); //固定考勤的日期规定
			mustworkday = Mustworkday.selectBygid(competencegroup.getId());//必须考勤的时间
			Map<Date,String> hashMustday = new java.util.HashMap<>();
			for (Mustworkday x : mustworkday) {   
				hashMustday.put(Date.valueOf(x.date.substring(0,10)),x.times);  
		     }  
			notworkday = Notworkday.selectBygid(competencegroup.getId());
			Map<Date,String> hashNotday = new java.util.HashMap<>();
			for (Notworkday x : notworkday) {   
				hashNotday.put(Date.valueOf(x.date.substring(0,10)),"1");  
		     }
			if(hashNotday.containsKey(date)) {
				sa.setState("休息");sa.setStart(Time.valueOf("09:00:00"));sa.setEnd(Time.valueOf("17:00:00"));
			}
			else if(!hashMustday.containsKey(date)) {
				if((competencegroup.stytle.equals("1")&&fixedworkday.get((week+5)%7).getTimes().equals("休息"))||
						(freeWorkday[(week+5)%7].equals("0")&&competencegroup.stytle.equals("2"))) {
					sa.setState("休息");sa.setStart(Time.valueOf("09:00:00"));sa.setEnd(Time.valueOf("17:00:00"));
				}
					
			}
			service.insert(sa);
		}
		System.out.print("insert");
    }
	@RequestMapping("/delete")
	@ResponseBody
	public void delete() {
		service.deleteById(2);;
		System.out.print("delete");
    }
	@RequestMapping("/update")
	@ResponseBody
	public void update(StaffAttend information) {
		service.update(information);;
		System.out.print("update");
    }
	@RequestMapping("/getType") //获取考勤方式
	@ResponseBody
	public Competencegroup sign(String username) {
		Usergroup Usergroup=usergroup.selectByusername(username);//查询员工考勤组
		if(Usergroup == null)
			return null;
		Group Group = group.selectById(Usergroup.getGroupname());//查询员工考勤组
		Competencegroup competencegroup = competencegroupservice.selectByname(Group.getClassname());  //查询员工考勤组
		return competencegroup;
	}
	@RequestMapping("/sign") //考勤方法
	@ResponseBody
	public String sign(@RequestParam Map<String,Object> map) throws ParseException {
		String username = (String) map.get("username");
		System.out.println(username);
		System.out.println((String) map.get("date"));
		Usergroup Usergroup=usergroup.selectByusername(username);//查询员工考勤组
		if(Usergroup == null)
			return "没有该员工！";
		Group Group = group.selectById(Usergroup.getGroupname());//查询员工考勤组
		Competencegroup competencegroup = competencegroupservice.selectByname(Group.getClassname());  //查询员工考勤组
		String freeWorkday[] = competencegroup.getFreeWorkday().split(""); //自由考勤的日期规定
		List<Fixedworkday> fixedworkday = Fixedworkday.selectBygid(competencegroup.getId()); //固定考勤的日期规定
		List<Mustworkday> mustworkday = Mustworkday.selectBygid(competencegroup.getId());//必须考勤的时间
		Map<Date,String> hashMustday = new java.util.HashMap<>();
		for (Mustworkday x : mustworkday) {   
			hashMustday.put(Date.valueOf(x.date.substring(0,10)),x.times);  
	     }  
		List<Notworkday> notworkday = Notworkday.selectBygid(competencegroup.getId());//无需考勤的时间
		Map<Date,String> hashNotday = new java.util.HashMap<>();
		for (Notworkday x : notworkday) {   
			hashNotday.put(Date.valueOf(x.date.substring(0,10)),"1");  
	     } 
		String str=(String) map.get("date");
		Date date=Date.valueOf(str.substring(0,10));
		Time time=Time.valueOf(str.substring(11,19));
		Calendar cal = Calendar.getInstance();cal.setTime(date);
		int week = cal.get(Calendar.DAY_OF_WEEK);//获得该日期是一周中的第几天（周日是第一天）
		
		System.out.println(date);
		System.out.println(time);
		System.out.println(week);
		StaffAttend sa= new StaffAttend();
		sa.setDate(date);
		sa.setUserid(Usergroup.getUserid());
		StaffAttend update=service.selectAttend(sa);
		if(update==null)
			return "签到失败！签到日期错误";
		if(competencegroup.stytle.equals("1"))
			return this.fiexdsign(update,sa,date,time,week,fixedworkday,hashMustday,hashNotday);
		else
			return this.freesign(update,sa,date,time,week,freeWorkday,hashMustday,hashNotday);
		
		//return "测试";
    }
	public String freesign(StaffAttend update,StaffAttend sa,Date date,Time time,int week,String freeWorkday[],
			Map<Date,String> hashMustday,Map<Date,String> hashNotday) throws ParseException {
		if(hashNotday.containsKey(date))
			return "休息日不用考勤1";
		else if(freeWorkday[(week+5)%7].equals("0")&&!hashMustday.containsKey(date))
			return "休息日不用考勤2";
		Time start=Time.valueOf("12:00:00");
		Time end=Time.valueOf("17:00:00");
		if(update.getStart()==null)
		{
			//sa=new StaffAttend();
			sa.setId(update.getId());
			sa.setStart(time);
			sa.setState("下班缺卡");
			if(start.before(time)) {
				sa.setStart(start);
				sa.setEnd(time);
				sa.setState("上班缺卡");
			}
			service.update(sa);
			return "上班签到";
		}
		else if(update.getEnd()==null)
		{
			//sa=new StaffAttend();
			sa.setId(update.getId());
			sa.setEnd(time);
			sa.setState("正常");
			service.update(sa);
			return "下班签到";
		}
		return "今日以签到两次，别点了！";
		
	}
	public String fiexdsign(StaffAttend update,StaffAttend sa,Date date,Time time,int week,List<Fixedworkday> fixedworkday,
			Map<Date,String> hashMustday,Map<Date,String> hashNotday) throws ParseException {
		if(hashNotday.containsKey(date))
			return "休息日不用考勤";
		else if(fixedworkday.get((week+5)%7).getTimes().equals("休息")&&!hashMustday.containsKey(date))
			return "休息日不用考勤";
		String[] times = fixedworkday.get((week+5)%7).getTimes().split("-");
		if(hashMustday.containsKey(date))
			times=hashMustday.get(date).split("-");
		Time lstart = Time.valueOf("12:00:00");
		Time lend = Time.valueOf("17:00:00");
		Time start= Time.valueOf(times[0].concat(":00"));
		Time end= Time.valueOf(times[1].concat(":00"));
		System.out.println(start+"-"+end);
		if(update.getStart()==null)
		{
			//sa=new StaffAttend();
			sa.setId(update.getId());
			sa.setStart(time);
			sa.setState("下班缺卡");
			if(time.after(lstart))
				sa.setState("上班缺卡");
			else if(time.before(lstart)&&time.after(start))
				sa.setState("迟到");
			else if(end.before(time))
				return "你已缺席今天的考勤，别点了";
			service.update(sa);
			return "上班签到";
		}
		else if(update.getEnd()==null)
		{
			//sa=new StaffAttend();
			sa.setId(update.getId());
			sa.setEnd(time);
			if(time.before(start))
				return "现在还不能打卡";
			else {
				if(update.getState().equals("下班缺卡"))
				{
					if(end.before(time))
						sa.setState("正常");
					else
						sa.setState("早退");
				}
				else if(update.getState().equals("上班缺卡"))
				{
					if(end.after(time))
						sa.setState("迟到早退");
				}
				else if(update.getState().equals("迟到"))
				{
					if(end.after(time))
						sa.setState("迟到早退");
				}
			}
			service.update(sa);
			return "下班签到";
		}
		System.out.println(update.toString());
		System.out.println("insert");
		return "今日以签到两次，别点了！";	
	}
	@RequestMapping("/getMathScore") //获取人脸对比分数
	@ResponseBody
	public float getMathScore(@RequestParam Map<String,String> map) {
		String username = map.get("username");//用户姓名
		String ailogin = map.get("ailogin");//用户登陆图像
		User user = service1.selectByName(username); //用户信息
		String accessToken=com.example.demo.ai.acccessKey.getAuth();//获取平台key
		Map<String,String> mathMap= new HashMap<String, String>();map.put("image", ailogin.substring(22));map.put("liveness_control", "NORMAL");
        map.put("group_id_list", "2021_03_lzr");map.put("image_type", "BASE64");map.put("quality_control", "LOW");
        map.put("user_id", ""+user.getId());
    	String param = GsonUtils.toJson(map);
    	String res=com.example.demo.ai.FaceSearch.faceSearch(param, accessToken);
    	Airesult result = GsonUtils.fromJson(res, Airesult.class);
    	if(result.getResult()!=null)
    		return result.getResult().getUser_list().get(0).getScore();
		return 0;
	}
}
