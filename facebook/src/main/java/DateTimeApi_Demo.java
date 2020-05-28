import java.util.Date;
import java.util.Formatter;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class DateTimeApi_Demo {

	public static void main(String[] args) {
		//useOlderDate();
		useJdk8Date();
		//useJdk8Time();

	}
	private static void useOlderDate() {
		Date date=new Date(114, 2, 18);
		System.out.println(date);
		
		//System.out.println(forrmattes.get.format(date));
		Calendar cc=Calendar.getInstance();
		cc.set(2014, Calendar.FEBRUARY,18);
		System.out.println(cc);
	}
	
	private static void useJdk8Date() {
		LocalDate date=LocalDate.of(2014, 3, 18);
		
		DateTimeFormatter ff=DateTimeFormatter.ofPattern("d. MMMM yyyy",Locale.ITALIAN);
		System.out.println(date.format(ff));
		
		
		System.out.println("jdk8 local date "+date);
		
		System.out.println(date.getYear());
		Month m=date.getMonth();
		System.out.println(m);
		int day=date.getDayOfMonth();
		System.out.println(day);
		DayOfWeek dow=date.getDayOfWeek();
		System.out.println(dow);
		int length=date.lengthOfMonth();
		System.out.println(length);
		boolean b=date.isLeapYear();
		
		System.out.println(b);
	}
	
	private static void useJdk8Time() {
		LocalTime time=LocalTime.of(13, 45, 20);
		System.out.println(time.getMinute());
		
		LocalDateTime dt1=LocalDateTime.of(2014,Month.MAY,28, 12,40,33);
		
		Duration d1=Duration.between(LocalTime.of(13, 45, 20), LocalTime.of(13, 45, 28));
		System.out.println(d1.getSeconds());
		
		
		
		
	}
	

}































