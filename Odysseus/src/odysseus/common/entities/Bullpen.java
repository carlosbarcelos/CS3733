package odysseus.common.entities;

import java.util.*;

/**
 * The Bullpen stores the pieces for a level.
 * 
 * Only in the bullpen can a piece be rotated or flipped.
 * The bullpen keeps a record of the pieces that it currently has for outside use.
 * 
 * @author Carlos Barcelos
 * @author Justin Myerson
 *
 */
public class Bullpen implements java.io.Serializable{
	private int numPieces;
	private ArrayList<Piece> pieces = new ArrayList<Piece>();

	public Bullpen(ArrayList<Piece> pieces){
		this.pieces = pieces;
		this.numPieces = pieces.size();

	}


	public Bullpen(){
		this.numPieces = 0;	
	}

	/**
	 * Returns the filled status of the board.
	 * 
	 * @return true - when the board is empty.
	 * 
	 * @author Carlos Barcelos
	 */
	// Check if the current bullpen is empty
	public boolean empty(){
		return pieces.isEmpty();
	}

	/**
	 *  Add piece to bullpen.
	 * @param p - The piece being used.
	 * 
	 * @author Carlos Barcelos
	 */
	public void add(Piece p){
		pieces.add(p);
		numPieces++;
	}

	/**
	 *  Remove and return piece from bullpen.
	 * @param p - The piece being used.
	 * @return
	 * 
	 * @author Carlos Barcelos
	 */
	public Piece remove(Piece p){
		int index = pieces.indexOf(p);
		pieces.remove(index);
		numPieces--;
		return p;
	}

	/**
	 *  A simple getter.
	 * @return number of pieces in the bullpen.
	 * 
	 * @author Carlos Barcelos
	 */
	public int getNumberPieces(){
		return numPieces;
	}

	/**
	 * A simple getter. 
	 * 
	 * @return a list of the pieces in the bullpen.
	 * 
	 * @author Carlos Barcelos
	 */
	public ArrayList<Piece> getListPiece(){
		return pieces;	
	}

	/**
	 * A simple getter.
	 * 
	 * @return a piece from the bullpen given its x,y position.
	 * The pieces are laid out 4 wide which is 4*7*Square.WIDTH.
	 */
	public Piece getPiece(int x, int y){
		int xFactor;
		int yFactor;

		// Find the factor of x that the piece is located
		if(x < 7*Square.WIDTH){ // One wide
			xFactor = 0;
		} else if(x < 14*Square.WIDTH){ // Two wide
			xFactor = 1;
		}
		else if(x < 21*Square.WIDTH){ // Three wide
			xFactor = 2;
		}
		else if(x < 28*Square.WIDTH){ // Four wide
			xFactor = 3;
		}
		
		// Find the factor of y that the piece is located
		if(y < 7*Square.WIDTH){ // One tall
			yFactor = 0;
		} else if(y < 14*Square.WIDTH){ // Two tall
			yFactor = 4;
		} else if(y < 21*Square.WIDTH){ // Three tall
			yFactor = 8;
		} else if(y < 28*Square.WIDTH){ // Four tall
			yFactor = 12;
		} else {yFactor = 5;}
		
		
		int index = x + y;

		return pieces.get(index);
	}
}
