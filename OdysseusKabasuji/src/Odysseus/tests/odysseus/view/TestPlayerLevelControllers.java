package odysseus.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;
import odysseus.Builder;
import odysseus.Player;
import odysseus.common.entities.Board;
import odysseus.common.entities.Bullpen;
import odysseus.common.entities.Lightning;
import odysseus.common.entities.Piece;
import odysseus.common.entities.Puzzle;
import odysseus.common.entities.Release;
import odysseus.view.Frames.BuilderMenu;
import odysseus.view.Frames.PlayerMenu;
import odysseus.view.controller.PlayerLightningController;
import odysseus.view.controller.PlayerPuzzleController;
import odysseus.view.controller.PlayerReleaseController;

/**
 * Test cases for the Player Level Controllers.
 * @author Kevin Valente
 *
 */
public class TestPlayerLevelControllers extends TestCase {
	Player p;
	PlayerMenu pm;

	ActionEvent e = null;

	public ArrayList<Piece> bullpenPieces = new ArrayList<Piece>();
	public ArrayList<Piece> boardPieces = new ArrayList<Piece>();
	public long time = 0;
	public List<Piece> list;

	public void testPlayerPuzzleController(){
		p = new Player();
		//		p.initalize();
		p.board = new Board();
		p.bullpen = new Bullpen(bullpenPieces);

		p.levelP = new Puzzle(p.board, p.bullpen, 0, false, null, 0);
		p.levelL = new Lightning(p.board, p.bullpen, 0, false, null, time);
		p.levelR = new Release(p.board, p.bullpen, 0, false, null);

		p.levelP.setValue(17);
		p.levelL.setValue(17);
		p.levelR.setValue(17);
		pm = new PlayerMenu(p);
		pm.setVisible(true);

		assertTrue(pm.isVisible());

		PlayerPuzzleController ppc = new PlayerPuzzleController(pm,p);
		ppc.actionPerformed(e);

		assertFalse(pm.isVisible());
	}

	public void testPlayerLightningController(){
		p = new Player();
		//		p.initalize();
		p.board = new Board();
		p.bullpen = new Bullpen(bullpenPieces);

		p.levelP = new Puzzle(p.board, p.bullpen, 0, false, null, 0);
		p.levelL = new Lightning(p.board, p.bullpen, 0, false, null, time);
		p.levelR = new Release(p.board, p.bullpen, 0, false, null);

		p.levelP.setValue(17);
		p.levelL.setValue(17);
		p.levelR.setValue(17);
		pm = new PlayerMenu(p);
		pm.setVisible(true);

		assertTrue(pm.isVisible());

		PlayerLightningController plc = new PlayerLightningController(pm,p);
		plc.actionPerformed(e);

		assertFalse(pm.isVisible());
	}

	public void testPlayerReleaseController(){
		p = new Player();
		//		p.initalize();
		p.board = new Board();
		p.bullpen = new Bullpen(bullpenPieces);

		p.levelP = new Puzzle(p.board, p.bullpen, 0, false, null, 0);
		p.levelL = new Lightning(p.board, p.bullpen, 0, false, null, time);
		p.levelR = new Release(p.board, p.bullpen, 0, false, null);

		p.levelP.setValue(17);
		p.levelL.setValue(17);
		p.levelR.setValue(17);
		pm = new PlayerMenu(p);
		pm.setVisible(true);

		assertTrue(pm.isVisible());

		PlayerReleaseController prc = new PlayerReleaseController(pm,p);
		prc.actionPerformed(e);

		assertFalse(pm.isVisible());
	}

}
