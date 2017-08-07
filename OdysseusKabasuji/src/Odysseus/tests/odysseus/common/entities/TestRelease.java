package odysseus.common.entities;

import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.TestCase;

public class TestRelease extends TestCase {

	private Board b = setUpBoard();
	private Release rl = new Release(b,null,5,true,null);

	
	/**
	 * Testing the functionality of getReleaseSquares, Board creation, Square creation, and release level functionality
	 * 
	 * @author Justin Myerson
	 * @author Carlos Barcelos
	 */
	
	// 36 squares / 2 = 18 num squares / 3 = 3 colors of six numbers
	public Board setUpBoard(){
		Square[][] squares = new Square[12][12];
		Square[] forFilling = makeSquare();
		int cnt = 0;
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				squares[i][j] = forFilling[cnt++]; // Q1
				squares[i+6][j] = new Square("null", 0, 0); // Q2 
				squares[i][j+6] = new Square("null", 0, 0); // Q3
				squares[i+6][j+6] = new Square("null", 0, 0); // Q4
			}
		}
		
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		return new Board(squares,pieces);
	}
	
	private Square[] makeSquare(){
		Square[] squares = new Square[36];
		Square s = new Square("empty",0,0);
		ReleaseSquare rs;
		for(int i = 1; i <= 36; i++){
			if(i % 6 == 0){ // Occurs 6 times
				rs = new ReleaseSquare(0,0,36/i,1);
				squares[i-1] = rs;
			} else if(i % 6 == 1){ // Occurs 6 times
				rs = new ReleaseSquare(0,0,36/i,2);
				squares[i-1] = rs;
			} else if(i % 6 == 2){ // Occurs 6 times
				rs = new ReleaseSquare(0,0,36/i,3);
				squares[i-1] = rs;
			} else{
				squares[i-1] = s;
			}
		}
		return squares;
	}
	
	// Test numSetsCovered
	public void testNumSetsCovered(){
		assertFalse(rl.hasWon());
		
	}
	// Test hasWon
	
}
