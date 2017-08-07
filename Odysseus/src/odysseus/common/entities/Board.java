package odysseus.common.entities;

import java.util.*;


/**
 * The board is a collection of squares that constitute playable and nonplayable area.
 * 
 * The types of squares that can make up a board are:
 * 	null - non playable
 * 	filled - a piece has overlapped the square on the board
 * 	empty - a playable square which is not filled
 * 	ReleaseSquare - a  playable with a number and color
 * 	hint - a playable square with an outline of a piece location.
 * 
 * @author Carlos Barcelos
 * @author Justin Myerson
 */
public class Board implements java.io.Serializable {

	// A board is a collection of squares (up to 12x12)
	// of one or many square types: null, filled, empty, number, hint
	private Square[][] squares = new Square[12][12];
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	
	// Build a board with a given array of squares
	public Board(Square[][] squares, ArrayList<Piece> pieces){
		this.squares = squares;
		this.pieces = pieces;
	}
	// Build an empty board with predetermined "empty" squares and no pieces
	public Board(){
		this.squares = initalize();
		this.pieces = pieces;
	}
	
	/**
	 * Initialize the board squares to a generic form.
	 * 
	 * @return squares - The two dimensional array of squares that construct the board.
	 */
	public Square[][] initalize(){
		Square[][] squares = new Square[12][12];
		Square widthSquare = new Square("empty",1,2);
		int WIDTH = widthSquare.getWidth();
		
		// Makes a grid of squares, 0,0 is the top left coordinate
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12; j++){
				squares[i][j] = new Square("empty", i * WIDTH, j * WIDTH);
			}
		}
		return squares;
	}
	
	/**
	 * Change the type of square that is contained within a board.
	 * (Probably a controller).
	 * 
	 * @param oldSquare - The square to be changed.
	 */
	public void changeSquare(Square oldSquare){
		String type = oldSquare.getType();
		
		int x = oldSquare.getX();
		int y = oldSquare.getY();
		
		if(type == "null"){
			squares[x/Square.WIDTH][y/Square.WIDTH] = new Square("empty",x,y);
		} else if(type == "empty"){
			squares[x/Square.WIDTH][y/Square.WIDTH] = new Square("hint",x,y);
		} else if(type == "hint"){
			squares[x/Square.WIDTH][y/Square.WIDTH] = new Square("null",x,y);
		} else{
			System.err.println("Board.changeSquare():: square type not found.");
		}
	}
	/**
	 * Change the type of square to a release square.
	 * 
	 * @param oldSquare - The square to be changed.
	 * 
	 * @author Justin Myerson
	 * @author Carlos Barcelos
	 */
	public void changeToReleaseSquare(Square oldSquare){
		int x = oldSquare.getX();
		int y = oldSquare.getY();
		//Sanity check
		if(oldSquare.getType() == "release"){
			return;
		}
		
		ReleaseSquare[] releaseArray = getReleaseSquares();
		
		try{
			ReleaseSquare releaseSquare = whichReleaseSquare(releaseArray, oldSquare);
			squares[x/Square.WIDTH][y/Square.WIDTH] = releaseSquare;
		} catch(NullPointerException n){
			System.err.println("Board.ChangeToReleaseSquare() :: Maximum number of ReleaseSquares on the board.");
		}
		
	}
	
	
	/**
	 * Helper method to tell the game what the next release tile to place is.
	 * @param releaseArray
	 * @param oldSquare Takes in a regular square.
	 * @return Replaces oldSquare with a new Release Square.
	 * @throws NullPointerException
	 * 
	 * @author Justin Myerson
	 * @author Carlos Barcelos
	 */
	private ReleaseSquare whichReleaseSquare(ReleaseSquare[] releaseArray, Square oldSquare) throws NullPointerException{
		int[] yellow = {1,2,3,4,5,6};
		int[] red = {1,2,3,4,5,6};
		int[] blue = {1,2,3,4,5,6};
		
		int x = oldSquare.getX();
		int y = oldSquare.getY();
		
		try{
		for(ReleaseSquare s : releaseArray){
			if(s.getColor() == 1){ // Yellow
				yellow[s.getNumber()] = 0;
			} else if(s.getColor() == 2){ // Red
				red[s.getNumber()] = 0;
			} else if(s.getColor() == 3){ // Blue
				blue[s.getNumber()] = 0;
			}
		}
		} catch(NullPointerException n){} // For when the array is not full
		
		for(Integer i : yellow){
			if(i != 0){
				return new ReleaseSquare(x,y,i,1);
			}
		}
		for(Integer i : red){
			if(i != 0){
				return new ReleaseSquare(x,y,i,2);
			}
		}
		for(Integer i : blue){
			if(i != 0){
				return new ReleaseSquare(x,y,i,3);
			}
		}
		
		throw new NullPointerException();
	}
	
	/**
	 * Returns the number of playable squares on the board.
	 * 
	 * @return count - The number of filled squares in the board.
	 * 
	 * @author Justin Myerson
	 */
	public int numSquares(){
		int count = 0;
		
		for(int i = 0; i < 12; i++){
			for(int j = 0; i < 12; i++){
				if(squares[i][j].playable()){
					count++;
				}
			}
		}
		
		return count;
	}
	
	/**
	 * Returns the number of filled squares on the board.
	 * 
	 * @return count - The number of filled squares in the board.
	 * 
	 * @author Justin Myerson
	 */
	public int numFilledSquares(){
		
		int count = 0;
		for(int i = 0; i < 12; i++){
			for(int j = 0; i < 12; i++){
				if(squares[i][j].getType() == "filled"){
					count++;
				}
			}
		}
		
		return count;
	}
	
	/**
	 * Returns the array of all release style squares on the board.
	 * 
	 * @return releaseSquares - The array of release squares in the board.
	 * 
	 * @author Justin Myerson
	 * @author Carlos Barcelos
	 */
	public ReleaseSquare[] getReleaseSquares(){
		ReleaseSquare[] releaseSquares = new ReleaseSquare[18];
		int count = 0;
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12; j++){
				if(this.squares[i][j].getType() == "release"){
					releaseSquares[count] = (ReleaseSquare) squares[i][j];
					count++;
				}
			}
		}
		return releaseSquares;
	}
	
	/**
	 * Checks to see if a given square is inside of the board and playable. 
	 * 
	 * @return True - The passed square is inside of the board and playable.
	 * 
	 * @author Carlos Barelos
	 * @author Justin Myerson
	 */
	public boolean isPlayableSquare(Square s){
		// Check within squares at the location of the given square
		int x = s.getX() / s.getWidth();
		int y = s.getY() / s.getWidth();
	
		if(squares[x][y].getType() != "null"){
			if(squares[x][y].playable()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 *  A simple getter.
	 *  
	 * @return The ArraList of all the square on the board.
	 * 
	 * @author Carlos Barcelos
	 */
	public Square[][] getSquares(){
		return squares;
	}
	
	public Square getSquare(int x, int y){
		return squares[x/Square.WIDTH][y/Square.WIDTH];
	}
	
	/**
	 *  Add piece to board.
	 *  
	 * @param p - The piece being given.
	 * 
	 * @author Carlos Barcelos
	 */
	public boolean add(Piece p){
		Square topLeftSquare = p.decodeSquare(p.getLocation()[0]);
		
		if(isPlayableSquare(squares[topLeftSquare.getX()/Square.WIDTH][topLeftSquare.getY()/Square.WIDTH])){
			pieces.add(p);
			System.out.println("true");
			return true;
		} else{
			System.out.print("false");
			return false;
		}
	}
	
	/**
	 *  Remove piece from board.
	 *  
	 * @param p - The piece being taken.
	 * 
	 * @author Carlos Barcelos
	 */
	public Piece remove(Piece p){
		int index = pieces.indexOf(p);
		pieces.remove(index);
		return p;
	}
	
	/**
	 *  Returns true if the board has no pieces on it.
	 *  
	 * @return True if the board is empty, false if it's not.
	 * 
	 * @author Justin Myerson
	 */
	public boolean empty(){
		return pieces.isEmpty();
	}
	
	/**
	 * A simple getter.
	 * 
	 * @return The Array List with all the pieces within it.
	 */
	public ArrayList<Piece> getPieces(){
		return pieces;
	}
	
}
