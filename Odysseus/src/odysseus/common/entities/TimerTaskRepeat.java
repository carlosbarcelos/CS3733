package odysseus.common.entities;
import java.util.TimerTask;
import java.awt.Toolkit;

/**
 * Class for operating the timer in Lightning levels.
 * 
 * @author Michelle Gagnon
 *
 */

public class TimerTaskRepeat extends TimerTask {
	int secondCount = 0;
	private long timeLimit;
	Toolkit toolkit;
	
	public TimerTaskRepeat(long timeLimit){
		this.timeLimit = timeLimit; 
	}

	@Override
	public void run() {
		if(secondCount <= timeLimit){
			toolkit.beep();
			secondCount++;
			System.out.println("timeLimit " + timeLimit);
			System.out.println("count " + secondCount);
		}
		else {
			toolkit.beep();
			System.out.println("cancelling");
			this.cancel();
		}
	}
	
	/**
	 * A simple getter.
	 * 
	 * @return The time the game has been.
	 */
	public int getCount(){
		return secondCount;
	}

}
