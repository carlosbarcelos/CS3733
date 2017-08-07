package odysseus.common.entities;

import junit.framework.TestCase;

/**
 * Test the functionality of Board and its methods.
 * 
 * @author Justin Myerson\
 *
 */

public class TestBoard extends TestCase {
	
	Board testBoard = new Board();

	Square[][] boardArray = testBoard.getSquares();

	String state = boardArray[1][1].getType();

	
	public void testChangeSquare(){
		
		assertEquals(state, "empty");
		
		testBoard.changeSquare(boardArray[1][1]);
		
		state = boardArray[1][1].getType();
		
		assertEquals(state, "hint");
		
		testBoard.changeSquare(boardArray[1][1]);
		
		state = boardArray[1][1].getType();
		
		assertEquals(state, "null");
		
		testBoard.changeSquare(boardArray[1][1]);
		
		state = boardArray[1][1].getType();
		
		assertEquals(state, "empty");
	
	}
	
	public void testChangeToReleaseSquare(){
		
		assertEquals(state, "empty");
		
		testBoard.changeToReleaseSquare(boardArray[1][1]);
		
		state = boardArray[1][1].getType();
		
		assertEquals(state, "release");
		
		testBoard.changeToReleaseSquare(boardArray[1][1]);
		
		state = boardArray[1][1].getType();
		
		assertEquals(state, "release");
		
	}

}
