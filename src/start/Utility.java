// name: itai damri 
//id: 318375714
package start;

import java.util.Arrays;
import java.util.Random;

import q1.MyDate;
import q2.Location;
import q2.Temperature;
import q3.Swimmable;

public class Utility {
	public static MyDate threeDates(MyDate []arr ) {//Checks a date that has 2 consecutive dates in a date set
		
		MyDate prev;
		MyDate next;
		for(int i=0;i<arr.length-1; i++) {
			MyDate curr=arr[i];
			prev=null;
			next=null;
			for(int j =0;j<arr.length-1;j++) {
				MyDate date=arr[j];
				if(j==i)
					continue;
				if(date.compareDate(curr.nextDate())==0) {
					next=date;
				}
				else if(date.nextDate().compareDate(curr)==0) {
					prev=date;
				}
				if(prev!=null & next!=null) {
					return prev;
				}
			}
			
		}
		MyDate ret =new MyDate();
		return ret;
	}

	public static int getMaxTemp(Location []arr ) {
		int highest=0;
		double max=arr[0].getAverage();
		for(int i=1;i<arr.length;i++) {
			if(arr[i].getAverage()>max) {
				highest=i;
				max=arr[i].getAverage();
			}
		}
		return highest;
		
	}
	public static void printAquarium(Swimmable[] arr) {
		System.out.println("Aquarium[type/color/actual size/eat count]:");
		for(Swimmable s: arr) {
			System.out.println(s);
		}
		System.out.println();
	}
	public static void feedAquaticAnimal(Swimmable[] arr,int max) {//get Array of  creatures from sea and amount of food and feeding them randomly
		Random r = new Random();
		int food;
		int min=1;
		for(Swimmable s: arr) {
			food=r.nextInt((max - min) + 1) + min;
			food+=s.getEatCount();
		}
		

	}
	public static int countAquaticAnimal(Swimmable[] arr) {//returns the amount of small sea creatures The size of the first sea creature in the array
		
		int first=arr[0].getSize(),count=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i].getSize()<first) {
				count++;
			}
		}
		return count;
	}
	public static void sortAquaticAnimal(Swimmable[] arr) {//sorting array of sea creatures by size of the creature
		Arrays.sort(arr);	
	}

}
