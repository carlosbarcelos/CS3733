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
import odysseus.view.Frames.BSplashScreen;
import odysseus.view.Frames.BuilderMenu;
import odysseus.view.Frames.PSplashScreen;
import odysseus.view.Frames.PlayerMenu;
import odysseus.view.controller.BuilderController;
import odysseus.view.controller.PlayerController;

/**
 * Test Cases for the Player and Builder Controllers.
 * @author Kevin Valente
 *
 */
public class TestMenuControllers extends TestCase {
	Builder b;
	
	Player p;

	ActionEvent e = null;
	
	public ArrayList<Piece> bullpenPieces = new ArrayList<Piece>();
	public ArrayList<Piece> boardPieces = new ArrayList<Piece>();
	public long time = 0;
	public List<Piece> list;
	
	
	public void testBuilderController(){
		b = new Builder();
//		b.initalize();
		b.board = new Board();
		b.bullpen = new Bullpen(bullpenPieces);
		
		b.levelP = new Puzzle(b.board, b.bullpen, 0, false, null, 0);
		b.levelL = new Lightning(b.board, b.bullpen, 0, false, null, time);
		b.levelR = new Release(b.board, b.bullpen, 0, false, null);
		
		b.levelP.setValue(17);
		b.levelL.setValue(17);
		b.levelR.setValue(17);
		
		BSplashScreen bss = new BSplashScreen(b);
		bss.setVisible(true);
		assertTrue(bss.isVisible());
		
		BuilderController bc = new BuilderController(bss,b);
		bc.actionPerformed(e);
		
		assertFalse(bss.isVisible());
		assertTrue(bss.getBuilder().isBuilder());
	}
	
	public void testPlayerController(){
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
		
		PSplashScreen pss = new PSplashScreen(p);
		pss.setVisible(true);
		assertTrue(pss.isVisible());
		
		PlayerController pc = new PlayerController(pss,p);
		pc.actionPerformed(e);
		
		assertFalse(pss.isVisible());
		assertFalse(pss.getPlayer().isBuilder());
	}

}
