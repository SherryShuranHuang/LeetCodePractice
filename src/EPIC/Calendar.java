package EPIC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/*
 * Get a date (mon/day/year) from user. Print exact the week of dates 
 * (Sun to Sat). ex) input: 2/20/2001 if the day is Wednesday 
 * output: Sunday 2/17/2001 
 * Monday 2/18/2001
 * Tuesday 2/19/2001 
 * Wednesday 2/20/2001
 * Thursday 2/21/2001 
 * Friday 2/22/2001 
 * Saturday 2/23/2001
 */ 
import java.util.GregorianCalendar;

class Calendar {
	public static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static void main(String[] args){
		//findWeek(2,27,2016,3);   // solutionB
		String dt = "04/13/2015";  //solutionA
		printWeek(dt);
	}
	/**
	 * solutionA, use library to achieve
	 * @param str
	 */
	public static void printWeek(String str) {
		SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sft = new SimpleDateFormat("E MM/dd/yyyy");
		try {
			Date date = ft.parse(str);
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(date);
			int temp = cal.get(GregorianCalendar.DAY_OF_WEEK);
			while (temp > 0) {
				cal.add(GregorianCalendar.DATE, -1);
				temp--;
			}
			while (temp < 7) {
				cal.add(GregorianCalendar.DATE, 1);
				System.out.println(sft.format(cal.getTime()));
				temp++;
			}
		} catch (ParseException e) {
			System.out.println("Unparsable");
		}

	}
	
	/**
	 * solutionB, need the whichDay input
	 * 
	 */
	public static void findWeek(int month, int day, int year, int whichDay){
		for(int i=whichDay;i>0;i--){
			if(day==1){
				if(month==1){
					year--;
					month=12;
					day = numOfDaysInMonthAndYear(month,year);
					
				}else{
					month--;
					day = numOfDaysInMonthAndYear(month,year);
				}
			}
			else{
				day--;
			}
		}
		
		for(int i=0;i<7;i++){
			printDay(month,day,year,i);
			day++;
			if(day>numOfDaysInMonthAndYear(month,year)){
				day=1;
				month++;
				if(month>12){
					month=1;
					year++;
				}
			}
		}
		
	}
	private static int numOfDaysInMonthAndYear(int month, int year){
		if(isLeapYear(year) && month==2)
			return 29;
		else return days[month];
	}
	private static boolean isLeapYear(int year){
		return (year%4==0); 
	}
	public static void printDay(int month, int day, int year, int whichDay) {
		String d = new String();
		switch(whichDay) {
			case 0:
				d = "Sunday";
				break;
			case 1:
				d = "Monday";
				break;
			case 2:
				d = "Tuesday";
				break;
			case 3:
				d = "Wednesday";
				break;
			case 4:
				d = "Thursday";
				break;
			case 5:
				d = "Friday";
				break;
			case 6:
				d = "Saturday";
				break;
			default:
				break;
		}
		System.out.println(d + " " + month + "/" + day + "/" + year);
	}

}
