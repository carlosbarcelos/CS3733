package odysseus.common.entities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * A level is composed of a board, bullpen with pieces, and an objective for play.
 * 
 * The level is serializable and save to disk. Meeting score requirements gains stars
 * that are saved. Getting one star unlocks the next level. The first level is always
 * unlocked. The Level class is used as an abstract model for the special level types.
 * 
 * @author Carlos Barcelos
 *
 */
public abstract class AbsLevel implements java.io.Serializable {

	public Board board;
	public Bullpen bullpen;
	protected String levelType;
	protected int levelNumber;
	protected boolean isUnlocked;
	protected int numStars;
	protected List<Piece> pieces = new ArrayList<Piece>();
	int value;
	
	public AbsLevel(Board board, Bullpen bullpen, String levelType, int levelNumber, boolean isUnlocked, List<Piece> pieces){
		this.board = board;
		this.bullpen = bullpen;
		this.levelType = levelType;
		this.levelNumber = levelNumber;
		this.isUnlocked = isUnlocked;
		this.pieces = pieces;
		this.numStars = 0;
	}
	
	/**
	 * Saves a new level and all of its components to disk.
	 */
	public void saveLevel(){
	try{
			FileOutputStream outFile = new FileOutputStream("src/odysseus/leveldata/" + levelType + "/" + levelNumber + ".ser");
			ObjectOutputStream outObj = new ObjectOutputStream(outFile);
			outObj.writeObject(this);
			outObj.close();
			outFile.close();
			System.out.println(levelType + levelNumber + " successfully saved.");
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads an existing level and all of its components from disk.
	 * 
	 * @param levelNum - The number of the level that is to be opened.
	 * 
	 * @author Carlos Barcelos
	 */
	public AbsLevel loadLevel(int levelNum){
		 AbsLevel l;
	      try{
	         FileInputStream inFile = new FileInputStream("src/odysseus/leveldata/" + levelType + "/" + levelNum + ".ser");
	         ObjectInputStream inObj = new ObjectInputStream(inFile);
	         l = (AbsLevel) inObj.readObject();
	         inObj.close();
	         inFile.close();
	         System.out.println(levelType + levelNum + " successfully loaded.");
	         return l;
	      } catch(IOException i){
	         i.printStackTrace();
	         return null;
	      } catch(ClassNotFoundException c){
	         System.err.println(levelType + levelNum + "not found");
	         c.printStackTrace();
	         return null;
	      } catch(NullPointerException n){
	    	  System.err.println(levelType + levelNum + "not found"); 
	    	  n.printStackTrace();
	    	  return null;
	      }
	}
	
	/**
	 * Deletes the existing level from disk.
	 * 
	 * @author Carlos Barcelos
	 */
	public void deleteLevel(){
		File file = new File("src/odysseus/leveldata/" + levelType + "/" + levelNumber + ".ser");
		file.delete();
	}
	
	/**
	 * Overrideable method to determine if the game is over.
	 * @return false - to be overriden within each subclass.
	 * 
	 * @author Carlos Barcelos
	 */
	public boolean isOver(){
		return false;
	}
	/**
	 * A level is won when at least one star is acquired.
	 * @return true - at least one star earned.
	 * 
	 * @author Carlos Barcelos
	 */
	public boolean hasWon(){
		return starsEarned() >= 1;
	}
	
	/**
	 * Overidable method to determine how many stars are earned on a level.
	 * @return starsEarned - Number of stars earned based on level requirements.
	 * 
	 * @author Carlos Barcelos
	 */
	public int starsEarned(){
		return 0;
	}
	
	/** Ensure current move is a valid move.
	* Need to map the piece squares to the board squares.
	* Loop through and ensure none of the board squares are of type filled for puzzle/release.
	* For lightning, ensure none of the board squares are null squares.
	* 
	* @returns false.
	*/
	protected boolean isValid(){
		return false;
	}
	

	/**
	 * A simple getter.
	 * 
	 * @return the number assigned to value.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * A simple setter.
	 * 
	 * @param v- a random integer (in our case we use 17).
	 */
	public void setValue (int v) {
		value = v;
	}
	
	public boolean isUnlocked(){
		return isUnlocked;
	}
	
}