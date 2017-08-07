package odysseus.common.entities;

/**
 * Square defines the basic behavior of a square.
 * 
 * The square is crafted of a type and location.
 * The method playable() returns true if the type of square can be played
 * upon by another square; false if it can not be played upon.
 * 
 * The types of square are:
 * 	null
 * 	empty
 * 	filled
 * 	hint
 * 	release.
 * 
 * @author Carlos Barcelos
 * @author Michelle Gagnon
 * @author Andre Imperiali
 * @author Justin Myerson
 * @author Kevin Valente
 *
 */
public class Square implements java.io.Serializable {
	private int x1;
	private int y1;
	private String type; // Options: null, filled, empty, release, hint

	// Define the second point of the square
	public static final int WIDTH = 20;
	private int x2;
	private int y2;
	
	public Square(String type, int x1, int y1){
		this.type = type;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x1 + WIDTH;
		this.y2 = y1 + WIDTH;
	}
	
	
	/**
	 * A simple getter.
	 * 
	 * @return locationArray - The locations of the four corners of the square.
	 * 
	 * @author Justin Myerson
	 * @author Michelle Gagnon
	 * @author Carlos Barcelos
	 */
	public int[] getLocation(){
		int[] returnArray = {x1, y1, x2, y2};
		return returnArray;
	}
	
	// Simple getters for single coordinates of a square 
	public int getX() {return x1;}
	public int getY() {return y1;}
	public int getX2() {return x2;}
	public int getY2() {return y2;}
	public int getWidth() {return WIDTH;}
	
	/**
	 * A simple getter.
	 * 
	 * @return type - The type of the square.
	 * 
	 * @author Carlos Barcelos
	 */
	public String getType(){
		return type;
	}
	
	/**
	 * Returns the playable status, i.e. whether or not another square can be played above this one.
	 * 
	 * @return false - Squares are inherently not playable.
	 * 
	 * @author Justin Myerson
	 * @author Carlos Barcelos
	 * @author Michelle Gagnon
	 */
	public boolean playable(){
		if(type.equals("empty") || type.equals("hint") || type.equals("release")){
			return true;
		}
		return false;
	}
	
	/**
	 * Converts the object to string form in the form of (x1,y1):(x2,y2)type.
	 * 
	 * @return String representation of object
	 * 
	 * @author Carlos Barcelos
	 */
	public String toString () { 
		return "(" + x1 + "," + y1 + ":" + x2 + "," + y2 + ") " + type;
	}
}
