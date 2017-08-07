package odysseus.common.entities;

import junit.framework.TestCase;
import java.lang.Object;

public class TestLightning extends TestCase{

	// First, make sure that the counter countdowns
	public void testCountdown(){
		// Make a timer with a ten second time limit
				GameTimer gt = new GameTimer(10);
				//gt.run();
				assertFalse(gt.isOver());
		//		try {
		//		    Thread.sleep(1500);
		//			assertTrue(gt.isOver());
		//		} catch(InterruptedException ex) {
		//		    Thread.currentThread().interrupt();
		//		    System.err.println("TestLightning :: testCountdown() failed to sleep.");
		//		}


		
	}
}