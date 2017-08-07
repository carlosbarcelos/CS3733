package odysseus.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;
import odysseus.Player;
import odysseus.common.entities.Board;
import odysseus.common.entities.Bullpen;
import odysseus.common.entities.Lightning;
import odysseus.common.entities.Piece;
import odysseus.common.entities.Puzzle;
import odysseus.common.entities.Release;
import odysseus.view.Frames.PlayerLLvl;
import odysseus.view.Frames.PlayerLevelL;
import odysseus.view.Frames.PlayerLevelP;
import odysseus.view.Frames.PlayerLevelR;
import odysseus.view.Frames.PlayerMenu;
import odysseus.view.Frames.PlayerPLvl;
import odysseus.view.Frames.PlayerRLvl;
import odysseus.view.controller.PLBackController;
import odysseus.view.controller.PLLvlExitController;
import odysseus.view.controller.PLvlExitController;
import odysseus.view.controller.PPBackController;
import odysseus.view.controller.PRBackController;
import odysseus.view.controller.PRLvlExitController;
import odysseus.view.controller.RageQuitController;

/**
 * Test cases for all Exit/ Back Controllers for the Builder
 * @author Kevin Valente
 *
 */
public class TestPlayerExitControllers extends TestCase {
	Player p;

	ActionEvent e = null;

	public ArrayList<Piece> bullpenPieces = new ArrayList<Piece>();
	public ArrayList<Piece> boardPieces = new ArrayList<Piece>();
	public long time = 0;
	public List<Piece> list;

	public void testRageQuitController(){
		p = new Player();
		p.initialize();

		PlayerMenu pm = new PlayerMenu(p);
		pm.setVisible(true);
		assertTrue(pm.isVisible());

		RageQuitController rqc = new RageQuitController(pm,p);
		rqc.actionPerformed(e);
		assertFalse(pm.isVisible());

	}

	public void testPLBackController(){
		p = new Player();
		//		p.initialize();
		p.board = new Board();
		p.bullpen = new Bullpen(bullpenPieces);

		p.levelP = new Puzzle(p.board, p.bullpen, 0, false, null, 0);
		p.levelL = new Lightning(p.board, p.bullpen, 0, false, null, time);
		p.levelR = new Release(p.board, p.bullpen, 0, false, null);

		p.levelP.setValue(17);
		p.levelL.setValue(17);
		p.levelR.setValue(17);

		PlayerLevelL pll = new PlayerLevelL(p.levelL);
		pll.setVisible(true);
		assertTrue(pll.isVisible());

		PLBackController plbc = new PLBackController(pll, p.levelL);
		plbc.actionPerformed(e);
		assertFalse(pll.isVisible());
	}

	public void testPPBackController(){
		p = new Player();
		p.initialize();

		PlayerLevelP plp = new PlayerLevelP(p.levelP);
		plp.setVisible(true);
		assertTrue(plp.isVisible());

		PPBackController ppbc = new PPBackController(plp, p.levelP);
		ppbc.actionPerformed(e);
		assertFalse(plp.isVisible());
	}

	public void testPRBackController(){
		p = new Player();
		p.initialize();

		PlayerLevelR plr = new PlayerLevelR(p.levelR);
		plr.setVisible(true);
		assertTrue(plr.isVisible());

		PRBackController prbc = new PRBackController(plr, p.levelP);
		prbc.actionPerformed(e);
		assertFalse(plr.isVisible());
	}

	public void testPLLvlExitController(){
		p = new Player();
		p.initialize();

		PlayerLLvl pll = new PlayerLLvl(p.levelL);
		pll.setVisible(true);
		assertTrue(pll.isVisible());

		PLLvlExitController pllec = new PLLvlExitController(pll, p.levelL);
		pllec.actionPerformed(e);
		assertFalse(pll.isVisible());
	}

	public void testPPLvlExitController(){
		p = new Player();
		p.initialize();

		PlayerPLvl ppl = new PlayerPLvl(p.levelP);
		ppl.setVisible(true);
		assertTrue(ppl.isVisible());

		PLvlExitController plec = new PLvlExitController(ppl, p.levelP);
		plec.actionPerformed(e);
		assertFalse(ppl.isVisible());
	}

	public void testPRLvlExitController(){
		p = new Player();
		p.initialize();

		PlayerRLvl prl = new PlayerRLvl(p.levelR);
		prl.setVisible(true);
		assertTrue(prl.isVisible());

		PRLvlExitController prlec = new PRLvlExitController(prl, p.levelR);
		prlec.actionPerformed(e);
		assertFalse(prl.isVisible());
	}

}
