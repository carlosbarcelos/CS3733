package bowling;

import junit.framework.TestCase;

public class TestFrame extends TestCase {
	
	
	public void testInitial(){
		Game bowling = new Game();
		assertEquals(0, bowling.score());
	}
	
	public void testScore(){
		Game bowling = new Game();
		bowling.roll(6);
		assertEquals(6, bowling.score());
	}
	
	public void testSpare(){
		
	}
	
	public void testStrike(){
		
	}
	
	public void testPlayFullGame(){
		
	}
	
}