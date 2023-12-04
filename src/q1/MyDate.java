// name: itai damri 
//id: 318375714
package q1;
import java.time.LocalDate;
import java.time.*;


public class MyDate {

	private int day;
		private int month;
		private int year;
	public MyDate() {
		create();
	}
	public MyDate(int d,int m,int y) { //constructor
		boolean flag=false;
		if(CheckDay(d) &&CheckMonth(m) &&CheckYear(y)) {
			flag=true;
		}
		
		if(flag == false) {
			create();
		}
		else {
			day=d;
			month=m;
			year=y;
		}
	}
	//constructor
	public MyDate(MyDate other) {
		day=other.day;
		month = other.month;
		year= other.year;
	}
	public void create() {//constructor
		LocalDate d=LocalDate.now();
		day =d.getDayOfMonth();
		month =d.getMonthValue();
		year =d.getYear();
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(CheckDay(day))
			this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(CheckYear(month))
			this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(CheckYear(year))
			this.year = year;
	}
	public boolean CheckDay(int d) {//check if the day number in the month is correct 
		if(d<1 || d>getMonthDay()) {
			return false;
		}
		return true;
	}
	public boolean CheckMonth(int m) {//check if the month is correct 
		if(m<1 || m>12) {
			return false;
		}
		return true;
	}
	public boolean CheckYear(int y) {
		if(y<1900 || y>2100) {
			return false;
		}
		return true;
	}
	public String toString() {
		String Date="";
		if(day<10) {
			Date="0";
		}
		Date+=String.valueOf(day)+"/";
		if(month<10) {
			Date+="0";
		}
		Date+=String.valueOf(month)+"/"+String.valueOf(year);
		return Date;
	}
	public void printDate() {
		System.out.print(this);
	}
	public void printMonthName() {
		String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
		String Date= String.valueOf(day)+ " "+ months[month-1] + " "+ String.valueOf(year);
		System.out.print(Date);
	}
	public int getMonthDay() {//Returns the number of days in a month
		int daysInMonth;
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			   daysInMonth = 30;
			} else if (month == 2) {
			    daysInMonth = (isLeapYear()) ? 29 : 28;
			}
			else { 
			    daysInMonth = 31;
			}
		return daysInMonth;
	}
	public boolean isLeapYear() { // check if the year is leap 
		Year y = Year.of(year);
		return y.isLeap();
	}
	public MyDate nextDate() {//return next day 
		MyDate date2;
		if(day<getMonthDay()) {
			date2=new MyDate(day+1,month,year);
			return date2;
		}
		else if(month<12) {
			date2=new MyDate(1,month+1,year);
			return date2;
		}
		else{
			date2=new MyDate(1,1,year+1);
			return date2;
		}
	}
	public void printFormatDate(String format) {// format date like "dd/mm/yy
		if(format=="ddmmyyyy") {
			System.out.print(this);
		}
		else if(format=="ddMMyyyy") {
			printMonthName();
		}
		else if (format== "ddmmyy") {
			String date=this.toString();
			System.out.print(date.substring(0,6)+ date.substring(8,10));
		}
		else if(format == "mmddyyyy") {
			String date=this.toString();
			System.out.print(date.substring(3,6)+ date.substring(0,3) +date.substring(6,10));
		}
		else if(format == "yyyymmdd") {
			String date=this.toString();
			System.out.print(date.substring(6,10)+ date.substring(2,6) +date.substring(0,2));
		}
	}
	public int compareDate(MyDate obj) {//compare between date
		if(this.year==obj.year && this.month==obj.month && this.day==obj.day )
			return 0;
		else if(this.year<obj.year) {
			return -1;
		}
		else if(this.year==obj.year && this.month<obj.month)
			return -1;
		else if(this.year==obj.year && this.month==obj.month && this.day<obj.day )
			return -1;	
		return 1;
	}

}
