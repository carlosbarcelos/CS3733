package odysseus.common.entities;

import java.awt.Point;

import junit.framework.TestCase;

public class TestPiece extends TestCase {

	public void testInitalize(){
		// Test the first piece
		Piece p = new Piece(1);
		int[] expectedLocation = {11,12,13,14,15,16};
		
		boolean validation = true;
		int[] actualLocation = p.getLocation();
		
		for(int i = 0; i < 6; i++){
			if(actualLocation[i] != expectedLocation[i]){
				validation = false;
			}
		}
		
		assertTrue(validation);
		
		// Test some n number piece
		Piece p2 = new Piece(5);
		int[] expectedLocation2 = {31,41,12,22,32,13};
		
		boolean validation2 = true;
		int[] actualLocation2 = p2.getLocation();
		
		for(int i = 0; i < 6; i++){
			if(actualLocation2[i] != expectedLocation2[i]){
				validation2 = false;
			}
		}
		
		assertTrue(validation2);
		
		// Test the last piece
		Piece p3 = new Piece(35);
		int[] expectedLocation3 = {31,22,32,42,13,23};
		
		boolean validation3 = true;
		int[] actualLocation3 = p3.getLocation();
		
		for(int i = 0; i < 6; i++){
			if(actualLocation3[i] != expectedLocation3[i]){
				validation3 = false;
			}
		}
		
		assertTrue(validation3);
		
		// Now try to make a piece of a different type
		
		Piece p4 = new Piece(35,"hint");
		int[] expectedLocation4 = {31,22,32,42,13,23};
		
		boolean validation4 = true;
		int[] actualLocation4 = p4.getLocation();
		
		for(int i = 0; i < 6; i++){
			if(actualLocation4[i] != expectedLocation4[i]){
				validation4 = false;
			}
		}
		assertEquals(p4.getType(), "hint");
		assertTrue(validation4);
	}
	
	// Make sure that when a piece is construced, it is made of the same type of squares
	
	// Make sure that a piece can be properly rotated back to inital position
	public void testRotate(){
		Piece p = new Piece(4);
		int[] origionalLocation = p.getLocation();
				
		int[] expectedLocation1 = {61,51,41,42,31,21}; // rotate 90
		int[] expectedLocation2 = {66,65,64,54,63,62}; // rotate 180
		int[] expectedLocation3 = {16,26,36,35,46,56}; // rotate 270
		
		// Rotate 90
		p.rotate();
		int[] actualLocation1 = p.getLocation();
		boolean validation1 = true;
		for(int i = 0; i < 6; i++){
			if(actualLocation1[i] != expectedLocation1[i]){
				validation1 = false;
			}
		}
		// Rotate 180
		p.rotate();
		int[] actualLocation2 = p.getLocation();
		boolean validation2 = true;
		for(int i = 0; i < 6; i++){
			if(actualLocation2[i] != expectedLocation2[i]){
				validation2 = false;
			}
		}
		// Rotate 270
		p.rotate();
		int[] actualLocation3 = p.getLocation();
		boolean validation3 = true;
		for(int i = 0; i < 6; i++){
			if(actualLocation3[i] != expectedLocation3[i]){
				validation3 = false;
			}
		}
		// Rotate 360
		p.rotate();
		int[] actualLocation4 = p.getLocation(); // 4 rotates goes back to origional
		boolean validation4 = true;
		for(int i = 0; i < 6; i++){
			if(actualLocation4[i] != origionalLocation[i]){
				validation4 = false;
			}
		}
		
		// Make sure this function works for all cases
		assertTrue(validation1);
		assertTrue(validation2);
		assertTrue(validation3);
		assertTrue(validation4);
	}
	
	// Test mirroring a piece, and then rotating the mirrored piece and returning it back to origional position
	public void testMirror(){
		Piece p = new Piece(4);
		int[] origionalLocation = p.getLocation();
		 
		int[] expectedLocation1 = {61,51,41,42,31,21}; // rotate 90
		int[] expectedLocation2 = {11,21,31,32,41,51}; // mirror
		int[] expectedLocation3 = {61,62,63,53,64,65}; // rotate 90
		 
		 
		// Origional Position = Rotate + Mirror + Rotate + Mirror
		// Rotate 90
		p.rotate();
		int[] actualLocation1 = p.getLocation();
		boolean validation1 = true;
		for(int i = 0; i < 6; i++){
			if(actualLocation1[i] != expectedLocation1[i]){
				validation1 = false;
			}
		}
		// Mirror
		p.mirror();
		int[] actualLocation2 = p.getLocation();
		boolean validation2 = true;
		for(int i = 0; i < 6; i++){
			if(actualLocation2[i] != expectedLocation2[i]){
				validation2 = false;
			}
		}
		// Rotate 90
		p.rotate();
		int[] actualLocation3 = p.getLocation();
		boolean validation3 = true;
		for(int i = 0; i < 6; i++){
			if(actualLocation3[i] != expectedLocation3[i]){
				validation3 = false;
			}
		}
		// Mirror - This move gets the piece back in its origional position
		p.mirror();
		int[] actualLocation4 = p.getLocation();
		boolean validation4 = true;
		for(int i = 0; i < 6; i++){
			if(actualLocation4[i] != origionalLocation[i]){
				validation4 = false;
			}
		}
		 
		// Make sure this function works for all cases
		assertTrue(validation1);
		assertTrue(validation2);
		assertTrue(validation3);
		assertTrue(validation4);
	}
	
	// Test the various decode methods
	public void testDecode(){
		// Piece one is {11,12,13,14,15,16}
		Piece p = new Piece(1);
		
		// Location 1 should be the top-left most location
		assertEquals(p.getLocation()[0], 11);
		
		// Decoding the top-left most location should result in x,y1:(20,20) x,y2:(20+width,20+width)
		Square topLeft = p.decodeSquare(p.getLocation()[0]);
		assertEquals(topLeft.getX(), 20);
		assertEquals(topLeft.getY(), 20);
		assertEquals(topLeft.getX2(), 20 + Square.WIDTH);
		assertEquals(topLeft.getY2(), 20 + Square.WIDTH);
	}
	
	public void testSameSquareType(){
		Piece p = new Piece(1);
		assertTrue(p.squaresSameType());
	}
	
	public void testContains(){
		Piece p = new Piece(1);
		
		Point po = new Point(0,0);
		assertFalse(p.contains(po));
		
		Point po2 = new Point(25,25);
		assertTrue(p.contains(po2));
	}
	
}
