// name: itai damri 
//id: 318375714
package q3;

import gui.AquaPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;

public class Jellyfish extends Swimmable {
	private boolean up_y=false;
	private boolean up_x=false;
    private int EAT_DISTANCE;
    private int size;
    private int col;
    private int eatCount;
    private int x_front;
    private int y_front;
    private int x_dir;
    private int y_dir;
	private boolean suspend;

  //constructors
    public Jellyfish(int size,int x_front,int y_front,int horSpeed,int verSpeed,int col) {
    	super(horSpeed,verSpeed);
        this.EAT_DISTANCE = 4;
        this.size = size;
        this.col = col;
        this.eatCount = 0;
        this.x_front = x_front;
        this.y_front = y_front;
        this.x_dir = 1;
        this.y_dir = 1;
        
    }
    public int getEAT_DISTANCE() {//get the amount of food that the fish need to get bigger
		return EAT_DISTANCE;
	}
	public void setEAT_DISTANCE(int eAT_DISTANCE) {
		EAT_DISTANCE = eAT_DISTANCE;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public void setEatCount(int eatCount) {
		this.eatCount = eatCount;
	}
	public int getX_front() {
		return x_front;
	}
	public void setX_front(int x_front) {
		this.x_front = x_front;
	}
	public int getY_front() {
		return y_front;
	}
	public void setY_front(int y_front) {
		this.y_front = y_front;
	}
	public int getX_dir() {
		return x_dir;
	}
	public void setX_dir(int x_dir) {
		this.x_dir = x_dir;
	}
	public int getY_dir() {
		return y_dir;
	}
	public void setY_dir(int y_dir) {
		this.y_dir = y_dir;
	}
	public String getColor() {
	        if(col==0) {
	        	return "green";
	        }
	        else if(col==1) {
	        	return "blue";
	        }
	        else if(col==2) {
	        	return "yellow";
	        }
	        else if(col==3) {
	        	return "black";
	        }
	        else if(col==4) {
	        	return "red";
	        }
	        return "black";
    }
    public void changeJellyfish(){// making the jellyfish bigger
    	if(EAT_DISTANCE<=eatCount) {
    		size+=1;
    		eatCount=0;
    	}
    }
    public void changeColor() {//change the color to the next in list
    	col+=1;
    	if(col==10)
    		col=1;
    	
    }

	@Override
	public void run() {

		try {
			while (true) {

				if (!suspend) {
					synchronized (lock) {
						lock.wait();

					}
					AquaPanel.Barrier.await();
					if (AquaPanel.food > 0) {
						if (Math.abs(this.y_front - 300) <= verSpeed && Math.abs(this.x_front - 600) <= horSpeed) {
							AquaPanel.checkEat(this);
						}
						changeDerection();
					}
				}
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}



	public  String getAnimalName() {
    	return "Jellyfish";
    }
    public  int getEatCount() {
    	return eatCount;
    }
    public  void eatInc() {//Increase the amount of food the animal has eaten by 1
    	eatCount++;
    }
    public void drawAnimal(Graphics g) {//draw jellyfish

		Color[] colors = {Color.green, Color.blue, Color.yellow, Color.black, Color.red};
		Color color = colors[col];
		g.setColor(color);
		int numLegs;
		if (size < 40)
			numLegs = 5;
		else if (size < 80)
			numLegs = 9;
		else
			numLegs = 12;
		g.setColor(color);
		g.fillArc(x_front - size / 2, y_front - size / 4, size, size / 2, 0, 180);
		for (int i = 0; i < numLegs; i++){
			g.drawLine(x_front - size / 2 + size / numLegs + size * i / (numLegs + 1),
					y_front, x_front - size / 2 + size / numLegs + size * i / (numLegs + 1),
					y_front + size / 3);
		}
		if(!suspend) {//repaint the screen if suspend is false
			if (up_y == false) {//check if the jellyfish Reached the edge of the screen and changed direction

				if (y_front >= 600) {
					up_y = true;
					y_front -= verSpeed;

				} else {
					y_front += verSpeed;
				}

			} else if (up_y == true) {
				if (y_front <= 1) {
					up_y = false;
					y_front += verSpeed;

				} else {
					y_front -= verSpeed;
				}
			}
			if (up_x == false) {
				if (x_front >= 1200) {
					up_x = true;
					x_front -= verSpeed;

				} else {
					x_front += verSpeed;
				}

			} else if (up_x == true) {
				if (x_front <= 1) {
					up_x = false;
					x_front += verSpeed;
				} else {
					x_front -= verSpeed;
				}
			}
		}
	}
	@Override
	public void setSuspend() {

		suspend = true;
	}

	@Override
	public void setResume() {

		suspend=false;
	}

	@Override
	public void setBarrier(CyclicBarrier b) {

	}

	public void changeDerection() {

		if(this.y_front<300 && this.up_y)
			this.up_y=false;
		if(this.y_front>300 && !this.up_y)
			this.up_y=true;
		if(this.x_front<600 && this.up_x)
			this.up_x=false;
		if(this.x_front>600 && !this.up_x)
			this.up_x=true;
    }
    
}


