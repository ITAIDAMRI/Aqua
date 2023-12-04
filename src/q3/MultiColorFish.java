// name: itai damri 
//id: 318375714
package q3;

public class MultiColorFish extends Fish{
	  //constructor
	public MultiColorFish(int size,int x_front,int y_front,int horSpeed,int verSpeed,int col) {
		super(size, x_front, y_front, horSpeed, verSpeed, col);
	}
	
	public void changeFish() {//check if  the size changed and change the color if needs
		int oldSize =super.getSize();
	    super.changeFish();
	    if(oldSize!=getSize()) {
	    	changeColor();
	    }
	}
	public  String getAnimalName() {
    	return "MultiColorFish";
    }
}
