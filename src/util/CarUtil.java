package util;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CarUtil {
	
	/**
	 * 
	 * @param startDate
	 * @param startTime
	 * @return Date in valid format
	 * @throws Exception
	 */
	public Date stringToDate(String s, String t) throws Exception{
		Date date = null;
		Date presentDate = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(s.matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,4}.*") && stringToTime(t)){
			Date dateParsed = dateFormat.parse(s.concat(" " +t));
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateParsed);
			date = cal.getTime();
			
			Calendar todayCal = Calendar.getInstance();
			presentDate = todayCal.getTime();
			
			if(date.after(presentDate)){
				return date;
			}
			else
				System.out.println("\nStart Date cannot be past Date");
			
		}
		return null;
	}
	
	private boolean stringToTime(String inputTime) throws Exception{
			LocalTime.parse(inputTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
			return true;		
	}
	
	/**
	 * 
	 * @param startDate
	 * @param daysRequested
	 * @return endDate after adding daysRequested to startDate 
	 * @throws Exception
	 */
	public Date getEndDate(Date startDate, int daysRequested) throws Exception{
		if(startDate != null && daysRequested >= 1 ){
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			cal.add(Calendar.DATE, (daysRequested));
			return cal.getTime();
		}
		return null;
	}
	
}
