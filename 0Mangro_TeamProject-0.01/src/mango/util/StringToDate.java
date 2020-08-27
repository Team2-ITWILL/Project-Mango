package mango.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StringToDate {	
	
	// 년,월,일 -> java.sql.Date로 변환
	public static Date StringtoSqlDate(String year, String month, String day){
		String date = year + "-" + month + "-" + day;
		Date d = Date.valueOf(date);
		
		return d;
	}
	
	// yyyymmdd -> java.sql.Date로 변환
	public static Date StringtoSqlDate(String date){
		
		//현재 입력된 날짜 형식
		SimpleDateFormat before = new SimpleDateFormat("yyyymmdd");
		
		//Date 형식으로 변경
		SimpleDateFormat after = new SimpleDateFormat("yyyy-mm-dd");
		
		java.util.Date tempDate = null;
		
		try {
			tempDate = before.parse(date);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		
		// yyyy-mm-dd 형식 String 객체
		String transDate = after.format(tempDate);
		
		//String -> Date 변환
		Date d = Date.valueOf(transDate);
		
		return d;
		
	}
	
	// yyyy-mm-dd -> java.sql.Date
	public static java.sql.Date StringtoSqlDateFormatted(String day){		
		java.sql.Date d = java.sql.Date.valueOf(day);			
		return d;
	}
	
	
	
	// String -> Timestamp
	public static java.sql.Timestamp StringToTimestamp(String day){
		//String : "2016-11-22 11:22:30.0"
		java.sql.Timestamp t = java.sql.Timestamp.valueOf(day);		
		return t;
	}
	
	// String -> java.util.Date
	public static java.util.Date StringToUtilDate(String day) throws ParseException{
		//String : "2016-11-22"
		java.util.Date d = new java.text.SimpleDateFormat("yyyyMMdd").parse(day);
		return d;
	}
	
		
	/*public static void main(String[] args) {		
		StringToDate st = new StringToDate();		
		System.out.println(st.transformDate("2020", "08", "26"));
		System.out.println(st.transformDate("20200826"));		
	}*/	

}
