package odysseus.common.entities;


/**
 * The release square takes two more parameters to define the number and color associated with it.
 * 
 * Numbers: 1 - 6
 * Colors: Yellow = 1, Red = 2, Blue = 3
 * 
 * @author Carlos Barcelos
 * @author Justin Myerson
 */

public class ReleaseSquare extends Square{

	public final static int YELLOW = 1;
	public final static int RED = 2;
	public final static int BLUE = 3;
	
	private int number;
	private int color;
	private boolean isFilled;
	
	public ReleaseSquare(int x1, int y1, int number, int color){
		super("release",x1,y1);
		this.number = number;
		this.color = color;
		this.isFilled = false;
	}
	
	/**
	 * A simple getter.
	 * 
	 * @return The color of the release square.
	 */
	public int getColor(){
		return this.color;
	}
	
	/**
	 * A simple getter.
	 * 
	 * @return The number of the release squares.
	 */
	public int getNumber(){
		return this.number;
	}
	
	public boolean isFilled(){
		return this.isFilled;
	}
	
	@Override
	public boolean playable(){
		return true;
	}
	
}
