// name: itai damri 
//id: 318375714
package q2;
import java.awt.Point;
import java.time.LocalDate;
import java.util.Scanner;

import q1.MyDate;

public class Temperature  {
	
	private double scale;
	private MyDate scale_date;
	//constructors
	public Temperature(double scale, int d, int m, int y) {
		this.scale_date=new MyDate(d,m,y);
		this.scale=scale;
		
	}
	public Temperature(double scale) {
		this.scale_date=new MyDate();
		this.scale=scale;
	}
	public Temperature(Temperature other) {
		scale=other.scale;
		scale_date=new MyDate(other.scale_date);
	}
	public double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
	}
	public MyDate getScale_date() {
		return scale_date;
	}
	public void setScale_date(MyDate scale_date) {
		this.scale_date = scale_date;
	}
	public String toString() {
		String temp=scaleToString();
		temp+=scale_date.toString();
		return temp;
	}
	public void printTemp() {//print Temperature in C format temp
		System.out.println(scaleToString());
	}
	public String scaleToString() {
		String temp="";
		if(scale>0)
			temp+="+";
		temp+=scale + ""+ (char)176 + "C " ;
		return temp;
	}
	public void printTempFull() {//Prints  date in format yyyy / mm / dd and temperature in C ° temp format
		System.out.println(this);
	}
	public Temperature compareTemp(Temperature obj) {//Returns an object with the highest temperature between the two
		if(this.scale<obj.scale)
			return obj;
		else 
			return this;
	}
}
