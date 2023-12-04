// name: itai damri 
//id: 318375714
package q2;

import start.Utility;

public class Location{
	private String name;
	private Temperature temp[];
	
	public Location(String name) {//constructors
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Temperature[] getTemp() {
		return temp;
	}
	public void setTemp(Temperature[] temp) {
		this.temp = temp;
	}
	//Prints location and list of temperature measurements or message no measurements
	public void printLocation(double range) {
		if(temp==null)
			System.out.println(name + " no temperature measurements in available");
		else {
		double avg=getAverage();
		double low=range - avg;
		double high=range + avg;
		double scale;
		System.out.print(name+" temperature measurements:");
		boolean flag=true;
		
		for(Temperature x:temp) {
			scale=x.getScale();
			if(scale<=high && scale>=low) {
				flag=false;
				System.out.print(x+"|");
			}
		}
		if(flag)
			System.out.print("no measurements in range");
		}
		System.out.println();
	}
	public void printLocation() {
		if(temp==null)
			System.out.println( name+" no temperature measurements in available ");
		else {
			System.out.print(name+" temperature measurements:");
			for(Temperature x:temp) 
					System.out.print(x+"|");
				
			}
		System.out.println();
		
	}
	public double getAverage() {//Returns average temperature for location
		double sum=0;
		if(temp==null)
			return sum;
		for(int i=0; i<temp.length;i++) {
			sum+=temp[i].getScale();
		}
		sum/=temp.length;
		return sum;
	}
	//get date and temperature and add to arr of temperature measurements
	public void addTemp(double scale,int d,int m,int y) {
		Temperature obj=new Temperature(scale,d,m,y);
		addTemp(obj);
		
	}
	public void addTemp(double scale) {	
		Temperature obj=new Temperature(scale);
		addTemp(obj);
	}
	public void addTemp(Temperature obj) {
		int i;
		if(temp==null) {
			temp=new Temperature[1];
			temp[0]=obj;
		}
		else {
			Temperature[] newArr=new Temperature[temp.length+1];
			for(i=0;i<temp.length;i++) {
				newArr[i]=temp[i];
			}
			newArr[i]=obj;
			temp=newArr;
		}
	}
	public Temperature getMax(){//return the max Temperature in the list of measurements
		if(temp==null)
			return null;
		double highest=temp[0].getScale();
		int j=0;
		for(int i=1;i<temp.length;i++) {
			if(temp[i].getScale()>highest) {
				j=i;
				highest=temp[i].getScale();
			}
		
		}
		return temp[j];
	}
}
	


