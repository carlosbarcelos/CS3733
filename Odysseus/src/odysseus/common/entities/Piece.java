package odysseus.common.entities;

import java.util.*;
import java.awt.Point;
import java.io.*;

/**
 * A Piece is represented as a two dimensional array of null or filled.
 * 
 * The piece is created with an integer representing its piece ID.
 * There are 35 unique hexonimoes.
 * 
 * @author Carlos Barcelos
 *
 */
public class Piece implements java.io.Serializable {
	private Square[][] squares = new Square[7][7];
	private int[] location = new int[6];
	public final int ID;

	// Creating a piece will make a filled piece
	public Piece(int i){
		this.location = initializeLocation(i);
		this.squares = initializeSquares("filled");
		ID = i;
	}

	// Option to create a piece of a different type
	public Piece(int i, String type){
		this.location = initializeLocation(i);
		this.squares = initializeSquares(type);
		ID = i;
	}

	/**
	 * Initialize takes a pieceNum ID and converts that into an actualized hexonimo.
	 * 
	 * @param pieceID - The ID number of the hexonimoe requested.
	 * @return An integer array of the location of the piece.
	 * 
	 * @author Carlos Barcelos
	 * @author Michelle Gagnon
	 * @author Justin Myerson
	 * @author Kevin Valente
	 */
	private int[] initializeLocation(int pieceID){
		Scanner file;

		try{
			file = new Scanner(new File("PieceData.txt"));
			String stringLocation = "";
			int[] intLocation = new int[6];


			// Get the correct piece
			for(int j = 1; j <= pieceID; j++){
				stringLocation = file.nextLine();
			}

			// Parse the string to find the individual locations
			for(int k = 0; k < 12; k+=2){
				intLocation[k/2] = Integer.parseInt(stringLocation.substring(k, k+2));
			}

			//Close the file and return
			file.close();
			return intLocation;			
		} catch (Exception e){
			System.err.println(e);
		}
		return null;
	}

	/**
	 * Method used for initializing squares for a piece.
	 * 
	 * @param type - The type of square being made.
	 * @return All of the squares within a piece.
	 * 
	 * @author Carlos Barcelos
	 * @author Michelle Gagnon
	 * @author Kevin Valente
	 */
	private Square[][] initializeSquares(String type) {
		Square[][] squares = new Square[7][7];
		int[] squareLocation = new int[2];

		for(int i : location){
			squareLocation = decode(i);
			squares[squareLocation[0]][squareLocation[1]] = new Square(type,squareLocation[0]*Square.WIDTH, squareLocation[1]*Square.WIDTH);
		}

		// Remove null and replace with null squares
		for(int j = 0; j <= 6; j++){
			for(int k = 0; k <= 6; k++){
				if(squares[j][k] == null){
					int[] nullLocation = {j,k};
					squares[j][k] = new Square("null", nullLocation[0]*Square.WIDTH, nullLocation[1]*Square.WIDTH);
				}
			}
		}

		return squares;
	}

	/**
	 * A simple getter.
	 * 
	 * @return An array of all the squares within a piece.
	 */
	public Square[][] getSquares(){
		return squares;
	}

	/**
	 *  Returns the squares of the piece as an array of integers.
	 *  Each integer represents the location of a square within the piece.
	 *  Ordering is top left to bottom right.
	 *  
	 *  @return The square of the piece as an array of integers.
	 *  
	 *  @author Carlos Barcelos
	 *  @author Justin Myerson
	 *  @author Michelle Gagnon
	 */
	public int[] encode(){
		int[] truncArray = new int[6];
		int cnt = 0;

		for(int i = 1; i <= 6; i++){
			for(int j = 1; j <= 6; j++){
				if(squares[i][j] == null){
					continue;				
				} else{
					if(squares[i][j].getType() == "filled"){
						// Encode the squares location to an X1X2 format
						// X1 corresponds to i (x position)
						// X2 corresponds to j (y position)
						int toAdd = (i*10) + j;
						truncArray[cnt] = toAdd;
						cnt++;	
					}
				}
			}
		}
		return truncArray;
	}

	/** Returns the locations of the squares in the piece.
	 * Considers the array of encoded squares and expands the positions.
	 * 
	 * @param pos - The position of the square.
	 * 
	 * @return The XY position of the square.
	 * 
	 * @author Carlos Barcelos
	 * @author Justin Myerson
	 * @author Michelle Gagnon
	 */
	public int[] decode(int pos){
		// Returns the XY position of the "pos" square in location
		int[] XY = cypher(pos);		
		return XY;
	}

