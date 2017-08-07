package odysseus.common.entities;

import junit.framework.TestCase;

public class TestSquare extends TestCase {
	
	public void testGetType(){
		Square s = new Square("null", 10, 10);
		String squareString = s.toString();
		
		assertEquals(s.getType(), "null"); // Test getType
		assertEquals(s.toString(),squareString); // Test toString
	}
	
	public void testGetLocation(){
		Square s = new Square("null", 10, 10);
		
		int[] testArray = {10,10,30,30};
		int[] squareArray = s.getLocation();
		for(int i = 0; i < 4; i++){
			assertEquals(squareArray[i], testArray[i]);
		}
		
		// Make sure that the coordinates of the square are properly spaced
		assertEquals(s.getX(), s.getX2() - s.getWidth());
		assertEquals(s.getY(), s.getY2() - s.getWidth());
	}
	
	// Test that only the hint, release and empty squares can be played upon
	public void testPlayableType(){
		Square nullSquare = new Square("null",10,10);
		Square emptySquare = new Square("empty",10,10);
		Square filledSquare = new Square("filled",10,10);
		Square hintSquare = new Square("hint",10,10);
		ReleaseSquare releaseSquare = new ReleaseSquare(10,10,1,1);
		
		// Empty, hint and release are playable
		assertTrue(emptySquare.playable());
		assertTrue(hintSquare.playable());
		assertTrue(releaseSquare.playable());
		
		// Null and filled are not
		assertFalse(nullSquare.playable());
		assertFalse(filledSquare.playable());
	}
	
	
	
}
