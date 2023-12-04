package gui;

import java.awt.Graphics;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JPanel;

import q3.Swimmable;

public class AquaPanel extends JPanel {
	public static HashSet<Swimmable> animals;

	public static CyclicBarrier Barrier;
	public static Integer food;
	private static  Lock lock;

	private static Lock pause;

	public Integer numOfWorms;
	public static  boolean isFood;
	private boolean suspend;

	public AquaPanel() {

		animals=new HashSet();
		numOfWorms=0;
		food=0;
		isFood=false;
		Barrier=new CyclicBarrier(1);
		lock= new ReentrantLock();
		pause= new ReentrantLock();
	}
	public void setAnimals(HashSet other) {
		this.animals = other;
	}
	

	public void paint(Graphics g) {//paint the food and the animals


			super.paint(g);
			if (isFood) {
				g.fillOval(600, 300, 10, 10);
				paintFood();
			}

			for (Swimmable p : animals) {
				p.drawAnimal(g);

			}

	}
	public synchronized void paintFood(){

		Barrier=new CyclicBarrier(animals.size());

		synchronized (lock){
			lock.notify();
		}
		try {
			Barrier.await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (BrokenBarrierException e) {

		}
	}

	public static void checkEat(Swimmable swim) throws InterruptedException {
		//update eats
		synchronized (food){
			if(food>0){
				food--;
				swim.eatInc();
				isFood=false;
			}
		}

	}


	public void addAnimal(Swimmable fish) {

		animals.add(fish);
		fish.addLock(lock);
	}

	public void stopRunning() {

		suspend=true;
		for (Swimmable swim : animals){

			swim.setSuspend();
		}
	}

	public void resumeRunning() {

		suspend=false;
		for (Swimmable swim : animals){

			swim.setResume();
		}
	}
}
