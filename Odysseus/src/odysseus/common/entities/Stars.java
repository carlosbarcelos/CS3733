package odysseus.common.entities;

import java.awt.Image;

/**
 * Keeps track of how the player performs.
 * @author Kevin Valente
 *
 */
public class Stars {

	private int starsEarned;
	Image img;

	public Stars(){
	}

	/**
	 * Updates the number of stars player has earned
	 *
	 * @author Kevin Valente
	 */
	public void updateStarsEarned(){
		if(starsEarned!=3)
			starsEarned++;
	}

	/**
	 * A simple getter.
	 * 
	 * @return The number of stars earned.
	 * 
	 * @author Kevin Valente
	 */
	public int getStarsEarned(){
		return starsEarned;
	}

	/**
	 * Used to determine whether the player has won or not.
	 * 
	 * @return True if the player has won the level.
	 * 
	 * @author Kevin Valente
	 */
	public boolean hasWon(){
		if(starsEarned == 0)
			return false;

		return true;
	}
}
