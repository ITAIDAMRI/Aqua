// name: itai damri 
//id: 318375714
package q3;

public class UnusualFish extends Fish {
	private int factor;
	//constructor
	public UnusualFish(int size,int x_front,int y_front,int horSpeed,int verSpeed,int col,int factor) {
		super(size, x_front, y_front, horSpeed, verSpeed, col);
		this.factor=factor;
	}

	public int getFactor() {
		return factor;
	}

	public void setFactor(int factor) {
		this.factor = factor;
	}
	public int getSize() {
		return super.getSize()*factor;
	}
	public  String getAnimalName() {
    	return "UnusualFish";
    }
}
