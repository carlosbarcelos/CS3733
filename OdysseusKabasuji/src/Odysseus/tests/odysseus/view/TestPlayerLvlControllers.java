package odysseus.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;
import odysseus.common.entities.Board;
import odysseus.common.entities.Bullpen;
import odysseus.common.entities.Lightning;
import odysseus.common.entities.Piece;
import odysseus.common.entities.Puzzle;
import odysseus.common.entities.Release;
import odysseus.view.Frames.PlayerLevelL;
import odysseus.view.Frames.PlayerLevelP;
import odysseus.view.Frames.PlayerLevelR;
import odysseus.view.controller.PlayerLLvlController;
import odysseus.view.controller.PlayerLvlController;
import odysseus.view.controller.PlayerRLvlController;

/**
 * Test cases for the Player Level Selector Controllers.
 * @author valente
 *
 */
public class TestPlayerLvlControllers extends TestCase {
	ArrayList<Piece> bullpenPieces = new ArrayList<Piece>();
	ArrayList<Piece> boardPieces = new ArrayList<Piece>();
	long time = 0;
	List<Piece> list;

	Board board = new Board();
	Bullpen bullpen = new Bullpen(bullpenPieces);

	Puzzle puzzle;
	Lightning light;
	Release release;
	
	ActionEvent e = null;

	public void testPlayerPLvlController(){
		puzzle  = new Puzzle(board, bullpen, 0, true, list, 0);
		puzzle.setValue(17);

		PlayerLevelP plevel = new PlayerLevelP(puzzle);
		plevel.setVisible(true);
		assertTrue(plevel.isVisible());

		PlayerLvlController pController = new PlayerLvlController(plevel,puzzle,1);
		pController.actionPerformed(e);

		assertFalse(plevel.isVisible());
	}

	public void testPlayerLLvlController(){
		light= new Lightning(board, bullpen, 0, false, null, time);
		light.setValue(17);
		
		PlayerLevelL lLevel = new PlayerLevelL(light);
		lLevel.setVisible(true);
		assertTrue(lLevel.isVisible());
		
		PlayerLLvlController lController = new PlayerLLvlController(lLevel, light, 1);
		lController.actionPerformed(e);

		assertTrue(lLevel.isVisible());
		
	}
	
	public void testPlayerRLvlController(){
		release = new Release(board, bullpen, 0, false, null);
		release.setValue(17);
		
		PlayerLevelR rLevel = new PlayerLevelR(release);
		rLevel.setVisible(true);
		assertTrue(rLevel.isVisible());
		
		PlayerRLvlController rController = new PlayerRLvlController(rLevel, release,1);
		rController.actionPerformed(e);

		assertTrue(rLevel.isVisible());
	}
}