	/** Decodes the location from location array and returns corresponding Square.
	 * 
	 * @param pos - The position of the square.
	 * @return Square located at the requested position.
	 * 
	 * @author Justin Myerson
	 * @author Carlos Barcelos
	 * @author Michelle Gagnon
	 */
	public Square decodeSquare(int pos){
		int[] XY = decode(pos);
		return squares[XY[0]][XY[1]];
	}

	/** Helper function to perform decryption cypher for integer.
	 * 
	 * @param i - The array value of the square.
	 * @return Decoded position of the square.
	 * 
	 * @author Justin Myerson
	 * @author Carlos Barcelos
	 * @author Michelle Gagnon
	 */
	private int[] cypher(int i){
		int[] returnArray = new int[2];

		returnArray[1] = i % 10;
		i -= returnArray[1];
		returnArray[0] = i / 10;

		return returnArray;
	}

	/** Performs decryption cypher for array.
	 * 
	 * @param a - The encoded version of the square position.
	 * @return Decoded position of the square.
	 * 
	 * @author Justin Myerson
	 * @author Carlos Barcelos
	 * @author Michelle Gagnon
	 */
	private int cypher(int[] a){
		return (a[0]*10) + a[1];
	}

	/**
	 * Rotates the piece 90*. Change is seen in truncated location array.
	 * 
	 * @return location - Changes the object's truncated location array, fixed for 90* shifted coordinates.
	 * 
	 * @author Carlos Barcelos
	 */
	public void rotate(){
		int[] cordArr = new int[2];
		int[] temp;

		for(int i = 0; i < 6; i++){
			temp = cypher(location[i]); // Extract coordinate
			cordArr[0] = 6 - temp[1] + 1; // newX = 6 - oldY + 1
			cordArr[1] = temp[0]; // newY = oldX
			location[i] = cypher(cordArr); // Replace rotated coordinate
		}
	}

	/**
	 * Mirrors a piece about the Y-axis. Change is seen in truncated location array.
	 * 
	 * @return location - Changes the object's truncated location array, fixed for mirrored coordinates.
	 * 
	 * @author Carlos Barcelos
	 */
	public void mirror(){
		int[] cordArr = new int[2];
		int[] temp;

		for(int i = 0; i < 6; i++){
			temp = cypher(location[i]); // Extract coordinate
			cordArr[0] = 6 - temp[0] + 1; // newX = 6 - oldX + 1
			cordArr[1] = temp[1]; // newY = oldY
			location[i] = cypher(cordArr); // Replace rotated coordinate
		}
	}

	/** confirm all squares in the piece are the same type.
	 * 
	 * @return True if all of the squares are of the same type.
	 * 
	 * @author Carlos Barcelos
	 */
	public boolean squaresSameType(){
		for(int i : location){
			int [] pos = decode(i);
			if(squares[pos[0]][pos[1]].getType() != "filled"){
				return false;
			}
		}
		return true;
	}

	/** A simple getter.
	 * 
	 * @return An array of the location.
	 * 
	 * @author Carlos Barcelos
	 */
	public int[] getLocation(){
		return this.location;
	}

	/**
	 * A simple getter.
	 * 
	 * @param x - The x location of the square.
	 * @param y - The y location of the square.
	 * @return The requested square.
	 * 
	 * @author Carlos Barcelos
	 * @author Justin Myerson
	 */
	public Square getSquare(int x, int y){
		return squares[x][y];
	}

	/**
	 * Verify if the location has a square of the piece.
	 * 
	 * @param p - Location to be verified.
	 * @return True if at least one square is in that position.
	 */
	public boolean contains(Point p) {
		//For each square in piece:
		//get X and Y for square
		//See if point x and point y are within
		//square x + square width and square y + square height
		int squareX = 0;
		int squareY = 0;
		int squareX2 = 0;
		int squareY2 = 0;
		boolean xValid = false;
		boolean yValid = false;
		Square[][] squareList = this.getSquares();
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 7; j++){
				if(squareList[i][j].getType().equals("filled")){
					squareX = squareList[i][j].getX();
					squareY = squareList[i][j].getY();
					squareX2 = squareList[i][j].getX2();
					squareY2 = squareList[i][j].getY2();

					if(p.x > squareX & p.x < squareX2){
						xValid = true;
					}
					if(p.y > squareY & p.y < squareY2){
						yValid = true;
					}
					if(xValid & yValid){
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * A simple getter.
	 * 
	 * @return The type of a square within the piece.
	 */
	public String getType(){
		int[] squareLocation = new int[2];
		squareLocation = cypher(location[0]);
		Square square = getSquare(squareLocation[0],squareLocation[1]);

		return square.getType();

	}
}