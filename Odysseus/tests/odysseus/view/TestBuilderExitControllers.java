package odysseus.view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;
import odysseus.Builder;
import odysseus.common.entities.Board;
import odysseus.common.entities.Bullpen;
import odysseus.common.entities.Lightning;
import odysseus.common.entities.Piece;
import odysseus.common.entities.Puzzle;
import odysseus.common.entities.Release;
import odysseus.view.Frames.BuilderLLvl;
import odysseus.view.Frames.BuilderMenu;
import odysseus.view.Frames.BuilderPLvl;
import odysseus.view.Frames.BuilderRLvl;
import odysseus.view.controller.BLLvlExitController;
import odysseus.view.controller.BLvlExitController;
import odysseus.view.controller.BRLvlExitController;
import odysseus.view.controller.NoMoreController;

/**
 * Test cases for all Exit/ Back Controllers for the Builder
 * @author Kevin Valente
 *
 */
public class TestBuilderExitControllers extends TestCase {
	Builder b;

	ActionEvent e = null;

	public ArrayList<Piece> bullpenPieces = new ArrayList<Piece>();
	public ArrayList<Piece> boardPieces = new ArrayList<Piece>();
	public long time = 0;
	public List<Piece> list;

	public void testNoMoreController(){
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

		BuilderMenu bm = new BuilderMenu(b);
		bm.setVisible(true);
		assertTrue(bm.isVisible());

		NoMoreController nmc = new NoMoreController(bm,b);
		nmc.actionPerformed(e);
		assertFalse(bm.isVisible());
	}

	public void testBLLvlExitController(){
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
		
		BuilderLLvl bll = new BuilderLLvl(b.levelL);
		bll.setVisible(true);
		assertTrue(bll.isVisible());
		
		BLLvlExitController bllec = new BLLvlExitController(bll,b.levelL);
		bllec.actionPerformed(e);
		assertFalse(bll.isVisible());
	}
	
	public void testBPLvlExitController(){
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
		
		BuilderPLvl bpl = new BuilderPLvl(b.levelP);
		bpl.setVisible(true);
		assertTrue(bpl.isVisible());
		
		BLvlExitController blec = new BLvlExitController(bpl,b.levelP);
		blec.actionPerformed(e);
		assertFalse(bpl.isVisible());
	}
	
	public void testBRLvlExitController(){
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
		
		BuilderRLvl brl = new BuilderRLvl(b.levelR);
		brl.setVisible(true);
		assertTrue(brl.isVisible());
		
		BRLvlExitController brlec = new BRLvlExitController(brl,b.levelP);
		brlec.actionPerformed(e);
		assertFalse(brl.isVisible());
	}
	
}
