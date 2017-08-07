package odysseus.common.entities;

import junit.framework.TestCase;

/**
 * Validates the counter class runs as should.
 * @author valente
 *
 */
public class TestCounter extends TestCase {
	
	public void testUpdateMoves(){
		Counter c = new Counter(3);
		int x1 = c.getMovesMade();
		assertEquals(0,x1);
		
		c.update();
		
		int x2 = c.getMovesMade();
		assertEquals(1,x2);
		
		c.update(-1);
		assertEquals(0,x1);
	}
	
	public void testIsOver(){
		Counter c2 = new Counter(3);
		 assertFalse(c2.isOver());
		 
		 c2.update();
		 c2.update();
		 assertFalse(c2.isOver());
		 
		 c2.update();
		 assertTrue(c2.isOver());
	}

}
