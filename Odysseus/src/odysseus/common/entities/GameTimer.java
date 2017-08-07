package odysseus.common.entities;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A timer to be used to keep track of game time in Lightning levels.
 * 
 * @author Michelle Gagnon
 *
 */

public class GameTimer implements java.io.Serializable {
	static  Thread thread = new Thread();
	private static long TIME_LIMIT;
	private static boolean isOver = false;
	
	public GameTimer(long timeLimit){
		this.TIME_LIMIT = timeLimit;
		//Timer timer = new Timer();
		//TimerTask tasknew = new TimerTaskRepeat(TIME_LIMIT);
		
		//timer.scheduleAtFixedRate(tasknew, 0, 1000);
	}
//
//	
//	// this method performs the task
//	public void run() {
//		// creating timer task, timer
//		TimerTask tasknew = new TimerTaskRepeat(TIME_LIMIT);
//		Timer timer = new Timer();
//
//		// scheduling the task at fixed rate delay
//		timer.scheduleAtFixedRate(tasknew,0,1000);
//		timer.cancel();
//		isOver = true;   
//	}

	/**
	 * Used to see if player has no more time left.
	 * @return True - If the level has reached its time limit.
	 */
	public boolean isOver() {
		return isOver;
	}

	
	public static void main(String[] args) {
		System.out.println("starting");
//		for(long i = 0; i < TIME_LIMIT; i++){
//			try {
//				thread.sleep(1000);
//			} catch (InterruptedException e) {
//				//System.out.println("broken");
//			}
//			//System.out.println(i);
//		}
//		isOver = true;
	}
}
