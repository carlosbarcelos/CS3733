package odysseus.common.entities;

import junit.framework.TestCase;

/**
 * Validates that stars class runs as should.
 * @author valente
 *
 */
public class TestStar extends TestCase {

	public void testHasWon(){
		Stars s = new Stars();
		assertFalse(s.hasWon());
		
		s.updateStarsEarned();
		assertTrue(s.hasWon());
	}
	
	public void testUpdateStarsEarned(){
		Stars s1 = new Stars();
		int x =s1.getStarsEarned();
		assertEquals(0,x);
		
		s1.updateStarsEarned();
		s1.updateStarsEarned();
		s1.updateStarsEarned();
		s1.updateStarsEarned();
		
		int x2 = s1.getStarsEarned();
		assertEquals(3,x2);
	}
}
