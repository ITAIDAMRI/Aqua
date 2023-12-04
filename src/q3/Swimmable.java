// name: itai damri 
//id: 318375714

package q3;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.CyclicBarrier;

import gui.AquaFrame;
import gui.AquaPanel;

public  abstract class Swimmable extends Thread implements Comparable   {
    protected int horSpeed;
    protected int verSpeed;
    protected Lock lock;
    protected Lock pause;
    
    public Swimmable(){
        horSpeed=0;
        verSpeed=0;
    }


    public Swimmable(int horSpeed, int verSpeed ){  //constructor
        this.horSpeed=horSpeed;
        this.verSpeed=verSpeed;
    }

    abstract public void run();

    public void setLock(Lock val){
        this.lock=val;
    }
    abstract public String getAnimalName();
    abstract public void drawAnimal(Graphics g);

    abstract public void setSuspend();
    abstract public void setResume();
    public int getHorSpeed(){return horSpeed;}
    public void setHorSpeed(int horSpeed){this.horSpeed=horSpeed;}
    public int getVerSpeed(){return verSpeed;}
    public void setVerSpeed(int verSpeed){this.verSpeed=verSpeed;}

    abstract public void setBarrier(CyclicBarrier b);

    abstract public int getSize();//get size of the swimmable
    abstract public void eatInc();//increases the amount of food
    abstract public int getEatCount();
    abstract public String getColor();
    public	 abstract void changeDerection();
    public abstract int getX_front();
    public abstract int getY_front();

    @Override
	public int compareTo(Object o) {//compare the sizes of the animals
    	if(getSize()==((Swimmable)o).getSize())
    		return 0;
    	else if(getSize()<((Swimmable)o).getSize())
    		return -1;
    	else {
    		return 1;
    	}
	}

    public String toString() {
    	String str=getAnimalName() +"\t" + getColor() + "\t" + String.valueOf(getSize())+ "\t" + String.valueOf(getEatCount());
    	return str;
    }

    public void addLock(Lock lock) {
        this.lock=lock;
    }
    public void addPause(Lock pause) {
        this.pause=pause;
    }
}
